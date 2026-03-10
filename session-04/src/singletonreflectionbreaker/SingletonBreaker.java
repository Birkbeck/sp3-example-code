package singletonreflectionbreaker;

import singletonreflectionbreaker.versions.PremiumVaultOriginal;
import singletonreflectionbreaker.versions.PremiumVaultThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// Use Reflection to force that private constructor to open up.

public class SingletonBreaker {
    static void main(String... args) throws Exception {
        PremiumVault instanceOne = PremiumVaultOriginal.getInstance();
        PremiumVault instanceTwo = PremiumVaultOriginal.getInstance();
        PremiumVault instanceThree = PremiumVaultOriginal.getInstance();
        // PremiumVault instanceFour = new PremiumVaultOriginal(); // private constructor

        System.out.println(instanceOne);
        System.out.println(instanceTwo);
        System.out.println(instanceThree);

        tryToBreakSingleton(instanceOne, instanceTwo);
//
//        instanceOne = PremiumVaultThrows.getInstance();
//        instanceTwo = PremiumVaultThrows.getInstance();
//
//        tryToBreakSingleton(instanceOne, instanceTwo);
    }

    static void tryToBreakSingleton(PremiumVault instanceOne, PremiumVault instanceTwo) {
        // Use Reflection to get the private constructor
        Constructor<?>[] constructors = instanceTwo.getClass().getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            // Below is the magic wand: it bypasses the 'private' modifier
            System.out.println(constructor);
            constructor.setAccessible(true);
            System.out.println(constructor); // nothing has changed on the signature of the method
            try {
                instanceTwo = (PremiumVault) constructor.newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException ex) {
                System.err.println(ex.getMessage());
                return;
            }
        }
        System.out.println(instanceTwo.getClass().getSimpleName() + " is not a singleton!");

        System.out.println("Instance 1 HashCode: " + instanceOne.hashCode());
        System.out.println("Instance 2 HashCode: " + instanceTwo.hashCode());

        if (instanceOne != instanceTwo) {
            System.out.println("FAILURE: We now have two different instances!");
        }
    }
}