# Worksheet One

## Java Generics

+ This worksheet examines your existing knowledge on Java Generics to reinforce the concepts from your previous studies.
+ It is essential that you commit regularly any changes to your source code (to the respective `GitHub Classroom`
  repository).
+ Where the questions make incremental changes to the code you **do not** need to keep separate versions of your code,
  as your commits will deal with that situation.
+ Text based questions should be answered inline by modifying this document.

You are provided with some source files under the `src/main/java/generics`.

1. Add the following code snippet to the `Driver` class `main` method, creating two different storage objects with two
   different type specialisations:

   ```
   Storage<BankAccount>  aStorage = new Storage<>();
   Storage<String>       sStorage = new Storage<>();
   ```
    + What are the reasons for using generics here?

      | We use generics here as we can store objects of various types in a Storage object, and also to reference our own class types within it (e.g. BankAccount). This could help encapsulate our BankAccount object as the Storage class only allows us to retrieve the object type and location reference, not the BankAccount details/fields themselves. |
                             | :----------------------------------------------------------- |
      |                                                              |

    + What are the benefits?

      | The benefits of generics are that they provide flexibility, are customisable, remove the need for additional lines  of code (casting), and check for errors at compile time rather than run time. |
                             | ------------------------------------------------------------ |
      |                                                              |

2. Add the following code to your `Driver` class:

   ```
   Class baCls = BankAccount.class;
   try {
       Object myAccount =  baCls.newInstance();
       aStorage.setValue(myAccount);
       // Deposit
       myAccount.deposit(15);
   }
   catch ( InstantiationException e ) {
       // ...
   }
   catch ( IllegalAccessException e ) {
       // ... 
   }
   ```
    + Compile and analyse the compiler output.

    + What is the cause of the problem reported by the compiler, if any?

      | The problem reported by the compiler is incompatible types, the Object myAccount cannot be converted to generics.BankAccount. As variable aStorage has been initialised to take generic type BankAccount, it will not take calls on objects of different types as the two types are now incompatible. Consequently, the method .deposit() will not work on a higher-level class Object as it belongs to the BankAccount Class. |
                             | ------------------------------------------------------------ |
      |                                                              |

3. Now replace:

   ```
   Object myAccount =  baCls.newInstance();
   ```
   with
   ```
   BankAccount myAccount =  baCls.newInstance();
   ```
    + How does this affect the compilation process?

    + What is the problem, if any?
    + What does the `myAccount` variable hold when the code is executed?
    + Decide whether your analysis from the previous question was correct. If not, why not?

   | baCls is an Object and not an instance of BankAccount.class. Therefore it cannot be used to instantiate BankAccount myAccount.  When the code is executed, myAccount holds a Class Object. |
               | ------------------------------------------------------------ |
   |                                                              |

4. Now add an explicit dynamic cast:

   ```
   BankAccount myAccount =  (BankAccount) baCls.newInstance();
   ```
    + What does the dynamic cast do here?

    + Is it the compiler that performs the cast operation or the Java runtime environment (JVM)?

    + Is this code safe?

   | The dynamic cast here explicitly converts Object baCls to an instance of BankAccount, which can instantiate myAccount. The compiler checks whether the object being cast is part of the same family as the cast type  (further up the Class tree), the JVM performs the actual cast operation. This code is largely safe as Java ensures type safety during compile time, however it is not safe from injection. Also, the method .newInstance() is  deprecated indicating that it is not safe as it bypasses compile-time exception checking. |
               | ------------------------------------------------------------ |
   |                                                              |

5. Now replace your initial declaration:

   ```
   Class baCls = BankAccount.class;
   ```
   with
   ```
   Class<BankAccount> baCls = BankAccount.class; 
   ```
    + Explain the compiler output?

    + What does this say about the role of generics in our code?

   | There is no compiler output as no errors occur and nothing is being printed to the console. This is because baCls  is explicitly instantiated as a BankAccount class rather than a generic Class.  There are no errors but there is now redundancy with the (BankAccount) cast from question 4.   In our code, generics provide a level of type security. We cannot add incompatible class objects to our generic  Storage objects. |
               | ------------------------------------------------------------ |
   |                                                              |

6. Now add:

   ```
   System.out.println( aStorage.getValue().showBalance() );
   
   if( aStorage.getClass() == sStorage.getClass() ) {
       System.out.println( "EQUAL" );
   } else {
       System.out.println( "NOT EQUAL" );
   }
   ```
    - What is the run-time output?
    - Explain why you get such output and how does this relate to generics and their use
      with reflective instantiation of objects?

   | The run-time output of the program is:  115.0 and EQUAL. |
               | -------------------------------------------------------- |
   |                                                          |

   | We get this output because the generic field within aStorage contains a reference to myAccount. myAccount is initialised with balance 100 as per the Class Constructor, but the program deposited 15 in myAccount, which is reflected in aStorage's field value. aStorage and sStorage are equal as, although they each accept different generic types they are Objects in their own right (Storage.Class). The generic types of their fields are not considered when we getClass(). |
               | ------------------------------------------------------------ |
   |                                                              |

------

End of file
