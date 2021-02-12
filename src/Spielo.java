import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fourwins.*;

public class Spielo extends JFrame {
	
	private JPanel contentPane;

	public static void main(String[] args) {
		
		System.out.println("---Start---");
		Board board = new Board();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI gui = new GUI(board);
					gui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("---end---");
	}

}
