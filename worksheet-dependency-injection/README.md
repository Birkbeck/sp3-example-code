# Worksheet — Write a (simple) DI Container 

This practical is of the “follow me” type where you

+ follow the logic,
+ examine the code,
+ build the code, and
+ run the code.

##“Follow Me”

There are no questions to answer, but you must understand the contents of this practical before attempting the coursework.

## Dependency Injection

Dependency Injection (DI) can be a difficult topic to grasp due to the apparent presence of “magic” involved in the binding process. As we have seen, this can involve several annotations scattered across the code base and various XML files or configurations, some of which are not always transparent regarding their application.

In this exercise, you will build a very bare-bones yet fully functional dependency injection container, an extension of the one we saw presented in the lecture screencast. There are some ground rules we should state:

+ No external libraries are used except for the JDK itself.
+ This is a fundamental implementation with little flexibility.
+ We are not considering performance and are not attempting to optimise the code base.

We will create a straightforward DI container which:

+ encapsulates the creation of a service network
+ creates the services and wires them together
+ is capable of scanning the `classpath` for service classes
+ showcases the use of reflection and annotations

This will involve the following steps:

+ We replace static references with objects and constructors.
+ We introduce interfaces to decouple the objects.
+ We introduce setters to handle cyclic dependencies.
+ We will see that manually calling all setters to build the service network is error-prone.
+ We will use reflection to automate this process.
+ We will add `classpath` scanning to auto-detect service classes.

So, on to the first example.

## Stage 0: Basic example

We have two classes, `ServiceA` and `ServiceB`, and `ServiceA` needs `ServiceB` to do its work. We could implement this relationship with static methods:

```java
public class ServiceA {
    public static String jobA(){
        return "jobA(" + ServiceB.jobB() + ")";
    }
}

public class ServiceB {
    public static String jobB(){
        return "jobB()";
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(ServiceA.jobA());
    }
}
```

If we run this code, it will print:

```
jobA(jobB())
```

### What are the “issues” with this code?

+ The code exhibits poor OO design. `ServiceA` and `ServiceB` should, at the very least, be objects.
+ The code is tightly coupled and very hard to test in isolation.
+ We cannot swap either `ServiceA` or `ServiceB` for a different implementation.

## Stage 1: No static references

The main problem we have identified so far is that there are only static methods, resulting in highly tight coupling. We want our services to be objects talking to each other, so we can replace them as needed.

> Now the question arises: how does `ServiceA` know which `ServiceB` to talk to? 

The most basic idea is to provide our instance of `ServiceB` to the constructor of `ServiceA`:

```java
public class ServiceA {

    private ServiceB serviceB;

    public ServiceA(ServiceB serviceB){
        this.serviceB = serviceB;
    }

    public String jobA(){
        return "jobA(" + this.serviceB.jobB() + ")";
    }

}
```

Service B does not need to change much:

```java
public class ServiceB {
  public String jobB() {
    return "jobB()";
  }
}
```

and `main` now needs to assemble the objects before it can call the `jobA` method:

```java
public static void main(String[] args) {
  ServiceB serviceB = new ServiceB();
  ServiceA serviceA = new ServiceA(serviceB);
  System.out.println(serviceA.jobA());
}
```
We have certainly improved some things:

+ We can now replace the implementation of `ServiceB`, which is used by `ServiceA`, by providing another object, potentially even of another subclass.
+ We can isolate both services with a proper test mock for `ServiceA`.

> But there are issues
>
> + It is hard to create mocks, as we require a class.
> + It would be much nicer if we required interfaces instead.
> + We need to reduce the coupling further.

## Stage 2: Using interfaces


We will use one interface for each of our services. They are about as simple as it gets:

```java
public interface ServiceA {
    public String jobA();
}

public interface ServiceB {
    public String jobB();
}
```

Their corresponding implementations are `ServiceAImpl` and `ServiceBImpl`.

```java
public class ServiceAImpl implements ServiceA {
    private final ServiceB serviceB;

    public ServiceAImpl(ServiceB serviceB){
        this.serviceB = serviceB;
    }
    // jobA() is the same as before
}
```
That also makes our `main` method slightly cleaner:

```java
  public static void main(String[] args) {
        ServiceB serviceB = new ServiceBImpl();
        ServiceA serviceA = new ServiceAImpl(serviceB);
        System.out.println(serviceA.jobA());
    }
```

This is perfectly acceptable for simple use cases from an object-oriented design perspective.

> But…
>
> + As your code scales, creating the network of services inside your `main` method will become more complex.
> + You will encounter cycles in your service dependencies which cannot be resolved using constructors as we have done.

## Stage 3: Utilising setters

Assume that not only `ServiceA` requires `ServiceB`, but also the other way around — and therefore we have a cycle. Of course, we may still declare a parameter in the constructor of the `*Impl` classes:

