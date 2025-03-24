// generics/PlainGenericInheritance.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import misc.Base;
import misc.Derived;

class GenericSetter<T> { // Not self-bounded
  void set(T arg) {
    System.out.println("GenericSetter.set(misc.Base)");
  }
}

class DerivedGS extends GenericSetter<Base> {
  void set(Derived derived) {
    System.out.println("DerivedGS.set(misc.Derived)");
  }
}

public class PlainGenericInheritance {
  public static void main(String[] args) {
    Base base = new Base();
    Derived derived = new Derived();
    DerivedGS dgs = new DerivedGS();
    dgs.set(derived);
    dgs.set(base); // Overloaded, not overridden!
  }
}
/* Output:
DerivedGS.set(misc.Derived)
GenericSetter.set(misc.Base)
*/
