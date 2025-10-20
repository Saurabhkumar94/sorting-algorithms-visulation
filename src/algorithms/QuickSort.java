package algorithms;

import core.SortingAlgorithm;
import gui.VisualPanel;

public class QuickSort extends SortingAlgorithm {
    public QuickSort(int[] array, VisualPanel panel) { super(array, panel); }

    @Override
    protected void sort() throws InterruptedException {
        quick(0, array.length - 1);
        panel.highlight(-1, -1);
    }

    private void quick(int low, int high) throws InterruptedException {
        if (!running || low >= high) return;
        int p = partition(low, high);
        quick(low, p - 1);
        quick(p + 1, high);
    }

    private int partition(int low, int high) throws InterruptedException {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j <= high - 1 && running; j++) {
            panel.highlight(j, high);
            metrics.incrementComparisons();
            if (array[j] < pivot) {
                i++;
                int t = array[i]; array[i] = array[j]; array[j] = t;
                metrics.incrementSwaps();
                panel.setArray(array);
            }
            sleep();
        }
        int t = array[i+1]; array[i+1] = array[high]; array[high] = t;
        metrics.incrementSwaps();
        panel.setArray(array);
        sleep();
        return i+1;
    }
}
