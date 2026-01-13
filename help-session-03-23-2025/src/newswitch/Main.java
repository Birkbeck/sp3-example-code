package newswitch;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var num = 0.0;
        do {
            var sc = new Scanner(System.in);
            System.out.println("A numeric value? ");
            var item = sc.next();
            num = (double) nullExample(item);
            System.out.println(num);
        } while (num != 0);
    }

    static double nullExample(Object o) {
        return switch (o) {
            case String s -> Double.parseDouble(s);
            case null -> 0d;
            default -> throw new IllegalStateException("Unexpected value: " + o);
        };
    }

    static String exampleOfOldSwitch(String animal) {
        String result = "";
        switch (animal) {
            case "DOG":
                result = "Dog";
                break;
            case "CAT":
                result = "Cat";
                break;
            default:
                result = "Unknown";
                break;
        }
        return result;
    }

    static String exampleOfNewSwitchExpression(String animal) {
        return switch (animal) {
            case "DOG" -> "Dog";
            case "CAT" -> "Cat";
            default -> "Unknown";
        };
    }

//    static String exampleRange(int x){
//        return switch (x){
//            case 1 -> "One";
//            case 2..5 ->
//            default -> "Out of Range";
//        }
//    }

    static String exampleOfYield(String animal) {
        return switch (animal) {
            case "DOG", "CAT", "RABBIT" -> "Domestic Animal";
            case "TIGER", "LION", "WOLF" -> {
                var str = "Wild Animal";
                yield "To be avoided: " + str;
            }
            default -> "Unknown";
        };
    }

    static void primtivesExample() {
        var r = new Random();
        switch (r.nextInt()) {
            case 1 -> System.out.println("1");
            case int i when i > 1 && i < 100 -> System.out.println("int is greater than 1 and less than 100");
            default -> System.out.println("int is greater than or equal to 100");
        }
    }
}
