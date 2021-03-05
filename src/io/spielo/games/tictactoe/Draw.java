package io.spielo.games.tictactoe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class Draw extends JLabel 
{

	private static final long serialVersionUID = 1L;
	private final int minusX = 175;
	private final int minusY = 50;

	protected void paintComponent(Graphics g) 
	{

		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// draw///
		g.setColor(new Color(192,192,192));
		g.fillRect(0, 0, 450, 450);

		g.setColor(Color.BLACK);
		
		//Vetikal
		
		g.drawLine(325-minusX, 50-minusY, 325-minusX, 500-minusY);
		g.drawLine(475-minusX, 50-minusY, 475-minusX, 500-minusY);
		
		//Horizontal
		
		g.drawLine(175-minusX, 200-minusY, 625-minusX, 200-minusY);
		g.drawLine(175-minusX,350-minusY, 625-minusX, 350-minusY);
		
		if (GUI.pressed[0] == 1) {
			g.drawImage(ImageLoader.imgX, 175-minusX, 50-minusY, 150, 150, null);
		} else if (GUI.pressed[0] == 2) {
			g.drawImage(ImageLoader.imgO, 175-minusX, 50-minusY, 150, 150, null);
		}

		if (GUI.pressed[1] == 1) {
			g.drawImage(ImageLoader.imgX, 325-minusX, 50-minusY, 150, 150, null);
		} else if (GUI.pressed[1] == 2) {
			g.drawImage(ImageLoader.imgO, 325-minusX, 50-minusY, 150, 150, null);
		}

		if (GUI.pressed[2] == 1) {
			g.drawImage(ImageLoader.imgX, 475-minusX, 50-minusY, 150, 150, null);
		} else if (GUI.pressed[2] == 2) {
			g.drawImage(ImageLoader.imgO, 475-minusX, 50-minusY, 150, 150, null);
		}

		// Reihe 2

		if (GUI.pressed[3] == 1) {
			g.drawImage(ImageLoader.imgX, 175-minusX, 200-minusY, 150, 150, null);
		} else if (GUI.pressed[3] == 2) {
			g.drawImage(ImageLoader.imgO, 175-minusX, 200-minusY, 150, 150, null);
		}

		if (GUI.pressed[4] == 1) {
			g.drawImage(ImageLoader.imgX, 325-minusX, 200-minusY, 150, 150, null);
		} else if (GUI.pressed[4] == 2) {
			g.drawImage(ImageLoader.imgO, 325-minusX, 200-minusY, 150, 150, null);
		}

		if (GUI.pressed[5] == 1) {
			g.drawImage(ImageLoader.imgX, 475-minusX, 200-minusY, 150, 150, null);
		} else if (GUI.pressed[5] == 2) {
			g.drawImage(ImageLoader.imgO, 475-minusX, 200-minusY, 150, 150, null);
		}

		// Reihe 3

		if (GUI.pressed[6] == 1) {
			g.drawImage(ImageLoader.imgX, 175-minusX, 350-minusY, 150, 150, null);
		} else if (GUI.pressed[6] == 2) {
			g.drawImage(ImageLoader.imgO, 175-minusX, 350-minusY, 150, 150, null);
		}

		if (GUI.pressed[7] == 1) {
			g.drawImage(ImageLoader.imgX, 325-minusX, 350-minusY, 150, 150, null);
		} else if (GUI.pressed[7] == 2) {
			g.drawImage(ImageLoader.imgO, 325-minusX, 350-minusY, 150, 150, null);
		}

		if (GUI.pressed[8] == 1) {
			g.drawImage(ImageLoader.imgX, 475-minusX, 350-minusY, 150, 150, null);
		} else if (GUI.pressed[8] == 2) {
			g.drawImage(ImageLoader.imgO, 475-minusX, 350-minusY, 150, 150, null);
		}
		
		repaint();
		 
		
		

	}
	
}
