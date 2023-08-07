package ui;

import model.Block;
import model.Schedule;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// A JPanel class to display the schedule as rectangles representing the blocks
public class SchedulePanel extends JPanel {
    private Schedule schedule;
    protected GridBagConstraints constraints;
    private final int scheduleStartingPixel = 10;
    private int scheduleEndingPixel;
    private int oneHourInPixels;
    private ArrayList<Integer> pixelForLines;

    // EFFECTS: Constructs a GUI for the schedule
    public SchedulePanel(Schedule schedule) {
        this.schedule = schedule;
        this.setSize(new Dimension(20, 706));
        pixelForLines = new ArrayList<>();
    }

    @Override
    public void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawHourLines(g);
    }

    public void drawBlocks() {
        setLayout(null);
        constraints = new GridBagConstraints();
        float oneHourInPixels = ((getHeight() - 10)/24.0F);
        for (Block block : schedule.getSchedule()) {
            makePixelsForLines();
            int index = Math.round(block.getStartTime());
            int pixel = getPixelsForLines().get(index);
            ScheduledBlockVisual scheduledBlockVisual = new ScheduledBlockVisual(block, constraints, oneHourInPixels, pixel);
            add(scheduledBlockVisual);
        }
    }


    private void makePixelsForLines() {
        int hour = 0;
        scheduleEndingPixel = getHeight() - 10;
        int totalPixels = scheduleEndingPixel - scheduleStartingPixel;
        oneHourInPixels = totalPixels / 24;

        for (int y = scheduleStartingPixel; y <= scheduleEndingPixel; y += oneHourInPixels) {
            pixelForLines.add(y);
            hour++;
        }
    }

    // EFFECTS: draws grid with lines corresponding to hour mark
    private void drawHourLines(Graphics g) {
        ArrayList<Integer> pixelForLinesTemp = new ArrayList<>();
        Color save = g.getColor();
        g.setColor(new Color(	170, 16, 79));
        int hour = 0;
        scheduleEndingPixel = getHeight() - 10;
        int totalPixels = scheduleEndingPixel - scheduleStartingPixel;
        oneHourInPixels = totalPixels / 24;

        for (int y = scheduleStartingPixel; y <= scheduleEndingPixel; y += oneHourInPixels) {
            g.drawString(Integer.toString(hour), 0, y+5);
            g.drawLine(15, y, getWidth(), y);
            System.out.println(y);

            pixelForLinesTemp.add(y);
            hour++;
        }
        g.setColor(save);
        setPixelsForLines(pixelForLinesTemp);
        pixelForLinesTemp = null;
    }

    public void setPixelsForLines(ArrayList<Integer> pixelForLinesTemp) {
        this.pixelForLines = pixelForLinesTemp;
    }

    public ArrayList<Integer> getPixelsForLines() {
        System.out.println(pixelForLines);
        return pixelForLines;
    }
}

