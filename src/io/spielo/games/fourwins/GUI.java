package io.spielo.games.fourwins;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import io.spielo.games.tictactoe.Game.player;


public class GUI extends JFrame {
	private JTextField txtPressTheButton;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public GUI(Board board, Network network) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 445);
		getContentPane().setLayout(null);
		
		Button button = new Button("print board to console");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(board.toString());
			}
		});
		button.setBounds(415, 10, 137, 43);
		getContentPane().add(button);
		
		Button button_70 = new Button("print  winner to console");
		button_70.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(board.getWinner());
			}
		});
		button_70.setBounds(415, 59, 137, 43);
		getContentPane().add(button_70);
		
		drawBoard(board);
		this.network = network;
	}
	
	private Network network;
	
	public void drawBoard(Board board) {
		player [][] board_status = board.getBoard();

		int x_coordinate = 10;
		int y_coordinate = 10;
		
		JButton[] buttons = new JButton[7];
		JPanel[][] panels = new JPanel[7][6];
		
		int counter = 0;
		//initialize buttons
		for(int i = 0; i < 7; i++) {
			if (counter != 0) {
				x_coordinate += 55;
			}
			buttons[i] = new JButton("insert");
			buttons[i].setBounds(x_coordinate, 10, 48, 22);
			getContentPane().add(buttons[i]);
			counter++;
		}
		counter = 0;
		
		//Action Listeners for Buttons
		buttons[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board.getPlayer() == player.YOU) {
					board.insertChip(0);
					network.sendMessage(0);
				}
			}
		});
		buttons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board.getPlayer() == player.YOU) {
					board.insertChip(1);
					network.sendMessage(1);
				}
			}
		});
		buttons[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board.getPlayer() == player.YOU) {
					board.insertChip(2);
					network.sendMessage(2);
				}
			}
		});
		buttons[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board.getPlayer() == player.YOU) {
					board.insertChip(3);
					network.sendMessage(3);
				}
			}
		});
		buttons[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board.getPlayer() == player.YOU) {
					board.insertChip(4);
					network.sendMessage(4);
				}
			}
		});
		buttons[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board.getPlayer() == player.YOU) {
					board.insertChip(5);
					network.sendMessage(5);
				}
			}
		});
		buttons[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(board.getPlayer() == player.YOU) {
					board.insertChip(6);
					network.sendMessage(6);
				}
			}
		});
		
		x_coordinate = 10;
		y_coordinate = 40;
		//draw panels and coins
		for(int k = 0; k < 7; k++) {
			if (k != 0) {
				x_coordinate += 55;
			}
			for (int l = 0; l < 6; l++) {
				if (l != 0) {
					y_coordinate += 55;
				}
				panels[k][l] = new JPanel();
				panels[k][l].setBounds(x_coordinate, y_coordinate, 48, 48);
				panels[k][l].setBackground(Color.WHITE);
				switch(board_status[k][l]) {
				case YOU:
					JLabel youCoin = new JLabel();
					youCoin.setIcon(new ImageIcon(getClass().getResource("blue.png")));
					panels[k][l].add(youCoin);
				case OPPONENT:
					JLabel opponentCoin = new JLabel();
					opponentCoin.setIcon(new ImageIcon(getClass().getResource("red.png")));
					panels[k][l].add(opponentCoin);
				case NONE:
				}
				
				getContentPane().add(panels[k][l]);
			}
			y_coordinate = 40;
		
		}
	}
}

