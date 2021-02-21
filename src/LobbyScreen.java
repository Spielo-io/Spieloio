import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbyScreen extends SpieloView implements ActionListener {
    private GridBagLayout gridBagLayout;
//    heading
    private JLabel heading_Label;
//    joinCode
    private JLabel joinCode_Label;
//      player label
    private JLabel player1_Label;
    private JLabel player1Name_Label;
    private JLabel player2_Label;
    private JLabel player2Name_Label;
//      lobbySettings
    public LobbySettings lobbySettings_Panel;
//    button
    private JButton leaveLobby_Button;
    private JButton startGame_Button;

    public LobbyScreen(){
        initializeElements();
        addElementsToLayout();
        configureElements();
        addActionListeners();
    }

    private void initializeElements(){
        gridBagLayout = new GridBagLayout();
//        heading
        heading_Label = new JLabel(StyleSheet.underlineHeading("Lobby"));
//        joinCode
        joinCode_Label = new JLabel("Beitritts-Code:");
//        player Label
        player1_Label = new JLabel("Spieler 1: ");
        player1Name_Label = new JLabel("username1");
        player2_Label = new JLabel("Spieler 2: ");
        player2Name_Label = new JLabel("username2");
//        lobbySettings
        lobbySettings_Panel = new LobbySettings();
//        buttons
        leaveLobby_Button = new JButton("Lobby verlassen");
        startGame_Button = new JButton("Spiel starten");
    }

    private void configureElements(){
//        heading
        heading_Label.setHorizontalAlignment(JLabel.CENTER);
//        joinCode
        joinCode_Label.setHorizontalAlignment(JLabel.LEFT);
//        playerLabel
        player1_Label.setHorizontalAlignment(JLabel.RIGHT);
        player2_Label.setHorizontalAlignment(JLabel.RIGHT);
        player1Name_Label.setHorizontalAlignment(JLabel.LEFT);
        player2Name_Label.setHorizontalAlignment(JLabel.LEFT);
//        font
        StyleSheet.changeFontOfLobbyScreenElements(this);
        heading_Label.setFont(StyleSheet.heading_Font);
    }

    private void addElementsToLayout(){
        this.setLayout(gridBagLayout);
//        heading
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, heading_Label, 1, 0, 1, 2, 0, new int[]{0, 0, 20, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, joinCode_Label, 3, 0, 1, 1, 0, new int[]{0, 0, 20, 0});
//        player Label
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, player1_Label, 0, 1, 1, 1, 0, new int[]{0, 0, 20, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, player1Name_Label, 1, 1, 1, 1, 0, new int[]{0, 0, 20, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, player2_Label, 2, 1, 1, 1, 0, new int[]{0, 0, 20, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, player2Name_Label, 3, 1, 1, 1, 0, new int[]{0, 0, 20, 0});
//        lobbySettings
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, lobbySettings_Panel, 0, 2, 5, 4, 0, new int[]{0, 5, 0, 5});
//        buttons
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, startGame_Button, 0, 7, 1, 2, 0, new int[]{20, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, leaveLobby_Button, 2, 7, 1, 2, 0, new int[]{20, 0, 0, 0});
    }

    public void setLobbyAndGameSettings(String usernamePlayer1){
        player1Name_Label.setText(usernamePlayer1);
    }

    private void addActionListeners(){
        leaveLobby_Button.addActionListener(this);
        startGame_Button.addActionListener(this);
    }

    private void setJoinCodeLabel(String joinCode){
        joinCode_Label.setText("Betritts-Code: " + joinCode);
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
