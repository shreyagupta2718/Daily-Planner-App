package ui.tools;

import ui.DailyPlannerApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents a tool for saving the current plan
public class SaveTool extends Tool {

    // EFFECTS: Constructs a tool for saving the current plan in the given parent
    public SaveTool(DailyPlannerApp planner, JPanel toolArea) {
        super(planner, toolArea);
    }

    @Override
    // MODIFIES: this
    // EFFECTS: creates a save button and adds it to the parent passed as a parameter
    protected void createButton(JComponent parent) {
        button = new JButton("Save");
        addToParent(parent);
    }

    // MODIFIES: this
    // EFFECTS: constructs a new listener object which is added to the JButton
    @Override
    protected void addListener() {
        button.addActionListener(new SaveToolClickHandler());
    }

    // Represents the ActionListener for the SaveTool
    private class SaveToolClickHandler implements ActionListener {
        @Override
        // MODIFIES: this
        // EFFECTS: Saves the current plan
        public void actionPerformed(ActionEvent e) {
            planner.savePlan();
        }
    }
}
