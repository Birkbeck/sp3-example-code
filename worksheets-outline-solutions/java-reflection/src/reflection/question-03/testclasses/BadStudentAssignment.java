package reflection.question3.testclasses;

import java.util.ArrayList;

/**
 * Class that should fail every test in JUnit assignment test class.
 */
public class BadStudentAssignment {
    private static final int d = -1;
    private final int b = 3;
    private final ArrayList<Integer> failingArrayListField = new ArrayList<>();
    private final int a;
    public int failingPublicField = 1;

    BadStudentAssignment(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
    }

    private static Integer helper1() {
        return 10;
    }

    public int BadReturnType() {
        return 1;
    }

    public Integer GoodIntReturnType() {
        return 1;
    }

    public String GoodReturnType() {
        return "1";
    }

    public void BadThrows() throws Exception {
        throw new Exception();
    }
}