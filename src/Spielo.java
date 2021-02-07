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

	public static void main(String[] args) {
		Spielo spielo = new Spielo();
		System.out.println(Spielo.currentView.toString());
	}

	public Spielo(){
		initializeVariables();
		configureJFrame();
		loadScreens();

		changeView("GameScreen");
		changeView("StartScreen");
	}

	private void initializeVariables(){
		frame = new JFrame();
		container = frame.getContentPane();
		cardLayout = new CardLayout();
		screens = new HashMap<String, SpieloView>();
	}

	private void configureJFrame(){

		frame.setSize(500, 500);
		frame.setTitle("Spielo.io");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(cardLayout);
	}

	public static void changeView(String newView){
		cardLayout.show(container, newView);
		currentView = screens.get(newView);
//		System.out.println(currentView.toString());
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

