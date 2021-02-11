import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbyScreen extends SpieloView implements ActionListener {
    private GridBagLayout gridBagLayout;
    private JLabel heading_Label;
//      player label
    private JLabel player1_Label;
    private JLabel player1Name_Label;
    private JLabel player2_Label;
    private JLabel player2Name_Label;
    private JButton leaveLobby_Button;
    private JButton startGame_Button;

    private JPanel lobbySettings_Panel;
    private boolean addedLobbySettingsPanel_bool;

    public LobbyScreen(){
        initializeElements();
        configureElements();
        addElementsToLayout();
        addActionListeners();
    }

    private void initializeElements(){
        heading_Label = new JLabel("Lobby");
        gridBagLayout = new GridBagLayout();
//        player Label
        player1_Label = new JLabel("Spieler 1:");
        player1Name_Label = new JLabel();
        player2_Label = new JLabel("Spieler 2:");
        player2Name_Label = new JLabel("username");
        leaveLobby_Button = new JButton("Lobby verlassen");
        startGame_Button = new JButton("Spiel starten");
//        lobbySettings
        addedLobbySettingsPanel_bool = false;
    }

    private void configureElements(){
        heading_Label.setHorizontalAlignment(JLabel.CENTER);

    }

    private void addElementsToLayout(){
        this.setLayout(gridBagLayout);
//        heading
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, heading_Label, 1, 0, 1, 2, 0, new int[]{0, 0, 0, 0});
//        player Label
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, player1_Label, 0, 1, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, player1Name_Label, 1, 1, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, player2_Label, 2, 1, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, player2Name_Label, 3, 1, 1, 1, 0, new int[]{0, 0, 0, 0});
//        buttons
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, startGame_Button, 0, 7, 1, 2, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, leaveLobby_Button, 2, 7, 1, 2, 0, new int[]{0, 0, 0, 0});
    }

    public void setLobbyAndGameSettings(String usernamePlayer1){
        player1Name_Label.setText(usernamePlayer1);
    }

    private void addActionListeners(){
        leaveLobby_Button.addActionListener(this);
        startGame_Button.addActionListener(this);
    }

    public void setLobbySettingsPanel(JPanel lobbySettings){
        if(!addedLobbySettingsPanel_bool){
            addedLobbySettingsPanel_bool = true;
            lobbySettings_Panel = lobbySettings;
            addElementToPanelUsingGridBagLayout(this, gridBagLayout, lobbySettings_Panel, 0, 2, 5, 4, 0, new int[]{0, 0, 0, 0});
        }
    }

    public void resetAddedLobbySettingsPanel(){
        addedLobbySettingsPanel_bool = false;
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
