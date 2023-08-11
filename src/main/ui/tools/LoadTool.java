package ui.tools;

import ui.DailyPlannerApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents a tool for loading a saved plan
public class LoadTool extends Tool {

    // EFFECTS: Constructs a tool for loading a saved plan
    public LoadTool(DailyPlannerApp planner, JPanel toolArea) {
        super(planner, toolArea);
    }

    // MODIFIES: this
    // EFFECTS: creates a load button and adds it to the parent JComponent passed as a parameter
    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Load");
        addToParent(parent);
    }

    // MODIFIES: this
    // EFFECTS: constructs a new listener object which is added to the JButton
    @Override
    protected void addListener() {
        button.addActionListener(new LoadToolClickHandler());
    }

    // Represents the ActionListener for the LoadTool
    private class LoadToolClickHandler implements ActionListener {
        @Override
        // MODIFIES: this
        // EFFECTS: loads the saved plan
        public void actionPerformed(ActionEvent e) {
            planner.loadPlan();
        }
    }
}
