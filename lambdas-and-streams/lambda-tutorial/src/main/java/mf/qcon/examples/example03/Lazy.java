package mf.qcon.examples.example03;

import java.util.*;

public class Lazy {

    public static boolean isEven(int n) {
        System.out.println("isEven: " + n);
        return n % 2 == 0;
    }

    public static int doubleIt(int n) {
        System.out.println("doubleIt: " + n);
        return n * 2;
    }

    public static boolean isGT5(int n) {
        System.out.println("isGT5: " + n);
        return n > 5;
    }

    public static void main(String... args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Take only the even numbers, double them and print
        // the first one bigger than 5

        for (int n : numbers) {
            if (n % 2 == 0) {
                int n2 = n * 2;
                if (n2 > 5) {
                    System.out.println(n2);
                    break;
                }
            }
        }

        List<Integer> l1 = new ArrayList<Integer>();
        for (int n : numbers) {
            if (isEven(n)) l1.add(n);
        }

        List<Integer> l2 = new ArrayList<Integer>();
        for (int n : l1) {
            l2.add(doubleIt(n));
        }

        List<Integer> l3 = new ArrayList<Integer>();
        for (int n : l2) {
            if (isGT5(n)) l3.add(n);
        }

        System.out.println(l3.get(0));

        System.out.println(
            numbers.stream()
                .filter(Lazy::isEven)
                .map(Lazy::doubleIt)
                .filter(Lazy::isGT5)
                .findFirst().get());
    }
}



















/*
        List<Integer> l1 = new ArrayList<Integer>();
        for (int n : numbers) {
            if (isEven(n)) l1.add(n);
        }

        List<Integer> l2 = new ArrayList<Integer>();
        for (int n : l1) {
            l2.add(doubleIt(n));
        }

        List<Integer> l3 = new ArrayList<Integer>();
        for (int n : l2) {
            if (isGT5(n)) l3.add(n);
        }

        System.out.println(l3.get(0));
*/