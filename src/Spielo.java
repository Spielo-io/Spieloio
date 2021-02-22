import javax.swing.*;
import java.awt.*;


public class Spielo {
	private JFrame frame;
	private static CardLayout cardLayout;
	private static Container container;
//	private static SpieloView currentView;
//	private static HashMap<String, SpieloView> screens;

	private static StartScreen startScreen;
	private static LobbyCreateScreen lobbyCreateScreen;
	private static LobbySelectScreen lobbySelectScreen;
	private static LobbyScreenHostPublic lobbyScreenHostPublic;
	private static LobbyScreenHostPrivat lobbyScreenHostPrivat;
	private static LobbyScreenClientPublic lobbyScreenClientPublic;
	private static LobbyScreenClientPrivat lobbyScreenClientPrivat;
	private static GameScreen gameScreen;

	private static LobbyScreen currentLobbyScreen;


	private static boolean isHost;

	public static String username;

	public static void main(String[] args) {
		new Spielo();
	}

	public Spielo() {
		initializeElements();
		configureElements();
	}

	private void initializeElements() {
		frame = new JFrame();
		container = frame.getContentPane();
		cardLayout = new CardLayout();
//		screens = new HashMap<String, SpieloView>();

		startScreen = new StartScreen();
		lobbyCreateScreen = new LobbyCreateScreen();
		lobbySelectScreen = new LobbySelectScreen();
		lobbyScreenHostPublic = new LobbyScreenHostPublic();
		lobbyScreenHostPrivat = new LobbyScreenHostPrivat();
		lobbyScreenClientPublic = new LobbyScreenClientPublic();
		lobbyScreenClientPrivat = new LobbyScreenClientPrivat();
		gameScreen = new GameScreen();

		isHost = false;
	}

	private void configureElements() {

		frame.setSize(700, 500);
		frame.setLocation(300, 200);
		frame.setTitle("Spielo.io");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(cardLayout);

		cardLayout.addLayoutComponent(startScreen, "StartScreen");
		cardLayout.addLayoutComponent(lobbyCreateScreen, "LobbyCreateScreen");
		cardLayout.addLayoutComponent(lobbySelectScreen, "LobbySelectScreen");
		cardLayout.addLayoutComponent(lobbyScreenHostPublic, "LobbyScreenHostPublic");
		cardLayout.addLayoutComponent(lobbyScreenHostPrivat, "LobbyScreenHostPrivat");
		cardLayout.addLayoutComponent(lobbyScreenClientPublic, "LobbyScreenClientPublic");
		cardLayout.addLayoutComponent(lobbyScreenClientPrivat, "LobbyScreenClientPrivat");
		cardLayout.addLayoutComponent(gameScreen, "GameScreen");

		frame.add(startScreen);
		frame.add(lobbyCreateScreen);
		frame.add(lobbySelectScreen);
		frame.add(lobbyScreenHostPublic);
		frame.add(lobbyScreenHostPrivat);
		frame.add(lobbyScreenClientPublic);
		frame.add(lobbyScreenClientPrivat);
		frame.add(gameScreen);

		UIManager.put("OptionPane.yesButtonText", "Ja");
		UIManager.put("OptionPane.noButtonText", "Nein");
		UIManager.put("OptionPane.cancelButtonText", "Abbrechen");
	}

	public static boolean userIsHost() {
		return isHost;
	}

	public static void changeView(String newView) {
		switch (newView) {
			case "StartScreen" -> {
				isHost = false;
				prepareAppForNewGame();
			}
			case "LobbyCreateScreen" -> {
				isHost = true;
			}
			case "LobbyScreenHostPublic" -> {
				lobbyScreenHostPublic.setLobbySettings(lobbyCreateScreen.getLobbySettings(), true);
				currentLobbyScreen = lobbyScreenHostPublic;
			}
			case "LobbyScreenHostPrivat" -> {
				lobbyScreenHostPrivat.setLobbySettings(lobbyCreateScreen.getLobbySettings(), true);
				currentLobbyScreen = lobbyScreenHostPrivat;
			}
			case "LobbyScreenClientPublic" -> {
				currentLobbyScreen = lobbyScreenClientPublic;
			}
			case "LobbyScreenClientPrivat" -> {
				currentLobbyScreen = lobbyScreenClientPrivat;
			}
		}
//			get and set username
		if (!newView.equals("StartScreen")) {
			username = startScreen.getUsername();
		}

		if(newView.contains("LobbyScreen")){
			currentLobbyScreen.setNameForPlayerOne(username);
		}

//			actualize view
		cardLayout.show(container, newView);
	}

	private static void prepareAppForNewGame(){
		startScreen.clearJoinCodeTextfield();

		lobbyScreenHostPublic.prepareLobbyForNewGame();
		lobbyScreenHostPrivat.prepareLobbyForNewGame();
		lobbyScreenClientPublic.preparePanelForNewLobby();
		lobbyScreenClientPrivat.preparePanelForNewLobby();

	}

}

