import java.util.*;
import java.util.function.*;

public class Sample {
  public static void print(int number, String msg,
    Function<Integer, Integer> func) {

    System.out.println(number + " " + msg + ": " + func.apply(number));
  }

  public static void main(String[] args) {
    Function<Integer, Integer> inc = e -> e + 1; 
    Function<Integer, Integer> doubled = e -> e * 2;

    print(5, "increment", inc);
    print(6, "increment", inc);

    print(5, "doubled", doubled);
    print(6, "doubled", doubled);

    Function<Integer, Integer> incrementAndDouble =
      inc.andThen(doubled);

    print(5, "incremeted and doubled", incrementAndDouble);

    /*
         -----> |  inc  | ---->
         -----> |  doubled  | ---->

	               incrementAndDouble
         -----> ||----> |  inc | ---> | doubled |---> || --->
    */
  }
}


