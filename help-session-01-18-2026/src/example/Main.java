package example;

import example.impl.StudentImpl;
import example.impl.TeachingAssistantImpl;
import example.spec.Student;
import example.spec.TeachingAssistant;

public class Main {
    static void main() {
        Student s = new StudentImpl();
        TeachingAssistant ta = new TeachingAssistantImpl();
        s.thing();
        ta.thing();
        // System.out.printf("Name is: %s\n", s.name); // mixin doesn't confirm to the interface spec
        }
    }
}
