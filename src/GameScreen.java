import io.spielo.games.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameScreen extends SpieloView implements ActionListener {
    private GridBagLayout gridBagLayout;
    private JLabel heading_Label;
    private JButton exitGame_Button;

    private JPanel playedGame_Panel;

    public GameScreen(){
        initializeElements();
        addElementsToLayout();
        addActionListeners();
    }
    private void initializeElements(){
        gridBagLayout = new GridBagLayout();

        heading_Label = new JLabel("Game-Screen");
        exitGame_Button = new JButton("Spiel verlassen");

        playedGame_Panel = new TicTacToe();
    }

    private void addElementsToLayout(){
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, heading_Label, 0, 0, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, playedGame_Panel, 0, 1, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, exitGame_Button, 0, 2, 1, 1, 0, new int[]{0, 0, 0, 0});
    }

    private void addActionListeners(){
        exitGame_Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exitGame_Button){
            Spielo.changeView("StartScreen");
        }
    }
}
