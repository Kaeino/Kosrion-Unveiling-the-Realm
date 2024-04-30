package MainGame.Main;

import MainGame.Entity.Player;
//import MainGame.Main.KeyHandler;
import MainGame.Tile.TIleManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements  Runnable{
    // SCREEN SETTINGS
    final  int originalTileSize = 16; // 16 x 16 pixels
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; // 48x48 tile
    public final int maxScreenCol = 16;
    public  final int maxScreenRow = 12;
    public   final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public  final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    // WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;




    int FPS = 60;



   public   TIleManager tileM = new TIleManager(this);
    KeyHandler keyH = new KeyHandler(this);
    public GameUI ui = new GameUI(this);
    Thread gameThread;
    public CollisionChecker cCHecker = new CollisionChecker(this);

    public Player player = new Player(this, keyH);


    // GAME STATE
    public  int gameState;
    public  final int playState = 0;
    public  final int pauseState = 1;

    // JPanel for holding Swing components
    public  GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);



    }

    // FIND WHERE TO PUT THIS
    public  void setUpGame()
    {
        gameState = playState;
    }

    public  void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        //[DELTA METHOD UPDATE]
        double drawInterval = 1000000000 / FPS; // 0.16 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null)
        {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1)
            {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer >= 1000000000)
            {
                //    System.out.println("drawCount = " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update()
    {
        if(gameState == playState)
        {
            player.update();
        }
        if(gameState == pauseState)
        {
            // Do nothing
        }
    }

    public  void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        // TILES SHOULD BE DRAWN FIRST BECAUSE IF THE PLAYER IS DRAWN FIRST, THE PLAYER WILL BE UNDER THE TILES
        tileM.draw(g2);

        // PLAYER
        player.draw(g2);

        // UI
       ui.draw(g2);

        g2.dispose();
    }
    public  void showMainGame(JFrame gameFrame)
    {
        gameFrame.add(this);
    }
}
