import javax.swing.*;
import java.awt.*;

public class LobbySettings extends JPanel{
    private GridBagLayout gridBagLayout;
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
        configureElements();
        addElementsToLayout();
    }

    private void initializeElements(){
        gridBagLayout = new GridBagLayout();
//        gameSetting
        gameSetting_Label = new JLabel("Spiel:");
        gameSetting_ButtonGroup = new ButtonGroup();
        ticTacToe_RadioButton = new JRadioButton("TicTacToe");
        fourWinds_RadioButton = new JRadioButton("4 Gewinnt");
        checkers_RadioButton = new JRadioButton("Dame");
        mill_RadioButton = new JRadioButton("Mühle");
//        visibilitySetting
        visibilitySetting_Label = new JLabel("Sichtbarkeit:");
        visibilitySetting_ButtonGroup = new ButtonGroup();
        publicVisibility_RadioButton = new JRadioButton("Öffentlich");
        privateVisibility_RadioButton = new JRadioButton("Privat");
//        timerSetting
        timerSetting_Label = new JLabel("Timer");
        timerSetting_ButtonGroup = new ButtonGroup();
        offTimer_RadioButton = new JRadioButton("Aus");
        thirtySeconds_RadioButton = new JRadioButton("30 Sek.");
        oneMinute_RadioButton = new JRadioButton("1 Min.");
//        roundModeSetting
        roundModeSetting_Label = new JLabel("Rundenmodus:");
        roundModeSetting_ButtonGroup = new ButtonGroup();
        bestOfOne_RadioButton = new JRadioButton("Best of 1");
        bestOfThree_RadioButton = new JRadioButton("Best of 3");
        bestOfFive_RadioButton = new JRadioButton("Best of 5");
        bestOfSeven_RadioButton = new JRadioButton("Best of 7");

    }

    private void configureElements(){
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
    }

    private void addElementsToLayout(){
        this.setLayout(gridBagLayout);
//        gameSetting
        addElementToPanelUsingGridBagLayout(gameSetting_Label, 0, 0, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(ticTacToe_RadioButton, 0, 1, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout( fourWinds_RadioButton, 0, 2, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(checkers_RadioButton, 0, 3, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(mill_RadioButton, 0, 4, 1, 1, 0, new int[]{0, 0, 0, 0});
//        visibilitySetting
        addElementToPanelUsingGridBagLayout(visibilitySetting_Label, 1, 0, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(privateVisibility_RadioButton, 1, 1, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout( publicVisibility_RadioButton, 1, 2, 1, 1, 0, new int[]{0, 0, 0, 0});
//        timerSetting
        addElementToPanelUsingGridBagLayout(timerSetting_Label, 2, 0, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(offTimer_RadioButton, 2, 1, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(thirtySeconds_RadioButton, 2, 2, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(oneMinute_RadioButton, 2, 3, 1, 1, 0, new int[]{0, 0, 0, 0});
//        roundModeSetting
        addElementToPanelUsingGridBagLayout(roundModeSetting_Label, 3, 0, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(bestOfOne_RadioButton, 3, 1, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(bestOfThree_RadioButton, 3, 2, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(bestOfFive_RadioButton, 3, 3, 1, 1, 0, new int[]{0, 0, 0, 0});
        addElementToPanelUsingGridBagLayout(bestOfSeven_RadioButton, 3, 4, 1, 1, 0, new int[]{0, 0, 0, 0});

    }

    private void addRadioButtonsToButtonGroup(ButtonGroup buttonGroup, JRadioButton [] radioButtons){
        for (JRadioButton radioButton : radioButtons) buttonGroup.add(radioButton);
    }

    public String[] getLobbySettings(){
        String[] settings = new String[4];
        settings[0] = gameSetting_ButtonGroup.getSelection().getActionCommand();
        settings[1] = visibilitySetting_ButtonGroup.getSelection().getActionCommand();
        settings[2] = timerSetting_ButtonGroup.getSelection().getActionCommand();
        settings[3] = roundModeSetting_ButtonGroup.getSelection().getActionCommand();
        return settings;
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
