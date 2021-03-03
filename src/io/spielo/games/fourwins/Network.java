package io.spielo.games.fourwins;

import io.spielo.Spielo;
import io.spielo.client.events.ClientEventSubscriber;
import io.spielo.games.tictactoe.Game.player;
import io.spielo.messages.Message;
import io.spielo.messages.games.Win4Message;

public class Network{
	public Network(Board board) {
//		Spielo.client.subscribe(this);
		this.board = board;
	}
	
	public void sendMessage(int message) {
		System.out.println("sende" + message);
		Spielo.client.game4Win(message);
	}

	public void messageReceived(int valueNew){
		System.out.println("message empfangen: " + valueNew);
//		if(message instanceof Win4Message) {
//			System.out.println("message received" + ((Win4Message) message).getValue());
//			Win4Message winfourMessage = (Win4Message)message;
			int value =  valueNew;  //	winfourMessage.getValue();
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
}