```java
 // constructor examples
 public ServiceAImpl(ServiceB serviceB) { ... }
 public ServiceBImpl(ServiceA serviceA) { ... }
```

but that does not help; we cannot create an actual instance of either of the two classes. To create an example of `ServiceAImpl`, we would first require an instance of `ServiceB`, and to create an example of `ServiceBImpl` we first require an instance of `ServiceA`. We are **deadlocked**.

**Side note**: there is a way out of this by using proxies. However, we're not going to take that route here.

Since we are dealing with cyclic dependencies, we need the ability first to create the services and then wire them together. We do this by using appropriate setters:

```java
public class ServiceAImpl implements ServiceA {
    private ServiceB serviceB;

    // no constructor anymore here!

    @Override // <- added getter to ServiceA interface
    public ServiceB getServiceB() { 
      return serviceB; 
    }

    @Override // <- added setter to ServiceA interface
    public void setServiceB(final ServiceB serviceB) { 
      this.serviceB = serviceB; 
    }

    // jobA() same as before
}
```

Our `main` method now looks like this:

```java
    public static void main(String[] args) {
        // create instances
        ServiceB serviceB = new ServiceBImpl();
        ServiceA serviceA = new ServiceAImpl();

        // wire them together
        serviceA.setServiceB(serviceB);
        serviceB.setServiceA(serviceA);

        // call business logic
        System.out.println(serviceA.jobA());
    }
```

The pattern to follow is first to create the objects, then connect them to form the service graph (i.e., service network).

> Any issues?
>
> + By doing the wiring part manually, we have introduced an error-prone process.
> + You might forget to call a setter, which is `NullPointerException` hell.
> + You might accidentally use a service instance still under construction, so it would be beneficial to encapsulate the network construction somehow.

## Stage 4: Automating the wiring

Consider the `main` method, and we shall try to find a more automatic way of creating the service network. Certainly, forgetting to call a setter is a real threat here, and the compiler cannot warn you about it. But our services are structurally different, and there is no uniform way to access them… or is there? Java Reflection to the rescue!

All we essentially want to provide our setup with is a list of our service classes. From there, the setup should construct and wire the service network. In particular, our `main` method is only really interested in `ServiceA`; it does not need `ServiceB`. Let us rewrite it like so:

```java
    public static void main(String[] args) throws Exception {
        Set<Class<?>> serviceClasses = new HashSet<>();
        serviceClasses.add(ServiceAImpl.class);
        serviceClasses.add(ServiceBImpl.class);

        ServiceA serviceA = createServiceA(serviceClasses);

        // call business logic
        System.out.println(serviceA.jobA());
    }
```

But how can we implement the "magic” `createServiceA` method?

```java
    private static ServiceA createServiceA(Set<Class<?>> serviceClasses) throws Exception{
        // step 1: create an instance of each service class
        Set<Object> serviceInstances = new HashSet<>();
        for(Class<?> serviceClass : serviceClasses){
            Constructor<?> constructor = serviceClass.getConstructor();
            constructor.setAccessible(true);
            serviceInstances.add(constructor.newInstance());
        }
        // step 2: wire them together
        for(Object serviceInstance : serviceInstances){
            for(Field field : serviceInstance.getClass().getDeclaredFields()){
                Class<?> fieldType = field.getType();
                field.setAccessible(true);
                // find a suitable matching service instance
                for(Object matchPartner : serviceInstances){
                    if(fieldType.isInstance(matchPartner)){
                        field.set(serviceInstance, matchPartner);
                    }
                }
            }
        }
        // step 3: from all our service instances, find ServiceA
        for(Object serviceInstance : serviceInstances){
            if(serviceInstance instanceof ServiceA){
                return (ServiceA)serviceInstance;
            }
        }
        // we didn't find the requested service instance
        return null;
    }
```

We need to break this code down.

In Step 1, we iterate over our classes, and for each class, we attempt to get the default constructor (i.e., the constructor with no arguments). Since neither `ServiceAImpl` nor `ServiceBImpl` specifies any constructor (we deleted them when introducing the getters/setters), the Java compiler provides a public default constructor. Then, we make this constructor accessible. That’s just defensive programming to ensure private constructors will work too. Finally, we call `newInstance()` on the constructor to create the instance of the class, and add it to our set of instances.

In Step 2, we want to wire together our service instances. To do so, we look at each service object one by one. We retrieve its Java class via `getClass()` and ask that class for all its declared fields (declared means that private fields will be returned too). As with the constructor, we ensure the field is accessible, and then we check the field type. This will give us the service class to put into the field.

