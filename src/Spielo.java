import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class Spielo {
	private JFrame frame;
	private static CardLayout cardLayout;
	private static Container container;
	private static SpieloView currentView;
	private static HashMap<String, SpieloView> screens;

	private static boolean isHost;
	private static boolean isPrivatLobby;

	public static String username;

	public static void main(String[] args) {
		new Spielo();
	}

	public Spielo(){
		initializeElements();
		configureJFrame();
		loadScreens();
	}

	private void initializeElements(){
		frame = new JFrame();
		container = frame.getContentPane();
		cardLayout = new CardLayout();
		screens = new HashMap<String, SpieloView>();

		isHost = false;
	}

	private void configureJFrame(){

		frame.setSize(700, 500);
		frame.setTitle("Spielo.io");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(cardLayout);
//		frame.pack();

		container.setPreferredSize(new Dimension(500, 300));
	}

	public static boolean userIsHost(){
		return isHost;
	}

	public static void changeView(String newView){
		currentView = screens.get(newView);
//				get username from StartScreen
		if(!newView.equals("StartScreen")){
			username = ((StartScreen)screens.get("StartScreen")).getUsername();
		}

		switch (newView) {
			case "StartScreen" -> {
				((StartScreen) currentView).clearJoinCodeTextfield();
				isHost = false;
			}
			case "LobbyCreateScreen" -> {
				isHost = true;
			}
			case "LobbySelectScreen" -> {
				isPrivatLobby = false;
			}
			case "LobbyScreen" -> {
				((LobbyScreen)currentView).lobbySettings_Panel.activateRadioButtons(isHost);
				if(isHost){
					((LobbyScreen)currentView).lobbySettings_Panel.setLobbySettings(((LobbyCreateScreen)screens.get("LobbyCreateScreen")).getLobbySettings(), isHost);

				}
				((LobbyScreen)currentView).lobbySettings_Panel.disableVisibiltyButtonGroupSetting();
				((LobbyScreen)currentView).setStartGameButton(isHost);
			}
		}
//			actualize view
		cardLayout.show(container, newView);
	}

	private void loadScreens(){
		screens.put("StartScreen", new StartScreen());
		screens.put("LobbyCreateScreen", new LobbyCreateScreen());
		screens.put("LobbyScreen", new LobbyScreen());
		screens.put("GameScreen", new GameScreen());
		screens.put("LobbySelectScreen", new LobbySelectScreen());

		SpieloView currentScreen;
		for(String screen : screens.keySet()){
			currentScreen = screens.get(screen);
			cardLayout.addLayoutComponent(currentScreen, screen);
			frame.add(currentScreen);
			}
		}

	}

