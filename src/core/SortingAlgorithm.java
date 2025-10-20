package core;

import gui.VisualPanel;

public abstract class SortingAlgorithm implements Runnable {
    protected int[] array;
    protected VisualPanel panel;
    protected volatile boolean running = true;
    protected volatile boolean paused = false;
    protected int delay = 20; // ms
    protected core.MetricsTracker metrics = core.MetricsTracker.getInstance();

    public SortingAlgorithm(int[] array, VisualPanel panel) {
        this.array = array;
        this.panel = panel;
    }

    protected abstract void sort() throws InterruptedException;

    @Override
    public void run() {
        try {
            sort();
        } catch (InterruptedException e) {
            // interrupted
        } finally {
            running = false;
            paused = false;
            panel.setStatus("Idle");
        }
    }

    protected void sleep() throws InterruptedException {
        synchronized(this) {
            while (paused && running) {
                panel.setStatus("Paused");
                wait();
            }
        }
        if (!running) throw new InterruptedException("Stopped");
        if (delay > 0) Thread.sleep(delay);
    }

    public void stop() {
        running = false;
        resume();
    }

    public void pause() {
        paused = true;
    }

    public synchronized void resume() {
        paused = false;
        notifyAll();
    }

    public void setDelay(int d) { this.delay = d; }
    public boolean isRunning() { return running; }
}
