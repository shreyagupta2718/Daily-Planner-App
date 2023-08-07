package ui;

import model.Block;
import model.Schedule;

import javax.swing.*;
import java.awt.*;

// A JPanel class to display the schedule as rectangles representing the blocks
public class SchedulePanel extends JPanel {
    private Schedule schedule;
    protected GridBagConstraints constraints;

    // EFFECTS: Constructs a GUI for the schedule
    public SchedulePanel(Schedule schedule) {
        this.schedule = schedule;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        for (Block block : schedule.getSchedule()) {
            ScheduledBlockVisual scheduledBlockVisual = new ScheduledBlockVisual(block, constraints);
            add(scheduledBlockVisual, constraints);
        }
    }
}

