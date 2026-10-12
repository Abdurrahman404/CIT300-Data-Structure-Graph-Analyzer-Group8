import java.util.Arrays;

/** Singly linked list. Tail reference makes append O(1). */
public class IntLinkedList {
    private static class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; }
    }
    private Node head;
    private Node tail;
    private int size;
    public int size() { return size; }
    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head; head = node;
        if (tail == null) tail = node;
        size++;
    }
    public void insertLast(int value) {
        Node node = new Node(value);
        if (tail == null) head = node; else tail.next = node;
        tail = node; size++;
    }
    /** Removes the first occurrence only; returns false if it is absent. */
    public boolean delete(int value) {
        Node previous = null;
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                if (previous == null) head = current.next; else previous.next = current.next;
                if (current == tail) tail = previous;
                size--; return true;
            }
            previous = current; current = current.next;
        }
        return false;
    }
    public SearchResult search(int target) {
        long start = System.nanoTime();
        int index = 0;
        for (Node current = head; current != null; current = current.next, index++) {
            if (current.value == target)
                return new SearchResult(index, index + 1, System.nanoTime() - start);
        }
        return new SearchResult(-1, index, System.nanoTime() - start);
    }
    public int[] toArray() {
        int[] result = new int[size]; int index = 0;
        for (Node node = head; node != null; node = node.next) result[index++] = node.value;
        return result;
    }
    public void clear() { head = null; tail = null; size = 0; }
    public String toString() { return Arrays.toString(toArray()); }
}
