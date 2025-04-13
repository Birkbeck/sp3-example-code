import java.util.*;

public class Sample {
    public static void main(String[] args) {
        var names = List.of("Jack", "Jill");

        //for(int i = 0; i < names.size(); i++) {
        //  System.out.println(names.get(i));
        //}

        //for(String name : names) {
        //  System.out.println(name);
        //}

        for (var i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        for (var name : names) {
            System.out.println(name);
        }
    }
}