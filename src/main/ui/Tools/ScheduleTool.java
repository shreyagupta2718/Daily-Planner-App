package ui.Tools;

import ui.DailyPlannerApp;

import javax.swing.*;

public class ScheduleTool extends Tool {
    public ScheduleTool(DailyPlannerApp planner, JPanel toolArea) {
        super(planner, toolArea);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Schedule");
        addToParent(parent);
    }

    @Override
    protected void addListener() {

    }
}
