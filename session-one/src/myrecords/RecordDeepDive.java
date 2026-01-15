package myrecords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecordDeepDive {
    public record Range(int start, int end) {
        // start > end
        public Range {
            if (start > end) {
                var temp = start;
                start = end;
                end = temp;
                System.out.printf("Start %d and End %d swapped\n", start, end);
            }
            // implied actions follow
            // this.start = start
            // this.end = end
        }
    }

    public record Team(String name, List<String> members) {

        public Team(String name, List<String> members) {
            // does not replace default constructor hence the arguments
            this.name = name;
            // stop the "leak"
            if (members == null) {
                this.members = List.of();
            } else {
                this.members = Collections.unmodifiableList(members); // should be thread safe but...
            }
        }
    }

    public static void main(String... args) {
        System.out.println("Here we go with records...");
        Range r = new Range(4, 5);
        System.out.println(r);
        System.out.printf("This is the start %d and this is the end %s\n", r.start(), r.end());
        System.out.println("Hear we go with defensive copying...");
        List<String> list = new ArrayList<>(Arrays.asList("Alice", "Bob"));
        Team team = new Team("Devs", list);
        list.add("Donald");
        System.out.printf("Original list size is %d\n", list.size());
        System.out.printf("Record members size is %d\n", team.members().size());
    }
}
