package io.spielo.games.fourwins;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import io.spielo.games.Game;

public class FourWinsTestMain extends JFrame {
	
	private JPanel contentPane;

	public static void main(String[] args) {
		System.out.println("---start---");
		Game game = new Game();
		game.setTimer(5000);
		game.startTimer();
		//while(game.getTimer() > 0) {
			//System.out.println(game.getTimer());			
		//}
		FourWins fourwins = new FourWins(true);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI gui = fourwins.gui;
					gui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("---end---");
	}

}
