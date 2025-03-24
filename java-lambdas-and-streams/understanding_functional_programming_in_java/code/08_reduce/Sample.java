import java.util.*;

public class Sample {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

    var result =  numbers.stream()
      .filter(e -> e % 2 == 0)
      .map(e -> e * 2)
      .reduce(0, (total, e) -> total + e);

    System.out.println(result);
  }
}

/*
The reduce operation comes in two flavors.
1. We convert or transform a collection into a single value
or
2. We convert or transform a collection into another destination or
concrete collection

If we want to produce a single result

        e1    e2    e3 ...
	|     |     |
init -> op -> op -> op -> ...  result

          ei
	  |
          v
  init -> op -----> output
       ^       |
       |       |
       ---------

We may do this from left to right (fold or reduce or foldLeft)
We may do this from right to left (foldRight - available in some langauges
but not Java)

     filter %       map * 2              reduce +
x1     |                                   0
--------------------------------------------\-----------
x2 ---------->       * 2 ---------> y2 --->  + (0 + 4 = 4)
----------------------------------------------\---------
x3     |                                       \
------------------------------------------------\-------
x4 ---------->       * 2 ---------> y4 ------->  + (4 + 8 = 12)
--------------------------------------------------\-----
x5     |                                           \
----------------------------------------------------\---
x6 ---------->       * 2 ---------> y6 ------------> + (12 + 12 = 24)
                                                      \--> output

*/


