package io.spielo.games.fourwins;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import io.spielo.Spielo;
import io.spielo.games.Game;
import io.spielo.games.Game.player;

public class FourWins {
	public FourWins(boolean youAreInitializer, int maxTimer, int totalRounds) {
		board = new Board(this, maxTimer, totalRounds);
		gui = new GUI(this);
		
		//determine start player
		if(youAreInitializer) {
			board.setPlayer(player.YOU);
			Spielo.getGameScreen().setYourTurnLabel(true);
		}
		else {
			board.setPlayer(player.OPPONENT);
			Spielo.getGameScreen().setYourTurnLabel(false);
		}
	}
	
	public void receiveMessage(int value){
		if(value < 7) {
			board.insertChip(value);
			gui.update();
		}
		else {
			if(value == 7)
				board.setPlayer(player.OPPONENT);
			else if(value == 8)
				board.setPlayer(player.YOU);
			else if(value == 9) {
				JOptionPane.showMessageDialog(null, "Die Zeit des Gegners ist abgelaufen!", "Runde zu Ende", JOptionPane.PLAIN_MESSAGE);
				board.addWin();
			}
				
		}
	}

	public GUI getGui(){
		return gui;
	}
	
	public boolean closeGame = false;

	public Board board;
	public GUI gui;
}
