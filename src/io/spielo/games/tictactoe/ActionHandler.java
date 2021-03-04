package io.spielo.games.tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import io.spielo.games.Game;
import io.spielo.Spielo;
import io.spielo.client.events.ClientEventSubscriber;
import io.spielo.messages.Message;
import io.spielo.messages.games.TicTacToeMessage;
import io.spielo.messages.lobbysettings.LobbyBestOf;

public class ActionHandler extends Game implements ActionListener, ClientEventSubscriber
{
	private final GameSettings settings;
	private JFrame frame;
	private int localPlayerWins;
	private int remotePlayerWins;
	
	public ActionHandler(final GameSettings settings, int maxTimer, int totalRounds) {
		super(maxTimer, totalRounds);
		this.settings = settings;

		localPlayerWins = 0;
		remotePlayerWins = 0;
	}
	public void actionPerformed(ActionEvent e) 
	{ 
		if(GUI.player == 1) 
		{
			GUI.player = 2;
		}
		else
		{
			GUI.player = 1;
		}
		
			if(getTimer() > 0)
			{
				for(int i = 0; i < 9; i++)
				{
					if(e.getSource() == GUI.btn[i])
					{
						if(GUI.pressed[i] == 0)
						{
							GUI.pressed[i] = GUI.player;
							GUI.countButtonspressed++;
							Spielo.client.gameTicTacToe(i);
							winningGame();
							disableButtons();
						}
					}
				}
			}
			else
			{
				addLoss();
				Spielo.client.gameTicTacToe(9);
				
			}
		}	
	
	public void winningGame()
	{
		//Vertikal
		for(int button = 0; button < 3; button++)
		{
			if(GUI.pressed[button] == GUI.player && GUI.pressed[button+3] == GUI.player && GUI.pressed[button+6] == GUI.player)
			{
				addWin();
				localPlayerWins++;
				
			}
		}
		//Horizontal
		for(int button = 0; button < 7; button+=3)
		{
			if(GUI.pressed[button] == GUI.player && GUI.pressed[button+1] == GUI.player && GUI.pressed[button+2] == GUI.player)
			{
				addWin();
				localPlayerWins++;
				
			}
		}
		//Diagonal
		if(GUI.pressed[0] == GUI.player && GUI.pressed[4] == GUI.player && GUI.pressed[8] == GUI.player)
		{
			addWin();
			localPlayerWins++;
			
		}
		if(GUI.pressed[2] == GUI.player && GUI.pressed[4] == GUI.player && GUI.pressed[6] == GUI.player)
		{
			addWin();
			localPlayerWins++;
			
		}
		//Draw
		if(GUI.countButtonspressed == 9)
		{
			addDraw();
			
		}
	}
	
	public void opponentWinningGame()
	{
		//Vertikal
		for(int button = 0; button < 3; button++)
		{
			if(GUI.pressed[button] == GUI.player && GUI.pressed[button+3] == GUI.player && GUI.pressed[button+6] == GUI.player)
			{
				addLoss();
				remotePlayerWins++;
				
			}
		}
		//Horizontal
		for(int button = 0; button < 7; button+=3)
		{
			if(GUI.pressed[button] == GUI.player && GUI.pressed[button+1] == GUI.player && GUI.pressed[button+2] == GUI.player)
			{
				addLoss();
				remotePlayerWins++;
				
			}
		}
		//Diagonal
		if(GUI.pressed[0] == GUI.player && GUI.pressed[4] == GUI.player && GUI.pressed[8] == GUI.player)
		{
			addLoss();
			remotePlayerWins++;
			
		}
		if(GUI.pressed[2] == GUI.player && GUI.pressed[4] == GUI.player && GUI.pressed[6] == GUI.player)
		{
			addLoss();
			remotePlayerWins++;
			
		}
		//Unentschieden
		if(GUI.countButtonspressed == 9)
		{
			addDraw();
			
		}
	}
	
	public void disableButtons()
	{
		for (int i = 0; i < 9; i++) {
			GUI.btn[i].setEnabled(false);
		}
	}
	
	public void enableButtons()
	{
		for (int i = 0; i < 9; i++) {
			GUI.btn[i].setEnabled(true);
		}
	}
	
	public void resetBoard()
	{
		for (int i = 0; i < GUI.pressed.length; i++) {
			GUI.pressed[i] = 0;
		}
	
		if(GUI.player == 1) 
		{
			GUI.player = 2;
			disableButtons();
		}
		else
		{
			GUI.player = 1;
			enableButtons();
		}
	}
	
	public void rounds()
	{
		if(localPlayerWins == settings.getRoundsToWin())
		{
			JOptionPane.showMessageDialog(frame, "You win!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
			disableButtons();
		}
		else if(remotePlayerWins == settings.getRoundsToWin())
		{
			JOptionPane.showMessageDialog(frame, "You lose!", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
			disableButtons();
		}
	}
	
	@Override
	public void onMessageReceived(Message message) {
		if (message instanceof TicTacToeMessage) {
			TicTacToeMessage ticTacToeMessage = (TicTacToeMessage) message;
			
			int i = ticTacToeMessage.getValue();
			if(i == 9)
			{
				addWin();
			}
			else
			{
				GUI.pressed[i] = GUI.opponent;
				opponentWinningGame();
				enableButtons();
			}
		}
	}

	@Override
	public void onDisconnect() {		
	}
	
	@Override
	public void sendTimeOut() {
		// TODO Auto-generated method stub
		
	}
}
