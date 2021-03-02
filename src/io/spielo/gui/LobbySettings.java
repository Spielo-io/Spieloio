package io.spielo.gui;

import io.spielo.messages.lobbysettings.LobbyBestOf;
import io.spielo.messages.lobbysettings.LobbyGame;
import io.spielo.messages.lobbysettings.LobbyTimer;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class LobbySettings extends JPanel{
//    layout
    private GridBagLayout gridBagLayout;
//    border
    private EtchedBorder borderForPanel_Border;
//    gameSetting
    private JLabel gameSetting_Label;
    public ButtonGroup gameSetting_ButtonGroup;
    private JRadioButton ticTacToe_RadioButton;
    private JRadioButton fourWins_RadioButton;
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
    private JRadioButton thirtySeconds_RadioButton;
    private JRadioButton oneMinute_RadioButton;
    private JRadioButton threeMinutes_RadioButton;
//    roundModeSetting
    private JLabel roundModeSetting_Label;
    private ButtonGroup roundModeSetting_ButtonGroup;
    private JRadioButton bestOfOne_RadioButton;
    private JRadioButton bestOfThree_RadioButton;
    private JRadioButton bestOfFive_RadioButton;
    private JRadioButton bestOfSeven_RadioButton;
    private JRadioButton bestOfNine_RadioButton;


    public LobbySettings(){
        initializeElements();
        addElementsToLayout();
        configureElements();
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
        fourWins_RadioButton = new JRadioButton("4 Gewinnt");
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
        thirtySeconds_RadioButton = new JRadioButton("30 Sek.");
        oneMinute_RadioButton = new JRadioButton("1 Min.");
        threeMinutes_RadioButton = new JRadioButton("3 Min.");
//        roundModeSetting
        roundModeSetting_Label = new JLabel(StyleSheet.underlineHeading("Rundenmodus:"));
        roundModeSetting_ButtonGroup = new ButtonGroup();
        bestOfOne_RadioButton = new JRadioButton("Best of 1");
        bestOfThree_RadioButton = new JRadioButton("Best of 3");
        bestOfFive_RadioButton = new JRadioButton("Best of 5");
        bestOfSeven_RadioButton = new JRadioButton("Best of 7");
        bestOfNine_RadioButton = new JRadioButton("Best of 9");

    }

    private void configureElements(){
//        border
        this.setBorder(borderForPanel_Border);
//        add RadioButtons to ButtonGroup
        addRadioButtonsToButtonGroup(gameSetting_ButtonGroup, new JRadioButton[] {ticTacToe_RadioButton, fourWins_RadioButton, checkers_RadioButton, mill_RadioButton});
        addRadioButtonsToButtonGroup(visibilitySetting_ButtonGroup, new JRadioButton[] {publicVisibility_RadioButton, privateVisibility_RadioButton});
        addRadioButtonsToButtonGroup(timerSetting_ButtonGroup, new JRadioButton[] {thirtySeconds_RadioButton, oneMinute_RadioButton, threeMinutes_RadioButton});
        addRadioButtonsToButtonGroup(roundModeSetting_ButtonGroup, new JRadioButton[] {bestOfOne_RadioButton, bestOfThree_RadioButton, bestOfFive_RadioButton, bestOfSeven_RadioButton, bestOfNine_RadioButton});
//        check one of the RadioButtonsInButtonGroup
        ticTacToe_RadioButton.doClick();
        privateVisibility_RadioButton.doClick();
        bestOfOne_RadioButton.doClick();
        thirtySeconds_RadioButton.doClick();
//        set Action Commands for RadioButtons
//              gameSetting
        ticTacToe_RadioButton.setActionCommand("TicTacToe");
        fourWins_RadioButton.setActionCommand("4 Gewinnt");
        checkers_RadioButton.setActionCommand("Dame");
        mill_RadioButton.setActionCommand("Mühle");
//              visibilitySetting
        publicVisibility_RadioButton.setActionCommand("Öffentlich");
        privateVisibility_RadioButton.setActionCommand("Privat");
//              timerSetting
        thirtySeconds_RadioButton.setActionCommand("30 Sek.");
        oneMinute_RadioButton.setActionCommand("1 Min.");
        threeMinutes_RadioButton.setActionCommand("3 Min.");
//              roundModeSetting
        bestOfOne_RadioButton.setActionCommand("Best of 1");
        bestOfThree_RadioButton.setActionCommand("Best of 3");
        bestOfFive_RadioButton.setActionCommand("Best of 5");
        bestOfSeven_RadioButton.setActionCommand("Best of 7");
        bestOfNine_RadioButton.setActionCommand("Best of 9");
//        font
        StyleSheet.changeFontOfLobbySettingsElements(this);

        checkers_RadioButton.setEnabled(false);
        mill_RadioButton.setEnabled(false);

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
        addElementToPanelUsingGridBagLayout(fourWins_RadioButton, 1, 2, 1, 1, 0, new int[]{0, 10, 0, 0});
        addElementToPanelUsingGridBagLayout(checkers_RadioButton, 1, 3, 1, 1, 0, new int[]{0, 10, 0, 0});
        addElementToPanelUsingGridBagLayout(mill_RadioButton, 1, 4, 1, 1, 0, new int[]{0, 10, 0, 0});
//        roundModeSetting
        addElementToPanelUsingGridBagLayout(roundModeSetting_Label, 2, 0, 1, 1, 0, new int[]{5, 5, 0, 0});
        addElementToPanelUsingGridBagLayout(bestOfOne_RadioButton, 2, 1, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(bestOfThree_RadioButton, 2, 2, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(bestOfFive_RadioButton, 2, 3, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(bestOfSeven_RadioButton, 2, 4, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(bestOfNine_RadioButton, 2, 5, 1, 1, 0, new int[]{0, 0, 0, 0});
//        timerSetting
        addElementToPanelUsingGridBagLayout(timerSetting_Label, 3, 0, 1, 1, 0, new int[]{5, 0, 5, 0});
        addElementToPanelUsingGridBagLayout(thirtySeconds_RadioButton, 3, 1, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(oneMinute_RadioButton, 3, 2, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(threeMinutes_RadioButton, 3, 3, 1, 1, 0, new int[]{0, 0, 0, 0});
    }

    private void addRadioButtonsToButtonGroup(ButtonGroup buttonGroup, JRadioButton [] radioButtons){
        for (JRadioButton radioButton : radioButtons) buttonGroup.add(radioButton);
    }

    public void setLobbySettingsEnum(boolean isPublic, LobbyGame game, LobbyBestOf bestOf, LobbyTimer timer, boolean userIsHost){
        activateRadioButtons(true);
        if(isPublic){
            publicVisibility_RadioButton.doClick();
        }
        else{
            privateVisibility_RadioButton.doClick();
        }

        switch(game){
            case TicTacToe -> ticTacToe_RadioButton.doClick();
            case Win4 -> fourWins_RadioButton.doClick();
//            case Checkers -> checkers_RadioButton.doClick();
//            case Mill -> mill_RadioButton.doClick();
        }

        switch (bestOf){
            case BestOf_1 -> bestOfOne_RadioButton.doClick();
            case BestOf_3 -> bestOfThree_RadioButton.doClick();
            case BestOf_5 -> bestOfFive_RadioButton.doClick();
            case BestOf_7 -> bestOfSeven_RadioButton.doClick();
            case BestOf_9 -> bestOfNine_RadioButton.doClick();
        }

        switch (timer){

            case Seconds_30 -> thirtySeconds_RadioButton.doClick();
            case Minute_1 -> oneMinute_RadioButton.doClick();
            case Minute_3 -> threeMinutes_RadioButton.doClick();
        }
        activateRadioButtons(userIsHost);


    }

    public boolean getVisibilitySetting(){
        return visibilitySettingToBoolean(visibilitySetting_ButtonGroup.getSelection().getActionCommand());
    }

    public LobbyGame getGameSettingEnum(){
        if(gameSetting_ButtonGroup.getSelection().getActionCommand().equals("TicTacToe")){
            return LobbyGame.TicTacToe;
        }
        else if(gameSetting_ButtonGroup.getSelection().getActionCommand().equals("4 Gewinnt")){
            return LobbyGame.Win4;
        }
        else{
            return null;
        }
    }

    public LobbyBestOf getRoundModeSettingEnum(){
        return switch (roundModeSetting_ButtonGroup.getSelection().getActionCommand()) {
            case "Best of 1" -> LobbyBestOf.BestOf_1;
            case "Best of 3" -> LobbyBestOf.BestOf_3;
            case "Best of 5" -> LobbyBestOf.BestOf_5;
            case "Best of 7" -> LobbyBestOf.BestOf_7;
            case "Best of 9" -> LobbyBestOf.BestOf_9;
            default -> null;
        };
    }

    public LobbyTimer getTimerSettingEnum(){
        return switch (timerSetting_ButtonGroup.getSelection().getActionCommand()) {
            case "30 Sek." -> LobbyTimer.Seconds_30;
            case "1 Min." -> LobbyTimer.Minute_1;
            case "3 Min." -> LobbyTimer.Minute_3;
            default -> null;
        };
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
        checkers_RadioButton.setEnabled(false);
        mill_RadioButton.setEnabled(false);
    }

    public boolean visibilitySettingToBoolean(String visibilitySetting){
        return !visibilitySetting.equals("Privat");
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

    public JRadioButton [] getChoosableButtons(){
        JRadioButton [] buttons = new JRadioButton[10];
        buttons[0] = ticTacToe_RadioButton;
        buttons[1] = fourWins_RadioButton;
        buttons[2] = bestOfOne_RadioButton;
        buttons[3] = bestOfThree_RadioButton;
        buttons[4] = bestOfFive_RadioButton;
        buttons[5] = bestOfSeven_RadioButton;
        buttons[6] = bestOfNine_RadioButton;
        buttons[7] = thirtySeconds_RadioButton;
        buttons[8] = oneMinute_RadioButton;
        buttons[9] = threeMinutes_RadioButton;

        return buttons;
    }
}
