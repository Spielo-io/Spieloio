import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LobbyCreateScreen extends SpieloView implements ActionListener {
    private GridBagLayout gridBagLayout;
    //    heading
    private JLabel heading_Label;
    //    lobbySettings
    public LobbySettings lobbySettings_Panel;
    //    buttons
    private JButton createLobby_Button;
    private JButton backToStartScreen_Button;

    public LobbyCreateScreen() {
        initializeElements();
        addElementsToLayout();
        configureElements();
        addActionListeners();
    }

    private void initializeElements() {
        gridBagLayout = new GridBagLayout();
//        heading
        heading_Label = new JLabel(StyleSheet.underlineHeading("Lobby-Einstellungen"));
//        lobbySettings
        lobbySettings_Panel = new LobbySettings();
//        Buttons
        createLobby_Button = new JButton("Lobby erstellen");
        backToStartScreen_Button = new JButton("Zum Startbildschirm");
    }

    private void configureElements() {
        heading_Label.setFont(StyleSheet.heading_Font);
        heading_Label.setHorizontalAlignment(JLabel.CENTER);
//        font
        StyleSheet.changeFontOfLobbyCreateScreenElements(this);
    }

    private void addElementsToLayout() {
        this.setLayout(gridBagLayout);
//        heading
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, heading_Label, 1, 0, 1, 2, 0, new int[]{0, 0, 20, 0});
//          lobbySettings
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, lobbySettings_Panel, 0, 1, 5, 4, 0, new int[]{0, 5, 0, 5});
//          Buttons
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, createLobby_Button, 0, 6, 1, 2, 0, new int[]{20, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, backToStartScreen_Button, 2, 6, 1, 2, 0, new int[]{20, 0, 0, 0});
    }

    public void setLobbySettings(String[] lobbySettings, boolean isHost) {
        lobbySettings_Panel.setLobbySettings(lobbySettings, true);
    }

    public String[] getLobbySettings() {
        return lobbySettings_Panel.getLobbySettings();
    }

    private void addActionListeners() {
        createLobby_Button.addActionListener(this);
        backToStartScreen_Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backToStartScreen_Button) {
            Spielo.changeView("StartScreen");
        } else if (e.getSource() == createLobby_Button) {
            if (lobbySettings_Panel.getVisibilityLobbySetting().equals("Öffentlich")) {
                Spielo.changeView("LobbyScreenHostPublic");
            } else if (lobbySettings_Panel.getVisibilityLobbySetting().equals("Privat")) {
                Spielo.changeView("LobbyScreenHostPrivat");
            }
        }
    }

}

