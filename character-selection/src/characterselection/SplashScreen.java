package characterselection;

import javax.swing.*;
import java.awt.*;

public class SplashScreen {
    public static void show() {
        JFrame splashFrame = new JFrame();

        //sheesh undecorated = means no decoration, no title bar, borders, etc.
        splashFrame.setUndecorated(true);

        //size ng splashscren natin
        splashFrame.setSize(450, 300); 

        //sineset nya yung position ng frame sa center ng screen damnn
        splashFrame.setLocationRelativeTo(null);

        // eto nmn gumagawa sya ng panel for splashscreen gamit yung Borderlayout
        JPanel splashPanel = new JPanel(new BorderLayout());

        // damn karami comments, tho this one niloload nya lang image ng splashscreen, with path
        ImageIcon splashImage = new ImageIcon("character-selection/src/game-background/background-1.gif");

        // label ng image damn
        JLabel imageLabel = new JLabel(splashImage);

        //sinecenter yung image sa panel, damnnn
        splashPanel.add(imageLabel, BorderLayout.CENTER);


        //eto nmn label ng Splashscreen text, sheesh
        JLabel textLabel = new JLabel("Entering a GODLY GAME, SHEESH", SwingConstants.CENTER);

        //damnn yung pang design ng splashscreen text nmn toh
        textLabel.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 18));
        
        //kaya nasa baba yung Splashscreen text natin is dahil dito
        splashPanel.add(textLabel, BorderLayout.SOUTH);

        //eto inaadd nya yung panel sa splashframe nmn
        splashFrame.add(splashPanel);

        //para makita yung splashFrame, ginawa syang visible sheeeeshh
        splashFrame.setVisible(true);

        try {
            Thread.sleep(3000); //kung gano katagal yung running time ng SPLASH SCREEN, damn 1 hour
        } catch (InterruptedException e) {
            // damnn mag shoshoww sya error kung may interruption habang nag roroll yung splashscreen
            e.printStackTrace();
        }
        // damnnnn Disposing the Body damnn, inaalis nya yung frame after running yung splashscreen, ready for the next process, which is yung main menu
        splashFrame.dispose();
    }
}
