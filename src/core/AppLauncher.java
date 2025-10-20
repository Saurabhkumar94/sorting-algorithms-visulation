package core;

import gui.MainFrame;
import javax.swing.SwingUtilities;

public class AppLauncher {
    public static void main(String[] args) {
        System.out.println("Starting Sorting Visualizer...");
        SwingUtilities.invokeLater(() -> {
            MainFrame mf = new MainFrame();
            mf.setVisible(true);
        });
    }
}
