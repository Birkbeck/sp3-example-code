package top.items;

import top.Container;
import top.ThingBridge;

public class MySubClass extends Container {

    public void doSomething() {
        var t = new ThingBridge(this.getThings());
        t.getBridgeitem();
    }
}
