package ui;

import model.Block;

import java.awt.*;

public class ScheduledBlockVisual extends BlockVisual {
    public ScheduledBlockVisual(Block block, GridBagConstraints constraints, int height) {
        super(block, constraints, height);
        setBackground(new Color(255, 209, 229));
        constraints.gridy = (int) (block.getStartTime()*10); //todo
        addActionListener(e -> handleClick());
    }

    private void handleClick() {
    }
}
