package concurrent;// concurrent/CollectionIntoStream.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import onjava.Rand;

import java.util.*;
import java.util.stream.*;

public class CollectionIntoStream {
  public static void main(String[] args) {
    List<Integer> ints =
      Stream.generate(new Random(5)::nextInt)
        .limit(10)
        .toList();
    ints.forEach(System.out::println);
    // Convert to a Stream for many more options:
    Integer result = ints.stream()
      .reduce(0, Integer::sum);
    System.out.println(result);
  }
}
/* Output:
btpen
pccux
szgvg
meinn
eeloz
tdvew
cippc
ygpoa
lkljl
bynxt
:PENCUXGVGINNLOZVEWPPCPOALJLNXT
*/
