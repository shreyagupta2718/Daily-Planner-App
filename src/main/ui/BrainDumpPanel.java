package ui;

import model.Block;
import model.BrainDump;

import javax.swing.*;
import java.awt.*;

// A JPanel class to display the brain dump as rectangles representing the blocks
public class BrainDumpPanel extends JPanel {
    private BrainDump brainDump;
    protected GridBagConstraints constraints;

    // EFFECTS: Constructs a GUI for the brain dump
    public BrainDumpPanel(BrainDump brainDump) {
        this.brainDump = brainDump;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        for (Block block : brainDump.getBrainDump()) {
            UnscheduledBlockVisual unscheduledBlockVisual = new UnscheduledBlockVisual(block, constraints);
            add(unscheduledBlockVisual, constraints);
        }
    }
}

