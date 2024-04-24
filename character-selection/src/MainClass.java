import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

//damnn eto packages, para magamit yung character-selection-package
import characterselection.*;
import characterselection.SplashScreen;

public class MainClass {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        // these four lines setup for the music but don't play it, music play command is in line 47
        File file = new File("character-selection/src/res/Music/BGM.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

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
        MainMenu.show(mainFrame, "character-selection/src/res/game-background/background-2.gif");

        // Hi, I'm music play command
        clip.start();
    }
}
