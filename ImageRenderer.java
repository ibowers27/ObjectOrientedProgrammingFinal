package FinalProject.bowers.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

// This class inherits from DefaultTableCellRenderer
public class ImageRenderer extends DefaultTableCellRenderer {
    // Override the setValue method to set the image for the cell if it is an ImageIcon
    @Override
    protected void setValue(Object value) {
        if (value instanceof ImageIcon) {
            // Set the image
            setIcon((ImageIcon) value);
        } else {
            // Otherwise, use default value
            super.setValue(value);
        }
    }
}
