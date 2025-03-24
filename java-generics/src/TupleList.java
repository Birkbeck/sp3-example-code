import misc.Amphibian;
import onjava.Tuple4;

import java.util.ArrayList;

public class TupleList<A, B, C, D> extends ArrayList<Tuple4<A, B, C, D>> {
    public static void main(String[] args) {
        TupleList<Vehicle, Amphibian, String, Integer> tl = new TupleList<>();
        tl.add(TupleTest2.h());
        tl.add(TupleTest2.h());
        tl.forEach(System.out::println);
    }
}
/* Output:
(Vehicle@ec7777, misc.Amphibian@107d329, hi, 47)
(Vehicle@1629346, misc.Amphibian@4b9385, hi, 47)
*/
