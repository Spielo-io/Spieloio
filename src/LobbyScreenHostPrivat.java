import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbyScreenHostPrivat extends LobbyScreen implements ActionListener {
    //    joinCode
    private JLabel joinCode_Label;
    //          buttons
    private JButton leaveLobby_Button;
    private JButton startGame_Button;
//          boolean
    private boolean opponentConfirmedStartOfGame;

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
        startGame_Button = new JButton("Spiel starten");
//        boolean
        opponentConfirmedStartOfGame = false;
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
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, leaveLobby_Button, 2, 7, 1, 2, 0, new int[]{20, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, startGame_Button, 0, 7, 1, 2, 0, new int[]{20, 0, 0, 0});
    }

    public void setJoinCodeLabel(String joinCode){
        joinCode_Label.setText("Betritts-Code: " + joinCode);
    }

    public void setOpponentConfirmedStartOfGame(){
        setStartConfirmedToPlayerTwo();
        opponentConfirmedStartOfGame = true;
    }

    public void prepareLobbyForNewGame(){
        opponentConfirmedStartOfGame = false;
    }

    private void addActionListeners(){
        leaveLobby_Button.addActionListener(this);
        startGame_Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == leaveLobby_Button){
            int answer = JOptionPane.showConfirmDialog(this, "Willst du die Lobby wirklich verlassen?", "Wähle eine Option!", JOptionPane.YES_NO_OPTION);
            if(answer == JOptionPane.YES_OPTION) {
                Spielo.changeView("StartScreen");
            }
        }
        else if(e.getSource() == startGame_Button){
            if(opponentConfirmedStartOfGame){
                setStartConfirmedToPlayerOne();
                Spielo.changeView("GameScreen");
            }
            else{
                JOptionPane.showMessageDialog(this, "Dein Gegner hat dem Spielstart noch nicht zugestimmt!");
            }
        }
    }

}
