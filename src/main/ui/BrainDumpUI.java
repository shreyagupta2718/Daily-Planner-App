package ui;

import model.Block;
import model.BrainDump;

import javax.swing.*;
import java.awt.*;

// A JPanel class to display the brain dump as rectangles representing the blocks
public class BrainDumpUI extends JPanel {
    private BrainDump brainDump;

    // EFFECTS: Constructs a GUI for the brain dump
    public BrainDumpUI(BrainDump brainDump) {
        this.brainDump = brainDump;
    }

    // EFFECTS: Overrides the super class method to draw unscheduled blocks of desired length
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int y = 0;

        for (Block block : brainDump.getBrainDump()) {
            BlockVisual blockVisual = new BlockVisual(g2d, block, y);
            y += block.getLength() + 1 ; // Adjust spacing between rectangles
        }
    }
}

