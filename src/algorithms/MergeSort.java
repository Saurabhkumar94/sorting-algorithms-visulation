package algorithms;

import core.SortingAlgorithm;
import gui.VisualPanel;

public class MergeSort extends SortingAlgorithm {
    public MergeSort(int[] array, VisualPanel panel) { super(array, panel); }

    @Override
    protected void sort() throws InterruptedException {
        mergeSort(0, array.length - 1);
        panel.highlight(-1, -1);
    }

    private void mergeSort(int l, int r) throws InterruptedException {
        if (!running) return;
        if (l >= r) return;
        int m = (l + r) / 2;
        mergeSort(l, m);
        mergeSort(m + 1, r);
        merge(l, m, r);
    }

    private void merge(int l, int m, int r) throws InterruptedException {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = array[l + i];
        for (int j = 0; j < n2; j++) R[j] = array[m + 1 + j];
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2 && running) {
            panel.highlight(l + i, m + 1 + j);
            metrics.incrementComparisons();
            if (L[i] <= R[j]) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
            metrics.incrementSwaps();
            panel.setArray(array);
            sleep();
        }
        while (i < n1 && running) { array[k++] = L[i++]; panel.setArray(array); sleep(); metrics.incrementSwaps(); }
        while (j < n2 && running) { array[k++] = R[j++]; panel.setArray(array); sleep(); metrics.incrementSwaps(); }
    }
}
