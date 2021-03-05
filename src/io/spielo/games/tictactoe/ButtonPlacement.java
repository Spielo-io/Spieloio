package io.spielo.games.tictactoe;

public class ButtonPlacement 
{
	public static void place()
	{
		final int minusX = 175;
		final int minuxY = 50;

		//Reihe 1
		GUI.btn[0].setBounds(175-minusX, 50-minuxY, 150, 150);
		GUI.btn[1].setBounds(325-minusX, 50-minuxY, 150, 150);
		GUI.btn[2].setBounds(475-minusX, 50-minuxY, 150, 150);

		//Reihe 2
		GUI.btn[3].setBounds(175-minusX, 200-minuxY, 150, 150);
		GUI.btn[4].setBounds(325-minusX, 200-minuxY, 150, 150);
		GUI.btn[5].setBounds(475-minusX, 200-minuxY, 150, 150);

		//Reihe 3
		GUI.btn[6].setBounds(175-minusX, 350-minuxY, 150, 150);
		GUI.btn[7].setBounds(325-minusX, 350-minuxY, 150, 150);
		GUI.btn[8].setBounds(475-minusX, 350-minuxY, 150, 150);
	}
}
