package ui;

import model.Block;

import javax.swing.*;
import java.awt.*;

// A visual representation of a block as a clickable rectangle (JButton)
public abstract class BlockVisual extends JButton {
    protected Block block;
    int height;

    //protected float scaleLength = (getHeight()-20)/24; // Scale to convert 24hr decimal time into pixels todo

    // Construct a visual representation of a block
    public BlockVisual(Block block, GridBagConstraints constraints) {
        this.block = block;
        setForeground(Color.black);
        setText(block.getTitle());
        setOpaque(true);
        setContentAreaFilled(true);
        setBorderPainted(true);
        constraints.gridx = 0;
        constraints.fill = GridBagConstraints.NONE;
        height = (int) (block.getLength() * 10); //todo
        setPreferredSize(new Dimension(100, height));
    }
}
