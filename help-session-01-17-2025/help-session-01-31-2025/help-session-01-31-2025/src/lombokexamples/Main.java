package lombokexamples;

public class Main {
    public static void main(String[] args) {
        Person p = new PersonImpl();
        System.out.println(p);
        System.out.println(p.getName());

        Person p2 = new PersonRedux("Fred", "xyz123");
        System.out.println(p2);

        //System.out.println(((Person)p).equals((Person)p2));
        p2.setName("Betty");
        System.out.println(p);
        System.out.println(p2);
    }
}
