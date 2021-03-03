package io.spielo.games.tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import io.spielo.Spielo;
import io.spielo.client.events.ClientEventSubscriber;
import io.spielo.messages.Message;
import io.spielo.messages.games.TicTacToeMessage;

public class ActionHandler implements ActionListener, ClientEventSubscriber
{
	
	private JFrame frame;
	
	public void actionPerformed(ActionEvent e) 
	{
		/*if(GUI.player == 1) // 2 -> Player O  // 1 -> Player X 
		{
			Game.message.setPlayer(Game.player.YOU);
		}
		if(GUI.player == 2)
		{
			Game.message.setPlayer(Game.player.OPPONENT);
		}
		if(GUI.player == 0)
		{
			Game.message.setPlayer(Game.player.NONE);
		}*/
		
		if(GUI.player == 1) 
		{
			GUI.player = 2;
		}
		else
		{
			GUI.player = 1;
		}
		
		Game.message.setTimer(10000);
		
			if(Game.message.getTimer() > 0)
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
				Game.message.addLoss();
				Spielo.client.gameTicTacToe(9);
				
			}
		}		
	
	
	//Gewinner pruefen
	public void winningGame()
	{
		//Vertikal
		for(int button = 0; button < 3; button++)
		{
			if(GUI.pressed[button] == GUI.player && GUI.pressed[button+3] == GUI.player && GUI.pressed[button+6] == GUI.player)
			{
				Game.message.addWin();
				reset();
			}
		}
		//Horizontal
		for(int button = 0; button < 7; button+=3)
		{
			if(GUI.pressed[button] == GUI.player && GUI.pressed[button+1] == GUI.player && GUI.pressed[button+2] == GUI.player)
			{
				Game.message.addWin();
				reset();
			}
		}
		//Diagonal
		if(GUI.pressed[0] == GUI.player && GUI.pressed[4] == GUI.player && GUI.pressed[8] == GUI.player)
		{
			Game.message.addWin();
			reset();
		}
		if(GUI.pressed[2] == GUI.player && GUI.pressed[4] == GUI.player && GUI.pressed[6] == GUI.player)
		{
			Game.message.addWin();
			reset();
		}
		//Unentschieden
		if(GUI.countButtonspressed == 9)
		{
			Game.message.addDraw();
			reset();
		}
	}
	
	public void opponentWinningGame()
	{
		//Vertikal
		for(int button = 0; button < 3; button++)
		{
			if(GUI.pressed[button] == GUI.player && GUI.pressed[button+3] == GUI.player && GUI.pressed[button+6] == GUI.player)
			{
				Game.message.addLoss();
				reset();
			}
		}
		//Horizontal
		for(int button = 0; button < 7; button+=3)
		{
			if(GUI.pressed[button] == GUI.player && GUI.pressed[button+1] == GUI.player && GUI.pressed[button+2] == GUI.player)
			{
				Game.message.addLoss();
				reset();
			}
		}
		//Diagonal
		if(GUI.pressed[0] == GUI.player && GUI.pressed[4] == GUI.player && GUI.pressed[8] == GUI.player)
		{
			Game.message.addLoss();
			reset();
		}
		if(GUI.pressed[2] == GUI.player && GUI.pressed[4] == GUI.player && GUI.pressed[6] == GUI.player)
		{
			Game.message.addLoss();
			reset();
		}
		//Unentschieden
		if(GUI.countButtonspressed == 9)
		{
			Game.message.addDraw();
			reset();
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
	
	public void reset()
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
	
	@Override
	public void onMessageReceived(Message message) {
		if (message instanceof TicTacToeMessage) {
			TicTacToeMessage ticTacToeMessage = (TicTacToeMessage) message;
			
			int i = ticTacToeMessage.getValue();
			if(i == 9)
			{
				Game.message.addWin();
				reset();
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
}
