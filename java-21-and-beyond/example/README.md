### Explanation:

+ Encapsulation is demonstrated in the `example.BankAccount` class where the `balance` variable is declared `private` and accessed only through `public` methods like `deposit()`, `withdraw()`, and `getBalance()`.
+ Inheritance is demonstrated in the `example.SavingsAccount` class that inherits from the `example.BankAccount` class and adds a new method `addInterest()`.
+ Polymorphism is demonstrated in the `BankTransaction` class that has two subclasses `DepositTransaction` and `WithdrawTransaction`, both of which have overridden the `execute()` method with different implementations.
+ Abstraction is demonstrated in the `Animal` class which is an abstract class with an abstract method `makeSound()`. The `Dog` class extends `Animal` and provides its own implementation of the `makeSound()` method.
+ Sealed classes are demonstrated in the `Shape` class which is declared as `abstract` and `sealed` with two subclasses `Circle` and `Rectangle`. Both subclasses implement the `area()` method that is declared `abstract` in the `Shape` class.