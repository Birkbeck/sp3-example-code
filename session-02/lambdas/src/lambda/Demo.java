package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo {
    static void main() {
        List<String> fruits = Arrays.asList("Apple","Kiwi","Banana","Elderberry");
        //MyComparator<String> mycomp = new MyComparator<>();
        // Anonymous Inner Class (AIC)
        Collections.sort(fruits, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });
        fruits.sort((s1,s2) //parameter list (head)
                -> // (neck)
                Integer.compare(s1.length(), s2.length())); // body
    }
}

class MyComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(),o2.length());
    }
}
