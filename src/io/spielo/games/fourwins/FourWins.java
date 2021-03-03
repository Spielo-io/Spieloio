package io.spielo.games.fourwins;

import java.awt.EventQueue;

import io.spielo.Spielo;
import io.spielo.games.tictactoe.Game.player;

public class FourWins {
	public FourWins(boolean youAreInitializer) {
		board = new Board();
		gui = new GUI(this);
		
		//determine start player
		if(youAreInitializer) 
			board.setPlayer(player.YOU);
		else
			board.setPlayer(player.OPPONENT);
		
		//-----------------GUi init
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//---------------Gui init end
	}
	
	public void receiveMessage(int value){
		System.out.println("message empfangen: " + value);

		if(value < 7) {
			board.insertChip(value);
			gui.update();
		}
		else {
			if(value == 7)
				board.setPlayer(player.OPPONENT);
			else if(value == 8)
				board.setPlayer(player.YOU);
				
		}
	}
	
	public boolean closeGame = false;

	public Board board;
	public GUI gui;
}
