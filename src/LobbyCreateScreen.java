import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbyCreateScreen extends SpieloView implements ActionListener {
    private GridBagLayout gridBagLayout;
    private JLabel heading_Label;
    private JButton createLobby_Button;
    private JButton backToStartScreen_Button;
    private JPanel lobbySettings_Panel;

    public LobbyCreateScreen(){
        initializeElements();
        configureElements();
        addElementsToLayout();
        addActionListeners();
    }

    private void initializeElements(){
        gridBagLayout = new GridBagLayout();
        heading_Label = new JLabel("Lobby-Einstellungen");
//        Buttons
        createLobby_Button = new JButton("Lobby erstellen");
        backToStartScreen_Button = new JButton("Zum Startbildschirm");
    }

    private void configureElements(){
        heading_Label.setHorizontalAlignment(JLabel.CENTER);
    }

    private void addElementsToLayout(){
        this.setLayout(gridBagLayout);
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, heading_Label, 1, 0, 1, 2, 0, new int[]{0, 0, 40, 0});
//          lobbySettings
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, createLobby_Button, 0, 6, 1, 2, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, backToStartScreen_Button, 2, 6, 1, 2, 0, new int[]{0, 0, 0, 0});
    }

    private void addActionListeners() {
        createLobby_Button.addActionListener(this);
        backToStartScreen_Button.addActionListener(this);
    }

    public void setLobbySettingsPanel(JPanel lobbySettings){
        lobbySettings_Panel = lobbySettings;
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, lobbySettings_Panel, 0, 1, 5, 4, 0, new int[]{0, 0, 0, 0});
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
