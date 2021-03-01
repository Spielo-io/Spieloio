package io.spielo.games.fourwins;

import io.spielo.Spielo;
import io.spielo.client.events.ClientEventSubscriber;
import io.spielo.messages.Message;
import io.spielo.messages.games.Win4Message;

public class Communication implements ClientEventSubscriber{
	public Communication() {
		//Spielo.client.subscribe(this);
	}
	
	private void sendMessage(int message) {
		Spielo.client.game4Win(message);
	}

	@Override
	public void onMessageReceived(Message message) {
		if(message instanceof Win4Message) {
			Win4Message winfourMessage = (Win4Message)message;
			int value = winfourMessage.getValue();
		}
		
	}

	@Override
	public void onDisconnect() {
		// TODO Auto-generated method stub
	}
}
