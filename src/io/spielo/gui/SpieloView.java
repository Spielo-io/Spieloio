package io.spielo.gui;

import javax.swing.*;
import java.awt.*;

public class SpieloView extends JPanel {
    public void addElementToPanelUsingGridBagLayout(JPanel panel, GridBagLayout layout, Component element, int xDimension, int yDimension, int height, int width, int ipady, int [] insets){
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = xDimension;
        gridBagConstraints.gridy = yDimension;
        gridBagConstraints.gridwidth = width;
        gridBagConstraints.gridheight = height;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.ipady = ipady;
        gridBagConstraints.insets = new Insets(insets[0], insets[1], insets[2], insets[3]);

        layout.setConstraints(element, gridBagConstraints);
        panel.add(element);
    }
}
