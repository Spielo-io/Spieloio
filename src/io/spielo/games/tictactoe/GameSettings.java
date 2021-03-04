package io.spielo.games.tictactoe;

import io.spielo.messages.lobbysettings.LobbyBestOf;

public class GameSettings {
	private final int roundsToWin;
	private final Boolean isHost;
	
	public GameSettings(final LobbyBestOf round, final Boolean isHost) {
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
		this.isHost = isHost;
	}

	public final int getRoundsToWin() {
		return roundsToWin;
	}
	
	public final Boolean getIsHost() {
		return isHost;
	}
}
