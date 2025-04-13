package reflection.question3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A JUnit test to grade the internal correctness
 * of a student’s submitted program for a hypothetical assignment.
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
public class AssignmentTest {

    static Class c;

    @BeforeAll
    static void getTestClass() throws ClassNotFoundException {
        c = Class.forName("reflection.question3.testclasses.BadStudentAssignment");
    }

    @Test
    void classHasFewerThanFiveFields() {
        assertTrue(c.getDeclaredFields().length < 5,
                "More than four fields declared.");
    }

    @Test
    void classOnlyHasPrivateFields() {
        Field[] flds = c.getDeclaredFields();
        for (Field fld : flds) {
            // Bitwise OR the field modifier int with the PRIVATE value.
            // If the method is static the operation result will
            // still equal the original modifier value.
            assertEquals(fld.getModifiers(), fld.getModifiers() | Modifier.PRIVATE,
                    "Non-private field found.");
        }
    }

    @Test
    void classHasNoFieldsOfArrayListType() {
        Field[] flds = c.getDeclaredFields();
        for (Field fld : flds) {
            assertNotEquals(java.util.ArrayList.class, fld.getType(),
                    "Field with an ArrayList type found.");
        }
    }

    //TODO update based on understanding of what a helper method is
    @Test
    void classHasTwoOrMoreHelperMethods() {
        // assumes a helper method in this context is a static method
        // other than the main method
        int helper = 0;
        Method[] methods = c.getDeclaredMethods();
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

    @Test
    void noMethodsHaveThrowClauses() {
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            assertEquals(0, method.getExceptionTypes().length,
                    "Method with a throw clause found in the class.");
        }
    }

    @Test
    void noMethodsReturnAnInt() {
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            assertNotEquals(int.class, method.getReturnType(),
                    "Method returning an int found in the class.");
        }
    }

    @Test
    void classHasAZeroArgumentConstructor() {
        Constructor[] constrs = c.getDeclaredConstructors();
        for (Constructor constr : constrs) {
            if (constr.getParameterCount() == 0) {
                return;
            }
        }
        fail("Class does not have a zero-argument constructor.");
    }
}