package fourwins;

public class Board {
	//public

	Board(){
		setGameStatus(status.IDLE);
	}
	
	public status getGameStatus() {
		return gameStatus;
	}
	
	public void setGameStatus(status status) {
		this.gameStatus = status;
	}
	
	//private
	private status gameStatus;
	private enum status  {
		IDLE, YOURTURN, OPPONENTTURN
	}
}
