package io.spielo.gui;

import io.spielo.Spielo;
import io.spielo.client.events.ClientEventSubscriber;
import io.spielo.messages.Message;
import io.spielo.messages.lobby.JoinLobbyResponseCode;
import io.spielo.messages.lobby.JoinLobbyResponseMessage;
import io.spielo.messages.lobby.LobbySettingsMessage;
import io.spielo.messages.lobby.ReadyToPlayMessage;
import io.spielo.messages.lobbysettings.LobbySettings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbyScreenClientPublic extends LobbyScreen implements ActionListener, ClientEventSubscriber {

    //          buttons
    private JButton leaveLobby_Button;
    private JButton confirmStart_Button;

    public LobbyScreenClientPublic(){
        initializeElements();
        addElementsToLayout();
        configureElements();
        addActionListeners();
    }

    private void initializeElements(){
//        button
        leaveLobby_Button = new JButton("Lobby verlassen");
        confirmStart_Button = new JButton("Spielstart zustimmen");
    }

    private void configureElements(){
//        lobbySettings
        lobbySettings_Panel.activateRadioButtons(false);

        StyleSheet.changeFontOfLobbyScreenElements(this);

    }

    private void addElementsToLayout(){
//        button
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, leaveLobby_Button, 2, 8, 1, 2, 0, new int[]{20, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, confirmStart_Button, 0, 8, 1, 2, 0, new int[]{20, 0, 0, 0});
    }

    private void addActionListeners(){
        leaveLobby_Button.addActionListener(this);
        confirmStart_Button.addActionListener(this);
    }

    public void preparePanelForNewLobby(){
        confirmStart_Button.setText("Spielstart zustimmen");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == leaveLobby_Button){
            int answer = JOptionPane.showConfirmDialog(this, "Willst du die Lobby wirklich verlassen?", "Wähle eine Option!", JOptionPane.YES_NO_OPTION);
            if(answer == JOptionPane.YES_OPTION) {
                Spielo.changeView("StartScreen");
            }
        }
        else if(e.getSource() == confirmStart_Button){
            if(confirmStart_Button.getText().equals("Spielstart zustimmen")){
                confirmStart_Button.setText("Spielstart verzögern");
                setStartConfirmedToPlayerOne();
                Spielo.client.readyToPlay(true);
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
            }
            else{
                setStartDelayedToPlayerTwo();
            }
            if(((ReadyToPlayMessage) message).getIsReady() && confirmStart_Button.getText().equals("Spielstart verzögern")){
                startGame();
            }
        }
    }

    @Override
    public void onDisconnect() {

    }
}
