package reflection.question4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * A universal toString method that gives a string
 * representation of any object showing
 * the object's class name and all declared field names and
 * values are printed.
 */
public class UniversalToString {

    public static void main(String[] args) {

    }

    /**
     * Returns all declared fields (public and non-public) in the parameter obj.
     * The class name and field name/value pairs are returned as a String
     * using the following pattern:
     * classname{fieldname1=value1, fieldname2=value2...}
     * <p>
     * Field values that are reference classes that do not have a toString method
     * will be included in the returned string using the same basic pattern:
     * classnameA{fieldname1=refclassB{fieldnameB1=valueB1, ...}, ...}
     *
     * @param obj instance object of any class type
     * @return string describing the class name, field names and values.
     */
    public static String toString(Object obj) {
        if (obj == null) return "null";
        Class<?> c = obj.getClass();
        // Array storage of name=value pairs
        List<String> fieldValues = new ArrayList<>();
        // work through declared fields in object
        for (Field fld : c.getDeclaredFields()) {
            try {
                // expose non public field values
                if (!Modifier.isPublic(fld.getModifiers()) && !fld.trySetAccessible()) {
                    return "Inaccessible";
                }
                Class<?> fieldTypeClass = fld.getType();
                Object fieldValue = fld.get(obj);
                // get and assign field values for primitive types
                if (fieldTypeClass.isPrimitive()) {
                    fieldValues.add(fld.getName() + "="
                            + (fieldTypeClass == Character.TYPE ? "'" + fieldValue + "'" : fieldValue));
                } else {
                    try {
                        // check if there's a declared toString method
                        Method m = fieldTypeClass.getDeclaredMethod("toString");

                        fieldValues.add(fld.getName() + "="
                                + (fieldTypeClass == String.class && fieldValue != null
                                ? "\"" + fieldValue + "\"" : fieldValue));
                    } catch (NoSuchMethodException e) {
                        // if there's no toString - recursively call GeneralToString on the fieldValue Object
                        fieldValues.add(fld.getName() + "=" + toString(fieldValue));
                    }
                }
            } catch (IllegalAccessException e) {
                fieldValues.add(fld.getName() + "=IllegalAccess");
            }
        }
        return c.getSimpleName() + "{" + String.join(", ", fieldValues) + "}";
    }
}