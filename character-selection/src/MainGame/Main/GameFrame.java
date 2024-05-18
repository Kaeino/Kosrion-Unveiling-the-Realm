package MainGame.Main;

import java.io.IOException;

import javax.swing.*;

public class GameFrame {

    public void showGame(int a, int b, int c) throws IOException // added parameters to this which passes the MainClassPick and SubClassPick variables from Mainselection Class (Under mainselection Package)
    {

        GamePanel gamePanel = new GamePanel();

        gamePanel.showGame(a, b , c); // Method calling in GamePanel Class which uses the passed Values of MainClassPick and SubClassPick variables from Mainselection Class

    }

  
    public void showGame(int a, int b, int c, int d) throws IOException // added parameters to this which passes the MainClassPick and SubClassPick variables from Mainselection Class (Under mainselection Package)
    {

        GamePanel gamePanel = new GamePanel();

        gamePanel.showGame(a, b , c, d); // Method calling in GamePanel Class which uses the passed Values of MainClassPick and SubClassPick variables from Mainselection Class

    }

}
