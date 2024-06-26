package ui;

import model.Block;
import model.BrainDump;

import javax.swing.*;
import java.awt.*;

// A JPanel class to display the brain dump as rectangles representing the blocks
public class BrainDumpPanel extends ListOfBlocksPanel {
    private BrainDump brainDump;
    protected GridBagConstraints constraints;

    // EFFECTS: Constructs a GUI for the brain dump
    public BrainDumpPanel(BrainDump brainDump) {
        this.brainDump = brainDump;
        this.setSize(dimension);
        this.setBorder(BorderFactory.createTitledBorder(border, "Brain Dump", titleX, titleY));
    }

    // EFFECTS: Draws each block in the brain dump with the right length
    public void drawBlocks() {
        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        int num = 0;
        UnscheduledBlockVisual unscheduledBlockVisual;
        float oneHourInPixels = ((getHeight() - 10) / 24.0F);
        for (Block block : brainDump.getBrainDump()) {
            num++;
            unscheduledBlockVisual = new UnscheduledBlockVisual(block, constraints, oneHourInPixels, num);
            add(unscheduledBlockVisual, constraints);
        }
    }
}

