package ui;

import javax.swing.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new DailyPlannerApp().setVisible(true);
            } catch (FileNotFoundException e) {
                System.out.println("Unable to run application: file not found");
            }
        });
    }
}
