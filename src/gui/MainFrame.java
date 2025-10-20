package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Advanced Sorting Visualizer");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        VisualPanel visualPanel = new VisualPanel();
        ControlPanel controlPanel = new ControlPanel(visualPanel);

        add(controlPanel, BorderLayout.NORTH);
        add(visualPanel, BorderLayout.CENTER);

        // register keyboard manager
        input.KeyboardManager.register(this, new core.SortManager(visualPanel), visualPanel, controlPanel);
    }
}
