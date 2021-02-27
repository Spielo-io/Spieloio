import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import java.util.Enumeration;

public class LobbySettings extends JPanel{
//    layout
    private GridBagLayout gridBagLayout;
//    border
    private EtchedBorder borderForPanel_Border;
//    gameSetting
    private JLabel gameSetting_Label;
    private ButtonGroup gameSetting_ButtonGroup;
    private JRadioButton ticTacToe_RadioButton;
    private JRadioButton fourWinds_RadioButton;
    private JRadioButton checkers_RadioButton;
    private JRadioButton mill_RadioButton;
//    visibilitySetting
    private JLabel visibilitySetting_Label;
    private ButtonGroup visibilitySetting_ButtonGroup;
    private JRadioButton publicVisibility_RadioButton;
    private JRadioButton privateVisibility_RadioButton;
//    timerSetting
    private JLabel timerSetting_Label;
    private ButtonGroup timerSetting_ButtonGroup;
    private JRadioButton offTimer_RadioButton;
    private JRadioButton thirtySeconds_RadioButton;
    private JRadioButton oneMinute_RadioButton;
//    roundModeSetting
    private JLabel roundModeSetting_Label;
    private ButtonGroup roundModeSetting_ButtonGroup;
    private JRadioButton bestOfOne_RadioButton;
    private JRadioButton bestOfThree_RadioButton;
    private JRadioButton bestOfFive_RadioButton;
    private JRadioButton bestOfSeven_RadioButton;

    public LobbySettings(){
        initializeElements();
        addElementsToLayout();
        configureElements();
//        hello();
    }

    private void initializeElements(){
//        layout
        gridBagLayout = new GridBagLayout();
//        border
        borderForPanel_Border = new EtchedBorder(EtchedBorder.LOWERED);
//        gameSetting
        gameSetting_Label = new JLabel(StyleSheet.underlineHeading("Spiel:"));
        gameSetting_ButtonGroup = new ButtonGroup();
        ticTacToe_RadioButton = new JRadioButton("TicTacToe");
        fourWinds_RadioButton = new JRadioButton("4 Gewinnt");
        checkers_RadioButton = new JRadioButton("Dame");
        mill_RadioButton = new JRadioButton("Mühle");
//        visibilitySetting
        visibilitySetting_Label = new JLabel(StyleSheet.underlineHeading("Sichtbarkeit:"));
        visibilitySetting_ButtonGroup = new ButtonGroup();
        publicVisibility_RadioButton = new JRadioButton("Öffentlich");
        privateVisibility_RadioButton = new JRadioButton("Privat");
//        timerSetting
        timerSetting_Label = new JLabel(StyleSheet.underlineHeading("Timer"));
        timerSetting_ButtonGroup = new ButtonGroup();
        offTimer_RadioButton = new JRadioButton("Aus");
        thirtySeconds_RadioButton = new JRadioButton("30 Sek.");
        oneMinute_RadioButton = new JRadioButton("1 Min.");
//        roundModeSetting
        roundModeSetting_Label = new JLabel(StyleSheet.underlineHeading("Rundenmodus:"));
        roundModeSetting_ButtonGroup = new ButtonGroup();
        bestOfOne_RadioButton = new JRadioButton("Best of 1");
        bestOfThree_RadioButton = new JRadioButton("Best of 3");
        bestOfFive_RadioButton = new JRadioButton("Best of 5");
        bestOfSeven_RadioButton = new JRadioButton("Best of 7");

    }

