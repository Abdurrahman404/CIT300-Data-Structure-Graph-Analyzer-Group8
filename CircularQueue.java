import java.util.Arrays;

public class CircularQueue {
    private final int[] data;
    private int front;
    private int size;
    public CircularQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive.");
        data = new int[capacity];
    }
    public int size() { return size; }
    public void enqueue(int value) {
        if (size == data.length) throw new IllegalStateException("Queue is full.");
        int rear = (front + size) % data.length;
        data[rear] = value;
        size++;
    }
    public int dequeue() {
        if (size == 0) throw new IllegalStateException("Queue is empty.");
        int value = data[front]; data[front] = 0;
        front = (front + 1) % data.length;
        size--;
        return value;
    }
    public int peek() {
        if (size == 0) throw new IllegalStateException("Queue is empty.");
        return data[front];
    }
    public void clear() { Arrays.fill(data, 0); front = 0; size = 0; }
    public int[] toArray() {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) result[i] = data[(front + i) % data.length];
        return result;
    }
    public String toString() { return Arrays.toString(toArray()); }
}
