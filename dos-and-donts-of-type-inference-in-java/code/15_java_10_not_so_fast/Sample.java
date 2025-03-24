import java.util.*;

public class Sample {
    public static void main(String[] args) {
        Collection<Integer> list = new ArrayList<>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };
        //Run this code, notice the output.
        //Now, change Collection<Integer> list to var list and run the code. Is the output the same?

        System.out.println(list);

        list.remove(1);
        System.out.println(list);
    }
}