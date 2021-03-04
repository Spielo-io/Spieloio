package io.spielo.games.tictactoe;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI 
{
	JFrame jf;
	Draw draw;
	
	static JButton btn[] = new JButton[9];
	static int pressed[] = new int[9];
	static int player = 0;
	static int countButtonspressed = 0;
	static int opponent = 0;
	
	public GUI(GameSettings settings)
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
			btn[i].addActionListener(new ActionHandler(settings, 1, 1)); //nicht 1,1 verwenden!!! random zahlen!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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
	
	public void receiveMessage(int value) {
		for (int i = 0; i < btn.length; i++) {
			((ActionHandler)btn[i].getActionListeners()[0]).receiveMessage(value);
		}
	}

}
