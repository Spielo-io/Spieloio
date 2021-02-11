import fourwins.*;

public class Spielo {

	public static void main(String[] args) {
		System.out.println("---Start---");
		Board board = new Board();
		board.insertChip(0);
		System.out.println(board.toString());
		System.out.println(board.getWinner());
	}

}
