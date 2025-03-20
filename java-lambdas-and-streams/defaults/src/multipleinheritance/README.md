### Conflict resolution rules for inherited default methods

1. Classes take higher precedence than interfaces.
2. Derived interfaces or sub-interfaces take higher precedence than the
   interfaces higher-up in the inheritance hierarchy.
3. In cases where Rule 1 and Rule 2 are not able to resolve the conflict then
   the implementing class has to specifically override and provide a method with
   the same method definition.