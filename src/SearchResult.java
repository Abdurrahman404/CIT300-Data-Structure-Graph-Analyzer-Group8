/** A step is one inspected element (not a count of CPU instructions). */
public class SearchResult {
    public final int index;
    public final int steps;
    public final long nanos;
    public SearchResult(int index, int steps, long nanos) {
        this.index = index; this.steps = steps; this.nanos = nanos;
    }
    public String description() { return index < 0 ? "Not found" : "Found at index " + index; }
}
