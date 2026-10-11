public class SearchAlgorithms {
    private SearchAlgorithms() { }
    public static SearchResult linear(int[] values, int target) {
        long start = System.nanoTime(); int steps = 0;
        for (int i = 0; i < values.length; i++) {
            steps++;
            if (values[i] == target) return new SearchResult(i, steps, System.nanoTime() - start);
        }
        return new SearchResult(-1, steps, System.nanoTime() - start);
    }
    /** Precondition: values must already be sorted in ascending order.
     * With duplicates, returns a matching index, not necessarily the first. */
    public static SearchResult binary(int[] values, int target) {
        long start = System.nanoTime(); int steps = 0;
        int low = 0, high = values.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            steps++;
            if (values[middle] == target)
                return new SearchResult(middle, steps, System.nanoTime() - start);
            if (values[middle] < target) low = middle + 1; else high = middle - 1;
        }
        return new SearchResult(-1, steps, System.nanoTime() - start);
    }
}
