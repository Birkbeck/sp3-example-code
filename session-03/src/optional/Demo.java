package optional;

import java.util.Optional;

class Demo {
    static void main() {

        //String name = Demo.getName();
        Optional<String> name = Optional.ofNullable(getName());
        System.out.println(name);
        System.out.println(name.map(String::valueOf).orElse("0"));
        //       System.out.println(name.length());

//        if (name != null) {
//            System.out.println(name.length());
//        } else {
//            System.out.println(0);
//        }
    }

    static String getName() {
        return "asassa";
    }
}