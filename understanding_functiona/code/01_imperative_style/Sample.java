import java.util.*;

public class Sample {
    public static void main(String[] args) {
        List<String> names = List.of("Dory", "Gill", "Bruce", "Nemo", "Darla", "Marlin", "Jacques");

        //find if Nemo is there.

        //imperative style: we tell what to do and also how to do it

        boolean found = false;

        //for(int i = 0; i < names.size(); i++...) //how
        for (String name : names) { //how
            //if(name == "Nemo") //how
            if (name.equals("Nemo")) {
                found = true;
                break; //how
            }
        }

        if (found) {
            System.out.println("Nemo found");
        } else {
            System.out.println("Nemo not found");
        }
    }
}
