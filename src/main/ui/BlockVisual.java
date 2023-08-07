package ui;

import model.Block;

import javax.swing.*;
import java.awt.*;

// A visual representation of a block as a clickable rectangle (JButton)
public abstract class BlockVisual extends JButton {
    protected Block block;
    int height;

    protected final float scaleLength = 10.0F; // Scale to convert 24hr decimal time into pixels (1hr -> 10 pixels)

    // Construct a visual representation of a block
    public BlockVisual(Block block, GridBagConstraints constraints) {
        this.block = block;
        setBackground(Color.pink);
        setForeground(Color.black);
        setText(block.getTitle());
        setOpaque(true);
        setContentAreaFilled(true);
        setBorderPainted(true);
        constraints.gridx = 0;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.NONE;
        height = (int) (block.getLength() * scaleLength);
        setPreferredSize(new Dimension(100, height));
    }
}
