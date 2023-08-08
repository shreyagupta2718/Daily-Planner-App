package ui;

import model.Block;

import javax.swing.*;
import java.awt.*;

// A visual representation of a block as a clickable rectangle (JButton)
public abstract class BlockVisual extends JButton {
    protected Block block;
    int height;

    // EFFECTS: Construct a visual representation of a block
    public BlockVisual(Block block, float oneHourInPixels) {
        this.block = block;
        setForeground(Color.black);
        setOpaque(true);
        setContentAreaFilled(true);
        setBorderPainted(true);
        this.height = (int) (block.getLength() * oneHourInPixels);
        setPreferredSize(new Dimension(180, this.height));
    }
}
