package defensivecopy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyDataStructure {
    List<String> list = new ArrayList<>();

    public void add(String s) {
        list.add(s);
    }

    /**
     * Makes a defensive copy of the List and return it
     * This way cannot modify the list itself
     *
     * @return List<String>
     */
    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }
}