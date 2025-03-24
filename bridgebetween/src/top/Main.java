package top;

import top.Container;

public class Main {
    public static void main(String[] args) {
        var container = new Container();
        Thing things = container.getThings();
        things.addItem("First");
        things.addItem("Another");
        things.addItem("Yet Another");
        System.out.println(things.indexOf("Another"));
        System.out.println(container.getThings().toString());
    }
}