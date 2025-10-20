package gui;

import javax.swing.*;
import java.awt.*;

public class VisualPanel extends JPanel {
    private int[] array;
    private int highlightA = -1, highlightB = -1;
    private String status = "Idle";

    public VisualPanel() {
        setBackground(Color.WHITE);
    }

    public synchronized void setArray(int[] arr) {
        if (arr == null) return;
        this.array = arr.clone();
        repaint();
    }

    public synchronized void highlight(int a, int b) {
        this.highlightA = a;
        this.highlightB = b;
        repaint();
    }

    public synchronized void setStatus(String s) {
        this.status = s;
        repaint();
    }

    @Override
    protected synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (array == null || array.length == 0) {
            g.setColor(Color.GRAY);
            g.drawString("No data", 10, 20);
            return;
        }

        int w = getWidth();
        int h = getHeight();
        int n = array.length;
        int barWidth = Math.max(1, w / n);

        int max = 1;
        for (int v : array) if (v > max) max = v;

        for (int i = 0; i < n; i++) {
            int val = array[i];
            int barHeight = (int) ((val / (double) max) * (h - 40));
            int x = i * barWidth;
            int y = h - barHeight - 20;

            if (i == highlightA || i == highlightB) {
                g.setColor(Color.RED);
            } else {
                g.setColor(new Color(30, 144, 255));
            }
            g.fillRect(x, y, barWidth - 1, barHeight);
        }

        g.setColor(Color.DARK_GRAY);
        g.drawString("Status: " + status + " | Size: " + n + " | Comparisons: " + core.MetricsTracker.getInstance().getComparisons() + " | Swaps: " + core.MetricsTracker.getInstance().getSwaps(), 10, 15);
    }
}
