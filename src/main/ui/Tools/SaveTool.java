package ui.Tools;

import ui.DailyPlannerApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveTool extends Tool {

    public SaveTool(DailyPlannerApp planner, JPanel toolArea) {
        super(planner, toolArea);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Save");
        addToParent(parent);
    }

    @Override
    protected void addListener() {
        button.addActionListener(new SaveToolClickHandler());
    }

    // Represents the ActionListener for the SaveTool
    private class SaveToolClickHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            planner.savePlan();
        }
    }
}
