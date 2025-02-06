package enumeration;

import java.util.Scanner;

public class EnumTest {
    enum SIZE {
        SMALL("S"), MEDIUM("M"), LARGE("L");

        private SIZE(String s) {
            this.value = s;
        }

        public String getValue() {
            return this.value;
        }

        private String value;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) { // try with resources
            System.out.println("Enter a size (SMALL, MEDIUM, or LARGE : ");
            String input = in.next().toUpperCase();
            SIZE size = Enum.valueOf(SIZE.class, input);
            System.out.println("Size = " + size);
            System.out.println("Value is: " + size.getValue());
            if (size == SIZE.SMALL) {
                System.out.println("Value is SMALL");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
//        finally {
//            System.out.println("This always is executed");
//        }
    }
}
