package io.spielo.gui;

import io.spielo.Spielo;
import io.spielo.client.events.ClientEventSubscriber;
import io.spielo.messages.Message;
import io.spielo.messages.lobby.JoinLobbyResponseMessage;
import io.spielo.messages.lobby.LeaveLobbyMessage;
import io.spielo.messages.lobby.ReadyToPlayMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbyScreenHostPublic extends LobbyScreen implements ActionListener, ClientEventSubscriber {

    //          buttons
    private JButton leaveLobby_Button;
    private JButton confirmStart_Button;
//    boolean
    private boolean loadedLobbySettings;
    private boolean opponentConfirmedStart;

    public LobbyScreenHostPublic(){
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
        lobbySettings_Panel.disableVisibiltyButtonGroupSetting();

        opponentConfirmedStart = false;
        confirmStart_Button.setEnabled(false);
        StyleSheet.changeFontOfLobbyScreenElements(this);
    }

    private void addElementsToLayout(){
//        button
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, leaveLobby_Button, 2, 8, 1, 2, 0, new int[]{20, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, confirmStart_Button, 0, 8, 1, 2, 0, new int[]{20, 0, 0, 0});
    }

    public void prepareLobbyForNewGame(){
        confirmStart_Button.setText("Spielstart zustimmen");
        setEmptyStringToPlayerTwo();
        loadedLobbySettings= false;
        opponentConfirmedStart = false;
        confirmStart_Button.setEnabled(false);
    }

    public void setLoadedLobbySettings(boolean isLoaded){
        loadedLobbySettings = isLoaded;
    }

    private void addActionListeners(){
        leaveLobby_Button.addActionListener(this);
        confirmStart_Button.addActionListener(this);
        for(JRadioButton button : lobbySettings_Panel.getChoosableButtons()){
            button.addActionListener(this);
        }
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
        for(JRadioButton button : lobbySettings_Panel.getChoosableButtons()){
            if(e.getSource() == button && loadedLobbySettings){
                Spielo.client.lobbySettings(lobbySettings_Panel.getVisibilitySetting(), lobbySettings_Panel.getGameSettingEnum(), lobbySettings_Panel.getRoundModeSettingEnum(), lobbySettings_Panel.getTimerSettingEnum());
            }
        }
    }

    @Override
    public void onMessageReceived(Message message) {
        if(message instanceof JoinLobbyResponseMessage){
            setNameForPlayerTwo(((JoinLobbyResponseMessage) message).getPlayerName());
            confirmStart_Button.setEnabled(true);
            Spielo.setOpponentLeftGame(false);
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
        if(Spielo.getCurrentLobbyScreen() == this && !Spielo.getOpponentLeftGame()){
            if (message instanceof LeaveLobbyMessage) {
                JOptionPane.showMessageDialog(this, "Dein Gegner hat die Lobby verlassen!");
                Spielo.prepareAppForNewGame();
                setLoadedLobbySettings(true);
            }
        }
    }

    @Override
    public void onDisconnect() {

    }
}
