package core;

import gui.VisualPanel;
import algorithms.*;
import java.util.Locale;

public class SortManager {
    private Thread worker;
    private SortingAlgorithm algorithm;
    private VisualPanel panel;

    public SortManager(VisualPanel panel) { this.panel = panel; }

    public synchronized void start(String key, int[] array, int delayMs) {
        stop();
        algorithm = createAlgorithm(key, array, panel);
        if (algorithm == null) return;
        algorithm.setDelay(delayMs);
        worker = new Thread(algorithm);
        panel.setStatus("Running: " + algorithm.getClass().getSimpleName());
        worker.start();
    }

    public synchronized void stop() {
        if (algorithm != null) {
            algorithm.stop();
            algorithm = null;
        }
        if (worker != null) {
            worker.interrupt();
            worker = null;
        }
    }

    public synchronized void pauseOrResume() {
        if (algorithm == null) return;
        if (algorithm.paused) algorithm.resume();
        else algorithm.pause();
    }

    public synchronized boolean isRunning() {
        return algorithm != null && algorithm.isRunning();
    }

    public synchronized void setDelay(int d) {
        if (algorithm != null) algorithm.setDelay(d);
    }

    private SortingAlgorithm createAlgorithm(String key, int[] array, VisualPanel panel) {
        key = key.toUpperCase(Locale.ROOT);
        switch (key) {
            case "B": return new BubbleSort(array, panel);
            case "I": return new InsertionSort(array, panel);
            case "S": return new SelectionSort(array, panel);
            case "M": return new MergeSort(array, panel);
            case "Q": return new QuickSort(array, panel);
            case "H": return new HeapSort(array, panel);
            default: return null;
        }
    }
}
