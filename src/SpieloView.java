import javax.swing.*;
import java.awt.*;

public class SpieloView extends JPanel {
    public void addElementToPanelUsingGridBagLayout(JPanel panel, GridBagLayout layout, Component element, int xDimension, int yDimension, int height, int width){
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = xDimension;
        gridBagConstraints.gridy = yDimension;
        gridBagConstraints.gridwidth = width;
        gridBagConstraints.gridheight = height;
        gridBagConstraints.weightx = 0.1;

        layout.setConstraints(element, gridBagConstraints);
        panel.add(element);
    }
}
