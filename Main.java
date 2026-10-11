import java.util.Arrays;
import java.util.Scanner;

/** CIT300 Assignment 2: integrated console entry point. No external libraries. */
public class Main {
    private final Scanner input = new Scanner(System.in);
    private final IntArray array = new IntArray(10);
    private final IntStack stack = new IntStack(10);
    private final CircularQueue queue = new CircularQueue(10);
    private final IntLinkedList list = new IntLinkedList();
    private final Graph graph = new Graph();
    private final PerformanceLog log = new PerformanceLog();

    private static class EndOfInput extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }
    public static void main(String[] args) { new Main().run(); }

    private String readLine(String prompt) {
        System.out.print(prompt);
        if (!input.hasNextLine()) throw new EndOfInput();
        return input.nextLine().trim();
    }
    private int readInt(String prompt) {
        while (true) {
            String text = readLine(prompt);
            try { return Integer.parseInt(text); }
            catch (NumberFormatException error) {
                System.out.println("Invalid input. Enter a whole number in the int range.");
            }
        }
    }
    private int choice(int minimum, int maximum) {
        while (true) {
            int value = readInt("Enter your choice: ");
            if (value >= minimum && value <= maximum) return value;
            System.out.println("Choose " + minimum + " to " + maximum + ".");
        }
    }
    private String vertex(String prompt) {
        while (true) {
            String name = readLine(prompt);
            if (!name.isEmpty()) return name;
            System.out.println("Vertex name cannot be blank.");
        }
    }
    private void heading(String title) {
        System.out.println("\n=============================================");
        System.out.println(title);
        System.out.println("=============================================");
    }
    private void safely(Runnable operation) {
        try { operation.run(); }
        catch (IllegalArgumentException | IllegalStateException error) {
            System.out.println("Cannot complete operation: " + error.getMessage());
        }
    }
    private void run() {
        System.out.println("CIT300 - Data Structure & Graph Performance Analyzer");
        System.out.println("All structures start empty. Array indexes are zero-based.");
        try {
            boolean running = true;
            while (running) {
                heading("MAIN MENU");
                System.out.println("1. Array Operations\n2. Stack Operations\n3. Queue Operations"
                    + "\n4. Linked List Operations\n5. Searching Operations\n6. Graph Operations"
                    + "\n7. Performance Comparison\n8. Display All Results\n9. Exit"
                    + "\n10. Reset and Load Demo Data");
                switch (choice(1, 10)) {
                    case 1: arrayMenu(); break;
                    case 2: stackMenu(); break;
                    case 3: queueMenu(); break;
                    case 4: listMenu(); break;
                    case 5: searchMenu(); break;
                    case 6: graphMenu(); break;
                    case 7: performanceMenu(); break;
                    case 8: displayAll(); break;
                    case 9: running = false; break;
                    case 10: resetDemo(); break;
                    default: break;
                }
            }
            System.out.println("Goodbye.");
        } catch (EndOfInput end) {
            System.out.println("\nInput ended. Program closed safely.");
        }
    }
    private void arrayMenu() {
        while (true) {
            heading("ARRAY OPERATIONS (capacity 10)");
            System.out.println("1. Insert at index\n2. Delete at index\n3. Search value\n4. Display\n5. Return");
            int selected = choice(1, 5);
            if (selected == 5) return;
            safely(() -> {
                switch (selected) {
                    case 1:
                        int index = readInt("Index (0 to " + array.size() + "): ");
                        int value = readInt("Value: "); array.insert(index, value);
                        System.out.println("Inserted. Array: " + array); break;
                    case 2:
                        System.out.println("Deleted: " + array.delete(readInt("Index: ")));
                        System.out.println("Array: " + array); break;
                    case 3:
                        int target = readInt("Target: ");
                        showSearch("Array linear search", target, array.size(), array.search(target), "original array"); break;
                    case 4: System.out.println("Array: " + array + " | size=" + array.size()); break;
                    default: break;
                }
            });
        }
    }
    private void stackMenu() {
        while (true) {
            heading("STACK OPERATIONS (capacity 10)");
            System.out.println("1. Push\n2. Pop\n3. Peek\n4. Display\n5. Return");
            int selected = choice(1, 5); if (selected == 5) return;
            safely(() -> {
                switch (selected) {
                    case 1: stack.push(readInt("Value: ")); System.out.println("Pushed."); break;
                    case 2: System.out.println("Popped: " + stack.pop()); break;
                    case 3: System.out.println("Top: " + stack.peek()); break;
                    case 4: System.out.println("Stack (bottom -> top): " + stack); break;
                    default: break;
                }
            });
        }
    }
    private void queueMenu() {
        while (true) {
            heading("QUEUE OPERATIONS (capacity 10)");
            System.out.println("1. Enqueue\n2. Dequeue\n3. Peek/Front\n4. Display\n5. Return");
            int selected = choice(1, 5); if (selected == 5) return;
            safely(() -> {
                switch (selected) {
                    case 1: queue.enqueue(readInt("Value: ")); System.out.println("Enqueued."); break;
                    case 2: System.out.println("Dequeued: " + queue.dequeue()); break;
                    case 3: System.out.println("Front: " + queue.peek()); break;
                    case 4: System.out.println("Queue (front -> rear): " + queue); break;
                    default: break;
                }
            });
        }
    }
    private void listMenu() {
        while (true) {
            heading("LINKED LIST OPERATIONS");
            System.out.println("1. Insert at end\n2. Insert at beginning\n3. Delete value"
                + "\n4. Search value\n5. Display\n6. Return");
            int selected = choice(1, 6); if (selected == 6) return;
            switch (selected) {
                case 1: list.insertLast(readInt("Value: ")); System.out.println("List: " + list); break;
                case 2: list.insertFirst(readInt("Value: ")); System.out.println("List: " + list); break;
                case 3:
                    System.out.println(list.delete(readInt("Value to delete: "))
                        ? "Deleted first occurrence." : "Value not found (list may be empty).");
                    System.out.println("List: " + list); break;
                case 4:
                    int target = readInt("Target: ");
                    showSearch("Linked list search", target, list.size(), list.search(target), "linked list"); break;
                case 5: System.out.println("List: " + list + " | size=" + list.size()); break;
                default: break;
            }
        }
    }
    private void showSearch(String algorithm, int target, int count, SearchResult result, String scope) {
        System.out.println(algorithm + ": " + result.description() + " (" + scope + ")"
            + " | steps=" + result.steps + " | time(ns)=" + result.nanos);
        log.search(algorithm, target, count, result, scope);
    }
    private void searchMenu() {
        while (true) {
            heading("SEARCHING OPERATIONS - uses the current array");
            System.out.println("1. Linear search\n2. Binary search on sorted copy\n3. Compare both\n4. Return");
            int selected = choice(1, 4); if (selected == 4) return;
            if (array.size() == 0) { System.out.println("Array is empty. Insert values first."); continue; }
            int target = readInt("Target: ");
            if (selected == 3) compareSearches(target);
            else if (selected == 1)
                showSearch("Linear Search", target, array.size(), array.search(target), "original array");
            else {
                int[] sorted = sortedCopy();
                showSearch("Binary Search", target, sorted.length,
                    SearchAlgorithms.binary(sorted, target), "sorted copy");
            }
        }
    }
    private int[] sortedCopy() {
        int[] sorted = array.toArray();
        long start = System.nanoTime(); Arrays.sort(sorted); long elapsed = System.nanoTime() - start;
        System.out.println("Original array: " + array);
        System.out.println("Sorted copy: " + Arrays.toString(sorted));
        System.out.println("Sort-only time(ns): " + elapsed + " (excluded from search timings; copy also excluded).");
        return sorted;
    }
    private void compareSearches(int target) {
        int[] sorted = sortedCopy();
        System.out.println("Both algorithms search the SAME sorted copy for a fair step comparison.");
        showSearch("Linear Search", target, sorted.length, SearchAlgorithms.linear(sorted, target), "sorted copy");
        showSearch("Binary Search", target, sorted.length, SearchAlgorithms.binary(sorted, target), "sorted copy");
        System.out.println("One search step = one inspected element. Worst-case: linear O(n), binary O(log n).");
        System.out.println("Binary search needs sorted data. Small-run timings vary; fewer steps do not guarantee less time.");
    }
    private void showTraversal(String algorithm, String start, TraversalResult result) {
        System.out.println(algorithm + " order: " + result.path());
        System.out.println("Vertices visited=" + result.order.size() + " | neighbor checks=" + result.neighborChecks
            + " | steps=" + result.steps() + " | time(ns)=" + result.nanos);
        System.out.println("Unreachable vertices=" + (graph.vertexCount() - result.order.size()));
        log.traversal(algorithm, start, result);
    }
    private void graphMenu() {
        while (true) {
            heading("GRAPH OPERATIONS - undirected adjacency list");
            System.out.println("1. Add vertex\n2. Add edge\n3. Display graph\n4. BFS traversal"
                + "\n5. DFS traversal\n6. Search vertex\n7. Return");
            int selected = choice(1, 7); if (selected == 7) return;
            safely(() -> {
                switch (selected) {
                    case 1:
                        System.out.println(graph.addVertex(vertex("Vertex name: ")) ? "Vertex added." : "Vertex already exists."); break;
                    case 2:
                        String from = vertex("From vertex: "); String to = vertex("To vertex: ");
                        System.out.println(graph.addEdge(from, to) ? "Undirected edge added." : "Edge already exists."); break;
                    case 3:
                        System.out.println(graph); System.out.println("V=" + graph.vertexCount() + " | E=" + graph.edgeCount()); break;
                    case 4:
                        String bfsStart = vertex("Start vertex: "); showTraversal("BFS", bfsStart, graph.bfs(bfsStart)); break;
                    case 5:
                        String dfsStart = vertex("Start vertex: "); showTraversal("DFS", dfsStart, graph.dfs(dfsStart)); break;
                    case 6:
                        System.out.println(graph.containsVertex(vertex("Vertex name: ")) ? "Vertex found." : "Vertex not found."); break;
                    default: break;
                }
            });
        }
    }
    private void performanceMenu() {
        while (true) {
            heading("PERFORMANCE COMPARISON");
            System.out.println("1. Compare linear/binary searches\n2. Compare BFS/DFS"
                + "\n3. Complexity guide\n4. Recorded results\n5. Return");
            int selected = choice(1, 5); if (selected == 5) return;
            safely(() -> {
                switch (selected) {
                    case 1:
                        if (array.size() == 0) System.out.println("Array is empty. Insert values first.");
                        else compareSearches(readInt("Target: ")); break;
                    case 2:
                        String start = vertex("Start vertex: ");
                        showTraversal("BFS", start, graph.bfs(start)); showTraversal("DFS", start, graph.dfs(start));
                        System.out.println("Graph steps = vertex visits + neighbor checks. Both are O(V + E).");
                        System.out.println("Each undirected edge is checked twice. Only the reachable component is traversed.");
                        break;
                    case 3: complexityGuide(); break;
                    case 4: log.display(); break;
                    default: break;
                }
            });
        }
    }
    private void complexityGuide() {
        System.out.println("Worst-case time (n = items; V = vertices; E = edges):");
        System.out.println("Array insert/delete by index: O(n); display/linear search: O(n).");
        System.out.println("Stack push/pop/peek: O(1); display: O(n).");
        System.out.println("Circular queue enqueue/dequeue/peek: O(1); display: O(n).");
        System.out.println("Linked list insert at head/tail: O(1); search/delete by value/display: O(n).");
        System.out.println("Linear search: O(n); binary search on already sorted array: O(log n).");
        System.out.println("BFS/DFS: O(V + E) time, O(V) auxiliary space; graph storage: O(V + E).");
        System.out.println("Hash-backed graph membership/add operations: expected O(1), not a worst-case guarantee.");
        System.out.println("Search steps and graph steps use different definitions; do not compare them directly.");
    }
    private void displayAll() {
        heading("CURRENT STRUCTURES AND RECORDED RESULTS");
        System.out.println("Array: " + array);
        System.out.println("Stack (bottom -> top): " + stack);
        System.out.println("Queue (front -> rear): " + queue);
        System.out.println("Linked list: " + list);
        System.out.println("Graph:\n" + graph);
        log.display();
    }
    private void resetDemo() {
        String answer = readLine("Reset all structures/results and load demo data? (y/n): ");
        if (!answer.equalsIgnoreCase("y")) { System.out.println("Reset cancelled."); return; }
        array.clear(); stack.clear(); queue.clear(); list.clear(); graph.clear(); log.clear();
        for (int value : new int[] {50, 10, 40, 20, 30}) array.insert(array.size(), value);
        for (int value : new int[] {10, 20, 30}) stack.push(value);
        for (int value : new int[] {100, 200, 300}) queue.enqueue(value);
        for (int value : new int[] {5, 15, 25}) list.insertLast(value);
        for (String name : new String[] {"Main Gate", "Library", "Computer Lab", "Cafeteria", "Student Center"}) graph.addVertex(name);
        graph.addEdge("Main Gate", "Library"); graph.addEdge("Main Gate", "Cafeteria");
        graph.addEdge("Library", "Computer Lab"); graph.addEdge("Library", "Student Center");
        System.out.println("Demo data loaded. Previous data and results cleared.");
    }
}
