package io.spielo.gui;

import io.spielo.Spielo;
import io.spielo.client.events.ClientEventSubscriber;
import io.spielo.messages.Message;
import io.spielo.messages.lobby.JoinLobbyResponseMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbyScreenHostPublic extends LobbyScreen implements ActionListener, ClientEventSubscriber {

    //          buttons
    private JButton leaveLobby_Button;
    private JButton confirmStart_Button;

    public LobbyScreenHostPublic(){
        initializeElements();
        addElementsToLayout();
        configureElements();
        addActionListeners();
    }

    private void initializeElements(){
//        button
        leaveLobby_Button = new JButton("Lobby verlassen");
        confirmStart_Button = new JButton("Spiel starten");
    }

    private void configureElements(){
//        lobbySettings
        lobbySettings_Panel.disableVisibiltyButtonGroupSetting();

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
                Spielo.changeView("StartScreen");
            }
        }
        else if(e.getSource() == confirmStart_Button){
            if(confirmStart_Button.getText().equals("Spielstart zustimmen")){
                confirmStart_Button.setText("Spielstart verzögern");
                setStartConfirmedToPlayerOne();
            }
            else if(confirmStart_Button.getText().equals("Spielstart verzögern")){
                confirmStart_Button.setText("Spielstart zustimmen");
                setStartDelayedToPlayerOne();
            }
        }
    }

    @Override
    public void onMessageReceived(Message message) {
        if(message instanceof JoinLobbyResponseMessage){
            setNameForPlayerTwo(((JoinLobbyResponseMessage) message).getPlayerName());
        }
    }

    @Override
    public void onDisconnect() {

    }
}
