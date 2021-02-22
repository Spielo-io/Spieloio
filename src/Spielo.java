import io.spielo.Game;

public class Spielo {

	public static void main(String[] args) {
		System.out.println("---start---");
		Game game = new Game();
		game.setTimer(5000);
		game.startTimer();
		while(game.getTimer() > 0) {
			//System.out.println(game.getTimer());			
		}
		System.out.println("---end---");
	}

}
