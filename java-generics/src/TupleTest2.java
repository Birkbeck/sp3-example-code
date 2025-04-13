import misc.Amphibian;
import onjava.Tuple2;
import onjava.Tuple3;
import onjava.Tuple4;
import onjava.Tuple5;

import static onjava.Tuple.tuple;

public class TupleTest2 {
    public static void main(String[] args) {
        Tuple2<String, Integer> ttsi = f();
        System.out.println(ttsi);
        System.out.println(f2());
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }

    static Tuple2<String, Integer> f() {
        return tuple("hi", 47);
    }

    static Tuple2 f2() {
        return tuple("hi", 47);
    }

    static Tuple3<Amphibian, String, Integer> g() {
        return tuple(new Amphibian(), "hi", 47);
    }

    static Tuple4<Vehicle, Amphibian, String, Integer> h() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47);
    }

    static Tuple5<Vehicle, Amphibian, String, Integer, Double> k() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47, 11.1);
    }
}
/* Output:
(hi, 47)
(hi, 47)
(misc.Amphibian@a298b7, hi, 47)
(Vehicle@16d3586, misc.Amphibian@154617c, hi, 47)
(Vehicle@17327b6, misc.Amphibian@14ae5a5, hi, 47, 11.1)
*/
