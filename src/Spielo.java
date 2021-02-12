import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fourwins.*;

public class Spielo extends JFrame {
	
	private JPanel contentPane;

	public static void main(String[] args) {
		
		System.out.println("---Start---");
		Board board = new Board();
		board.insertChip(0);
		System.out.println(board.toString());
		System.out.println(board.getWinner());
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("---end---");
	}

}
