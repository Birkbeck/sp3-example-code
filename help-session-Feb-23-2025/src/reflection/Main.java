package reflection;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        do {
            System.out.print("Which class do you wish to create?  (A, B, C): ");
            Scanner scanner = new Scanner(System.in);
            var classname = scanner.next();
            if (classname.equals("DONE")) {
                return;
            }
            System.out.println("Class name: " + classname);
            String fqcn = "reflection.sub." + classname + "Sub";
            var obj = getInstance(fqcn);
            obj.ifPresent(base -> System.out.println(base.print()));
        } while (true);
    }

    /**
     * @param fqcn
     * @return
     */
    static Optional<Base> getInstance(String fqcn) {
        Optional<Base> opt = Optional.empty();
        try {
            Class<?> clazz = Class.forName(fqcn);
            opt = Optional.of(Base.class.cast(clazz.getDeclaredConstructor().newInstance()));
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found: " + fqcn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return opt;
    }
}

