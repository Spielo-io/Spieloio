import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbyScreen extends SpieloView implements ActionListener {
    private JLabel heading_Label;
    private JButton leaveLobby_Button;
    private JButton startGame_Button;

    public LobbyScreen(){
        initializeElements();
        addElementsToLayout();
        addActionListeners();
    }

    private void initializeElements(){
        heading_Label = new JLabel("Lobby");
        leaveLobby_Button = new JButton("Lobby verlassen");
        startGame_Button = new JButton("Spiel starten");
    }

    private void addElementsToLayout(){
        this.add(heading_Label);
        this.add(leaveLobby_Button);
        this.add(startGame_Button);
    }

    private void addActionListeners(){
        leaveLobby_Button.addActionListener(this);
        startGame_Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == leaveLobby_Button){
            Spielo.changeView("StartScreen");
        }
        else if(e.getSource() == startGame_Button){
            Spielo.changeView("GameScreen");
        }
    }
}
