import javax.swing.*;
import java.awt.*;

public class StyleSheet {
//    heading Font
    public static Font heading_Font = new Font("Arial", Font.BOLD, 23);


//    startScreen
    public static Font startScreen_Font = new Font("Arial", Font.BOLD, 18);
//    lobbySettings
    public static Font lobbySettingsLabel_Font = new Font("Arial", Font.BOLD, 15);
    public static Font lobbySettingsRadioButton_Font = new Font("Arial", Font.PLAIN, 15);
//    lobbyCreateScreen
    public static Font lobbyCreateScreenButtons_Font = new Font(Font.DIALOG, Font.BOLD, 15);
//    lobbySelectScreen
    public static Font lobbySelectScreenButtons_Font = new Font(Font.DIALOG, Font.BOLD, 15);
    public static Font lobbySelectScreenList_Font = new Font("Arial", Font.PLAIN, 15);
//    lobbyScreen
    public static Font lobbyScreenButtons_Font = new Font(Font.DIALOG, Font.BOLD, 15);
    public static Font lobbyScreenLabels_Font = new Font("Arial", Font.PLAIN, 16);




    public static String underlineHeading(String textToUnderline){
        return "<html><u>" + textToUnderline + "</u></<html>";
    }

    public static void changeFontOfStartScreenElements(JPanel panel){
        for (Component comp : panel.getComponents()) {
            comp.setFont(startScreen_Font);
        }
    }

    public static void changeFontOfLobbySettingsElements(JPanel panel){
        for (Component comp : panel.getComponents()) {
            if(comp instanceof JLabel){
                ((JLabel)comp).setFont(lobbySettingsLabel_Font);
            }
            if(comp instanceof JRadioButton){
                ((JRadioButton)comp).setFont(lobbySettingsRadioButton_Font);
            }
        }
    }
    public static void changeFontOfLobbyCreateScreenElements(JPanel panel){
        for (Component comp : panel.getComponents()) {
            if(comp instanceof JButton){
                ((JButton)comp).setFont(lobbyCreateScreenButtons_Font);
            }
        }
    }

    public static void changeFontOfLobbySelectScreenElements(JPanel panel){
        for (Component comp : panel.getComponents()) {
            if(comp instanceof JButton){
                ((JButton)comp).setFont(lobbySelectScreenButtons_Font);
            }
            else if(comp instanceof JPanel){
                for(Component comp2 : ((JPanel)comp).getComponents()){
                    if(comp2 instanceof JList){
                        comp2.setFont(lobbySelectScreenList_Font);
                    }
                }
            }

        }
    }

    public static void changeFontOfLobbyScreenElements(JPanel panel){
        for (Component comp : panel.getComponents()) {
            if(comp instanceof JButton){
                ((JButton)comp).setFont(lobbyScreenButtons_Font);
            }
            else if(comp instanceof JLabel && !((JLabel) comp).getText().equals("<html><u>Lobby</u></<html>")){
                ((JLabel)comp).setFont(lobbyScreenLabels_Font);
            }

        }
    }
}
