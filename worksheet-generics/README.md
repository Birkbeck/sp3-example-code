# Worksheet One

## Java Generics

+ This worksheet examines your existing knowledge on Java Generics to reinforce the concepts from your previous studies.
+ It is essential that you commit regularly any changes to your source code (to the respective `GitHub Classroom` repository).
+ Where the questions make incremental changes to the code you **do not** need to keep separate versions of your code, as your commits will deal with that situation. 
+ Text based questions should be answered inline by modifying this document.

You are provided with some source files under the `src/main/java/generics`.

1. Add the following code snippet to the `Driver` class `main` method, creating two different storage objects with two different type specialisations:
  
   ```
   Storage<BankAccount>  aStorage = new Storage<>();
   Storage<String>       sStorage = new Storage<>();
   ```
   + What are the reasons for using generics here?
   
     ** YOUR ANSWER HERE**
   
   + What are the benefits?
   
     ** YOUR ANSWER HERE**
   
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
   
     ** YOUR ANSWER HERE**
   
3. Now replace:

   ```
   Object myAccount =  baCls.newInstance();
   ```
   with
   ```
   BankAccount myAccount =  baCls.newInstance();
   ```
   + How does this affect the compilation process?
   
     ** YOUR ANSWER HERE**
   
   + What is the problem, if any?
   
     ** YOUR ANSWER HERE**
   
   + What does the `myAccount` variable hold when the code is executed?
   
     ** YOUR ANSWER HERE**
   
   + Decide whether your analysis from the previous question was correct. If not, why not?
   
     ** YOUR ANSWER HERE**
   
4. Now add an explicit dynamic cast:

   ```
   BankAccount myAccount =  (BankAccount) baCls.newInstance();
   ```
   + What does the dynamic cast do here?
   
     ** YOUR ANSWER HERE**
   
   + Is it the compiler that performs the cast operation or the Java runtime environment (JVM)?
   
     ** YOUR ANSWER HERE**
   
   + Is this code safe?
   
     ** YOUR ANSWER HERE**
   
5. Now replace your initial declaration:

   ```
   Class baCls = BankAccount.class;
   ```
   with 
   ```
   Class<BankAccount> baCls = BankAccount.class; 
   ```
   + Explain the compiler output?
   
     ** YOUR ANSWER HERE**
   
   + What does this say about the role of generics in our code?
   
     ** YOUR ANSWER HERE**
   
6. Now add:
  
   ```
   System.out.println( aStorage.getValue().showBalance() );
   
   if( aStorage.getClass() == sStorage.getClass() ) {
       System.out.println( "EQUAL" );
   } else {
       System.out.println( "NOT EQUAL" );
   }
   ```
   What is the run-time output?
   
   ** YOUR ANSWER HERE**
   
   Explain why you get such output and how does this relate to generics and their use 
   with reflective instantiation of objects?
   
   ** YOUR ANSWER HERE**

------