All that is left is to find a suitable `matchPartner`, an object of the type specified by the field. Once we find one, we call `field.set(...)` and assign the `matchPartner` to the field. Note that the first parameter of the `field.set(...)` method is the object whose field value will be changed.

In Step 3, the network is already complete; all that remains is to find the instance of `ServiceA`. We can scan through the instances and check if we found the right one by using `instanceof ServiceA`.

This may not seem easy to follow, so reread this.

> So, what did we gain?
> 
> + Our services are wired together automatically.
> + We can no longer forget to call a setter (in fact, we don’t need them anymore).
> + Our application will fail on startup if the wiring fails, not during the business logic.
>
> Problems?
>
> + We do not want to repeat this whole procedure every time we want to get a hold of a service.
> + We want to have the ability to access every service in the network, not just one.

## Stage 5: Encapsulating the Context

The object holding the service network is called the *Dependency Injection Container*, or (in `Spring` terms) the *Application Context*. We will use the “context” terminology, but the terms are synonyms.

The context's primary job is to provide a `getServiceInstance(...)` method, which accepts a service class as a parameter and returns the (finished and wired) service instance.

```java
public class DIContext {
    private final Set<Object> serviceInstances = new HashSet<>();

    public DIContext(Collection<Class<?>> serviceClasses) throws Exception {
        // create an instance of each service class
        for(Class<?> serviceClass : serviceClasses){
            Constructor<?> constructor = serviceClass.getConstructor();
            constructor.setAccessible(true);
            Object serviceInstance = constructor.newInstance();
            this.serviceInstances.add(serviceInstance);
        }
        // wire them together
        for(Object serviceInstance : this.serviceInstances){
            for(Field field : serviceInstance.getClass().getDeclaredFields()){
                Class<?> fieldType = field.getType();
                field.setAccessible(true);
                // find a suitable matching service instance
                for(Object matchPartner : this.serviceInstances){
                    if(fieldType.isInstance(matchPartner)){
                        field.set(serviceInstance, matchPartner);
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getServiceInstance(Class<T> serviceClass){
        for(Object serviceInstance : this.serviceInstances){
            if(serviceClass.isInstance(serviceInstance)){
                return (T)serviceInstance;
            }
        }
        return null;
    }

}
```

As you can see, the code has not changed much from the previous step, except that we now have an object to encapsulate the context (`DIContext`). Internally, it manages a set of `serviceInstances` which are created from a collection of service classes, as before. 

Step three above has moved into its `getServiceInstance` method, which accepts the class to retrieve as a parameter. Since we cannot use `instanceof` anymore (it requires a hard-coded class, not a dynamic variable value), we have to fall back to `serviceClass.isInstance(...)` to do the same thing.

We can use this class in our new `main` method:

```java
    public static void main(String[] args) throws Exception {
        DIContext context = createContext();
        doBusinessLogic(context);
    }

    private static DIContext createContext() throws Exception {
        Set<Class<?>> serviceClasses = new HashSet<>();
        serviceClasses.add(ServiceAImpl.class);
        serviceClasses.add(ServiceBImpl.class);
        return new DIContext(serviceClasses);
    }

    private static void doBusinessLogic(DIContext context){
        ServiceA serviceA = context.getServiceInstance(ServiceA.class);
        ServiceB serviceB = context.getServiceInstance(ServiceB.class);
        System.out.println(serviceA.jobA());
        System.out.println(serviceB.jobB());
    }
```

As you can see, we can now easily extract complete service instances from the context by calling `getServiceInstance` as often as we need to, with different input classes. Also, the services can access each other simply by declaring a field of the proper type - they don’t have to know about the `DIContext` object.

> There are still some outstanding issues though
>
> + For example, what if we want a field in our services that does not refer to another service (say, an `int` field)?
> + We need a way to tell our algorithm which fields to set - and a way to tell our algorithm which fields we want it to set - and which ones to leave alone.


## Stage 6: Annotating fields

So how can we tell our algorithm which fields it needs to assign? We could introduce some naming scheme and parse the `field.getName()`, but that is a very error-prone solution. Instead, we will use an *annotation*:

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {

}
```

`@Target` tells the compiler which elements we can use for this annotation - we want it to apply to fields. With `@Retention`, we instruct the compiler to keep this annotation until runtime and not to discard it during compilation.

Let us annotate our fields:


```java
public class ServiceAImpl implements ServiceA {
    @Inject
    private ServiceB serviceB;

    // rest is the same as before

}

public class ServiceBImpl implements ServiceB {
    @Inject
    private ServiceA serviceA;

