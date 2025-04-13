package reflection.question1;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A class that takes the fully qualified Java class name as a String or a Class object
 * and provides public methods for accessing metadata about the class.
 * The toString method of an instance of this class will return an interface
 * description of the class declaration, and the fields, constructors and methods
 * of the class.
 */
public class InterfaceConstructor {

    private final static String INDENT = "\t";
    private Class<?> c;

    public InterfaceConstructor(Class<?> c) {
        this.c = c;
    }

    public InterfaceConstructor(String className) {
        try {
            this.c = Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.err.println("Unknown classname '" + className +
                    "' supplied to InterfaceConstructor constructor method.");
        }
    }

    /**
     * Create a string of Strings that have had any null values removed and that
     * are separated by a user defined delimiter.
     *
     * @param strings   array of Strings to be joined possibly including null values
     * @param delimiter string of the delimiter
     * @return string of delimiter separated String
     */
    private static String joinArrayRemovingNullEntries(String[] strings, String delimiter) {
        return Arrays.stream(strings)
                .filter(Objects::nonNull)
                .collect(Collectors.joining(delimiter));
    }

    /**
     * Removes all package names for a fully qualified class name, including package names
     * from any parameterized types present in the name.
     *
     * @param className string of fully qualified class name
     * @return simplified class name.
     */
    public static String simplifyClass(String className) {
        Pattern p = Pattern.compile("([$_A-Za-z0-9]+?\\.)+([$_A-Za-z0-9]+.*)");
        Matcher m = p.matcher(className);
        while (m.find()) {
            className = m.replaceAll("$2");
            m = p.matcher(className);
        }
        return className;
    }

    /**
     * Create a string of simplified parameter types that are separated by a
     * user defined delimiter.
     *
     * @param params    array list of reflection parameters
     * @param delimiter string of the delimiter
     * @return string of delimiter separated parameter types
     */
    private static String getDelimiterSeparatedParameterTypes(Parameter[] params, String delimiter) {
        return Stream.of(params)
                .map(Parameter -> simplifyTypeClass(Parameter.getParameterizedType()))
                .collect(Collectors.joining(delimiter));
    }

    private static String simplifyTypeClass(Type t) {
        return simplifyClass(t.getTypeName());
    }

    public String getClassType() {
        if (c.isInterface()) return null;
        return "class";
    }

    public String getExtension() {
        if (c.getSuperclass() != null) {
            return "extends " + c.getSuperclass().getSimpleName();
        }
        return null;
    }

    private String getSimpleModifiers(int modifiers) {
        if (modifiers != 0) {
            return Modifier.toString(modifiers);
        }
        return null;
    }

    public String getInterfaces() {
        if (c.getInterfaces().length != 0) {
            return "implements " + Stream.of(c.getInterfaces())
                    .map(Class::getSimpleName)
                    .collect(Collectors.joining(", "));
        }
        return null;
    }

    public String getClassDeclaration() {
        return joinArrayRemovingNullEntries(new String[]{
                        getSimpleModifiers(c.getModifiers()),
                        getClassType(),
                        c.getSimpleName(),
                        getExtension(),
                        getInterfaces()},
                " ");
    }

    public String getFieldInformation() {
        if (c.getDeclaredFields().length == 0) return null;

        List<String> output = new ArrayList<>(Arrays.asList(INDENT + "// Field information", ""));
        for (Field fld : c.getDeclaredFields()) {
            output.add(1, joinArrayRemovingNullEntries(new String[]{INDENT,
                            getSimpleModifiers(fld.getModifiers()),
                            simplifyTypeClass(fld.getGenericType()),
                            fld.getName() + ";",},
                    " "));
        }
        return String.join("\n", output);
    }

    public String getConstructorsInformation() {
        if (c.getConstructors().length == 0) return null;

        List<String> output = new ArrayList<>(Arrays.asList(INDENT + "// Constructor information", ""));
        for (Constructor<?> constr : c.getConstructors()) {
            output.add(1, joinArrayRemovingNullEntries(new String[]{INDENT,
                            getSimpleModifiers(constr.getModifiers()),
                            simplifyClass(constr.getName())
                                    + "(" + getDelimiterSeparatedParameterTypes(constr.getParameters(), ", ") + ");",},
                    " "));
        }
        return String.join("\n", output);
    }

    public String getMethodsInformation() {
        if (c.getDeclaredMethods().length == 0) return null;

        List<String> output = new ArrayList<>(Arrays.asList(INDENT + "// Declared method information", ""));
        for (Method method : c.getDeclaredMethods()) {
            output.add(1, joinArrayRemovingNullEntries(new String[]{INDENT,
                            getSimpleModifiers(method.getModifiers()),
                            simplifyTypeClass(method.getGenericReturnType()),
                            method.getName()
                                    + "(" + getDelimiterSeparatedParameterTypes(method.getParameters(), ", ") + ");"},
                    " "));
        }
        return String.join("\n", output);
    }

    @Override
    public String toString() {
        if (c == null) return null;
        return joinArrayRemovingNullEntries(new String[]{
                        "/**",
                        " * Interface created for " + c.getCanonicalName(),
                        " */",
                        getClassDeclaration() + " {",
                        getFieldInformation(),
                        getConstructorsInformation(),
                        getMethodsInformation(),
                        "}"},
                "\n");
    }
} // InterfaceConstructor