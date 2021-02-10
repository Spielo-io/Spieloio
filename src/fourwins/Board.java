package fourwins;

public class Board {
//public:
	public Board(){
		gameStatus = status.INITIALIZEING;
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				board[i][j] = player.NONE;
			}
		}
		gameStatus = status.YOURTURN;
	}
	
	public void insertChip(int column) {
		int height = 0;
		while(board[column][height] != player.NONE) {
			height++;
		}
		switch(gameStatus) {
		case YOURTURN:
			board[column][height] = player.YOU;
			break;
		case OPPONENTTURN:
			board[column][height] = player.OPPONENT;
			break;
		default:
			System.out.println("ERROR: unable to insert coin -> false game status");
		}
			
	}
	
	public player[][] getBoard() {
		return board;
	}

	
	public int getGameStatus() {
		return gameStatus.ordinal() ;
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
	private status gameStatus;
	private int width = 7, height = 6;
	private player[][] board = new player[width][height];
	
	public int getWinner() {
		player winner = player.NONE;
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height && winner == player.NONE; j++) {
				if(board[i][j] != player.NONE) {
					winner = checkVertical(i, j);
					if(winner != player.NONE)
						return winner.ordinal();
					
					winner = checkHorizontal(i, j);
					if(winner != player.NONE)
						return winner.ordinal();
					
					winner = checkDiagonal(i, j);
					if(winner != player.NONE)
						return winner.ordinal();
				}
			}
		}
		
		return winner.ordinal();
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
		return player.NONE;
	}
	
	private player checkDiagonal(int x, int y) {
		return player.NONE;
	}
	
	private enum status {
		LOST, WON, YOURTURN, OPPONENTTURN, INITIALIZEING
	}
	
	private enum player {
		NONE, YOU, OPPONENT
	}
}
