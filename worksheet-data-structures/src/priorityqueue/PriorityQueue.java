package priorityqueue;

public class PriorityQueue {
    private int[] heap;
    private int size;

    public PriorityQueue(int capacity) {
        this.heap = new int[capacity];
        this.size = 0;
    }

    public void insert(int data) {
        if (size == heap.length) {
            throw new IllegalStateException("Heap is full");
        }
        heap[size] = data;
        size++;
        heapifyUp(size - 1);
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        if (index > 0 && heap[index] < heap[parentIndex]) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    // Implement extractMin, peekMin, and heapifyDown methods
}