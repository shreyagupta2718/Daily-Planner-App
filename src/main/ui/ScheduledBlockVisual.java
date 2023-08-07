package ui;

import model.Block;

import java.awt.*;

public class ScheduledBlockVisual extends BlockVisual {
    public ScheduledBlockVisual(Block block, GridBagConstraints constraints) {
        super(block, constraints);
        setBackground(new Color(255, 209, 229));
        constraints.gridy = (int) (block.getStartTime()*scaleLength);
        addActionListener(e -> handleClick());
    }

    private void handleClick() {
    }
}
