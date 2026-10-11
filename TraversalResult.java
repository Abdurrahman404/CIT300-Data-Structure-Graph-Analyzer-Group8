import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TraversalResult {
    public final List<String> order;
    public final long neighborChecks;
    public final long nanos;
    public TraversalResult(List<String> order, long neighborChecks, long nanos) {
        this.order = Collections.unmodifiableList(new ArrayList<String>(order));
        this.neighborChecks = neighborChecks; this.nanos = nanos;
    }
    public long steps() { return order.size() + neighborChecks; }
    public String path() { return String.join(" -> ", order); }
}
