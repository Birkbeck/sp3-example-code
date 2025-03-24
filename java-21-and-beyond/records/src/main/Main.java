package main;

import two.Rectangle;

public class Main {
    public static void main(String[] args) {
        var rect = new Rectangle(3, 4);
        System.out.println(rect);
        System.out.println("Length: " + rect.length());
    }
}
