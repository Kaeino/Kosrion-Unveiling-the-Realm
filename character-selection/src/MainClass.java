import javax.swing.*;
import java.awt.*;

//damnn eto packages, para magamit yung character-selection-package
import characterselection.*;
import characterselection.SplashScreen;

public class MainClass {
    public static void main(String[] args) {
        // 1st - this show the splash screen muna
        SplashScreen.show();

        // Eto yung Main Frame, and it's values like sa CSS
        JFrame mainFrame = new JFrame("Main Application");
        //damnnnn, closing shit
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //damn para di na problemahin yung resize, false na damnn
        mainFrame.setResizable(false);
        //damnn size toh ng Main Framee damnn, so masasama yung main menu
        mainFrame.setPreferredSize(new Dimension(950, 550));
        
        //dammnn taga adjust lang ng frame size, damn technique lang sya, no need to damnn
        mainFrame.pack();
        //damnnn sinecenter nya rin sa Screen mo uli
        mainFrame.setLocationRelativeTo(null);
        //damnn para visible yung frame sheesh
        mainFrame.setVisible(true);

        // 2nd - then after splashscreen papakita nmn main menu
        MainMenu.show(mainFrame, "character-selection/src/game-background/background-2.gif");
    }
}
