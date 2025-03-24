package helloworld.decoupled;

import common.HelloWorldMessageProvider;
import common.StandardOutMessageRenderer;

public class HelloWorldDecoupled {
    public static void main(String[] args) {
        StandardOutMessageRenderer mr = new StandardOutMessageRenderer();
        HelloWorldMessageProvider mp = new HelloWorldMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}
