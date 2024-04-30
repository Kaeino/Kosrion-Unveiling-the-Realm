package MainGame.Main;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class GameFrame {
    public void showGame()
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");

        GamePanel gamePanel = new GamePanel();
        gamePanel.showMainGame(window);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setUpGame();

        gamePanel.startGameThread();
    }
}
