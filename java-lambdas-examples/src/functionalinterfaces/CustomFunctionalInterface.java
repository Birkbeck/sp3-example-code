package functionalinterfaces;

@FunctionalInterface
public interface CustomFunctionalInterface {

    //Single abstract method
    void singleMethod(String param);

    //void multipleMethods(String param1, String param2);

  default void foo(){}

  static void goo(){}

  private void meth(){}

  int THING = 3;
}