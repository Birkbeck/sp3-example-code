package helloworld.interfaces;

import common.HelloWorldMessageProvider;
import common.StandardOutMessageRenderer;
import interfaces.MessageProvider;
import interfaces.MessageRenderer;

public class HelloWorldDecoupledInterface {
    public static void main(String[] args) {
        MessageRenderer mr = new StandardOutMessageRenderer();
        MessageProvider mp = new HelloWorldMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}