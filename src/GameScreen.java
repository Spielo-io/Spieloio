import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameScreen extends SpieloView implements ActionListener {
    private GridBagLayout gridBagLayout;
//    heading
    private JLabel heading_Label;
//    buttons
    private JButton exitGame_Button;
//      gamePlay
    private JPanel playedGame_Panel;

    public GameScreen(){
        initializeElements();
        addElementsToLayout();
        addActionListeners();
    }
    private void initializeElements(){
        gridBagLayout = new GridBagLayout();
//          heading
        heading_Label = new JLabel("Game-Screen");
//          gameplay
//        playedGame_Panel =
//        buttons
        exitGame_Button = new JButton("Spiel verlassen");
    }

    private void addElementsToLayout(){
//        heading^^
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, heading_Label, 0, 0, 1, 1, 0, new int[]{0, 0, 0, 0});
//        gamePlay
//        addElementToPanelUsingGridBagLayout(this, gridBagLayout, playedGame_Panel, 0, 1, 1, 1, 0, new int[]{0, 0, 0, 0});
//        buttons
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
