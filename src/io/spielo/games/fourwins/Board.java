package io.spielo.games.fourwins;

import javax.swing.JOptionPane;

import io.spielo.Spielo;
import io.spielo.games.Game;

public class Board extends Game{
	public Board(FourWins fourWins, int maxTimer, int totalRounds){
		super(maxTimer, totalRounds);
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				board[i][j] = player.NONE;
			}
		}
		this.fourWins = fourWins;
		if(getPlayer() == player.YOU)
			startTimer();
	}
	
	public void insertChip(int column) {
		int height = 0;
		while(board[column][height] != player.NONE) {
			if(height == this.height - 1) {
				System.out.println("ERROR: unable to insert coin -> column" + column + "already full\n");
				return;
			}
			height++;
		}
		switch(getPlayer()) {
		case YOU:
			board[column][height] = player.YOU;
			setPlayer(player.OPPONENT);
			pauseTimer();
			sendMessage(column);
			break;
		case OPPONENT:
			board[column][height] = player.OPPONENT;
			startTimer();
			setPlayer(player.YOU);
			break;
		default:
			System.out.println("ERROR: unable to insert coin -> false game status\n");
		}
		if(getWinner() != player.NONE) {
			setPlayer(player.NONE);
			if(getWinner() == player.YOU) {
				fourWins.gui.update();
				addWin();
			}
			else {
				fourWins.gui.update();
				addLoss();
			}
		}
	}
	
	public player[][] getBoard() {
		return board;
	}
	
	public String toString(){
		String string = "";
		for(int i = height - 1; i >= 0; i--) {
			for(int j = 0; j < width; j++) {
				string = string + board[j][i].ordinal() + "|";
			}
			string = string + "\n";
		}
		return string;
	}
	
	public void resetBoard() {
		System.out.println("reset Board");
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				board[i][j] = player.NONE;
			}
		}
		System.out.println(toString());
		fourWins.gui.update();
	}
	
//private:
	private FourWins fourWins;
	private int width = 7, height = 6;
	private player[][] board = new player[width][height];
	
	public player getWinner() {
		player winner = player.NONE;
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height && winner == player.NONE; j++) {
				if(board[i][j] != player.NONE) {
					switch(checkHorizontal(i, j)) {
					case YOU:
						return player.YOU;
					case OPPONENT:
						return player.OPPONENT;
					}
					
					switch(checkVertical(i, j)) {
					case YOU:
						return player.YOU;
					case OPPONENT:
						return player.OPPONENT;
					}
					
					switch(checkDiagonal(i, j)) {
					case YOU:
						return player.YOU;
					case OPPONENT:
						return player.OPPONENT;
					}
				}
			}
		}
		
		return winner;
	}
	
	private player checkHorizontal(int x, int y) {
		if(x >= 0 && x < width - 3 && 
		   y >= 0 && y < height) 
		{
			player currentChip = board[x][y];
			int counter = 1;
			for(int i = 1; i < 4; i++) {
				if(board[x + i][y] == currentChip) {
					counter++;
				}
			}
			if(counter == 4)
				return currentChip;
		}
		return player.NONE;
	}
	
	private player checkVertical(int x, int y) {
		if(x >= 0 && x < width &&
		   y >= 0 && y < height - 3) {
			player currentChip = board[x][y];
			int counter = 1;
			for(int i = 1; i < 4; i++) {
				if(board[x][y + i] == currentChip) {
					counter++;
				}
			}
			if(counter == 4)
				return currentChip;
			
		}
		return player.NONE;
	}
	
	private player checkDiagonal(int x, int y) {
		if(x >= 0 && x < width &&
		   y >= 0 && y < height - 3) {
			player currentChip = board[x][y];
			int counter = 1;
			if(x < width - 3) {
				//diagonal right
				for(int i = 1; i < 4; i++) {
					if(board[x + i][y + i] == currentChip) {
						counter++;
					}
				}					
				if(counter == 4)
					return currentChip;
			}
			counter = 1;
			if(x > 3) {
				//diagonal left
				for(int i = 1; i < 4; i++) {
					if(board[x - i][y + i] == currentChip) {
						counter++;
					}
				}
				if(counter == 4)
					return currentChip;						
			}
			
		}
		return player.NONE;
	}	
	
	public void sendTimeOut() {
		sendMessage(9);
	}
	
	private void sendMessage(int message) {
		Spielo.client.game4Win(message);
	}
}
