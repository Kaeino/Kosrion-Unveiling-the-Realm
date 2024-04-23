import javax.swing.*;
import java.awt.*;

public class MainClass {
    public static void main(String[] args) {

        JFrame splashFrame = new JFrame();
        splashFrame.setUndecorated(true); 
        splashFrame.setSize(400, 300);
        splashFrame.setLocationRelativeTo(null); 

        JPanel splashPanel = new JPanel(new BorderLayout());


        ImageIcon splashImage = new ImageIcon("character-selection/src/images/game-background/background-1.gif"); 
        // Replace "splash_image.png" with the path to your image

        JLabel imageLabel = new JLabel(splashImage);
        splashPanel.add(imageLabel, BorderLayout.CENTER);

        JLabel textLabel = new JLabel("Entering a GODLY GAME, SHEESH", SwingConstants.CENTER);
        textLabel.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 18));
        splashPanel.add(textLabel, BorderLayout.SOUTH);


        splashFrame.add(splashPanel);
        
        splashFrame.setVisible(true);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        splashFrame.dispose();

        JFrame mainFrame = new JFrame("Main Application");
        mainFrame.setSize(800, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null); 
        mainFrame.setVisible(true);
    }
}
