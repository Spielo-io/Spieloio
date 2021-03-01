package io.spielo.games.fourwins;

import io.spielo.games.tictactoe.Game;
import io.spielo.games.tictactoe.Game.player;

public class Board extends Game{
//public:
	public Board(boolean youStart){
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				board[i][j] = player.NONE;
			}
		}
		
		if(youStart) 
			setPlayer(player.YOU);
		else
			setPlayer(player.OPPONENT);
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
			break;
		case OPPONENT:
			board[column][height] = player.OPPONENT;
			setPlayer(player.YOU);
			break;
		default:
			System.out.println("ERROR: unable to insert coin -> false game status\n");
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

//private:
	private int width = 7, height = 6;
	private player[][] board = new player[width][height];
	
	public player getWinner() {
		player winner = player.NONE;
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height && winner == player.NONE; j++) {
				if(board[i][j] != player.NONE) {
					switch(checkHorizontal(i, j)) {
					case YOU:
						addWin();
						return player.YOU;
					case OPPONENT:
						addLoss();
						return player.OPPONENT;
					}
					
					switch(checkVertical(i, j)) {
					case YOU:
						addWin();
						return player.YOU;
					case OPPONENT:
						addLoss();
						return player.OPPONENT;
					}
					
					switch(checkDiagonal(i, j)) {
					case YOU:
						addWin();
						return player.YOU;
					case OPPONENT:
						addLoss();
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
}
