package io.spielo.games.tictactoe;

import io.spielo.messages.lobbysettings.LobbyBestOf;
import io.spielo.messages.lobbysettings.LobbyTimer;

public class GameSettings {
	private final int roundsToWin;
	private final Boolean isHost;
	private final int timer;
	
	

	public GameSettings(final LobbyBestOf round, final Boolean isHost,final LobbyTimer lobbyTimer) {
		switch (round) {
		case BestOf_1:
			roundsToWin = 1;
			break;
		case BestOf_3:
			roundsToWin = 2;
			break;
		case BestOf_5:
			roundsToWin = 3;
			break;
		case BestOf_7:
			roundsToWin = 4;
			break;
		case BestOf_9:
			roundsToWin = 5;
			break;
		default:
			roundsToWin = -1;
			break;
		}
		
		switch (lobbyTimer) {
		case Seconds_30:
			timer = 30000;
			break;
		case Minute_1:
			timer = 60000;
			break;
		case Minute_3:
			timer = 180000;
			break;
		default:
			timer = -1;
			break;
		}
		this.isHost = isHost;
	}

	public final int getRoundsToWin() {
		return roundsToWin;
	}
	
	public final Boolean getIsHost() {
		return isHost;
	}
	public int getTimer() {
		return timer;
	}
}
