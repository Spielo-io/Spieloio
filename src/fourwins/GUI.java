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
		setBounds(100, 100, 751, 583);
		getContentPane().setLayout(null);
		
		Button button = new Button("print board to console");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(board.toString());
			}
		});
		button.setBounds(10, 10, 137, 43);
		getContentPane().add(button);
		
		Button button_0 = new Button("insert");
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				board.insertChip(0);
			}
		});
		button_0.setBounds(10, 122, 70, 22);
		getContentPane().add(button_0);
		
		Button button_1 = new Button("insert");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				board.insertChip(1);
			}
		});
		button_1.setBounds(86, 122, 70, 22);
		getContentPane().add(button_1);
		
		Button button_2 = new Button("insert");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				board.insertChip(2);
			}
		});
		button_2.setBounds(162, 122, 70, 22);
		getContentPane().add(button_2);
		
		Button button_3 = new Button("insert");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				board.insertChip(3);
			}
		});
		button_3.setBounds(238, 122, 70, 22);
		getContentPane().add(button_3);
		
		Button button_4 = new Button("insert");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				board.insertChip(4);
			}
		});
		button_4.setBounds(314, 122, 70, 22);
		getContentPane().add(button_4);
		
		Button button_5 = new Button("insert");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				board.insertChip(5);
			}
		});
		button_5.setBounds(390, 122, 70, 22);
		getContentPane().add(button_5);
		
		Button button_6 = new Button("insert");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				board.insertChip(6);
			}
		});
		button_6.setBounds(466, 122, 70, 22);
		getContentPane().add(button_6);
	}
}
