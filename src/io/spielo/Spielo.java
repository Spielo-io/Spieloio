package io.spielo;

import io.spielo.client.Client;
import io.spielo.gui.*;

import javax.swing.*;
import java.awt.*;


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

	private static String username;
	private static String joinCode;

	public static Client client;

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

		startScreen = new StartScreen();
		lobbyCreateScreen = new LobbyCreateScreen();
		lobbySelectScreen = new LobbySelectScreen();
		lobbyScreenHostPublic = new LobbyScreenHostPublic();
		lobbyScreenHostPrivat = new LobbyScreenHostPrivat();
		lobbyScreenClientPublic = new LobbyScreenClientPublic();
		lobbyScreenClientPrivat = new LobbyScreenClientPrivat();
		gameScreen = new GameScreen();

		isHost = false;

		client = new Client();
		client.subscribe(lobbyScreenClientPublic);
		client.subscribe(lobbyScreenClientPrivat);
		client.subscribe(lobbyScreenHostPrivat);
		client.subscribe(lobbyScreenHostPublic);
		client.subscribe(lobbySelectScreen);
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
				lobbyScreenHostPublic.lobbySettings_Panel.setLobbySettingsEnum(lobbyCreateScreen.lobbySettings_Panel.getVisibilitySetting(), lobbyCreateScreen.lobbySettings_Panel.getGameSettingEnum(), lobbyCreateScreen.lobbySettings_Panel.getRoundModeSettingEnum(), lobbyCreateScreen.lobbySettings_Panel.getTimerSettingEnum(), true);
				lobbyScreenHostPublic.lobbySettings_Panel.disableVisibiltyButtonGroupSetting();
				lobbyScreenHostPublic.setLoadedLobbySettings(true);
				currentLobbyScreen = lobbyScreenHostPublic;
			}
			case "LobbyScreenHostPrivat" -> {
				lobbyScreenHostPrivat.lobbySettings_Panel.setLobbySettingsEnum(lobbyCreateScreen.lobbySettings_Panel.getVisibilitySetting(), lobbyCreateScreen.lobbySettings_Panel.getGameSettingEnum(), lobbyCreateScreen.lobbySettings_Panel.getRoundModeSettingEnum(), lobbyCreateScreen.lobbySettings_Panel.getTimerSettingEnum(), true);
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
		lobbySelectScreen.preparePanelForNewGame();

	}

	public static String getUsername(){
		return username;
	}
	public static String getJoinCode() {
		return joinCode;
	}

}

