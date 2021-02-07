import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbyCreateScreen extends SpieloView implements ActionListener {
    private JLabel heading_Label;
    private JButton createLobby_Button;
    private JButton backToStartScreen_Button;

    public LobbyCreateScreen(){
        initializeElements();
        addElementsToLayout();
        addActionListeners();
    }

    private void initializeElements(){
        heading_Label = new JLabel("Lobby");
        createLobby_Button = new JButton("Lobby erstellen");
        backToStartScreen_Button = new JButton("Zum Startbildschirm");
    }

    private void addElementsToLayout(){
        this.add(heading_Label);
        this.add(createLobby_Button);
        this.add(backToStartScreen_Button);
    }

    private void addActionListeners(){
        createLobby_Button.addActionListener(this);
        backToStartScreen_Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backToStartScreen_Button){
            Spielo.changeView("StartScreen");
        }
        else if(e.getSource() == createLobby_Button){
            Spielo.changeView("LobbyScreen");
        }
    }
}
