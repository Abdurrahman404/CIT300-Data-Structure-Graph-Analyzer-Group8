import java.util.Arrays;

/** Array-based LIFO stack. Push, pop and peek take O(1) time. */
public class IntStack {
    private final int[] data;
    private int size;
    public IntStack(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive.");
        data = new int[capacity];
    }
    public int size() { return size; }
    public void push(int value) {
        if (size == data.length) throw new IllegalStateException("Stack is full.");
        data[size++] = value;
    }
    public int pop() {
        if (size == 0) throw new IllegalStateException("Stack is empty.");
        int value = data[--size]; data[size] = 0; return value;
    }
    public int peek() {
        if (size == 0) throw new IllegalStateException("Stack is empty.");
        return data[size - 1];
    }
    public void clear() { Arrays.fill(data, 0); size = 0; }
    public String toString() { return Arrays.toString(Arrays.copyOf(data, size)); }
}
