# Covariant Return Type

A covariant return type of a method is the one that can be replaced by a
"narrower" type (subtype) when the method is overridden in a sub-class or a
sub-interface.

In other words, an overridden method can have a more specific return type.
As long as the new return type is assignable to the return type of the method
we are overriding, it can be used.

Java has supported this feature since release 5.0.

# Covariant vs Contravariant vs Bivariant vs Invariant

A programming language can have features which may support the following
subtyping rules:

+ **Covariant** -
  A feature which allows to substitute a subtype with supertype.

+ **Contravariant** -
  A feature which allows to substitute a supertype with subtype.

+ **Bivariant** -
  A feature which is both covariant and contravariant.

+ **Invariant** -
  A feature which does not allow any of the above substitution.

Java supports:

+ Java Arrays are Covariant.

+ Java Generics are Invariant<br/>
  Java Generics with a specific type `T`,
  do not support covariant or contravariant substitutions.

+ Java Generics with wildcard `? extends` are Covariant.

+ Java Generics with wildcard `? super` are Contravariant.

+ 