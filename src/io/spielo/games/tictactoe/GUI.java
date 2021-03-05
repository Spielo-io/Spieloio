package io.spielo.games.tictactoe;
import javax.swing.*;
import java.awt.*;

public class GUI 
{
	JPanel jf;
//	JFrame jf;
	Draw draw;
	
	static JButton btn[] = new JButton[9];
	static int pressed[] = new int[9];
	static int player = 0;
	static int countButtonspressed = 0;
	static int opponent = 0;
	
	public GUI(GameSettings settings)
	{
		jf = new JPanel();
		jf.setLayout(null);
//		jf = new JFrame();
//		jf.setVisible(true);
		jf.setSize(450, 450);
		jf.setPreferredSize(new Dimension(450, 450));
//		jf.setSize(800, 600);
//		jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//		jf.setLocationRelativeTo(null);
//		jf.setResizable(false);
//		jf.setTitle("Tic Tac Toe");
		
		for(int i = 0; i<btn.length; i++)
		{

			btn[i] = new JButton();
			btn[i].setVisible(true);
			btn[i].setFocusPainted(false);
			btn[i].setContentAreaFilled(false);
			btn[i].setBorder(null);
			jf.add(btn[i]);

		}
		for (int i = 0; i < btn.length; i++) {
			btn[i].addActionListener(new ActionHandler(settings, 1, 1)); 
		}
		
		ButtonPlacement.place();

//		System.out.println(btn[8].getSize());
		
		draw = new Draw();
		draw.setBounds(0,0,450,450);
		jf.add(draw);

		
	}

	public JPanel getPanel(){
		return jf;
	}
	
	public void receiveMessage(int value) {
			((ActionHandler)btn[0].getActionListeners()[0]).receiveMessage(value);
	}

}
