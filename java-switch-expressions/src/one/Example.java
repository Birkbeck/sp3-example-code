package one;

enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class Example {
    public static void main(String[] args) {
        expression();
    }

//    static void expression(){
//        int numLetters = 0;
//        Day day = Day.WEDNESDAY;
//        switch (day) {
//            case MONDAY:
//            case FRIDAY:
//            case SUNDAY:
//                numLetters = 6;
//                break;
//            case TUESDAY:
//                numLetters = 7;
//                break;
//            case THURSDAY:
//            case SATURDAY:
//                numLetters = 8;
//                break;
//            case WEDNESDAY:
//                numLetters = 9;
//                break;
//            default:
//                throw new IllegalStateException("Invalid day: " + day);
//        }
//        System.out.println(numLetters);
//    }

//    static void expression() {
//        int numLetters = 0;
//        Day day = Day.WEDNESDAY;
//        switch (day) {
//            case MONDAY, FRIDAY, SUNDAY -> numLetters = 6;
//            case TUESDAY -> numLetters = 7;
//            case THURSDAY, SATURDAY -> numLetters = 8;
//            case WEDNESDAY -> numLetters = 9;
//            default -> throw new IllegalStateException("Invalid day: " + day);
//        }
//        System.out.println(numLetters);
//    }

//    static void expression() {
//        Day day = Day.WEDNESDAY;
//        System.out.println(
//            switch (day) {
//                case MONDAY, FRIDAY, SUNDAY -> 6;
//                case TUESDAY -> 7;
//                case THURSDAY, SATURDAY -> 8;
//                case WEDNESDAY -> 9;
//                default -> throw new IllegalStateException("Invalid day: " + day);
//            }
//        );
//    }


    static void expression() {
        Day day = Day.WEDNESDAY;
        int numLetters = switch (day) {
            case MONDAY,
                    FRIDAY,
                    SUNDAY -> {
                System.out.println(6);
                yield 6;
            }
            case TUESDAY -> {
                System.out.println(7);
                yield 7;
            }
            case THURSDAY,
                    SATURDAY -> {
                System.out.println(8);
                yield 8;
            }
            case WEDNESDAY -> {
                System.out.println(9);
                yield 9;
            }
            default -> {
                throw new IllegalStateException("Invalid day: " + day);
            }
        };
        System.out.println(numLetters);
    }
}