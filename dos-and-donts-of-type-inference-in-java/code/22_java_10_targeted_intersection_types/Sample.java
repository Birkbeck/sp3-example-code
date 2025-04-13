import java.util.*;

public class Sample {
    public static void main(String[] args) {
        var list = List.of(1, "2");

        list.add(1); //No compilation error, though runtime error
        list.add(1.2); //No compilation error, though runtime error
        list.add(new Sample()); //Compilation error

        //Reason?
        //list if an intersection type: List<Object,Serializable,Comparable<?>>
        //Sample is not implementing Serializable and Comparable<Sample>
    }
}