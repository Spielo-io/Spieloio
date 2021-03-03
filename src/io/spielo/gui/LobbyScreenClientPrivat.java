package io.spielo.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import io.spielo.Spielo;
import io.spielo.client.events.ClientEventSubscriber;
import io.spielo.messages.Message;
import io.spielo.messages.lobby.*;
import io.spielo.messages.lobbysettings.LobbySettings;

public class LobbyScreenClientPrivat extends LobbyScreen implements ActionListener, ClientEventSubscriber {
    //    joinCode
    private JLabel joinCode_Label;
//          buttons
    private JButton leaveLobby_Button;
    private JButton confirmStart_Button;
//      boolean
    private boolean opponentConfirmedStart;

    public LobbyScreenClientPrivat(){
        initializeElements();
        addElementsToLayout();
        configureElements();
        addActionListeners();
    }

    private void initializeElements(){
//        joinCode
        joinCode_Label = new JLabel("Beitritts-Code: ");
//        button
        leaveLobby_Button = new JButton("Lobby verlassen");
        confirmStart_Button = new JButton("Spielstart zustimmen");
    }

    private void configureElements(){
        //        joinCode
        joinCode_Label.setHorizontalAlignment(JLabel.LEFT);
//        lobbySettings
        lobbySettings_Panel.activateRadioButtons(false);
//        boolean
        opponentConfirmedStart = false;

        StyleSheet.changeFontOfLobbyScreenElements(this);
    }

    private void addElementsToLayout(){
//        joinCode
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, joinCode_Label, 3, 0, 1, 1, 0, new int[]{0, 0, 20, 0});
//        button
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, leaveLobby_Button, 2, 8, 1, 2, 0, new int[]{20, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, confirmStart_Button, 0, 8, 1, 2, 0, new int[]{20, 0, 0, 0});
    }

    public void setJoinCodeLabel(String joinCode){
        joinCode_Label.setText("Betritts-Code: " + joinCode.toUpperCase(Locale.ROOT));
    }

    public void preparePanelForNewLobby(){
        confirmStart_Button.setText("Spielstart zustimmen");
        opponentConfirmedStart = false;
    }

    private void addActionListeners(){
        leaveLobby_Button.addActionListener(this);
        confirmStart_Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == leaveLobby_Button){
            int answer = JOptionPane.showConfirmDialog(this, "Willst du die Lobby wirklich verlassen?", "Wähle eine Option!", JOptionPane.YES_NO_OPTION);
            if(answer == JOptionPane.YES_OPTION) {
                Spielo.client.leaveLobby();
                Spielo.changeView("StartScreen");
            }
        }
        else if(e.getSource() == confirmStart_Button){
            if(confirmStart_Button.getText().equals("Spielstart zustimmen")){
                confirmStart_Button.setText("Spielstart verzögern");
                setStartConfirmedToPlayerOne();
                Spielo.client.readyToPlay(true);
                if (opponentConfirmedStart) {
                    startGame();
                }
            }
            else if(confirmStart_Button.getText().equals("Spielstart verzögern")){
                confirmStart_Button.setText("Spielstart zustimmen");
                setStartDelayedToPlayerOne();
                Spielo.client.readyToPlay(false);
            }
        }

    }

    @Override
    public void onMessageReceived(Message message) {
        if(message instanceof JoinLobbyResponseMessage){
            if(((JoinLobbyResponseMessage) message).getResponseCode() == JoinLobbyResponseCode.Failed){
                JOptionPane.showMessageDialog(this, "Dein Join-Code war leider ungültig!");
                Spielo.changeView("StartScreen");
            }
            else{
                setNameForPlayerTwo(((JoinLobbyResponseMessage) message).getPlayerName());
            }
        }
        if(message instanceof LobbySettingsMessage){
            LobbySettings settings = ((LobbySettingsMessage) message).getSettings();
            lobbySettings_Panel.setLobbySettingsEnum(settings.getPublic(), settings.getGame(), settings.getBestOf(), settings.getTimer(), false);
        }
        if(message instanceof ReadyToPlayMessage){
            if(((ReadyToPlayMessage) message).getIsReady()){
                setStartConfirmedToPlayerTwo();
                opponentConfirmedStart = true;
            }
            else{
                setStartDelayedToPlayerTwo();
                opponentConfirmedStart = false;
            }
            if(((ReadyToPlayMessage) message).getIsReady() && confirmStart_Button.getText().equals("Spielstart verzögern")){
                startGame();
            }
        }
        if(Spielo.getCurrentLobbyScreen() == this) {
            if (message instanceof LeaveLobbyMessage) {
                JOptionPane.showMessageDialog(this, "Dein Gegner hat die Lobby verlassen!\nDu bist nun der Host dieser Lobby.");
                Spielo.prepareAppForNewGame();
                Spielo.setUserIsHost(true);
                Spielo.changeView("LobbyScreenHostPrivat");
                Spielo.setJoinCodeToLobbyScreenHostPrivat();
                Spielo.setLobbySettingsToLobbyScreenHostPrivat();
                Spielo.setOpponentLeftGame(true);
            }
        }

//        Spielo.client.leaveLobby();
//        if(message instanceof LeaveLobbyMessage){
////            message.
//        }
    }

    @Override
    public void onDisconnect() {

    }
}
