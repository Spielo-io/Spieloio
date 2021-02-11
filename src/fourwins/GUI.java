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

public class GUI extends JFrame {
	private JTextField txtPressTheButton;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 394);
		getContentPane().setLayout(null);
		
		Button button = new Button("button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPressTheButton.setText("what have you done?!");
				button.setLabel("*dead*");
			}
		});
		button.setBounds(10, 10, 117, 43);
		getContentPane().add(button);
		
		txtPressTheButton = new JTextField();
		txtPressTheButton.setText("press the button!!!");
		txtPressTheButton.setEditable(false);
		txtPressTheButton.setBounds(170, 27, 189, 20);
		getContentPane().add(txtPressTheButton);
		txtPressTheButton.setColumns(10);
	}
}
