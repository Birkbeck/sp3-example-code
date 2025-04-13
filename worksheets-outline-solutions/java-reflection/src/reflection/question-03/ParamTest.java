package reflection.question3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import reflection.question3.testclasses.BadStudentAssignment;
import reflection.question3.testclasses.GoodStudentAssignment;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A JUnit test to grade the internal correctness
 * of a student’s submitted program for a hypothetical assignment.
 * Parameterised set up that runs all tests on multiple
 * student classes. Each class to be tested should be added to the
 * ValueSource annotation array before <b>all</b> tests.
 * <p>
 * The tests fail if the class under test has any of the following:
 * <ul><li>more than four fields</li>
 * <li>any non-private fields</li>
 * <li>any fields of type ArrayList</li>
 * <li>fewer than two private helper methods</li>
 * <li>any method that has a throws clause</li>
 * <li>any method that returns an int</li>
 * <li>missing a zero-argument constructor</li></ul>
 */
public class ParamTest {

    @ParameterizedTest
    @ValueSource(classes = {BadStudentAssignment.class, GoodStudentAssignment.class})
    public void classHasFewerThanFiveFields(Class testClass) {
        assertTrue(testClass.getDeclaredFields().length < 5,
                "More than four fields declared.");
    }

    @ParameterizedTest
    @ValueSource(classes = {BadStudentAssignment.class, GoodStudentAssignment.class})
    void classOnlyHasPrivateFields(Class testClass) {
        Field[] flds = testClass.getDeclaredFields();
        for (Field fld : flds) {
            // Bitwise OR the field modifier int with the PRIVATE value.
            // If the method is static the operation result will
            // still equal the original modifier value.
            assertEquals(fld.getModifiers(), fld.getModifiers() | Modifier.PRIVATE,
                    "Non-private field found.");
        }
    }

    @ParameterizedTest
    @ValueSource(classes = {BadStudentAssignment.class, GoodStudentAssignment.class})
    void classHasNoFieldsOfArrayListType(Class testClass) {
        Field[] flds = testClass.getDeclaredFields();
        for (Field fld : flds) {
            assertNotEquals(java.util.ArrayList.class, fld.getType(),
                    "Field with an ArrayList type found.");
        }
    }

    //TODO update based on understanding of what a helper method is
    @ParameterizedTest
    @ValueSource(classes = {BadStudentAssignment.class, GoodStudentAssignment.class})
    void classHasTwoOrMoreHelperMethods(Class testClass) {
        // assumes a helper method in this context is a static method
        // other than the main method
        int helper = 0;
        Method[] methods = testClass.getDeclaredMethods();
        for (Method method : methods) {
            // Bitwise OR the method modifier int with the STATIC value.
            // If the method is static the operation result will
            // still equal the original modifier value.
            if ((method.getModifiers() | Modifier.STATIC) == method.getModifiers() &&
                    !method.getName().equals("main")) {
                helper += 1;
            }
        }
        assertTrue(helper >= 2,
                "The class has fewer than 2 helper methods.");
    }

    @ParameterizedTest
    @ValueSource(classes = {BadStudentAssignment.class, GoodStudentAssignment.class})
    void noMethodsHaveThrowClauses(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        for (Method method : methods) {
            assertEquals(0, method.getExceptionTypes().length,
                    "Method with a throw clause found in the class.");
        }
    }

    @ParameterizedTest
    @ValueSource(classes = {BadStudentAssignment.class, GoodStudentAssignment.class})
    void noMethodsReturnAnInt(Class testClass) {
        Method[] methods = testClass.getDeclaredMethods();
        for (Method method : methods) {
            assertNotEquals(int.class, method.getReturnType(),
                    "Method returning an int found in the class.");
        }
    }

    @ParameterizedTest
    @ValueSource(classes = {BadStudentAssignment.class, GoodStudentAssignment.class})
    void classHasAZeroArgumentConstructor(Class testClass) {
        Constructor[] constrs = testClass.getDeclaredConstructors();
        for (Constructor constr : constrs) {
            if (constr.getParameterCount() == 0) {
                return;
            }
        }
        fail("Class does not have a zero-argument constructor.");
    }
}