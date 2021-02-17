package io.spielo;

public class Game {
	public Game() {

	}
	
	public void setPlayer(player player) {
		turn = player;
	}
	
	public  player getPlayer() {
		return turn;
	}
	
	public void addWinn() {
		gamesWon++;
	}
	
	public void addLoss() {
		gamesLost++;
	}
	
	public void setTimer(long timerInMs) {
		timerStartValue = timerInMs;
	}
	
	public long getTimer() {
		long restTime = timerValue - (System.currentTimeMillis() - startTime);
		if(timerPause == true)
			restTime = timerValue;
		if(restTime < 0)
			restTime = 0;
		return restTime;
	}
	
	public void startTimer() {
		timerValue = timerStartValue;
		startTime = System.currentTimeMillis();
	}
	
	public void pauseTimer() {
		timerValue = getTimer();
		timerPause = true;
	}
	
	public void continueTimer() {
		startTime = System.currentTimeMillis();
		timerPause = false;
	}
	
	public int getWinnCount() {
		return gamesWon;
	}
	
	public int getLosscount() {
		return gamesLost;
	}
	
	public enum player{
		YOU, OPPONENT
	}
	

	private long timerStartValue;
	private long startTime;
	private long timerValue;
	private boolean timerPause = false;
	
	private player turn;
	
	private int gamesWon = 0;
	private int gamesLost= 0;
	
	
}
