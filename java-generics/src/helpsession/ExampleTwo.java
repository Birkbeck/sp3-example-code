package helpsession;

interface A {
}

interface B {
}

interface C extends A, B {
}

public class ExampleTwo {
    public static void main(String[] args) {
        A member1 = new Holder<C>().member;
        B member2 = new Holder<C>().member;
        C member3 = new Holder<C>().member;
        A member4 = new Cclass();
    }
}

class Cclass implements C {
}

class Holder<T extends A & B> {
    T member;
}