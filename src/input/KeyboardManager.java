package input;

import javax.swing.*;
import java.awt.event.ActionEvent;
import gui.ControlPanel;
import core.SortManager;
import gui.VisualPanel;

public class KeyboardManager {
    public static void register(JFrame frame, SortManager manager, VisualPanel panel, ControlPanel ctrl) {
        InputMap im = frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = frame.getRootPane().getActionMap();

        im.put(KeyStroke.getKeyStroke("SPACE"), "playPause");
        im.put(KeyStroke.getKeyStroke("control R"), "reset");
        im.put(KeyStroke.getKeyStroke("control shift R"), "forceReset");
        im.put(KeyStroke.getKeyStroke("control I"), "invert");
        im.put(KeyStroke.getKeyStroke("EQUALS"), "speedUp");
        im.put(KeyStroke.getKeyStroke("MINUS"), "speedDown");
        im.put(KeyStroke.getKeyStroke("control EQUALS"), "sizeUp");
        im.put(KeyStroke.getKeyStroke("control MINUS"), "sizeDown");
        im.put(KeyStroke.getKeyStroke("control T"), "themeToggle");
        im.put(KeyStroke.getKeyStroke('B'), "bubble");
        im.put(KeyStroke.getKeyStroke('I'), "insertion");
        im.put(KeyStroke.getKeyStroke('S'), "selection");
        im.put(KeyStroke.getKeyStroke('M'), "merge");
        im.put(KeyStroke.getKeyStroke('Q'), "quick");
        im.put(KeyStroke.getKeyStroke('H'), "heap");
        im.put(KeyStroke.getKeyStroke("ESCAPE"), "stop");

        am.put("playPause", new AbstractAction() { public void actionPerformed(ActionEvent e) { manager.pauseOrResume(); } });
        am.put("reset", new AbstractAction() { public void actionPerformed(ActionEvent e) { manager.stop(); ctrl.randomize(); } });
        am.put("forceReset", new AbstractAction() { public void actionPerformed(ActionEvent e) { manager.stop(); ctrl.randomize(); } });
        am.put("bubble", new AbstractAction() { public void actionPerformed(ActionEvent e) { ctrl.selectAlgorithm("B - Bubble"); } });
        am.put("insertion", new AbstractAction() { public void actionPerformed(ActionEvent e) { ctrl.selectAlgorithm("I - Insertion"); } });
        am.put("selection", new AbstractAction() { public void actionPerformed(ActionEvent e) { ctrl.selectAlgorithm("S - Selection"); } });
        am.put("merge", new AbstractAction() { public void actionPerformed(ActionEvent e) { ctrl.selectAlgorithm("M - Merge"); } });
        am.put("quick", new AbstractAction() { public void actionPerformed(ActionEvent e) { ctrl.selectAlgorithm("Q - Quick"); } });
        am.put("heap", new AbstractAction() { public void actionPerformed(ActionEvent e) { ctrl.selectAlgorithm("H - Heap"); } });
        am.put("stop", new AbstractAction() { public void actionPerformed(ActionEvent e) { manager.stop(); } });
    }
}
