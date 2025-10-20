package algorithms;

import core.SortingAlgorithm;
import gui.VisualPanel;

public class InsertionSort extends SortingAlgorithm {
    public InsertionSort(int[] array, VisualPanel panel) { super(array, panel); }

    @Override
    protected void sort() throws InterruptedException {
        int n = array.length;
        for (int i = 1; i < n && running; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && running) {
                panel.highlight(j, j+1);
                metrics.incrementComparisons();
                if (array[j] > key) {
                    array[j+1] = array[j];
                    metrics.incrementSwaps();
                    j--;
                    panel.setArray(array);
                    sleep();
                } else break;
            }
            array[j+1] = key;
            panel.setArray(array);
            sleep();
        }
        panel.highlight(-1, -1);
    }
}
