import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** Simple undirected graph. Ordered collections give repeatable traversal orders. */
public class Graph {
    private final Map<String, LinkedHashSet<String>> adjacency =
        new LinkedHashMap<String, LinkedHashSet<String>>();

    private String label(String value) {
        if (value == null || value.trim().isEmpty())
            throw new IllegalArgumentException("Vertex name cannot be blank.");
        return value.trim();
    }
    public boolean addVertex(String name) {
        name = label(name);
        if (adjacency.containsKey(name)) return false;
        adjacency.put(name, new LinkedHashSet<String>()); return true;
    }
    public boolean containsVertex(String name) { return adjacency.containsKey(label(name)); }
    public int vertexCount() { return adjacency.size(); }
    public int edgeCount() {
        int total = 0;
        for (Set<String> neighbors : adjacency.values()) total += neighbors.size();
        return total / 2;
    }
    public boolean addEdge(String from, String to) {
        from = label(from); to = label(to);
        requireVertex(from); requireVertex(to);
        if (from.equals(to)) throw new IllegalArgumentException("Self-loops are not allowed.");
        if (!adjacency.get(from).add(to)) return false;
        adjacency.get(to).add(from); return true;
    }
    private void requireVertex(String name) {
        if (!adjacency.containsKey(name))
            throw new IllegalArgumentException("Vertex does not exist: " + name);
    }
    public TraversalResult bfs(String startVertex) {
        startVertex = label(startVertex); requireVertex(startVertex);
        long start = System.nanoTime(); long checks = 0;
        List<String> order = new ArrayList<String>();
        Set<String> visited = new LinkedHashSet<String>();
        Deque<String> queue = new ArrayDeque<String>();
        visited.add(startVertex); queue.addLast(startVertex);
        while (!queue.isEmpty()) {
            String current = queue.removeFirst(); order.add(current);
            for (String neighbor : adjacency.get(current)) {
                checks++;
                if (visited.add(neighbor)) queue.addLast(neighbor);
            }
        }
        return new TraversalResult(order, checks, System.nanoTime() - start);
    }
    public TraversalResult dfs(String startVertex) {
        startVertex = label(startVertex); requireVertex(startVertex);
        long start = System.nanoTime();
        List<String> order = new ArrayList<String>();
        Set<String> visited = new LinkedHashSet<String>();
        long checks = dfsVisit(startVertex, visited, order);
        return new TraversalResult(order, checks, System.nanoTime() - start);
    }
    private long dfsVisit(String current, Set<String> visited, List<String> order) {
        visited.add(current); order.add(current); long checks = 0;
        for (String neighbor : adjacency.get(current)) {
            checks++;
            if (!visited.contains(neighbor)) checks += dfsVisit(neighbor, visited, order);
        }
        return checks;
    }
    public void clear() { adjacency.clear(); }
    public String toString() {
        if (adjacency.isEmpty()) return "Graph is empty.";
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, LinkedHashSet<String>> item : adjacency.entrySet())
            result.append(item.getKey()).append(" -> ").append(item.getValue()).append('\n');
        return result.toString().trim();
    }
}
