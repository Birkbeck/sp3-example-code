package linkedlist;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
class Node {
    private int data;
    private Node next;
}