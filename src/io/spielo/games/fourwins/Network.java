/*package io.spielo.games.fourwins;

import io.spielo.Spielo;
import io.spielo.client.events.ClientEventSubscriber;
import io.spielo.games.tictactoe.Game.player;
import io.spielo.messages.Message;
import io.spielo.messages.games.Win4Message;

public class Network{
	public Network(Board board) {
		this.board = board;
	}
	
	public void sendMessage(int message) {
		System.out.println("sende" + message);
		Spielo.client.game4Win(message);
	}

	public void messageReceived(int value){
		System.out.println("message empfangen: " + value);

		if(value < 7) {
			board.insertChip(value);
		}
		else {
			if(value == 7)
				board.setPlayer(player.OPPONENT);
			else if(value == 8)
				board.setPlayer(player.YOU);
				
		}
	}
	private Board board;
}*/