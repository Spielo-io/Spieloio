package io.spielo.games;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import io.spielo.Game;
import io.spielo.Game.player;

import java.awt.event.ActionEvent;

public class ActionHandler implements ActionListener 
{
	int countButtonspressed = 0;
	
	public void actionPerformed(ActionEvent e) 
	{
		if(GUI.player == 1) // 2 -> Player O  // 1 -> Player X 
		{
			Game.message.setPlayer(player.YOU);
			
			
		}
		if(GUI.player == 2)
		{
			Game.message.setPlayer(player.OPPONENT);
		}
		if(GUI.player == 0)
		{
			Game.message.setPlayer(player.NONE);
		}
		
		while(GUI.winner == false)
		{
			while(Game.message.getTimer() > 0)
			{
				for(int i = 0; i <= 9; i++)
				{
					if(e.getSource() == GUI.btn[i])
					{
						if(GUI.pressed[i] == 0)
						{
							GUI.pressed[i] = GUI.player;
							countButtonspressed++;
						}
						
					}
				}
			}	
		}		
	}
	//Gewinner prüfen
		public void winningGame()
		{
			//Vertikal
			for(int button = 0; button < 3; button++)
			{
				if(GUI.pressed[button] == GUI.player && GUI.pressed[button+3] == GUI.player && GUI.pressed[button+6] == GUI.player)
				{
					Game.message.addWin();
				}
			}
			//Horizontal
			for(int button = 0; button < 7; button+=3)
			{
				if(GUI.pressed[button] == GUI.player && GUI.pressed[button+1] == GUI.player && GUI.pressed[button+2] == GUI.player)
				{
					Game.message.addWin();
				}
			}
			//Diagonal
			if(GUI.pressed[1] == GUI.player && GUI.pressed[5] == GUI.player && GUI.pressed[9] == GUI.player)
			{
				Game.message.addWin();
			}
			if(GUI.pressed[3] == GUI.player && GUI.pressed[5] == GUI.player && GUI.pressed[7] == GUI.player)
			{
				Game.message.addWin();
			}
			//Unentschieden
			if(countButtonspressed == 9)
			{
				Game.message.addDraw();
			}
			
		}

}
