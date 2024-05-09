package characterselection;
import javax.sound.sampled.*;
import javax.swing.*;

import MainGame.Main.GameFrame;

import java.awt.*;
import java.io.File;
import java.io.IOException;

//shesh

public class MainClass {

    
        // Eto yung Main Frame, and it's values like sa CSS
       public static JFrame mainFrame = new JFrame("Kosrion");

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {


        // these four lines setup for the music but don't play it, music play command is in line 57 - 58
        File file = new File("character-selection/src/res/Music/BGM.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);


        // comments


        // 1st - this show the splash screen muna
 //       SplashScreen.show();

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
   //     mainFrame.setVisible(true);

        // 2nd - then after splashscreen papakita nmn main menu
        MainMenu.show(mainFrame, "character-selection/src/res/game-background/background-2.gif");

        // Hi, I'm music play command, first commands makes the music loop, 2nd command makes the music play, DAMN Discord Bot Command neh XD, Damn Groovy Memories
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();


        // Call this class on button click to show the game [MAKE SURE CLOSE THE MAIN FRAME DIN]
          GameFrame game = new GameFrame();
          game.showGame(2,0);
                
    }
}
