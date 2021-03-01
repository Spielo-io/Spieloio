package io.spielo.games;

public class Game {
	public Game() {

	}
	
	public void setPlayer(player player) {
		//determine which players turn it is
		turn = player;
	}
	
	public  player getPlayer() {
		//returns which players turn it is
		return turn;
	}
	
	public void addWin() {
		//should be called if the local player has won a game
		gamesWon++;
	}
	
	public void addLoss() {
		//should be called if the local player has lost a game
		gamesLost++;
	}
	
	public void addDraw() {
		//should be called after the match ended in a draw
		gamesDrawn++;
	}
	
	public void setTimer(long timer_in_ms) {
		//sets the initial timer value in milliseconds -> counts down
		timerStartValue = timer_in_ms;
	}
	
	public long getTimer() {
		//returns the rest time of the timer after it has been started
		long restTime = timerValue - (System.currentTimeMillis() - startTime);
		if(timerPause == true)
			restTime = timerValue;
		if(restTime < 0)
			restTime = 0;
		return restTime;
	}
	
	public void startTimer() {
		//as soon this function is called the timer starts
		//you need to set the timer first
		timerValue = timerStartValue;
		startTime = System.currentTimeMillis();
	}
	
	public void pauseTimer() {
		//pauses the timer. It will continue at the paused time if "continueTimer" is called
		timerValue = getTimer();
		timerPause = true;
	}
	
	public void continueTimer() {
		//the timer starts at the time when "pauseTimer" was called
		startTime = System.currentTimeMillis();
		timerPause = false;
	}
	
	public int getWinCount() {
		//returns the total wins of the local player
		return gamesWon;
	}
	
	public int getLossCount() {
		//returns the total losses of the local player aka. the total wins of the opponent
		return gamesLost;
	}
	
	public int getDrawCount() {
		//returns the total number of draws
		return gamesDrawn;
	}
	
	public enum player{
		//contains all possible players
		YOU, OPPONENT, NONE
	}
	

	private long timerStartValue = 0;
	private long startTime = 0;
	private long timerValue = 0;
	private boolean timerPause = false;
	
	private player turn;
	
	private int gamesWon = 0;
	private int gamesLost = 0;
	private int gamesDrawn = 0;
	
	
}
