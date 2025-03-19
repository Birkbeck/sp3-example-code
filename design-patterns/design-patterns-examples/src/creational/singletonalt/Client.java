package creational.singletonalt;

public class Client {
    public static void main(String... args) {
        var item = MySingleton.getInstance();
        System.out.println(item);
        var itemTwo = MySingleton.getInstance();
        System.out.println(itemTwo);
    }

}