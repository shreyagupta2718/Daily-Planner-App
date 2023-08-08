package ui.Tools;

import ui.DailyPlannerApp;

import javax.swing.*;

public class AddTool extends Tool {
    public AddTool(DailyPlannerApp planner, JPanel toolArea) {
        super(planner, toolArea);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Add");
        addToParent(parent);
    }

    @Override
    protected void addListener() {

    }
}
