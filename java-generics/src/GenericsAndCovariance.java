// generics/GenericsAndCovariance.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.
import misc.Fruit;

import java.util.*;

public class GenericsAndCovariance {
  public static void main(String[] args) {
    // Wildcards allow covariance:
    List<? extends Fruit> flist = new ArrayList<>();
    // Compile Error: can't add any type of object:
    // flist.add(new misc.Apple());
    // flist.add(new misc.Fruit());
    // flist.add(new Object());
    flist.add(null); // Legal but uninteresting
    // We know it returns at least misc.Fruit:
    Fruit f = flist.get(0);
  }
}
