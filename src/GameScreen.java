import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameScreen extends SpieloView implements ActionListener {
    private JLabel heading_Label;
    private JButton exitGame_Button;

    public GameScreen(){
        initializeElements();
        addElementsToLayout();
        addActionListeners();
    }
    private void initializeElements(){
        heading_Label = new JLabel("Lobby-Select-Screen");
        exitGame_Button = new JButton("Spiel verlassen");
    }

    private void addElementsToLayout(){
        this.add(heading_Label);
        this.add(exitGame_Button);
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
