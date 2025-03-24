package misc;// generics/misc.BasicSupplierDemo.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import java.util.stream.*;

public class BasicSupplierDemo {
  public static void main(String[] args) {
    Stream.generate(
      BasicSupplier.create(CountedObject.class))
      .limit(5)
      .forEach(System.out::println);
  }
}
/* Output:
misc.CountedObject 0
misc.CountedObject 1
misc.CountedObject 2
misc.CountedObject 3
misc.CountedObject 4
*/
