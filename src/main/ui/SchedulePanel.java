package ui;

import model.Block;
import model.Schedule;

import javax.swing.*;
import java.awt.*;

// A JPanel class to display the schedule as rectangles representing the blocks
public class SchedulePanel extends JPanel {
    private Schedule schedule;
    private final int emptySpace = 10;
    private int oneHourInPixels = 29;

    // EFFECTS: Constructs a GUI for the schedule
    public SchedulePanel(Schedule schedule) {
        this.schedule = schedule;
        this.setSize(new Dimension(20, 24 * oneHourInPixels + 2*emptySpace));
        this.setBorder(BorderFactory.createEmptyBorder(emptySpace, 5, emptySpace, 1));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawHourLines(g);
    }

    public void drawBlocks() {
        setLayout(null);
        for (Block block : schedule.getSchedule()) {
            float time = block.getStartTime();
            int pixel = emptySpace + (int) Math.round(oneHourInPixels * time);
            ScheduledBlockVisual scheduledBlockVisual = new ScheduledBlockVisual(block, oneHourInPixels, pixel);
            add(scheduledBlockVisual);
        }
    }

    // EFFECTS: draws grid with lines corresponding to hour mark
    private void drawHourLines(Graphics g) {
        Color save = g.getColor();
        g.setColor(new Color(170, 16, 79));
        int hour = 0;

        for (int y = emptySpace; y <= getHeight(); y += oneHourInPixels) {
            g.drawString(Integer.toString(hour), 0, y + 5);
            g.drawLine(15, y, getWidth(), y);
            if (hour == 24) {
                break;
            }
                hour++;
        }
        g.setColor(save);
    }
}

