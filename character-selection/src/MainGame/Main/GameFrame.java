package MainGame.Main;

import java.io.IOException;

import javax.swing.*;

public class GameFrame {

    public JFrame window = new JFrame();

    public void showGame(int a, int b, int c) throws IOException // added parameters to this which passes the MainClassPick and SubClassPick variables from Mainselection Class (Under mainselection Package)
    {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");

        GamePanel gamePanel = new GamePanel();
        WriteLocation writeLocation = new WriteLocation();

        gamePanel.Character(a, b , c); // Method calling in GamePanel Class which uses the passed Values of MainClassPick and SubClassPick variables from Mainselection Class
        gamePanel.showMainGame(window);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setUpGame();

        gamePanel.startGameThread();

    }

    public void showGame(int a, int b, int c, int d) throws IOException
    {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");

        GamePanel gamePanel = new GamePanel();
        gamePanel.Character(a, b , c, d);

        WriteLocation writeLocation = new WriteLocation();

        gamePanel.showMainGame(window);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setUpGame();

        gamePanel.startGameThread();

    }

}
