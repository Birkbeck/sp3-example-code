package basics;

public class Main {
    static void main() {
//        User u = new User();
//        u.setName("Fred");
//        u.setId(111L);
//        System.out.println(u);
        UserAnon ua = new UserAnon(111L, "Fred");
        var ua2 = new UserAnon();
//        ua.setId(111L);
//        ua.setName("Fred");
        System.out.println(ua);
    }
}
