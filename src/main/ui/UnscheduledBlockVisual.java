package ui;

import model.Block;

import java.awt.*;

public class UnscheduledBlockVisual extends BlockVisual {
    public UnscheduledBlockVisual(Block block, GridBagConstraints constraints, int height) {
        super(block, constraints, height);
        setBackground(new Color(226, 209, 249));
        addActionListener(e -> handleClick());
    }

    private void handleClick() {
    }
}
