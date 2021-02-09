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
	}
	
	public void insertChip(int column) {
		
	}
	
	public player[][] getBoard() {
		return board;
	}

	
	public int getGameStatus() {
		return gameStatus.ordinal() ;
	}
	
	public String toString(){
		String string = "";
		for(int i = 0; i < width; i++) {
			string = string + "|";
			for(int j = 0; j < height; j++) {
				string = string + board[i][j].ordinal() + "|";
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
