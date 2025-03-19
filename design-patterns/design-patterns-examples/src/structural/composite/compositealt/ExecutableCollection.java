package structural.composite.compositealt;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class ExecutableCollection implements Executable { // Composite
    protected Collection executables = new LinkedList();

    public void addExecutable(Executable executable) {
        this.executables.add(executable);
    }

    public void removeExecutable(Executable executable) {
        this.executables.remove(executable);
    }

    @Override
    public void execute() {
        for (Iterator i = this.executables.iterator(); i.hasNext(); ) {
            ((Executable) i.next()).execute();
        }
    }
}