package linkedlist;

public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next() != null) {
                current = current.next();
            }
            current.next(newNode);
        }
        size++;
    }

    // Implement remove, contains, and size methods

}