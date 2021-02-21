import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LobbySelectScreen extends SpieloView implements ActionListener {

        private GridBagLayout gridBagLayout;
//        heading
        private JLabel heading_Label;
//          lobbyList
        private JPanel panelForLobbyList_Panel;
        private DefaultListModel<String> listForLobbys_ListModel;
        private JList<String> listForLobbys_List;
        private JScrollPane listForLobbys_ScrollPane;
//          buttons
        private JButton joinLobby_Button;
        private JButton backToStartScreen_Button;
//          variables
        private String [][] lobbyList_Array;

        public LobbySelectScreen(){
            initializeElements();
            addElementsToLayout();
            configureElements();
            addActionListeners();

            addLobbysToLobbyList(new String [][] {{"jap", "hilfe", "public", "TicTacToe"}, {"Schach", "2", "2", "2"}});

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
        joinLobby_Button = new JButton("Trete ausgewählter Lobby bei");
        backToStartScreen_Button = new JButton("Zum Startbildschirm");


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
//          lobbyList
        panelForLobbyList_Panel.add(listForLobbys_List, BorderLayout.CENTER);
        panelForLobbyList_Panel.add(listForLobbys_ScrollPane, BorderLayout.EAST);
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, panelForLobbyList_Panel, 0, 1, 2, 4, 0, new int[]{0, 30, 0, 30});
//          buttons
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, joinLobby_Button, 0, 5, 1, 2, 0, new int[]{20, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, backToStartScreen_Button, 2, 5, 1, 2, 0, new int[]{20, 0, 0, 0});
    }

    public void addLobbysToLobbyList(String [][] lobbyList){
            if(lobbyList == null){
                removeLobbysFromLobbyList();
                listForLobbys_List.setBackground(new Color(238,238,238));
                JOptionPane.showMessageDialog(this, "Zur Zeit sind keine öffentlichen Lobbys verfügbar!");
            }
            else{
                listForLobbys_List.setBackground(new Color(255, 255, 255));
                lobbyList_Array = lobbyList;
                    StringBuilder output = new StringBuilder();
                    for(int i = 0; i< lobbyList.length; i++) {
                        output = new StringBuilder("Lobby" + String.valueOf(i) + ": ");
                        for (int k = 0; k < lobbyList[i].length; k++) {
                            if (k == lobbyList[i].length - 1) {
                                output.append(lobbyList[i][k]);
                            } else {
                                output.append(lobbyList[i][k]).append(", ");
                            }
                        }
                        listForLobbys_ListModel.addElement(output.toString());
                        output = new StringBuilder();
                    }
            }
    }

    private void removeLobbysFromLobbyList(){
            listForLobbys_ListModel.removeAllElements();
    }

    private String [] getSelectedLobby(){
            int selectedLobbyNumber = listForLobbys_List.getSelectedIndices()[0];
            String [] selectedLobby = new String[4];
            for(int i = 0; i < lobbyList_Array.length; i++){
                if(i == selectedLobbyNumber){
                    selectedLobby = lobbyList_Array[i];
                }
            }
            System.out.println(selectedLobby[0]);
            return selectedLobby;
    }

    private void addActionListeners(){
        backToStartScreen_Button.addActionListener(this);
        joinLobby_Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backToStartScreen_Button){
            Spielo.changeView("StartScreen");
        }
        if(e.getSource() == joinLobby_Button){
            if(listForLobbys_List.isSelectionEmpty()){
                JOptionPane.showMessageDialog(this, "Du musst zuerst eine Lobby auswählen!");
            }
            else{
                Spielo.changeView("LobbyScreen");
            }
        }
    }
}
