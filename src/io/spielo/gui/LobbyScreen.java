package io.spielo.gui;


import io.spielo.Spielo;
import io.spielo.games.fourwins.fourWins;

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
    public LobbySettings lobbySettings_Panel;

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
        player1_Label = new JLabel("Du: ");
        player1Name_Label = new JLabel("<html>username1</html>");
        player2_Label = new JLabel("Dein Gegner: ");
        player2Name_Label = new JLabel("<html></html>");
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
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, lobbySettings_Panel, 0, 2, 6, 4, 0, new int[]{0, 5, 0, 5});
    }

    public void setNameForPlayerOne(String usernamePlayer1){
        player1Name_Label.setText("<html>" + usernamePlayer1 + " <b style=\"color:red;\">&#10060</html>");
    }

    protected void setNameForPlayerTwo(String usernamePlayer2){
        Spielo.setUsernameOfPlayerTwo(usernamePlayer2);
        player2Name_Label.setText("<html>" + usernamePlayer2 + " <b style=\"color:red;\">&#10060</html>");
    }

    protected void setEmptyStringToPlayerTwo(){
        player2Name_Label.setText("");
    }

    protected void setStartConfirmedToPlayerOne(){
        player1Name_Label.setText("<html>" + Spielo.getUsername() + " <b style=\"color:green;\">&#10004</html>");
    }

    protected void setStartDelayedToPlayerOne(){
        player1Name_Label.setText("<html>" + Spielo.getUsername() + " <b style=\"color:red;\">&#10060</html>");
    }

    protected void setStartConfirmedToPlayerTwo(){
        player2Name_Label.setText("<html>" + Spielo.getUsernameOfPlayerTwo() + " <b style=\"color:green;\">&#10004</b></html>");
    }

    protected void setStartDelayedToPlayerTwo(){
        player2Name_Label.setText("<html>" + Spielo.getUsernameOfPlayerTwo() + " <b style=\"color:red;\">&#10060</b></html>");
    }

    protected void startGame(){
        System.out.println("spielen");
        fourWins spiel = new fourWins(Spielo.userIsHost());
    }

//    public void setLobbySettings(boolean isPublic, String game, String bestOf, String lobbyTimer, boolean userIsHost){
//        lobbySettings_Panel.setLobbySettings(isPublic, game, bestOf, lobbyTimer, userIsHost);
//    }
//
//    public String [] getLobbySettings(){
//        return lobbySettings_Panel.getLobbySettings();
//    }
}
