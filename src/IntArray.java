import java.util.Arrays;

/** A fixed-capacity array with a separate logical size. Indexes start at 0. */
public class IntArray {
    private final int[] data;
    private int size;

    public IntArray(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive.");
        data = new int[capacity];
    }
    public int size() { return size; }
    public int capacity() { return data.length; }

    public void insert(int index, int value) {
        if (index < 0 || index > size) throw new IllegalArgumentException("Invalid insertion index.");
        if (size == data.length) throw new IllegalStateException("Array is full.");
        for (int i = size; i > index; i--) data[i] = data[i - 1];
        data[index] = value;
        size++;
    }
    public int delete(int index) {
        if (size == 0) throw new IllegalStateException("Array is empty.");
        if (index < 0 || index >= size) throw new IllegalArgumentException("Invalid deletion index.");
        int removed = data[index];
        for (int i = index; i < size - 1; i++) data[i] = data[i + 1];
        data[--size] = 0;
        return removed;
    }
    public SearchResult search(int target) { return SearchAlgorithms.linear(toArray(), target); }
    public int[] toArray() { return Arrays.copyOf(data, size); }
    public void clear() { Arrays.fill(data, 0); size = 0; }
    public String toString() { return Arrays.toString(toArray()); }
}
