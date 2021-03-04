package io.spielo.games;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import io.spielo.Spielo;

public abstract class Game {
	private final ScheduledExecutorService timer;
	private int timerValue2;
	
	public Game() {
		timer = Executors.newSingleThreadScheduledExecutor();
		Timer host = new Timer(30);
		Timer player2 = new Timer(30);
		
		timer.scheduleAtFixedRate(host, 1, 1, TimeUnit.SECONDS);
		timer.scheduleAtFixedRate(player2, 1, 1, TimeUnit.SECONDS);
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
		currentRound++;
		if(currentRound <= totalRounds)
			resetBoard();
		System.out.println("spiele gewonnen" + gamesWon);
		Spielo.getGameScreen().setPlayerOneWins_Label(gamesWon);
	}
	
	public void addLoss() {
		//should be called if the local player has lost a game
		gamesLost++;
		currentRound++;
		if(currentRound <= totalRounds)
			resetBoard();
		System.out.println("spiele verloren" + gamesLost);
		Spielo.getGameScreen().setPlayerTwoWins_Label(gamesLost);
	}
	
	public void addDraw() {
		//should be called after the match ended in a draw
		gamesDrawn++;
		currentRound++;
		if(currentRound <= totalRounds)
			resetBoard();
	}
	
	public void setTimer(long timer_in_ms) {
		//sets the initial timer value in milliseconds -> counts down
		timerValue2 = 30;
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

	public void setRounds(int rounds) {
		totalRounds = rounds;
	}
		
	public abstract void resetBoard();
	
	public static enum player{
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
	//public static Game message = new Game();

	//multiple rounds start
	private int totalRounds = 3;
	private int currentRound = 1;
	//multiple rounds end
	
	private void timerIsZero() {
		
	}
	
	private final class Timer implements Runnable {

		private int timerValue2;
		
		public Timer(int timerValue) {
			this.timerValue2 = timerValue;
		}
		
		@Override
		public void run() {
			timerValue2--;
			Spielo.getGameScreen().setTimer_Label(timerValue2);
			
			if (timerValue2 == 0) {
				timerIsZero();
			}
		}
	}
}
