package fourwins;


public class fourWins extends Message{
	public fourWins(boolean youAreInitializer) {
		board = new Board(youAreInitializer);
		//TODO: initialize GUI with the board
		//TODO: initialize messageClaient thing
	}
	
	public void runGame() {
		while(!closeGame) {
			switch(board.getPlayer()) {
			case YOU:
				//inputEnabled = true;
				break;
			case OPPONENT:
				//inputEnabled = false;
				break;
			case NONE:
				//inputEnabled = false;
				break;
			}
		}
	}
	
	public boolean closeGame = false;

	private Board board;
}
