package fourwins;

public class Board {
//public:
	Board(){
		gameStatus = status.INITIALIZEING;
	}
	
	public void insertChip(int column) {
		
	}
	
	public player[][] getBoard() {
		return board;
	}

	
	public int getGameStatus() {
		return gameStatus.ordinal() ;
	}

//private:
	private status gameStatus;
	private player[][] board = new player[6][7];
	
	private int getWinner() {
		return player.NONE.ordinal();
	}
	
	private enum status {
		LOST, WON, YOURTURN, OPPONENTTURN, INITIALIZEING
	}
	
	private enum player {
		YOU, OPPONENT, NONE
	}
}
