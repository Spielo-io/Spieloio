package io.spielo;

import io.spielo.client.Client;
import io.spielo.gui.*;
import io.spielo.messages.lobbysettings.LobbyBestOf;
import io.spielo.messages.lobbysettings.LobbyGame;
import io.spielo.messages.lobbysettings.LobbyTimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Spielo {
	private JFrame frame;
	private static CardLayout cardLayout;
	private static Container container;

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
	private static boolean opponentLeftGame;

	private static String username;
	private static String usernameOfPlayerTwo;
	private static String joinCode;

	public static Client client;

	public static void main(String[] args) {
		new Spielo();
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
	}

	public Spielo() {
		initializeElements();
		configureElements();


	}

	private void initializeElements() {
		frame = new JFrame();
		System.out.println();
		container = frame.getContentPane();
		cardLayout = new CardLayout();

		startScreen = new StartScreen();
		lobbyCreateScreen = new LobbyCreateScreen();
		lobbySelectScreen = new LobbySelectScreen();
		lobbyScreenHostPublic = new LobbyScreenHostPublic();
		lobbyScreenHostPrivat = new LobbyScreenHostPrivat();
		lobbyScreenClientPublic = new LobbyScreenClientPublic();
		lobbyScreenClientPrivat = new LobbyScreenClientPrivat();
		gameScreen = new GameScreen();

		isHost = false;
		opponentLeftGame = false;

		client = new Client();
		client.subscribe(lobbyScreenClientPublic);
		client.subscribe(lobbyScreenClientPrivat);
		client.subscribe(lobbyScreenHostPrivat);
		client.subscribe(lobbyScreenHostPublic);
		client.subscribe(lobbySelectScreen);
		client.subscribe(gameScreen);

		client.connect("20.52.147.95");
//		client.connect("127.0.0.1");

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
		frame.add(gameScreen);
		frame.add(lobbyCreateScreen);
		frame.add(lobbySelectScreen);
		frame.add(lobbyScreenHostPublic);
		frame.add(lobbyScreenHostPrivat);
		frame.add(lobbyScreenClientPublic);
		frame.add(lobbyScreenClientPrivat);
//		gameScreen.startGame(LobbyGame.TicTacToe, LobbyBestOf.BestOf_1, LobbyTimer.Seconds_30);

		UIManager.put("OptionPane.yesButtonText", "Ja");
		UIManager.put("OptionPane.noButtonText", "Nein");
		UIManager.put("OptionPane.cancelButtonText", "Abbrechen");

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				client.close();
			}
		});
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
				lobbyScreenHostPublic.lobbySettings_Panel.setLobbySettings(lobbyCreateScreen.lobbySettings_Panel.getVisibilitySetting(), lobbyCreateScreen.lobbySettings_Panel.getGameSetting(), lobbyCreateScreen.lobbySettings_Panel.getRoundModeSetting(), lobbyCreateScreen.lobbySettings_Panel.getTimerSetting(), true);
				lobbyScreenHostPublic.lobbySettings_Panel.disableVisibiltyButtonGroupSetting();
				lobbyScreenHostPublic.setLoadedLobbySettings(true);
				currentLobbyScreen = lobbyScreenHostPublic;
			}
			case "LobbyScreenHostPrivat" -> {
				lobbyScreenHostPrivat.lobbySettings_Panel.setLobbySettings(lobbyCreateScreen.lobbySettings_Panel.getVisibilitySetting(), lobbyCreateScreen.lobbySettings_Panel.getGameSetting(), lobbyCreateScreen.lobbySettings_Panel.getRoundModeSetting(), lobbyCreateScreen.lobbySettings_Panel.getTimerSetting(), true);
				lobbyScreenHostPrivat.lobbySettings_Panel.disableVisibiltyButtonGroupSetting();
				lobbyScreenHostPrivat.setLoadedLobbySettings(true);
				currentLobbyScreen = lobbyScreenHostPrivat;
			}
			case "LobbyScreenClientPublic" -> {
				currentLobbyScreen = lobbyScreenClientPublic;
			}
			case "LobbyScreenClientPrivat" -> {
				currentLobbyScreen = lobbyScreenClientPrivat;
				lobbyScreenClientPrivat.setJoinCodeLabel(startScreen.getJoinCode());
				joinCode = startScreen.getJoinCode();
			}
			case "GameScreen" -> {
				currentLobbyScreen = null;
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

	public static void prepareAppForNewGame(){
		startScreen.clearJoinCodeTextfield();

		lobbyScreenHostPublic.prepareLobbyForNewGame();
		lobbyScreenHostPrivat.prepareLobbyForNewGame();
		lobbyScreenClientPublic.preparePanelForNewLobby();
		lobbyScreenClientPrivat.preparePanelForNewLobby();
		lobbySelectScreen.preparePanelForNewGame();

		usernameOfPlayerTwo = "";
		opponentLeftGame = false;
	}

	public static LobbyScreen getCurrentLobbyScreen(){
		return  currentLobbyScreen;
	}

	public static void setUserIsHost(boolean userIsHost){
		isHost = userIsHost;
	}

	public static String getUsername(){
		return username;
	}

	public static String getJoinCode() {
		return joinCode;
	}

	public static void setUsernameOfPlayerTwo(String username){
		usernameOfPlayerTwo = username;
	}

	public static String getUsernameOfPlayerTwo(){
		return usernameOfPlayerTwo;
	}

	public static void setJoinCodeToLobbyScreenHostPrivat(){
		lobbyScreenHostPrivat.setJoinCodeLabel(joinCode);
	}

	public static void setLobbySettingsToLobbyScreenHostPrivat(){
		lobbyScreenHostPrivat.lobbySettings_Panel.setLobbySettings(lobbyScreenClientPrivat.lobbySettings_Panel.getVisibilitySetting(), lobbyScreenClientPrivat.lobbySettings_Panel.getGameSetting(), lobbyScreenClientPrivat.lobbySettings_Panel.getRoundModeSetting(), lobbyScreenClientPrivat.lobbySettings_Panel.getTimerSetting(), true);
		lobbyScreenHostPrivat.lobbySettings_Panel.disableVisibiltyButtonGroupSetting();
	}

	public static void setLobbySettingsToLobbyScreenHostPublic(){
		lobbyScreenHostPublic.lobbySettings_Panel.setLobbySettings(lobbyScreenClientPublic.lobbySettings_Panel.getVisibilitySetting(), lobbyScreenClientPublic.lobbySettings_Panel.getGameSetting(), lobbyScreenClientPublic.lobbySettings_Panel.getRoundModeSetting(), lobbyScreenClientPublic.lobbySettings_Panel.getTimerSetting(), true);
		lobbyScreenHostPublic.lobbySettings_Panel.disableVisibiltyButtonGroupSetting();
	}

	public static void setOpponentLeftGame(boolean leftGame){
		opponentLeftGame = leftGame;
	}

	public static boolean getOpponentLeftGame(){
		return opponentLeftGame;
	}
	public static GameScreen getGameScreen(){
		return gameScreen;
	}


}

