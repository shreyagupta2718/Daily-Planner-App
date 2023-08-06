package ui;

import model.Block;
import model.Schedule;

import javax.swing.*;
import java.awt.*;

// A JPanel class to display the schedule as rectangles representing the blocks
public class ScheduleUI extends JPanel {
    private Schedule schedule;

    // EFFECTS: Constructs a GUI for the schedule
    public ScheduleUI(Schedule schedule) {
        this.schedule = schedule;
    }

    // EFFECTS: Overrides the super class method to draw scheduled blocks of desired length
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Block block : schedule.getSchedule()) {
            BlockVisual blockVisual = new BlockVisual(g2d, block);
        }
    }
}

