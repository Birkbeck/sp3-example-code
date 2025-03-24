// generics/OrdinaryArguments.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import misc.Base;
import misc.Derived;

class OrdinarySetter {
  void set(Base base) {
    System.out.println("OrdinarySetter.set(misc.Base)");
  }
}

class DerivedSetter extends OrdinarySetter {
  void set(Derived derived) {
    System.out.println("DerivedSetter.set(misc.Derived)");
  }
}

public class OrdinaryArguments {
  public static void main(String[] args) {
    Base base = new Base();
    Derived derived = new Derived();
    DerivedSetter ds = new DerivedSetter();
    ds.set(derived);
    // Compiles--overloaded, not overridden!:
    ds.set(base);
  }
}
/* Output:
DerivedSetter.set(misc.Derived)
OrdinarySetter.set(misc.Base)
*/
