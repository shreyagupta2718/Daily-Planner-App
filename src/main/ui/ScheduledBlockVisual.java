package ui;

import model.Block;

import java.awt.*;

public class ScheduledBlockVisual extends BlockVisual {
    public ScheduledBlockVisual(Block block, GridBagConstraints constraints, float oneHourInPixels) {
        super(block, constraints, oneHourInPixels);
        setBackground(new Color(255, 209, 229));
        constraints.gridy = (int) (block.getStartTime()*oneHourInPixels);
        addActionListener(e -> handleClick());
    }

    private void handleClick() {
    }
}
