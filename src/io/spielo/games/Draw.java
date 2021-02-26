package io.spielo.games;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class Draw extends JLabel 
{

	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) 
	{

		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// draw///
		
		//g.setColor(new Color(255,230,204));
		//g.fillRect(0, 0, 800, 600);

		g.setColor(Color.BLACK);
		
		//Vetikal
		
		g.drawLine(325, 50, 325, 500);
		g.drawLine(475, 50, 475, 500);
		
		//Horizontal
		
		g.drawLine(175, 200, 625, 200);
		g.drawLine(175,350 , 625, 350);
		
		if (GUI.pressed[0] == 1) {
			g.drawImage(ImageLoader.imgX, 175, 50, 150, 150, null);
		} else if (GUI.pressed[0] == 2) {
			g.drawImage(ImageLoader.imgO, 175, 50, 150, 150, null);
		}

		if (GUI.pressed[1] == 1) {
			g.drawImage(ImageLoader.imgX, 325, 50, 150, 150, null);
		} else if (GUI.pressed[1] == 2) {
			g.drawImage(ImageLoader.imgO, 325, 50, 150, 150, null);
		}

		if (GUI.pressed[2] == 1) {
			g.drawImage(ImageLoader.imgX, 475, 50, 150, 150, null);
		} else if (GUI.pressed[2] == 2) {
			g.drawImage(ImageLoader.imgO, 475, 50, 150, 150, null);
		}

		// Reihe 2

		if (GUI.pressed[3] == 1) {
			g.drawImage(ImageLoader.imgX, 175, 200, 150, 150, null);
		} else if (GUI.pressed[3] == 2) {
			g.drawImage(ImageLoader.imgO, 175, 200, 150, 150, null);
		}

		if (GUI.pressed[4] == 1) {
			g.drawImage(ImageLoader.imgX, 325, 200, 150, 150, null);
		} else if (GUI.pressed[4] == 2) {
			g.drawImage(ImageLoader.imgO, 325, 200, 150, 150, null);
		}

		if (GUI.pressed[5] == 1) {
			g.drawImage(ImageLoader.imgX, 475, 200, 150, 150, null);
		} else if (GUI.pressed[5] == 2) {
			g.drawImage(ImageLoader.imgO, 475, 200, 150, 150, null);
		}

		// Reihe 3

		if (GUI.pressed[6] == 1) {
			g.drawImage(ImageLoader.imgX, 175, 350, 150, 150, null);
		} else if (GUI.pressed[6] == 2) {
			g.drawImage(ImageLoader.imgO, 175, 350, 150, 150, null);
		}

		if (GUI.pressed[7] == 1) {
			g.drawImage(ImageLoader.imgX, 325, 350, 150, 150, null);
		} else if (GUI.pressed[7] == 2) {
			g.drawImage(ImageLoader.imgO, 325, 350, 150, 150, null);
		}

		if (GUI.pressed[8] == 1) {
			g.drawImage(ImageLoader.imgX, 475, 350, 150, 150, null);
		} else if (GUI.pressed[8] == 2) {
			g.drawImage(ImageLoader.imgO, 475, 350, 150, 150, null);
		}
		
		repaint();
		 
		
		

	}
	
}
