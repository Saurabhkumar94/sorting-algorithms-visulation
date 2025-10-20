package algorithms;

import core.SortingAlgorithm;
import gui.VisualPanel;

public class HeapSort extends SortingAlgorithm {
    public HeapSort(int[] array, VisualPanel panel) { super(array, panel); }

    @Override
    protected void sort() throws InterruptedException {
        int n = array.length;
        for (int i = n/2 -1; i>=0 && running; i--) heapify(n, i);
        for (int i = n-1; i>0 && running; i--) {
            int t = array[0]; array[0] = array[i]; array[i] = t;
            metrics.incrementSwaps();
            panel.setArray(array);
            sleep();
            heapify(i, 0);
        }
        panel.highlight(-1,-1);
    }

    private void heapify(int n, int i) throws InterruptedException {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if (l < n) { panel.highlight(l, largest); metrics.incrementComparisons(); if (array[l] > array[largest]) largest = l; sleep(); }
        if (r < n) { panel.highlight(r, largest); metrics.incrementComparisons(); if (array[r] > array[largest]) largest = r; sleep(); }
        if (largest != i) {
            int swap = array[i]; array[i] = array[largest]; array[largest] = swap;
            metrics.incrementSwaps();
            panel.setArray(array);
            sleep();
            heapify(n, largest);
        }
    }
}
