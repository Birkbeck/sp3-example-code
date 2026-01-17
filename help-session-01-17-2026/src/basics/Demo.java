package basics;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    static void main() {
        //original();
        generics();
    }

    static void original(){
        List names = new ArrayList();
        names.add("Alice");
        names.add("Bob");
        names.add(22);

        for (Object item: names){
            String s = (String) item;
            System.out.printf("The item is %s\n",s);
        }
    }

    static void generics(){
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        // names.add(22); won't compile

        for (Object item: names){
            String s = (String) item;
            System.out.printf("The item is %s\n",s);
        }
    }
}
