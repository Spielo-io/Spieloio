package io.spielo.gui;

import io.spielo.Spielo;
import io.spielo.client.events.ClientEventSubscriber;
import io.spielo.games.fourwins.FourWins;
import io.spielo.games.fourwins.GUI;
import io.spielo.messages.Message;
import io.spielo.messages.games.Win4Message;
import io.spielo.messages.lobbysettings.LobbyBestOf;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameScreen extends JPanel implements ActionListener, ClientEventSubscriber {
    private GridBagLayout gridBagLayout;
//    labels
    private JLabel timer_Label;
    private JLabel bestOf_Label;
    private JLabel playerOneWins_Label;
    private JLabel playerTwoWins_Label;
//    borders
    private EtchedBorder borderForTimerLabel_Border;

//    buttons
    private JButton exitGame_Button;
//      gamePlay
    private GUI playedGame_Panel;

    private int widthOfPlayedGame_Panel;
    private int heightOfPlayedGame_Panel;

    public FourWins vierGewinnt;

    public GameScreen(){
        initializeElements();
        addElementsToLayout();
        configureElements();
        addActionListeners();
    }
    private void initializeElements(){
        gridBagLayout = new GridBagLayout();
//        label
        timer_Label = new JLabel("0:30");
        bestOf_Label = new JLabel("Best of 3");
        playerOneWins_Label = new JLabel("Username1: 2 Wins");
        playerTwoWins_Label = new JLabel("Username2: 1 Win");
//        border
        borderForTimerLabel_Border = new EtchedBorder(EtchedBorder.LOWERED);
//          gameplay
//        playedGame_Panel = new JPanel();

//        buttons
        exitGame_Button = new JButton("Spiel verlassen");

        widthOfPlayedGame_Panel = 5;
        heightOfPlayedGame_Panel = 5;
    }

    private void configureElements(){
        timer_Label.setBorder(borderForTimerLabel_Border);
//        playedGame_Panel.setPreferredSize(new Dimension(450, 450));
//        playedGame_Panel.setBackground(new Color(100, 100, 100));
        timer_Label.setHorizontalAlignment(SwingConstants.CENTER);
        bestOf_Label.setHorizontalAlignment(SwingConstants.CENTER);
        playerOneWins_Label.setHorizontalAlignment(SwingConstants.CENTER);
        playerTwoWins_Label.setHorizontalAlignment(SwingConstants.CENTER);
        StyleSheet.changeFontOfGameScreenElements(this);
    }



    private void addElementsToLayout(){
        this.setLayout(gridBagLayout);
//        label
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, timer_Label, widthOfPlayedGame_Panel, 0, 1, 1, 0, new int[]{0, 155, 20, 10});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, bestOf_Label, widthOfPlayedGame_Panel, 1, 1, 1, 0, new int[]{0, 0, 20, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, playerOneWins_Label, widthOfPlayedGame_Panel, 2, 1, 1, 0, new int[]{0, 0, 20, 0});
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, playerTwoWins_Label, widthOfPlayedGame_Panel, 3, 1, 1, 0, new int[]{0, 0, 20, 0});
//        gamePlay
//        addElementToPanelUsingGridBagLayout(this, gridBagLayout, playedGame_Panel, 0, 0, heightOfPlayedGame_Panel, widthOfPlayedGame_Panel, 0, new int[]{0, 10, 0, 0});
//        buttons
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, exitGame_Button, widthOfPlayedGame_Panel, heightOfPlayedGame_Panel -1, 1, 1, 0, new int[]{230, 20, 10, 20});
    }

//    public void setPlayedGame_Panel(JPanel gamePanel){
//        playedGame_Panel = gamePanel;
//    }

    public void setBestOf_Label(LobbyBestOf bestOf){
        switch (bestOf){
            case BestOf_1 -> bestOf_Label.setText("Best of 1");
            case BestOf_3 -> bestOf_Label.setText("Best of 3");
            case BestOf_5 -> bestOf_Label.setText("Best of 5");
            case BestOf_7 -> bestOf_Label.setText("Best of 7");
            case BestOf_9 -> bestOf_Label.setText("Best of 9");
        }
    }

    public void setPlayerOneWins_Label(int numberOfWins){
        String winText = "";
        if(numberOfWins > 1){
            winText = " Wins";
        }
        else{
            winText = " Win";
        }
        playerOneWins_Label.setText(Spielo.getUsername() + ": " + String.valueOf(numberOfWins) + winText);
    }

    public void setPlayerTwoWins_Label(int numberOfWins){
        String winText = "";
        if(numberOfWins > 1){
            winText = " Wins";
        }
        else{
            winText = " Win";
        }
        playerTwoWins_Label.setText(Spielo.getUsernameOfPlayerTwo() + ": " + String.valueOf(numberOfWins) + winText);
    }

    public void setTimer_Label(String timerText){
        timer_Label.setText(timerText);
    }

    public void addElementToPanelUsingGridBagLayout(JPanel panel, GridBagLayout layout, Component element, int xDimension, int yDimension, int height, int width, int ipady, int [] insets){
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridx = xDimension;
        gridBagConstraints.gridy = yDimension;
        gridBagConstraints.gridwidth = width;
        gridBagConstraints.gridheight = height;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.ipady = ipady;
        gridBagConstraints.insets = new Insets(insets[0], insets[1], insets[2], insets[3]);

        layout.setConstraints(element, gridBagConstraints);
        panel.add(element);
    }

    public void startGame(){
        System.out.println("Start Game");
        vierGewinnt = new FourWins(Spielo.userIsHost());
        playedGame_Panel = vierGewinnt.getGui();
        addElementToPanelUsingGridBagLayout(this, gridBagLayout, playedGame_Panel, 0, 0, heightOfPlayedGame_Panel, widthOfPlayedGame_Panel, 0, new int[]{0, 10, 0, 0});
        playedGame_Panel.setPreferredSize(new Dimension(450, 450));
        setPlayerOneWins_Label(0);
        setPlayerTwoWins_Label(0);
    }

    private void addActionListeners(){
        exitGame_Button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exitGame_Button){
            int answer = JOptionPane.showConfirmDialog(this, "Willst du das Spiel wirklich verlassen?", "Wähle eine Option!", JOptionPane.YES_NO_OPTION);
            if(answer == JOptionPane.YES_OPTION) {
                Spielo.changeView("StartScreen");
            }
        }
    }

    @Override
    public void onMessageReceived(Message message) {
        if(message instanceof Win4Message){
            System.out.println("4 gewinnt nachicht empfangen");
            vierGewinnt.receiveMessage(((Win4Message) message).getValue());
        }
    }

    @Override
    public void onDisconnect() {

    }
}
