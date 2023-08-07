package ui;

import model.Block;
import model.Schedule;

import javax.swing.*;
import java.awt.*;

// A JPanel class to display the schedule as rectangles representing the blocks
public class SchedulePanel extends JPanel {
    private Schedule schedule;
    protected GridBagConstraints constraints;
    private final int scheduleStartingPixel = 10;
    private int scheduleEndingPixel;

    // EFFECTS: Constructs a GUI for the schedule
    public SchedulePanel(Schedule schedule) {
        this.schedule = schedule;
        drawBlocks();
    }

    @Override
    public void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawHourLines(g);
    //drawBlocks();
    }


    private void drawBlocks() {
        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        for (Block block : schedule.getSchedule()) {
            ScheduledBlockVisual scheduledBlockVisual = new ScheduledBlockVisual(block, constraints);
            add(scheduledBlockVisual, constraints);
        }
    }

    // EFFECTS: draws grid with lines corresponding to hour mark
    private void drawHourLines(Graphics g) {
        Color save = g.getColor();
        g.setColor(new Color(	170, 16, 79));
        int hour = 0;
        scheduleEndingPixel = getHeight() - 10;
        int totalPixels = scheduleEndingPixel - scheduleStartingPixel;
        for (int y = scheduleStartingPixel; y <= scheduleEndingPixel; y += totalPixels/24) {
            g.drawString(Integer.toString(hour), 0, y);
            g.drawLine(0, y, getWidth(), y);
            hour++;
        }
        g.setColor(save);
    }
}

