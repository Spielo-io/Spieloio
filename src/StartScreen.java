import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends SpieloView implements ActionListener {
    private GridBagLayout gridBagLayout;
    private JLabel username_Label;
    private JTextField username_Textfield;
    private JButton createLobby_Button;
    private JButton searchLobby_Button;
    private JButton joinLobby_Button;
    public JTextField joinCode_TextField;
    private JButton randomLobby_Button;

    public StartScreen(){
        initializeElements();
        configureElements();
        addElementsToLayout();
        addActionListeners();
    }

    private void initializeElements(){
        gridBagLayout = new GridBagLayout();
        username_Label = new JLabel("Username:");
        username_Textfield = new JTextField();
        createLobby_Button = new JButton("Lobby erstellen");
        searchLobby_Button = new JButton("Lobby suchen");
        joinLobby_Button = new JButton("Lobby mit Code joinen:");
        joinCode_TextField = new JTextField();
        randomLobby_Button = new JButton("Random Lobby");
    }

    private void configureElements(){
        username_Label.setHorizontalAlignment(JLabel.RIGHT);
        joinLobby_Button.setHorizontalAlignment(JButton.TRAILING);
    }

    private void addElementsToLayout(){
        this.setLayout(gridBagLayout);
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, username_Label, 0, 0, 1, 1, 40, new int[] {10, 5, 10, 5});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, username_Textfield, 1, 0, 1, 1, 20, new int[] {10, 5, 10, 5});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, createLobby_Button, 0, 1, 1, 2, 40, new int[] {10, 5, 10, 5});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, searchLobby_Button, 0, 2, 1, 2, 40, new int[] {10, 5, 10, 5});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, joinLobby_Button, 0, 3, 1, 1, 40, new int[] {10, 5, 10, 5});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, joinCode_TextField, 1,3 , 1, 1, 20, new int[] {10, 5, 10, 5});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, randomLobby_Button, 0, 4, 1, 2, 40, new int[] {10, 5, 0, 5});
    }

    public void clearJoinCodeTextfield(){
        joinCode_TextField.setText("");
    }

    private void addActionListeners(){
        createLobby_Button.addActionListener(this);
        searchLobby_Button.addActionListener(this);
        joinLobby_Button.addActionListener(this);
        randomLobby_Button.addActionListener(this);
    }

    public String getUsername(){
        return username_Textfield.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("".equals(username_Textfield.getText())) {
            if (e.getSource() == this.createLobby_Button) {
                Spielo.changeView("LobbyCreateScreen");
            } else if (e.getSource() == this.searchLobby_Button) {
                Spielo.changeView("LobbySelectScreen");
            } else if (e.getSource() == this.joinLobby_Button) {
                if("".equals(joinCode_TextField.getText())){
                    Spielo.changeView("LobbyScreen");
                }
                else{
                    JOptionPane.showMessageDialog(this, "You have to enter a Code to join a private Lobby!");
                }
            } else if (e.getSource() == this.randomLobby_Button) {
                Spielo.changeView("LobbyScreen");
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "You have to enter a username!");
        }
    }
}
