package io.spielo.games.fourwins;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import io.spielo.games.Game.player;


public class GUI extends JPanel {
	private JTextField txtPressTheButton;
	private ImageIcon blueCoin;
	private ImageIcon redCoin;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public GUI(FourWins game) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 445);
		this.setLayout(null);
		createCoinImgaes();
		
		this.board = game.board;
		//init butons
		int x_coordinate = 10;
		int y_coordinate = 10;
		int counter = 0;
		//initialize buttons
		for(int i = 0; i < 7; i++) {
			if (counter != 0) {
				x_coordinate += 55;
			}
			buttons[i] = new JButton("insert");
			buttons[i].setBounds(x_coordinate, 10, 48, 22);
			this.add(buttons[i]);
			counter++;
		}
		
		//Action Listeners for Buttons
				buttons[0].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(board.getPlayer() == player.YOU) {
							board.insertChip(0);
							update();
						}
					}
				});
				buttons[1].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(board.getPlayer() == player.YOU) {
							board.insertChip(1);
							update();
						}
					}
				});
				buttons[2].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(board.getPlayer() == player.YOU) {
							board.insertChip(2);
							update();
						}
					}
				});
				buttons[3].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(board.getPlayer() == player.YOU) {
							board.insertChip(3);
							update();
						}
					}
				});
				buttons[4].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(board.getPlayer() == player.YOU) {
							board.insertChip(4);
							update();
						}
					}
				});
				buttons[5].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(board.getPlayer() == player.YOU) {
							board.insertChip(5);
							update();
						}
					}
				});
				buttons[6].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(board.getPlayer() == player.YOU) {
							board.insertChip(6);
							update();
						}
					}
				});
		//init butons end
				
		//init panels start
				y_coordinate = 350;
				x_coordinate = 10;
				for(int k = 0; k < 7; k++) {
					if (k != 0) {
						x_coordinate += 55;
					}
					for (int l = 0; l < 6; l++) {
						if (l != 0) {
							y_coordinate -= 55;
						}
						panels[k][l] = new JPanel();
						panels[k][l].setBounds(x_coordinate, y_coordinate, 48, 48);
						panels[k][l].setBackground(Color.WHITE);
						this.add(panels[k][l]);
					}
					y_coordinate = 350;
				}
		//init panels end
	}
	
	private Board board;
	private JButton[] buttons = new JButton[7];
	private JPanel[][] panels = new JPanel[7][6];
	
	public void update() {
		System.out.println("update GUI");
		player [][] boardStatus = board.getBoard();
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 6; j++) {
				if(boardStatus[i][j] != player.NONE) {
					if(boardStatus[i][j] == player.YOU) {
						System.out.println("you");
						JLabel imageLabel = new JLabel();
						imageLabel.setIcon(redCoin);
						panels[i][j].add(imageLabel);
					}
					else if(boardStatus[i][j] == player.OPPONENT){
						System.out.println("opponent");
						JLabel imageLabel = new JLabel();
						imageLabel.setIcon(blueCoin);
						panels[i][j].add(imageLabel);
					}
					else {
						System.out.println("all to zero");
						JLabel imageLabel = new JLabel();
						imageLabel.setIcon(null);
						panels[i][j].add(imageLabel);
					}
				}
			}
		}
	}
	private void createCoinImgaes(){
		BufferedImage bufferedImage = null;
		try{
			bufferedImage = ImageIO.read(new File("redCoin.png"));
		} catch (Exception e){
			e.printStackTrace();
		}
		Image image = bufferedImage.getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		redCoin = new ImageIcon(image);

		try{
			bufferedImage = ImageIO.read(new File("blueCoin.png"));
		} catch (Exception e){
			e.printStackTrace();
		}
		image = bufferedImage.getScaledInstance(48, 48, Image.SCALE_SMOOTH);
		blueCoin = new ImageIcon(image);
	}

}

