package factory.demo;

public class Demo {
    public static void main(String... args){
        List<String> people = List.of("Fred", "Betty", "James");
        System.out.println(people.getClass());
    }
}