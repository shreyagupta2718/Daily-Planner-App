package ui;

import model.Block;

import java.awt.*;

// A visual representation of a block as a rectangle
public class BlockVisual {
    Block block;
    final int x = 0; // Starting x-coordinate for the rectangles
    int y; // Starting y-coordinate for the rectangles
    final int width = 50; // Width of rectangle
    int height = 0; // Height of the rectangle (Scaled length of block as an integer)
    final float scaleLength = 10.0F; // Scale to convert 24hr decimal format time into pixels
    Graphics2D g2d;

    // Construct a visual representation of a scheduled block
    public BlockVisual(Graphics2D g2d, Block block) {
        g2d.setColor(Color.pink);
        this.height = (int) (block.getLength() * scaleLength);
        this.g2d = g2d;
        this.y = (int) (block.getStartTime() * scaleLength);
        this.block = block;
        drawBlock();
    }

    // Construct a visual representation of an unscheduled block
    public BlockVisual(Graphics2D g2d, Block block, int y) {
        g2d.setColor(Color.green);
        this.height = (int) (block.getLength() * scaleLength);
        this.g2d = g2d;
        this.y = (int) (y*scaleLength);
        this.block = block;
        drawBlock();
    }

    public float getScaleLength() {
        return scaleLength;
    }

    public int getHeight() {
        return height;
    }

    // Draws the given block
    public void drawBlock() {
        g2d.fillRect(x, y, width, height); // Draw the rectangle
        g2d.setColor(Color.black);
        g2d.drawString(block.getTitle(), x+1, y + (height / 2)); // Display the block title next to the rectangle
    }
}
