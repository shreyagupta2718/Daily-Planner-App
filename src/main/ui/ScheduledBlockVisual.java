package ui;

import model.Block;

import java.awt.*;

// Represents the UI for a block in the schedule
public class ScheduledBlockVisual extends BlockVisual {

   // EFFECTS: Constructs a scheduled block i.e. with a start time
    public ScheduledBlockVisual(Block block, float oneHourInPixels, int pixel) {
        super(block, oneHourInPixels);
        setText(block.getTitle());
        setBackground(new Color(255, 209, 229));
        this.setBounds(40, pixel, 180, height);
        addActionListener(e -> handleClick());
        this.setVisible(true);
    }

    private void handleClick() {
    }
}
