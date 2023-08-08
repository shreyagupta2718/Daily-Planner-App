package ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

// Represents the common layout/design features of brain dump and schedule
public abstract class ListOfBlocksPanel extends JPanel {
    protected final int emptySpace = 20;
    protected final int oneHourInPixels = 29;
    protected final Dimension dimension = new Dimension(20, 24 * oneHourInPixels + 2 * emptySpace);
    protected final Border border = BorderFactory.createEmptyBorder(emptySpace, 5, emptySpace, 1);
    protected final int titleX = TitledBorder.CENTER;
    protected final int titleY = TitledBorder.ABOVE_TOP;
}
