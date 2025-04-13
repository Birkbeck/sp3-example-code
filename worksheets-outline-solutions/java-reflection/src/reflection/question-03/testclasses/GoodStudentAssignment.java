package reflection.question3.testclasses;

/**
 * Class that should pass every test in JUnit assignment test class.
 */
public class GoodStudentAssignment {

    private static final int d = -1;
    private final int b = 3;
    private int a;

    GoodStudentAssignment() {
    }

    GoodStudentAssignment(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
    }

    private static Integer helper1() {
        return 10;
    }

    private static String helper2() {
        return "helpful";
    }

    public Integer GoodIntReturnType() {
        return 1;
    }

    public String GoodReturnType() {
        return "1";
    }
}