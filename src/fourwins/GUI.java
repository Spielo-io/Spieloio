package fourwins;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Canvas;
import java.awt.Color;

public class GUI extends JFrame {
	private JTextField txtPressTheButton;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public GUI(Board board) {
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
		
		Button button_0 = new Button("insert");
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				board.insertChip(0);
			}
		});
		button_0.setBounds(10, 10, 48, 22);
		getContentPane().add(button_0);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(10, 38, 48, 48);
		getContentPane().add(panel_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(10, 97, 48, 48);
		getContentPane().add(panel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 156, 48, 48);
		getContentPane().add(panel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 215, 48, 48);
		getContentPane().add(panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 274, 48, 48);
		getContentPane().add(panel_1);
		
		JPanel panel_0 = new JPanel();
		panel_0.setBackground(Color.WHITE);
		panel_0.setBounds(10, 333, 48, 48);
		getContentPane().add(panel_0);
		
		Button button_0_1 = new Button("insert");
		button_0_1.setBounds(68, 10, 48, 22);
		getContentPane().add(button_0_1);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(Color.WHITE);
		panel_5_1.setBounds(68, 38, 48, 48);
		getContentPane().add(panel_5_1);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(Color.WHITE);
		panel_4_1.setBounds(68, 97, 48, 48);
		getContentPane().add(panel_4_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBounds(68, 156, 48, 48);
		getContentPane().add(panel_3_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(68, 215, 48, 48);
		getContentPane().add(panel_2_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(68, 274, 48, 48);
		getContentPane().add(panel_1_1);
		
		JPanel panel_0_1 = new JPanel();
		panel_0_1.setBackground(Color.WHITE);
		panel_0_1.setBounds(68, 333, 48, 48);
		getContentPane().add(panel_0_1);
		
		Button button_0_2 = new Button("insert");
		button_0_2.setBounds(122, 10, 48, 22);
		getContentPane().add(button_0_2);
		
		JPanel panel_5_2 = new JPanel();
		panel_5_2.setBackground(Color.WHITE);
		panel_5_2.setBounds(122, 38, 48, 48);
		getContentPane().add(panel_5_2);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBackground(Color.WHITE);
		panel_4_2.setBounds(122, 97, 48, 48);
		getContentPane().add(panel_4_2);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(Color.WHITE);
		panel_3_2.setBounds(122, 156, 48, 48);
		getContentPane().add(panel_3_2);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setBounds(122, 215, 48, 48);
		getContentPane().add(panel_2_2);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.WHITE);
		panel_1_2.setBounds(122, 274, 48, 48);
		getContentPane().add(panel_1_2);
		
		JPanel panel_0_2 = new JPanel();
		panel_0_2.setBackground(Color.WHITE);
		panel_0_2.setBounds(122, 333, 48, 48);
		getContentPane().add(panel_0_2);
		
		Button button_0_3 = new Button("insert");
		button_0_3.setBounds(176, 10, 48, 22);
		getContentPane().add(button_0_3);
		
		JPanel panel_5_3 = new JPanel();
		panel_5_3.setBackground(Color.WHITE);
		panel_5_3.setBounds(176, 38, 48, 48);
		getContentPane().add(panel_5_3);
		
		JPanel panel_4_3 = new JPanel();
		panel_4_3.setBackground(Color.WHITE);
		panel_4_3.setBounds(176, 97, 48, 48);
		getContentPane().add(panel_4_3);
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setBackground(Color.WHITE);
		panel_3_3.setBounds(176, 156, 48, 48);
		getContentPane().add(panel_3_3);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setBackground(Color.WHITE);
		panel_2_3.setBounds(176, 215, 48, 48);
		getContentPane().add(panel_2_3);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(Color.WHITE);
		panel_1_3.setBounds(176, 274, 48, 48);
		getContentPane().add(panel_1_3);
		
		JPanel panel_0_3 = new JPanel();
		panel_0_3.setBackground(Color.WHITE);
		panel_0_3.setBounds(176, 333, 48, 48);
		getContentPane().add(panel_0_3);
		
		Button button_0_4 = new Button("insert");
		button_0_4.setBounds(230, 10, 48, 22);
		getContentPane().add(button_0_4);
		
		JPanel panel_5_4 = new JPanel();
		panel_5_4.setBackground(Color.WHITE);
		panel_5_4.setBounds(230, 38, 48, 48);
		getContentPane().add(panel_5_4);
		
		JPanel panel_4_4 = new JPanel();
		panel_4_4.setBackground(Color.WHITE);
		panel_4_4.setBounds(230, 97, 48, 48);
		getContentPane().add(panel_4_4);
		
		JPanel panel_3_4 = new JPanel();
		panel_3_4.setBackground(Color.WHITE);
		panel_3_4.setBounds(230, 156, 48, 48);
		getContentPane().add(panel_3_4);
		
		JPanel panel_2_4 = new JPanel();
		panel_2_4.setBackground(Color.WHITE);
		panel_2_4.setBounds(230, 215, 48, 48);
		getContentPane().add(panel_2_4);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setBackground(Color.WHITE);
		panel_1_4.setBounds(230, 274, 48, 48);
		getContentPane().add(panel_1_4);
		
		JPanel panel_0_4 = new JPanel();
		panel_0_4.setBackground(Color.WHITE);
		panel_0_4.setBounds(230, 333, 48, 48);
		getContentPane().add(panel_0_4);
		
		Button button_0_5 = new Button("insert");
		button_0_5.setBounds(288, 10, 48, 22);
		getContentPane().add(button_0_5);
		
		JPanel panel_5_5 = new JPanel();
		panel_5_5.setBackground(Color.WHITE);
		panel_5_5.setBounds(288, 38, 48, 48);
		getContentPane().add(panel_5_5);
		
		JPanel panel_4_5 = new JPanel();
		panel_4_5.setBackground(Color.WHITE);
		panel_4_5.setBounds(288, 97, 48, 48);
		getContentPane().add(panel_4_5);
		
		JPanel panel_3_5 = new JPanel();
		panel_3_5.setBackground(Color.WHITE);
		panel_3_5.setBounds(288, 156, 48, 48);
		getContentPane().add(panel_3_5);
		
		JPanel panel_2_5 = new JPanel();
		panel_2_5.setBackground(Color.WHITE);
		panel_2_5.setBounds(288, 215, 48, 48);
		getContentPane().add(panel_2_5);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setBackground(Color.WHITE);
		panel_1_5.setBounds(288, 274, 48, 48);
		getContentPane().add(panel_1_5);
		
		JPanel panel_0_5 = new JPanel();
		panel_0_5.setBackground(Color.WHITE);
		panel_0_5.setBounds(288, 333, 48, 48);
		getContentPane().add(panel_0_5);
		
		Button button_0_6 = new Button("insert");
		button_0_6.setBounds(342, 10, 48, 22);
		getContentPane().add(button_0_6);
		
		JPanel panel_5_6 = new JPanel();
		panel_5_6.setBackground(Color.WHITE);
		panel_5_6.setBounds(342, 38, 48, 48);
		getContentPane().add(panel_5_6);
		
		JPanel panel_4_6 = new JPanel();
		panel_4_6.setBackground(Color.WHITE);
		panel_4_6.setBounds(342, 97, 48, 48);
		getContentPane().add(panel_4_6);
		
		JPanel panel_3_6 = new JPanel();
		panel_3_6.setBackground(Color.WHITE);
		panel_3_6.setBounds(342, 156, 48, 48);
		getContentPane().add(panel_3_6);
		
		JPanel panel_2_6 = new JPanel();
		panel_2_6.setBackground(Color.WHITE);
		panel_2_6.setBounds(342, 215, 48, 48);
		getContentPane().add(panel_2_6);
		
		JPanel panel_1_6 = new JPanel();
		panel_1_6.setBackground(Color.WHITE);
		panel_1_6.setBounds(342, 274, 48, 48);
		getContentPane().add(panel_1_6);
		
		JPanel panel_0_6 = new JPanel();
		panel_0_6.setBackground(Color.WHITE);
		panel_0_6.setBounds(342, 333, 48, 48);
		getContentPane().add(panel_0_6);
	}
}
