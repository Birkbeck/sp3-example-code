package examples;

import java.util.ArrayList;
import java.util.Collection;

public class GenericsDemo {

    public static void validateTillStringType(Collection<? super B> collection) {
        // Wild card with Lower bound
        // Accept collection of objects of type string or SUPER-CLASS of String
    }

    public static void validateStringTypes(Collection<? extends B> collection) {
        // Wild card with Upper bound
        // Accept collection of objects of type string or SUB-CLASS of String
    }

    public static void main(String[] args) {
        GenericsDemo.validateTillStringType(new ArrayList<A>());//OK

        // GenericsDemo.validateTillStringType(new ArrayList<C>());//Error

        // GenericsDemo.validateStringTypes(new ArrayList<A>());//Error
        // GenericsDemo.validateStringTypes(new ArrayList<Object>());//Error

        GenericsDemo.validateStringTypes(new ArrayList<C>());//OK
    }
}

class A {
} // implicit extends Object

class B extends A {
}

class C extends B {
}