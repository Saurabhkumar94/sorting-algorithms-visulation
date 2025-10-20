package algorithms;

import core.SortingAlgorithm;
import gui.VisualPanel;

public class SelectionSort extends SortingAlgorithm {
    public SelectionSort(int[] array, VisualPanel panel) { super(array, panel); }

    @Override
    protected void sort() throws InterruptedException {
        int n = array.length;
        for (int i = 0; i < n-1 && running; i++) {
            int minIdx = i;
            for (int j = i+1; j < n && running; j++) {
                panel.highlight(minIdx, j);
                metrics.incrementComparisons();
                if (array[j] < array[minIdx]) minIdx = j;
                sleep();
            }
            if (minIdx != i) {
                int t = array[minIdx]; array[minIdx] = array[i]; array[i] = t;
                metrics.incrementSwaps();
                panel.setArray(array);
            }
            sleep();
        }
        panel.highlight(-1, -1);
    }
}
