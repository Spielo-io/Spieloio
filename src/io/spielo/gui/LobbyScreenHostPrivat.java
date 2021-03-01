package io.spielo.gui;

import io.spielo.Spielo;
import io.spielo.client.events.ClientEventSubscriber;
import io.spielo.messages.Message;
import io.spielo.messages.lobby.CreateLobbyResponseMessage;
import io.spielo.messages.lobby.JoinLobbyResponseMessage;
import io.spielo.messages.lobby.LobbySettingsMessage;
import io.spielo.messages.lobby.ReadyToPlayMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class LobbyScreenHostPrivat extends LobbyScreen implements ActionListener, ClientEventSubscriber {
    //    joinCode
    private JLabel joinCode_Label;
    //          buttons
    private JButton leaveLobby_Button;
    private JButton confirmStart_Button;
//      boolean
    private boolean loadedLobbySettings;

    public LobbyScreenHostPrivat(){
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
        lobbySettings_Panel.disableVisibiltyButtonGroupSetting();

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

    public void prepareLobbyForNewGame(){
        confirmStart_Button.setText("Spielstart zustimmen");
        setEmptyStringToPlayerTwo();
        loadedLobbySettings = false;
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
        for(JRadioButton button : lobbySettings_Panel.getChoosableButtons()){
            if(e.getSource() == button && loadedLobbySettings){
                Spielo.client.lobbySettings(lobbySettings_Panel.getVisibilitySetting(), lobbySettings_Panel.getGameSettingEnum(), lobbySettings_Panel.getRoundModeSettingEnum(), lobbySettings_Panel.getTimerSettingEnum());
            }
        }

    }

    @Override
    public void onMessageReceived(Message message) {
        if(message instanceof CreateLobbyResponseMessage){
            setJoinCodeLabel(((CreateLobbyResponseMessage) message).getCode());
        }
        if(message instanceof JoinLobbyResponseMessage){
            setNameForPlayerTwo(((JoinLobbyResponseMessage) message).getPlayerName());
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