    private void configureElements(){
//        border
        this.setBorder(borderForPanel_Border);
//        add RadioButtons to ButtonGroup
        addRadioButtonsToButtonGroup(gameSetting_ButtonGroup, new JRadioButton[] {ticTacToe_RadioButton, fourWinds_RadioButton, checkers_RadioButton, mill_RadioButton});
        addRadioButtonsToButtonGroup(visibilitySetting_ButtonGroup, new JRadioButton[] {publicVisibility_RadioButton, privateVisibility_RadioButton});
        addRadioButtonsToButtonGroup(timerSetting_ButtonGroup, new JRadioButton[] {offTimer_RadioButton, thirtySeconds_RadioButton, oneMinute_RadioButton});
        addRadioButtonsToButtonGroup(roundModeSetting_ButtonGroup, new JRadioButton[] {bestOfOne_RadioButton, bestOfThree_RadioButton, bestOfFive_RadioButton, bestOfSeven_RadioButton});
//        check one of the RadioButtonsInButtonGroup
        ticTacToe_RadioButton.doClick();
        privateVisibility_RadioButton.doClick();
        bestOfOne_RadioButton.doClick();
        offTimer_RadioButton.doClick();
//        set Action Commands for RadioButtons
//              gameSetting
        ticTacToe_RadioButton.setActionCommand("TicTacToe");
        fourWinds_RadioButton.setActionCommand("4 Gewinnt");
        checkers_RadioButton.setActionCommand("Dame");
        mill_RadioButton.setActionCommand("Mühle");
//              visibilitySetting
        publicVisibility_RadioButton.setActionCommand("Öffentlich");
        privateVisibility_RadioButton.setActionCommand("Privat");
//              timerSetting
        offTimer_RadioButton.setActionCommand("Timer aus");
        thirtySeconds_RadioButton.setActionCommand("30 Sek");
        oneMinute_RadioButton.setActionCommand("1 Min");
//              roundModeSetting
        bestOfOne_RadioButton.setActionCommand("Best of 1");
        bestOfThree_RadioButton.setActionCommand("Best of 3");
        bestOfFive_RadioButton.setActionCommand("Best of 5");
        bestOfSeven_RadioButton.setActionCommand("Best of 7");
//        font
        StyleSheet.changeFontOfLobbySettingsElements(this);

    }

