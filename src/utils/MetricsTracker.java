package core;

public class MetricsTracker {
    private static MetricsTracker instance;
    private long comparisons = 0;
    private long swaps = 0;

    private MetricsTracker() {}

    public static MetricsTracker getInstance() {
        if (instance == null) instance = new MetricsTracker();
        return instance;
    }

    public synchronized void reset() { comparisons = 0; swaps = 0; }
    public synchronized void incrementComparisons() { comparisons++; }
    public synchronized void incrementSwaps() { swaps++; }
    public synchronized long getComparisons() { return comparisons; }
    public synchronized long getSwaps() { return swaps; }
}
