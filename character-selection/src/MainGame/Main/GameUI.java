package MainGame.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameUI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40;
    JPanel pauseMenu;


    public GameUI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);

        pauseMenu = new JPanel();
    }

//+======================+++++++++++++++++++++++++++++++++++================================
    // PSALM HELP
    public  void initializePausePanel(GamePanel gp)
    {
        // Initialize JPanel for Swing components
        pauseMenu.setLayout(new GridLayout(3, 1));
        pauseMenu.setBackground(new Color(0,0,0,128));

        // Makes the whole screen dark
        pauseMenu.setSize(gp.screenWidth, gp.screenHeight);
    //    pauseMenu.setBounds(0, 0, gp.getWidth(), gp.getHeight());

        // BUTTON CODES GO THERE
        JButton continueButton = new JButton("Continue");
        continueButton.setFocusable(false);
        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setFocusable(false);

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle continue button action
            }
        });

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle main menu button action
            }
        });

        pauseMenu.add(continueButton);
        pauseMenu.add(mainMenuButton);

        gp.add(pauseMenu);
    }

    public  void draw(Graphics2D g2)
    {
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);

        if(gp.gameState == gp.playState)
        {
            pauseMenu.setLocation(1000,1000);
        }
        if(gp.gameState == gp.pauseState)
        {   
            pauseMenu.setLocation(0,0);

            // eto nagpapakita ng "pause" text pag naka pause
            drawPauseScreen();
        }
    }
    public  void drawPauseScreen()
    {
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;

        pauseMenu.setVisible(true); // Make pause menu visible
        g2.drawString(text, x,y);
    }


    public int getXforCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }
}

