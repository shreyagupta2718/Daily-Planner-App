package ui.Tools;

import ui.DailyPlannerApp;

import javax.swing.*;

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

    }
}
