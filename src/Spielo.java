import fourwins.*;

public class Spielo {

	public static void main(String[] args) {
		System.out.println("---Start---");
		Board board = new Board();
		board.insertChip(6);
		board.insertChip(3);
		board.insertChip(4);
		board.insertChip(5);
		System.out.println(board.toString());
		System.out.println(board.getWinner());
	}

}
