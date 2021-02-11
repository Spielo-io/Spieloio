import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LobbySelectScreen extends SpieloView implements ActionListener {

        private GridBagLayout gridBagLayout;
        private JLabel heading_Label;

//        private JLabel filter_Label;
//        private JTextField filter_TextField;

        private JPanel panelForLobbyList_Panel;
        private DefaultListModel<String> listForLobbys_ListModel;
        private JList<String> listForLobbys_List;
        private JScrollPane listForLobbys_ScrollPane;

        private JButton joinLobby_Button;
        private JButton backToStartScreen_Button;

        private String [][] lobbyList_Array;

        public LobbySelectScreen(){
            initializeElements();
            configureElements();
            addElementsToLayout();
            addActionListeners();

            addLobbysToLobbyList(new String [][] {{"jap", "hilfe", "public", "TicTacToe"}, {"Schach", "2", "2", "2"}});
        }

    private void initializeElements(){
        gridBagLayout = new GridBagLayout();
        heading_Label = new JLabel("Lobby-Select-Screen");

//        filter_Label = new JLabel("Filter:  ");
//        filter_TextField = new JTextField();

        panelForLobbyList_Panel = new JPanel(new BorderLayout());
        listForLobbys_ListModel = new DefaultListModel<String>();
        listForLobbys_List = new JList<String>(listForLobbys_ListModel);
        listForLobbys_ScrollPane = new JScrollPane(listForLobbys_List);

        joinLobby_Button = new JButton("Trete ausgewählter Lobby bei");
        backToStartScreen_Button = new JButton("Zum Startbildschirm");
    }

    private void configureElements(){

        heading_Label.setHorizontalAlignment(JLabel.CENTER);

        panelForLobbyList_Panel.setMaximumSize(new Dimension(200, 30));
        listForLobbys_List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listForLobbys_List.setLayoutOrientation(JList.VERTICAL);
        listForLobbys_List.setVisibleRowCount(5);

//        filter_Label.setHorizontalAlignment(JLabel.RIGHT);
    }

    private void addElementsToLayout(){
        this.setLayout(gridBagLayout);
        panelForLobbyList_Panel.add(listForLobbys_List, BorderLayout.CENTER);
        panelForLobbyList_Panel.add(listForLobbys_ScrollPane, BorderLayout.EAST);
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, heading_Label, 1, 0, 1, 2, 0, new int[]{0, 0, 0, 0});

//        addElementToPanelUsingGridBagLayout(this, gridBagLayout, filter_Label, 2, 1, 1, 1, 0, new int[]{0, 0, 20, 0});
//        addElementToPanelUsingGridBagLayout(this, gridBagLayout, filter_TextField, 3, 1, 1, 1, 0, new int[]{0, 0, 20, 0});

        addElementToPanelUsingGridBagLayout(this, gridBagLayout, panelForLobbyList_Panel, 0, 1, 2, 4, 0, new int[]{0, 30, 0, 30});


        addElementToPanelUsingGridBagLayout(this, gridBagLayout, joinLobby_Button, 0, 5, 1, 2, 0, new int[]{20, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, backToStartScreen_Button, 2, 5, 1, 2, 0, new int[]{20, 0, 0, 0});
    }

    private void addLobbysToLobbyList(String [][] lobbyList){
            lobbyList_Array = lobbyList;
            String output = "";
            for(int i = 0; i< lobbyList.length; i++){
                output = "Lobby" + String.valueOf(i) + ": ";
                for(int k = 0; k < lobbyList[i].length; k++){
                    if(k == lobbyList[i].length - 1){
                        output += lobbyList[i][k];
                    }
                    else{
                        output += lobbyList[i][k] + ", ";
                    }
                }
                listForLobbys_ListModel.addElement(output);
                output = "";
            }
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
