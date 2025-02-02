package lombokexamples;

public class Main {
    public static void main(String[] args) {
        PersonRedux personRedux = new PersonRedux();
        System.out.println(personRedux);
        System.out.println(personRedux.getName());
        PersonRedux personRedux2 = new PersonRedux("Fred", "xyz123");
        System.out.println(personRedux2);
        System.out.println(personRedux.equals(personRedux2));
        personRedux2.setName("Betty");
        System.out.println(personRedux2);
    }
}
