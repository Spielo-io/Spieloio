package io.spielo.games;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import io.spielo.Spielo;
import io.spielo.games.Game.player;
import io.spielo.gui.StartScreen;

public abstract class Game {
	private static final ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
	private final Timer timer;
	
	public Game(int maxTimer, int totalRounds) {
		timer = new Timer();
		scheduledExecutor.scheduleAtFixedRate(timer, 1, 1, TimeUnit.SECONDS);
		this.totalRounds = totalRounds;
		setTimer(maxTimer);
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
		alertGameEnd("Du hast diese Runde gewonnen!");
		if((totalRounds / 2) >= gamesWon) {
			resetBoard();
			setPlayer(player.OPPONENT);
		}
		else {
			pauseTimer();
			setPlayer(player.NONE);
			JOptionPane.showMessageDialog(null, "Gratulation, du hast dieses Spiel gewonnen.", "Spiel zu Ende", JOptionPane.PLAIN_MESSAGE);
			Spielo.changeView("StartScreen");
		}
		Spielo.getGameScreen().setPlayerOneWins_Label(gamesWon);
	}
	
	public void addLoss() {
		//should be called if the local player has lost a game
		gamesLost++;
		currentRound++;
		alertGameEnd("Du hast diese Runde verloren!");
		if((totalRounds / 2) >= gamesLost) {
			resetBoard();
			setPlayer(player.YOU);
		}
		else {
			pauseTimer();
			setPlayer(player.NONE);
			JOptionPane.showMessageDialog(null, "Schade, du hast dieses Spiel verloren.", "Spiel zu Ende", JOptionPane.PLAIN_MESSAGE);
			Spielo.changeView("StartScreen");
		}
		System.out.println("spiele verloren" + gamesLost);
		Spielo.getGameScreen().setPlayerTwoWins_Label(gamesLost);
	}
	
	public void addDraw() {
		//should be called after the match ended in a draw
		gamesDrawn++;
		currentRound++;
		alertGameEnd("unntschieden");
		if(currentRound <= totalRounds)
			resetBoard();
		else
			pauseTimer();
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
		timer.setIsRunning(true);
		timerPause = false;
	}
	
	public void pauseTimer() {
		//pauses the timer. It will continue at the paused time if "continueTimer" is called
		timerValue = getTimer();
		timerPause = true;
		timer.setIsRunning(false);
	}
	
	public void continueTimer() {
		//the timer starts at the time when "pauseTimer" was called
		startTime = System.currentTimeMillis();
		timerPause = false;
		timer.setIsRunning(false);
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
		
	private void alertGameEnd(String message) {
		//JOptionPane.showConfirmDialog(this, "Willst du das Spiel wirklich verlassen?", "Wähle eine Option!", JOptionPane.YES_NO_OPTION);
		JOptionPane.showMessageDialog(null, message, "Runde zu Ende", JOptionPane.PLAIN_MESSAGE);
	}
	
	public abstract void resetBoard();
	public abstract void sendTimeOut();
	
	public static enum player{
		//contains all possible players
		YOU, OPPONENT, NONE
	}
	

	private long timerStartValue = 30000;
	private long startTime = 30000;
	private long timerValue = 30000;
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
	
	private final class Timer implements Runnable {

		private Boolean isRunning;
		
		public Timer() {
			isRunning = false;
		}
		
		@Override
		public void run() {
			if (isRunning) {
				int timer = (int) (getTimer() / 1000);
				Spielo.getGameScreen().setTimer_Label(timer);
				if (timer == 0) {
					sendTimeOut();
					alertGameEnd("Deine Zeit ist abgelaufen!");
					addLoss();
					pauseTimer();
				}
			}
		}
		
		public void setIsRunning(final Boolean isRunning) {
			this.isRunning = isRunning;
		}
	}
}
