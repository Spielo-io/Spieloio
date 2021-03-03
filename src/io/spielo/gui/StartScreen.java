package io.spielo.gui;

import io.spielo.Spielo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class StartScreen extends SpieloView implements ActionListener {
    private GridBagLayout gridBagLayout;
//    username
    private JLabel username_Label;
    private JTextField username_Textfield;
//    buttons
    private JButton createLobby_Button;
    private JButton searchLobby_Button;
    private JButton joinLobby_Button;
    private JButton randomLobby_Button;
//    joinCode
    public JTextField joinCode_TextField;

    public StartScreen(){
        initializeElements();
        addElementsToLayout();
        configureElements();
        addActionListeners();

    }

    private void initializeElements(){
        gridBagLayout = new GridBagLayout();
//        username
        username_Label = new JLabel("Benutzername:");
        username_Textfield = new JTextField();
//        buttons
        createLobby_Button = new JButton("Lobby erstellen");
        searchLobby_Button = new JButton("Lobby suchen");
        joinLobby_Button = new JButton("Lobby mit Code joinen:");
        randomLobby_Button = new JButton("Random Lobby");
//        joinCode
        joinCode_TextField = new JTextField();
    }

    private void configureElements(){
//        username
        username_Label.setHorizontalAlignment(JLabel.RIGHT);
//        button
        joinLobby_Button.setHorizontalAlignment(JButton.TRAILING);
//        font
        StyleSheet.changeFontOfStartScreenElements(this);
    }

    private void addElementsToLayout(){
        this.setLayout(gridBagLayout);
//        username
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, username_Label, 0, 0, 1, 1, 40, new int[] {10, 5, 10, 5});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, username_Textfield, 1, 0, 1, 1, 20, new int[] {10, 5, 10, 5});
//        buttons
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, createLobby_Button, 0, 1, 1, 2, 40, new int[] {10, 5, 10, 5});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, searchLobby_Button, 0, 2, 1, 2, 40, new int[] {10, 5, 10, 5});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, joinLobby_Button, 0, 3, 1, 1, 40, new int[] {10, 5, 10, 5});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, randomLobby_Button, 0, 4, 1, 2, 40, new int[] {10, 5, 0, 5});
//        joinCode
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, joinCode_TextField, 1,3 , 1, 1, 20, new int[] {10, 5, 10, 5});
    }

    public void clearJoinCodeTextfield(){
        joinCode_TextField.setText("");
    }

    public String getUsername(){
        return username_Textfield.getText();
    }

    public String getJoinCode(){
        return joinCode_TextField.getText().toLowerCase(Locale.ROOT);
    }

    private boolean isValidJoinCode(String joinCode){
        return joinCode.length() == 6 && joinCode.matches("[a-z]*");
    }

    private void addActionListeners(){
        createLobby_Button.addActionListener(this);
        searchLobby_Button.addActionListener(this);
        joinLobby_Button.addActionListener(this);
        randomLobby_Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        entered Username
        if(!"".equals(username_Textfield.getText())) {
//                change to LobbyCreateScreen
            if (e.getSource() == this.createLobby_Button) {
//                Spielo.changeView("GameScreen");
                Spielo.changeView("LobbyCreateScreen");
//                change to LobbySelectScreen
            } else if (e.getSource() == this.searchLobby_Button) {
                Spielo.changeView("LobbySelectScreen");
                Spielo.client.refreshLobbyList();
//                change to LobbyScreen(PrivateLobby)
            } else if (e.getSource() == this.joinLobby_Button) {
//                          entered joinCode
                if(!"".equals(joinCode_TextField.getText())){
//                              valid joinCode
                    if(isValidJoinCode(getJoinCode())){
                        Spielo.client.joinLobby(getUsername(), getJoinCode());
                        Spielo.changeView("LobbyScreenClientPrivat");
                    }
//                              invalid joinCode
                    else{
                        JOptionPane.showMessageDialog(this, "Der Code muss aus sechs Buchstaben bestehen!");
                    }
                }
//                       didn´t entered JoinCode
                else{
                    JOptionPane.showMessageDialog(this, "Du musst einen Code eingeben, um einer privaten Lobby beizutreten!");
                }
//                change to LobbyScreen(RandomLobby)
            } else if (e.getSource() == this.randomLobby_Button) {
                Spielo.client.joinRandomLobby(getUsername());
                Spielo.changeView("LobbyScreenClientPublic");
            }
        }
//      didn´t entered username
        else{
            JOptionPane.showMessageDialog(this, "Du hast noch keinen Benutzernamen gesetzt!");
        }
    }
}
