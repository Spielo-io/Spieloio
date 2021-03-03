package io.spielo.games.fourwins;

import java.awt.EventQueue;

public class fourWins {
	public fourWins(boolean youAreInitializer) {
		board = new Board(youAreInitializer);
		network = new Network(board);
		
		//-----------------GUi init
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI gui = new GUI(board, network);
					gui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//---------------Gui init end
	}
	
	public boolean closeGame = false;

	private Board board;
	public Network network;
}