    // rest is the same as before

}
```

An annotation in and of itself does nothing. We need to read the annotation actively. So let’s do it in the constructor of our `DIContext`:

```java
// wire them together
for(Object serviceInstance : this.serviceInstances){
  for(Field field : serviceInstance.getClass().getDeclaredFields()){
    // check that the field is annotated
    if(!field.isAnnotationPresent(Inject.class)){
      // this field is none of our business
      continue;
    }
    // The remainder of the code is the same as before
```

Run the `main` method again; it should work like before. However, now you can add more fields to your services, and the wiring algorithm won’t break.

> What have we achieved?
>
> + We have created a DI container which is basic but functional. It relies on us providing it with the collection of service classes.
> + We now need to figure out how we can discover our service classes.


## Stage 7: Auto-detecting Services

Our current state represents (a simplified yet functional) version of libraries such as `Google Guice`. However, if you are familiar with `Spring Boot`, that goes further.

> What do we need to do next?
>
> + It is annoying that we must explicitly specify the service classes in a `set`.
> + We need to find a way to auto-detect service classes.

```java
public class ClassPathScanner {

    // this code is very much simplified; it works, but do not use it in production!
    public static Set<Class<?>> getAllClassesInPackage(String packageName) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        Set<Class<?>> classes = new HashSet<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;
    }

    private static List<Class<?>> findClasses(File directory, String packageName) throws Exception {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

}
```
Here we have to deal with the `ClassLoader` API. This particular API is quite old and dates back to the earliest days of `Java`, but it works well.

We start with a `packageName` to scan for. Each `Thread` in the `JVM` has a `contextClassLoader` assigned, from which the `Class` objects are being loaded. Since the `classloader` operates on files, we must convert the package name into a file path (replacing '.' with '/'). Then, we ask the `classloader` for all resources in this path, and convert them into `File`s one by one. In practice, only one resource will be here: our package, represented as a directory.

From there, we recursively iterate over the file tree of our directory package, looking for files ending in `.class`. We convert every class file we encounter into a class name (removing the trailing `.class`) to end up with our class name. Then, we finally call `Class.forName(...)` to retrieve the class.

We now have a way to retrieve all classes in our base package. How do we use it?

We add a static method to our `DIContext` class that produces a `DIContext` for a given base package:

```java
public static DIContext createContextForPackage(String rootPackageName) throws Exception {
  Set<Class<?>> allClassesInPackage = ClassPathScanner.getAllClassesInPackage(rootPackageName);
  Set<Class<?>> serviceClasses = new HashSet<>();

  for(Class<?> aClass : allClassesInPackage){   
    serviceClasses.add(aClass);
  }
  return new DIContext(serviceClasses);
}
```

Finally, we need to make use of this new method in our `createContext` method:

```java
private static DIContext createContext() throws Exception {
  String rootPackageName = Main.class.getPackage().getName();
    return DIContext.createContextForPackage(rootPackageName);
}
```

We retrieve the base package name from the Main class (the class we have used to contain our `main` method).

There is a problem, though. Our `classpath` scanner will detect all classes, whether they are services or not. We can tell the algorithm which ones we want with an annotation:

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {

}
```

Let’s annotate our services with it:

```java
@Service
public class ServiceAImpl implements ServiceA { ... }

@Service
public class ServiceBImpl implements ServiceB { ... }
```
and filter our classes accordingly:
```java
public static DIContext createContextForPackage(String rootPackageName) throws Exception {
  Set<Class<?>> allClassesInPackage = ClassPathScanner.getAllClassesInPackage(rootPackageName);
  Set<Class<?>> serviceClasses = new HashSet<>();

  for(Class<?> aClass : allClassesInPackage){
    if(aClass.isAnnotationPresent(Service.class)){
      serviceClasses.add(aClass);
    }
  }
  return new DIContext(serviceClasses);
}
```

## Summary

We have developed a minimalistic, poorly optimised, fully functional DI container. It is not deployment-ready and robust, but it illustrates the principles of DI.

Our `classpath` scanner is weak. It does not cover all cases, nesting depths, inner classes etc. Libraries like Guava's ClassPath do a much better job at this.

A significant advantage of DI is that we can hook into the lifecycle of a service. For example,

+ We might want to do something once the service has been created (`@PostConstruct`).
+ We might want to inject dependencies via setters, not fields.
+ We might want to use constructor injection, as we did initially.
+ We might want to wrap our services in proxies so that code is executed before and after each method (e.g., @Transactional).

For example, All those “bells and whistles” are provided by the `Spring Framework`.

+ Our wiring algorithm does not respect base classes (and their fields).
+ Our `getServiceInstance(...)` method is poorly optimised, as it linearly scans for the matching instance every time.
+ You will undoubtedly want to have different contexts for testing and production.
+ We only have one way of defining services; some might require additional configuration.

## Credits

This exercise is based on the article "Understanding Dependency Injection by writing a DI Container - from scratch!" by Martin Häusler (2020). The code accompanying the blog article can be found on the `GitHub` repo.

