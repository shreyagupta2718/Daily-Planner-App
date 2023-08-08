package ui.Tools;

import ui.DailyPlannerApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadTool extends Tool {
    public LoadTool(DailyPlannerApp planner, JPanel toolArea) {
        super(planner, toolArea);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Load");
        addToParent(parent);
    }

    @Override
    protected void addListener() {
        button.addActionListener(new LoadToolClickHandler());
    }

    // Represents the ActionListener for the LoadTool
    private class LoadToolClickHandler implements ActionListener {
        @Override
        // EFFECTS: Loads the saved plan
        public void actionPerformed(ActionEvent e) {
            planner.loadPlan();
        }
    }
}
