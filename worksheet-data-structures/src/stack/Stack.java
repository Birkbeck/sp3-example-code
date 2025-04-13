package stack;

public class Stack {
    private int[] stack;
    private int top;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;
    }

    public void push(int data) {
        if (top == capacity - 1) {
            throw new StackOverflowError("Stack is full");
        }
        stack[++top] = data;
    }

    // Implement pop, peek, and isEmpty methods
}