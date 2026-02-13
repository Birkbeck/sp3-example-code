package helloworld;

public class HelloWorld {

    public static void main(String[] args) {
        MessageSupportFactory msf = MessageSupportFactory.getInstance();
        MessageRenderer mr = msf.getMessageRenderer();
        MessageProvider mp = msf.getMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }
}