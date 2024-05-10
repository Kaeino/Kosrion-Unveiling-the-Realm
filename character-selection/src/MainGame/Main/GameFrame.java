package MainGame.Main;

import javax.swing.*;

public class GameFrame {

    public JFrame window = new JFrame();

    public void showGame(int a, int b) // added parameters to this which passes the MainClassPick and SubClassPick variables from Mainselection Class (Under mainselection Package)
    {
        System.out.println(a +" "+ b);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");

        GamePanel gamePanel = new GamePanel();
        gamePanel.Character(a, b); // Method calling in GamePanel Class which uses the passed Values of MainClassPick and SubClassPick variables from Mainselection Class
        gamePanel.showMainGame(window);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setUpGame();

        gamePanel.startGameThread();

    }
}
