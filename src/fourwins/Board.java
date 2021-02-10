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
	private int width = 6, height = 7;
	private player[][] board = new player[width][height];
	
	private int getWinner() {
		return player.NONE.ordinal();
	}
	
	private enum status {
		LOST, WON, YOURTURN, OPPONENTTURN, INITIALIZEING
	}
	
	private enum player {
		NONE, YOU, OPPONENT
	}
}
