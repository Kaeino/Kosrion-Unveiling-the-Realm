package MainGame.Main;

import MainGame.Entity.Player;
//import MainGame.Main.KeyHandler;
import MainGame.Tile.TIleManager;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel implements  Runnable{
    // SCREEN SETTINGS
    final  int originalTileSize = 16; // 16 x 16 pixels
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; // 48x48 tile
    public final int CharacterTileSize = tileSize +5;
    public final int maxScreenCol = 16;
    public  final int maxScreenRow = 12;
    public   final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public  final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    public JFrame window = new JFrame();

    // WORLD SETTINGS
    public  int maxWorldCol;
    public  int maxWorldRow;
    public  final int maxMap = 10;
    public int currentMap = 0;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;



    int LoadCreate;
    boolean test;
    int FPS = 60;


   public   TIleManager tileM = new TIleManager(this);
    KeyHandler keyH = new KeyHandler(this);
    public GameUI ui = new GameUI(this);
    public Thread gameThread;
    public CollisionChecker cCHecker = new CollisionChecker(this);
    public Player player = new Player(this, keyH);


    // GAME STATE
    public  int gameState;
    public  final int playState = 0;
    public  final int pauseState = 1;
    public  final  int characterState = 2;
    public  final int dialougeState = 3;

    // JPanel for holding Swing components
    public  GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        ui.initializePausePanel();

        // System.out.println(this.screenWidth);
        // System.out.println(this.screenHeight);
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
                WriteLocation write = new WriteLocation();
                write.CharacterLoc.setLength(0);
                    try {
                        write.SaveLocation(player.worldX, player.worldY, LoadCreate);
                    } catch (IOException e) {
                    }
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void showGame(int a, int b, int c) throws IOException // added parameters to this which passes the MainClassPick and SubClassPick variables from Mainselection Class (Under mainselection Package)
    {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");

        Character(a, b , c); // Method calling in GamePanel Class which uses the passed Values of MainClassPick and SubClassPick variables from Mainselection Class
        window.add(this);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        setUpGame();

        startGameThread();
    }

    public void showGame(int a, int b, int c, int d) throws IOException
    {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Adventure");

        Character(a, b , c, d);
        window.add(this);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        setUpGame();

        startGameThread();
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

        if(gameState == playState)
        {
            g2.dispose();   
        }      
    }
    public void Character(int a , int b, int c, int d)// Method I added which gets called when GameFrame gets called.
    {   
        player.setDefaultValues(c);
        LoadCreate = c;
         player.setCharacterStats(a, b);// Calls a method in Player Class which also uses these values passed from MainSelection class
         // can be considered Method Chaining ung not in the same class idk what thats called i forgor
    }

    public void Character(int a , int b, int c)
    {   
       player.setDefaultValues(5);
        LoadCreate = c;
         player.setCharacterStats(a, b);
        
    }
}
