package ui.Tools;

import ui.DailyPlannerApp;

import javax.swing.*;

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

    }
}
