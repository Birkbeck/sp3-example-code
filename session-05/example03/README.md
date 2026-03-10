## Summary of the Flow

+ Define: Create your classes and mark constructors with `@Inject`.
+ Bind: Create a class extending `AbstractModule` to link Interfaces to Implementations.
+ Boot: Use `Guice.createInjector()` in your `main` method.
+ Retrieve: Use `injector.getInstance()` to get your entry-point object.