package ui;

import model.Block;

import java.awt.*;

public class ScheduledBlockVisual extends BlockVisual {
    public ScheduledBlockVisual(Block block, GridBagConstraints constraints, float oneHourInPixels, int pixel) {
        super(block, constraints, oneHourInPixels);
        setBackground(new Color(255, 209, 229));
        this.setBounds(40, pixel, 100, height);
        addActionListener(e -> handleClick());
        this.setVisible(true);
    }

    private void handleClick() {
    }
}
