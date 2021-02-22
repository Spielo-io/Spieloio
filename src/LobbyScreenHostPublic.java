import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbyScreenHostPublic extends LobbyScreen implements ActionListener {

    //          buttons
    private JButton leaveLobby_Button;
    private JButton startGame_Button;
//      boolean
    private boolean opponentConfirmedStartOfGame;

    public LobbyScreenHostPublic(){
        initializeElements();
        addElementsToLayout();
        configureElements();
        addActionListeners();
    }

    private void initializeElements(){
//        button
        leaveLobby_Button = new JButton("Lobby verlassen");
        startGame_Button = new JButton("Spiel starten");
//        boolean
        opponentConfirmedStartOfGame = false;
    }

    private void configureElements(){
//        lobbySettings
        lobbySettings_Panel.disableVisibiltyButtonGroupSetting();

        StyleSheet.changeFontOfLobbyScreenElements(this);
    }

    private void addElementsToLayout(){
//        button
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, leaveLobby_Button, 2, 7, 1, 2, 0, new int[]{20, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, startGame_Button, 0, 7, 1, 2, 0, new int[]{20, 0, 0, 0});
    }

    public void setOpponentConfirmedStartOfGame(){
        opponentConfirmedStartOfGame = true;
        setStartConfirmedToPlayerTwo();
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
                Spielo.changeView("GameScreen");
            }
            else{
                JOptionPane.showMessageDialog(this, "Dein Gegner hat dem Spielstart noch nicht zugestimmt!");
            }
        }
    }

}
