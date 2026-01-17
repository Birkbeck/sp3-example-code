package pecsexample;

import java.util.List;

public class Demo {
    void manageUsers(List<? super User> list){
        // which of the following works?

        list.add(new Admin()); // YES
        // list.add(new Object()); // NO
        Object obj = list.getFirst(); // YES
        // User u = list.getFirst(); // NO
    }
}

class User{}
class Admin extends User {}

