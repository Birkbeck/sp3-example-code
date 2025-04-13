# Polymorphism through Java Generics

+ Invariance
+ Covariance
+ Contravariant

## Type conversion

Type conversion in Java are covariant.

## Arrays

Java arrays are also covariant.

## Invariant

`<T>` as seen in ordinary Java Generics - does not subclass

## Covariant

+ `<? extends T>` works with subclasses.
+ Return types from methods.
+ *Read* arguments to methods.

## Contravariant

+ `<? super T>` works with superclasses.
+ *Write* arguments to methods.
