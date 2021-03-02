package io.spielo.games.tictactoe;

import java.awt.EventQueue;

import io.spielo.games.tictactoe.*;

public class TicTacToe {
	
		public TicTacToe(boolean youAreInitializer) {
			
			if(youAreInitializer == true)
			{
				GUI.player = 1;
				GUI.opponent = 2;
			}
			else
			{
				GUI.player = 2;
				GUI.opponent = 1;
			}
			//-----------------GUi init
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						new GUI();
						new ImageLoader();
						new Draw();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			//---------------Gui init end
		}
}
