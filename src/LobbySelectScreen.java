import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbySelectScreen extends SpieloView implements ActionListener {
        private JLabel heading_Label;
        private JButton backToStartScreen_Button;

        public LobbySelectScreen(){
            initializeElements();
            addElementsToLayout();
            addActionListeners();
        }
    private void initializeElements(){
        heading_Label = new JLabel("Lobby-Select-Screen");
        backToStartScreen_Button = new JButton("Zum Startbildschirm");
    }

    private void addElementsToLayout(){
        this.add(heading_Label);
        this.add(backToStartScreen_Button);
    }

    private void addActionListeners(){
        backToStartScreen_Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backToStartScreen_Button){
            Spielo.changeView("StartScreen");
        }
    }
}
