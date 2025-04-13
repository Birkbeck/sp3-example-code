### Generic Wildcards

+ Read from a generic collection
+ Write to a generic collection

```java
import java.util.ArrayList;

List<?> wild = new ArrayList<A>();
List<? extends A> wildRead = new ArrayList<A>();
List<? super A> wildWrite = new ArrayList<A>();
```