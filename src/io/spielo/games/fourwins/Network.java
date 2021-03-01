package io.spielo.games.fourwins;

import io.spielo.Spielo;
import io.spielo.client.events.ClientEventSubscriber;
import io.spielo.games.tictactoe.Game.player;
import io.spielo.messages.Message;
import io.spielo.messages.games.Win4Message;

public class Network implements ClientEventSubscriber{
	public Network(Board board) {
		Spielo.client.subscribe(this);
		this.board = board;
	}
	
	public void sendMessage(int message) {
		Spielo.client.game4Win(message);
	}

	@Override
	public void onMessageReceived(Message message) {
		if(message instanceof Win4Message) {
			Win4Message winfourMessage = (Win4Message)message;
			int value = winfourMessage.getValue();
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
		
	}

	@Override
	public void onDisconnect() {
		// TODO Auto-generated method stub
	}
	
	private Board board;
}