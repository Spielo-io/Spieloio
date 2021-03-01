package io.spielo.gui;

import io.spielo.Spielo;
import io.spielo.client.events.ClientEventSubscriber;
import io.spielo.messages.Message;
import io.spielo.messages.lobby.PublicLobby;
import io.spielo.messages.lobby.PublicLobbyListMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class LobbySelectScreen extends SpieloView implements ActionListener, ClientEventSubscriber {

        private GridBagLayout gridBagLayout;
//        heading
        private JLabel heading_Label;
//          lobbyList
        private JPanel panelForLobbyList_Panel;
        private DefaultListModel<String> listForLobbys_ListModel;
        private JList<String> listForLobbys_List;
        private JScrollPane listForLobbys_ScrollPane;
//          buttons
        private JButton actualizeLobbys_Button;
        private JButton joinLobby_Button;
        private JButton backToStartScreen_Button;
//          variables
        private String [][] lobbyList_Array;

        private HashMap<Integer, String> lobbyCode_List;

        public LobbySelectScreen(){
            initializeElements();
            addElementsToLayout();
            configureElements();
            addActionListeners();
        }

    private void initializeElements(){
        gridBagLayout = new GridBagLayout();
//        heading
        heading_Label = new JLabel(StyleSheet.underlineHeading("Lobby-Select-Screen"));
//          lobbyList
        panelForLobbyList_Panel = new JPanel(new BorderLayout());
        listForLobbys_ListModel = new DefaultListModel<String>();
        listForLobbys_List = new JList<String>(listForLobbys_ListModel);
        listForLobbys_ScrollPane = new JScrollPane(listForLobbys_List);
//          buttons
        actualizeLobbys_Button = new JButton("Aktualisieren");
        joinLobby_Button = new JButton("Trete ausgewählter Lobby bei");
        backToStartScreen_Button = new JButton("Zum Startbildschirm");

        lobbyCode_List = new HashMap<Integer, String>();


    }

    private void configureElements(){
//          heading
        heading_Label.setHorizontalAlignment(JLabel.CENTER);
        heading_Label.setFont(StyleSheet.heading_Font);
//            lobbyList
        panelForLobbyList_Panel.setMaximumSize(new Dimension(200, 30));
        listForLobbys_List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listForLobbys_List.setLayoutOrientation(JList.VERTICAL);
        listForLobbys_List.setVisibleRowCount(5);
//        font
        StyleSheet.changeFontOfLobbySelectScreenElements(this);
    }

    private void addElementsToLayout(){
        this.setLayout(gridBagLayout);
//          heading
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, heading_Label, 1, 0, 1, 2, 0, new int[]{0, 0, 20, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, actualizeLobbys_Button, 3, 1, 1, 1, 0, new int[]{0, 0, 20, 0});

//          lobbyList
        panelForLobbyList_Panel.add(listForLobbys_List, BorderLayout.CENTER);
        panelForLobbyList_Panel.add(listForLobbys_ScrollPane, BorderLayout.EAST);
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, panelForLobbyList_Panel, 0, 2, 2, 4, 0, new int[]{0, 30, 0, 30});
//          buttons
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, joinLobby_Button, 0, 6, 1, 2, 0, new int[]{20, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, backToStartScreen_Button, 2, 6, 1, 2, 0, new int[]{20, 0, 0, 0});
    }

    public void addLobbysToLobbyListNew(List<PublicLobby> lobbyList){
            if(lobbyList.isEmpty()){
                removeLobbysFromLobbyList();
                listForLobbys_List.setBackground(new Color(238,238,238));
                JOptionPane.showMessageDialog(this, "Zur Zeit sind keine öffentlichen Lobbys verfügbar!");
            }
            else {
                removeLobbysFromLobbyList();
                listForLobbys_List.setBackground(new Color(255, 255, 255));
                int counter = 0;
                for (PublicLobby lobby : lobbyList) {
                    StringBuilder output = new StringBuilder("Lobby" + String.valueOf(counter + 1) + ": ");
                    lobbyCode_List.put(counter, lobby.getLobbyCode());
                    output.append(lobby.getHostname()).append(", ");
                    switch (lobby.getSettings().getGame()) {
                        case TicTacToe -> output.append("TicTacToe, ");
                        case Win4 -> output.append("4 Gewinnt, ");
                    }
                    switch (lobby.getSettings().getBestOf()) {
                        case BestOf_1 -> output.append("Best of 1, ");
                        case BestOf_3 -> output.append("Best of 3, ");
                        case BestOf_5 -> output.append("Best of 5, ");
                        case BestOf_7 -> output.append("Best of 7, ");
                        case BestOf_9 -> output.append("Best of 9, ");
                    }
                    switch (lobby.getSettings().getTimer()) {
                        case Seconds_30 -> output.append("30 Sek.");
                        case Minute_1 -> output.append("1 Min.");
                        case Minute_3 -> output.append("3 Min.");
                    }
                    listForLobbys_ListModel.addElement(output.toString());
                    counter++;
                }
            }
    }

    private void removeLobbysFromLobbyList(){
        listForLobbys_List.setBackground(new Color(238,238,238));
        listForLobbys_ListModel.removeAllElements();

    }

    private int getSelectedLobby() {
        return listForLobbys_List.getSelectedIndices()[0];
    }

    private void addActionListeners(){
            actualizeLobbys_Button.addActionListener(this);
        backToStartScreen_Button.addActionListener(this);
        joinLobby_Button.addActionListener(this);
    }

    public void preparePanelForNewGame(){
            removeLobbysFromLobbyList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == actualizeLobbys_Button){
            Spielo.client.refreshLobbyList();
        }
        if(e.getSource() == backToStartScreen_Button){
            Spielo.changeView("StartScreen");
        }
        if(e.getSource() == joinLobby_Button){
            if(listForLobbys_List.isSelectionEmpty()){
                JOptionPane.showMessageDialog(this, "Du musst zuerst eine Lobby auswählen!");
            }
            else{
                Spielo.client.joinLobby(Spielo.getUsername(), lobbyCode_List.get(getSelectedLobby()));
                Spielo.changeView("LobbyScreenClientPublic");
            }
        }
    }

    @Override
    public void onMessageReceived(Message message) {
        if(message instanceof PublicLobbyListMessage){
            addLobbysToLobbyListNew(((PublicLobbyListMessage) message).getList());
        }
    }

    @Override
    public void onDisconnect() {

    }
}
