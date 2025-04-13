package reflection.question2;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * An object created from a fully qualified Java class name and list of arguments,
 * or just a fully qualified Java class name, any arguments being
 * supplied via the command line.
 */
public class ObjectCreator {

    public static void main(String[] args) {
        if (args.length > 0) {
            Object obj1;
            try {
                if (args.length > 1) {
                    obj1 = builder(args[0], Arrays.copyOfRange(args, 1, args.length));
                } else {
                    obj1 = builder(args[0], new String[]{});
                }
                if (obj1 != null) System.out.println(obj1 + " - " + obj1.getClass());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates an instance of the class described in param className should such a
     * class exist. An appropriate constructor is chosen based on the number of
     * elements in the array argumentsList and all elements are passed to the
     * constructor as an appropriate type.
     *
     * @param className     fully qualified Java class name as a string
     * @param argumentsList String array of arguments or an empty String array to
     *                      pass to the class constructor
     * @return instantiated Object of class type className or null if construction is
     * not possible.
     * @throws ClassNotFoundException className does not refer to a known Class
     */
    public static Object builder(String className, String[] argumentsList) throws ClassNotFoundException {
        int argumentLen = argumentsList.length;
        for (Constructor<?> candidateConstructor : Class.forName(className).getConstructors()) {
            if (candidateConstructor.getParameterCount() == argumentLen) {
                try {
                    Object[] parameterObjs = new Object[argumentLen];
                    // get the candidate constructor parameters
                    Class<?>[] paramCons = candidateConstructor.getParameterTypes();
                    for (int i = 0; i < argumentLen; i++) {
                        // attempt to type the parameters using any available string constructors
                        // NoSuchMethodException will be thrown where retyping isn't possible
                        Class<?> c = toWrapper(paramCons[i]);
                        parameterObjs[i] = c.getConstructor(String.class).newInstance(argumentsList[i]);
                    }
                    // return instance ob object using the successful constructor
                    // and parameters of the right class types.
                    return candidateConstructor.newInstance(parameterObjs);
                } catch (NoSuchMethodException ignored) {
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * Return the correct Wrapper class if testClass is primitive
     *
     * @param testClass class being tested
     * @return Object class or testClass
     */
    private static Class<?> toWrapper(Class<?> testClass) {
        if (!testClass.isPrimitive()) return testClass;
        if (testClass == Integer.TYPE) return Integer.class;
        if (testClass == Long.TYPE) return Long.class;
        if (testClass == Boolean.TYPE) return Boolean.class;
        if (testClass == Byte.TYPE) return Byte.class;
        if (testClass == Character.TYPE) return Character.class;
        if (testClass == Float.TYPE) return Float.class;
        if (testClass == Double.TYPE) return Double.class;
        if (testClass == Short.TYPE) return Short.class;
        if (testClass == Void.TYPE) return Void.class;
        return testClass;
    }
}