import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbySelectScreen extends SpieloView implements ActionListener {

        private GridBagLayout gridBagLayout;
        private JLabel heading_Label;

        private JLabel filter_Label;
        private JTextField filter_TextField;

        private DefaultListModel<String> listForLobbys_ListModel;
        private JList<String> listForLobbys_List;

        private JButton joinLobby_Button;
        private JButton backToStartScreen_Button;

        public LobbySelectScreen(){
            initializeElements();
            configureElements();
            addElementsToLayout();
            addActionListeners();
        }
    private void initializeElements(){
        gridBagLayout = new GridBagLayout();
        heading_Label = new JLabel("Lobby-Select-Screen");

        filter_Label = new JLabel("Filter:  ");
        filter_TextField = new JTextField();

        listForLobbys_ListModel = new DefaultListModel<String>();
        listForLobbys_List = new JList<String>(listForLobbys_ListModel);

        joinLobby_Button = new JButton("Trete ausgewählter Lobby bei");
        backToStartScreen_Button = new JButton("Zum Startbildschirm");
    }

    private void configureElements(){
        heading_Label.setHorizontalAlignment(JLabel.CENTER);

        listForLobbys_List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listForLobbys_ListModel.addElement("element");
        listForLobbys_ListModel.addElement("element");
        listForLobbys_ListModel.addElement("element");
        listForLobbys_ListModel.addElement("element");
        listForLobbys_ListModel.addElement("element");
        listForLobbys_ListModel.addElement("element");

        filter_Label.setHorizontalAlignment(JLabel.RIGHT);
    }

    private void addElementsToLayout(){
        this.setLayout(gridBagLayout);
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, heading_Label, 1, 0, 1, 2, 0, new int[]{0, 0, 0, 0});

        addElementToPanelUsingGridBagLayout(this, gridBagLayout, filter_Label, 2, 1, 1, 1, 0, new int[]{0, 0, 20, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, filter_TextField, 3, 1, 1, 1, 0, new int[]{0, 0, 20, 0});

        addElementToPanelUsingGridBagLayout(this, gridBagLayout, listForLobbys_List, 0, 2, 3, 4, 0, new int[]{0, 0, 0, 0});



        addElementToPanelUsingGridBagLayout(this, gridBagLayout, joinLobby_Button, 0, 6, 1, 2, 0, new int[]{20, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, backToStartScreen_Button, 2, 6, 1, 2, 0, new int[]{20, 0, 0, 0});
    }

    private void addActionListeners(){
        backToStartScreen_Button.addActionListener(this);
    }


//    private void addLobbysToList(){
//
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backToStartScreen_Button){
            Spielo.changeView("StartScreen");
        }
    }
}
