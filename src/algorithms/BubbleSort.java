package algorithms;

import core.SortingAlgorithm;
import gui.VisualPanel;

public class BubbleSort extends SortingAlgorithm {
    public BubbleSort(int[] array, VisualPanel panel) { super(array, panel); }

    @Override
    protected void sort() throws InterruptedException {
        int n = array.length;
        for (int i = 0; i < n - 1 && running; i++) {
            for (int j = 0; j < n - i - 1 && running; j++) {
                panel.highlight(j, j+1);
                metrics.incrementComparisons();
                if (array[j] > array[j+1]) {
                    int t = array[j]; array[j] = array[j+1]; array[j+1] = t;
                    metrics.incrementSwaps();
                    panel.setArray(array);
                }
                sleep();
            }
        }
        panel.highlight(-1, -1);
    }
}
