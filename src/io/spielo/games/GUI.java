package io.spielo.games;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI 
{
	
	JFrame jf;
	Draw draw;
	
	static JButton btn[] = new JButton[9];
	//Ist der Button von Spieler 1 oder Spiele 2 oder garnicht gedrückt? (Zustände: 0 1 2)
	static int pressed[] = new int[9];
	static int player = 0; //Welcher Spieler ist am Zug?
	static boolean winner = false;
	
	

	public GUI()
	{
		jf = new JFrame();
		jf.setSize(800, 600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.setTitle("Tic Tac Toe");
		
		for(int i = 0; i<btn.length; i++)
		{
			btn[i] = new JButton();
			btn[i].setVisible(true);
			btn[i].addActionListener(new ActionHandler());
			btn[i].setFocusPainted(false);
			btn[i].setContentAreaFilled(false);
			btn[i].setBorder(null);
			jf.add(btn[i]);
			
		}
		
		ButtonPlacement.place();
		
		draw = new Draw();
		draw.setBounds(0,0,800,600);
		draw.setVisible(true);
		jf.add(draw);
		jf.setVisible(true);
		
	}

}
