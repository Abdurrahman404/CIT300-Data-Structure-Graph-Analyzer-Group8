import java.util.ArrayList;
import java.util.List;

/** Actual results from this session. Timings are illustrative, not benchmarks. */
public class PerformanceLog {
    private final List<String> entries = new ArrayList<String>();
    public void search(String algorithm, int target, int count, SearchResult result, String scope) {
        entries.add(algorithm + " | n=" + count + " | target=" + target + " | "
            + result.description() + " (" + scope + ") | steps=" + result.steps
            + " | time(ns)=" + result.nanos);
    }
    public void traversal(String algorithm, String start, TraversalResult result) {
        entries.add(algorithm + " | start=" + start + " | visited=" + result.order.size()
            + " | neighbor checks=" + result.neighborChecks + " | steps=" + result.steps()
            + " | time(ns)=" + result.nanos + " | " + result.path());
    }
    public void clear() { entries.clear(); }
    public void display() {
        if (entries.isEmpty()) { System.out.println("No search/traversal results recorded yet."); return; }
        for (int i = 0; i < entries.size(); i++) System.out.println((i + 1) + ". " + entries.get(i));
    }
}
