import javax.swing.*;
import java.awt.*;

public class LobbyScreen extends SpieloView {
    protected GridBagLayout gridBagLayout;
//    heading
    private JLabel heading_Label;
//      player label
    protected JLabel player1_Label;
    protected JLabel player1Name_Label;
    protected JLabel player2_Label;
    protected JLabel player2Name_Label;
//      lobbySettings
    protected LobbySettings lobbySettings_Panel;

    public LobbyScreen(){
        initializeElements();
        addElementsToLayout();
        configureElements();
    }

    private void initializeElements(){
        gridBagLayout = new GridBagLayout();
//        heading
        heading_Label = new JLabel(StyleSheet.underlineHeading("Lobby"));
//        player Label
        player1_Label = new JLabel("Spieler 1: ");
        player1Name_Label = new JLabel("username1");
        player2_Label = new JLabel("Spieler 2: ");
        player2Name_Label = new JLabel("username2");
//        lobbySettings
        lobbySettings_Panel = new LobbySettings();
    }

    private void configureElements(){
//        heading
        heading_Label.setHorizontalAlignment(JLabel.CENTER);
//        playerLabel
        player1_Label.setHorizontalAlignment(JLabel.RIGHT);
        player2_Label.setHorizontalAlignment(JLabel.RIGHT);
        player1Name_Label.setHorizontalAlignment(JLabel.LEFT);
        player2Name_Label.setHorizontalAlignment(JLabel.LEFT);
//        font
        heading_Label.setFont(StyleSheet.heading_Font);
    }

    private void addElementsToLayout(){
        this.setLayout(gridBagLayout);
//        heading
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, heading_Label, 1, 0, 1, 2, 0, new int[]{0, 0, 20, 0});
//        player Label
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, player1_Label, 0, 1, 1, 1, 0, new int[]{0, 0, 20, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, player1Name_Label, 1, 1, 1, 1, 0, new int[]{0, 0, 20, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, player2_Label, 2, 1, 1, 1, 0, new int[]{0, 0, 20, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, player2Name_Label, 3, 1, 1, 1, 0, new int[]{0, 0, 20, 0});
//        lobbySettings
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, lobbySettings_Panel, 0, 2, 5, 4, 0, new int[]{0, 5, 0, 5});
    }

    public void setNameForPlayerOne(String usernamePlayer1){
        player1Name_Label.setText(usernamePlayer1);
    }

    public void setNameForPlayerTwo(String usernamePlayer2){
        player2Name_Label.setText(usernamePlayer2);
    }

    public void setLobbySettings(String [] lobbySettings, boolean userIsHost){
        lobbySettings_Panel.setLobbySettings(lobbySettings, userIsHost);
    }

    public String [] getLobbySettings(){
        return lobbySettings_Panel.getLobbySettings();
    }
}