    private void addElementsToLayout(){
        this.setLayout(gridBagLayout);
//        visibilitySetting
        addElementToPanelUsingGridBagLayout(visibilitySetting_Label, 0, 0, 1, 1, 0, new int[]{5, 0, 5, 0});
        addElementToPanelUsingGridBagLayout(privateVisibility_RadioButton, 0, 1, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout( publicVisibility_RadioButton, 0, 2, 1, 1, 0, new int[]{0, 0, 0, 0});
//        gameSetting
        addElementToPanelUsingGridBagLayout(gameSetting_Label, 1, 0, 1, 1, 0, new int[]{5, 10, 5, 0});
        addElementToPanelUsingGridBagLayout(ticTacToe_RadioButton, 1, 1, 1, 1, 0, new int[]{0, 10, 0, 0});
        addElementToPanelUsingGridBagLayout( fourWinds_RadioButton, 1, 2, 1, 1, 0, new int[]{0, 10, 0, 0});
        addElementToPanelUsingGridBagLayout(checkers_RadioButton, 1, 3, 1, 1, 0, new int[]{0, 10, 0, 0});
        addElementToPanelUsingGridBagLayout(mill_RadioButton, 1, 4, 1, 1, 0, new int[]{0, 10, 0, 0});
//        roundModeSetting
        addElementToPanelUsingGridBagLayout(roundModeSetting_Label, 2, 0, 1, 1, 0, new int[]{5, 5, 0, 0});
        addElementToPanelUsingGridBagLayout(bestOfOne_RadioButton, 2, 1, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(bestOfThree_RadioButton, 2, 2, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(bestOfFive_RadioButton, 2, 3, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(bestOfSeven_RadioButton, 2, 4, 1, 1, 0, new int[]{0, 0, 0, 0});
//        timerSetting
        addElementToPanelUsingGridBagLayout(timerSetting_Label, 3, 0, 1, 1, 0, new int[]{5, 0, 5, 0});
        addElementToPanelUsingGridBagLayout(offTimer_RadioButton, 3, 1, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(thirtySeconds_RadioButton, 3, 2, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(oneMinute_RadioButton, 3, 3, 1, 1, 0, new int[]{0, 0, 0, 0});
    }

    private void addRadioButtonsToButtonGroup(ButtonGroup buttonGroup, JRadioButton [] radioButtons){
        for (JRadioButton radioButton : radioButtons) buttonGroup.add(radioButton);
    }

    public void setLobbySettings(boolean isPublic, String game, String bestOf, String lobbyTimer, boolean userIsHost){
        activateRadioButtons(true);
        setSettingOfButtonGroup(visibilitySetting_ButtonGroup, visibilitySettingToString(isPublic) );
        setSettingOfButtonGroup(gameSetting_ButtonGroup, game );
        setSettingOfButtonGroup(roundModeSetting_ButtonGroup, bestOf );
        setSettingOfButtonGroup(timerSetting_ButtonGroup, lobbyTimer );
        activateRadioButtons(userIsHost);
    }

    public void setVisibilitySetting(boolean setting){
        setSettingOfButtonGroup(visibilitySetting_ButtonGroup, visibilitySettingToString(setting));
    }

    public boolean getVisibilitySetting(){
        return visibilitySettingToBoolean(visibilitySetting_ButtonGroup.getSelection().getActionCommand());
    }

    public String getGameSetting(){
        return gameSetting_ButtonGroup.getSelection().getActionCommand();
    }

    public String getRoundModeSetting(){
        return roundModeSetting_ButtonGroup.getSelection().getActionCommand();
    }

    public String getTimerSetting(){
        return timerSetting_ButtonGroup.getSelection().getActionCommand();
    }

    private void setSettingOfButtonGroup(ButtonGroup buttonGroup, String singleSetting){
        for(Enumeration<AbstractButton> e = buttonGroup.getElements(); e.hasMoreElements();){
            AbstractButton button = e.nextElement();
            if(button.getActionCommand().equals(singleSetting)){
                button.doClick();
            }
        }
    }

    public void disableVisibiltyButtonGroupSetting(){
        for(Enumeration<AbstractButton> a = visibilitySetting_ButtonGroup.getElements(); a.hasMoreElements();) {
            a.nextElement().setEnabled(false);
        }
    }

    public void activateRadioButtons(boolean activated){
        for(Enumeration<AbstractButton> a = gameSetting_ButtonGroup.getElements(); a.hasMoreElements();) {
            a.nextElement().setEnabled(activated);
        }
        for(Enumeration<AbstractButton> b = visibilitySetting_ButtonGroup.getElements(); b.hasMoreElements();) {
            b.nextElement().setEnabled(activated);
        }
        for(Enumeration<AbstractButton> c = timerSetting_ButtonGroup.getElements(); c.hasMoreElements();) {
            c.nextElement().setEnabled(activated);
        }
        for(Enumeration<AbstractButton> d = roundModeSetting_ButtonGroup.getElements(); d.hasMoreElements();) {
            d.nextElement().setEnabled(activated);
        }
    }

    public String[] getLobbySettings(){
        String[] settings = new String[4];
        settings[0] = visibilitySetting_ButtonGroup.getSelection().getActionCommand();
        settings[1] = gameSetting_ButtonGroup.getSelection().getActionCommand();
        settings[2] = roundModeSetting_ButtonGroup.getSelection().getActionCommand();
        settings[3] = timerSetting_ButtonGroup.getSelection().getActionCommand();
        return settings;
    }

    public String getVisibilityLobbySetting(){
        return visibilitySetting_ButtonGroup.getSelection().getActionCommand();
    }

    public boolean visibilitySettingToBoolean(String visibilitySetting){
        return !visibilitySetting.equals("Privat");
    }

    public String visibilitySettingToString(boolean isPublic){
        if(isPublic){
            return "Öffentlich";
        }
        else{
            return "Privat";
        }
    }

    private void addElementToPanelUsingGridBagLayout(Component element, int xDimension, int yDimension, int height, int width, int ipady, int [] insets){
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = xDimension;
        gridBagConstraints.gridy = yDimension;
        gridBagConstraints.gridwidth = width;
        gridBagConstraints.gridheight = height;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.ipady = ipady;
        gridBagConstraints.insets = new Insets(insets[0], insets[1], insets[2], insets[3]);
        if(yDimension == 4)
            gridBagConstraints.anchor = GridBagConstraints.PAGE_END;

        gridBagLayout.setConstraints(element, gridBagConstraints);
        this.add(element);
    }
}
