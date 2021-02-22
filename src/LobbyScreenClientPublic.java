import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbyScreenClientPublic extends LobbyScreen implements ActionListener {

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
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, leaveLobby_Button, 2, 7, 1, 2, 0, new int[]{20, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, confirmStart_Button, 0, 7, 1, 2, 0, new int[]{20, 0, 0, 0});
    }

    private void addActionListeners(){
        leaveLobby_Button.addActionListener(this);
        confirmStart_Button.addActionListener(this);
    }

    public void startGame(){
        Spielo.changeView("GameScreen");
    }

    public void preparePanelForNewLobby(){
        confirmStart_Button.setText("Spielstart zustimmen");
        confirmStart_Button.setEnabled(true);
    }

    public void alarmClientToConfirmStartOfGame(){
        JOptionPane.showMessageDialog(this, "Dein Gegner will das Spiel starten!\nDrücke auf \"Spielstart zustimmen\", um das Spiel zu beginnen.");
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
            confirmStart_Button.setText("Spielstart zugestimmt");
            confirmStart_Button.setEnabled(false);
            setStartConfirmedToPlayerOne();
        }
    }

}
