package queue;

public class Queue {
    private Node front, rear;
    private int size;

    public Queue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Implement dequeue, peek, and isEmpty methods
}