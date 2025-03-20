import java.util.*;

public class Sample {
  public static void main(String[] args) {
    List<String> names = List.of("Dory", "Gill", "Bruce", "Nemo", "Darla", "Marlin", "Jacques");

    //find if Nemo is there.

    //imperative style: we tell what to do and also how to do it
    //declarative style: we tell what to do but *not* how to do it
    //  we delegate the how to some underlying functions in the library

    if(names.contains("Nemo")) {
      System.out.println("Nemo found");
    } else {
      System.out.println("Nemo not found");
    }
  }
}

/*
In the imperative style we had explicit mutability
We also used a garbage variable - a variable not needed for the problem but
was dragged into by the solution we choose.
The details were on your face.

In the declarative style we did not use any explicit mutabilty
The details of how are hidden behind that function and we can reach into
it if we need, but the details are not on our face.

The declarative style code follow the SLAP much better - Single Level of
Abstraction Principle

Easier to understand, easier to read, and easier to maintain.
*/
