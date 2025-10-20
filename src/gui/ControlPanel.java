package gui;

import core.SortManager;
import utils.ArrayGenerator;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    private JComboBox<String> algoBox;
    private JSlider speedSlider, sizeSlider;
    private JButton startBtn, pauseBtn, randomBtn, stopBtn;
    private VisualPanel visualPanel;
    private SortManager manager;
    private int[] currentArray;

    public ControlPanel(VisualPanel visualPanel) {
        this.visualPanel = visualPanel;
        this.manager = new SortManager(visualPanel);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setPreferredSize(new Dimension(1100, 60));

        algoBox = new JComboBox<>(new String[] { "B - Bubble", "I - Insertion", "S - Selection", "M - Merge", "Q - Quick", "H - Heap" });
        speedSlider = new JSlider(0, 200, 20);
        sizeSlider = new JSlider(5, 300, 80);

        startBtn = new JButton("Start");
        pauseBtn = new JButton("Pause/Resume");
        stopBtn = new JButton("Stop");
        randomBtn = new JButton("Randomize");

        add(new JLabel("Algorithm:"));
        add(algoBox);
        add(new JLabel(" Speed:"));
        add(speedSlider);
        add(new JLabel(" Size:"));
        add(sizeSlider);
        add(startBtn);
        add(pauseBtn);
        add(stopBtn);
        add(randomBtn);

        generateAndShowArray(sizeSlider.getValue());

        randomBtn.addActionListener(e -> generateAndShowArray(sizeSlider.getValue()));

        startBtn.addActionListener(e -> {
            core.MetricsTracker.getInstance().reset();
            String selected = ((String)algoBox.getSelectedItem()).substring(0,1);
            int delay = speedSlider.getValue();
            manager.start(selected, currentArray.clone(), delay);
        });

        pauseBtn.addActionListener(e -> manager.pauseOrResume());

        stopBtn.addActionListener(e -> manager.stop());

        sizeSlider.addChangeListener(e -> {
            if (!sizeSlider.getValueIsAdjusting()) {
                generateAndShowArray(sizeSlider.getValue());
            }
        });

        speedSlider.addChangeListener(e -> {
            manager.setDelay(speedSlider.getValue());
        });
    }

    public void randomize() {
        generateAndShowArray(sizeSlider.getValue());
    }

    public void selectAlgorithm(String item) {
        algoBox.setSelectedItem(item);
    }

    private void generateAndShowArray(int size) {
        currentArray = ArrayGenerator.generate(size, 400);
        visualPanel.setArray(currentArray);
    }
}
