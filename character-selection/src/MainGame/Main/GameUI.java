package MainGame.Main;

import javax.swing.*;

import characterselection.MainClass;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameUI{
    GamePanel gp;
    Graphics2D g2;
    Font arial_40;
    JPanel pauseMenu;
    JButton exitGameButton;
    JButton mainMenuButton;
    MainClass main = new MainClass();

    public GameUI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);

        // Initialize pause menu panel
        pauseMenu = new JPanel();
        //     pauseMenu.setLayout(new GridLayout(3, 1));
        pauseMenu.setBackground(Color.BLACK);
        pauseMenu.setOpaque(false); // Make it transparent

    }
    public void initializePausePanel() {
        // Calculate the position to center the componentsPanel
        int panelWidth = gp.screenWidth / 2; // 384
        int panelHeight = gp.screenHeight / 4;  // 144
        int panelX = (gp.screenWidth - panelWidth) / 2; // 192
        int panelY = (gp.screenHeight - panelHeight) / 2; // 216

        // Set bounds for the pause menu panel
        pauseMenu.setBounds(panelX, panelY, panelWidth, panelHeight);

        // Add buttons to the pause menu panel
        exitGameButton = new JButton("Continue");
        mainMenuButton = new JButton("Exit Game");
        exitGameButton.setFocusable(false);
        mainMenuButton.setFocusable(false);


        // Adjust the bounds of the buttons
        int buttonWidth = panelWidth / 2; // Half of the panel width
        int buttonHeight = panelHeight / 4; // One-fourth of the panel height
        int buttonX = (panelWidth - buttonWidth) / 2; // Center horizontally
        int buttonY = (panelHeight - buttonHeight * 2) / 2; // Center vertically with space between buttons

        exitGameButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        mainMenuButton.setBounds(buttonX, buttonY + buttonHeight * 2, buttonWidth, buttonHeight);


        // Add action listeners to the buttons
        exitGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle continue button action
                gp.gameState = gp.playState;
            }
        });

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle main menu button action 
                gp.window.dispose();
                System.exit(0);
            }
        });

        pauseMenu.add(exitGameButton);
        pauseMenu.add(mainMenuButton);

        // Add background panel and pause menu panel to the game panel
        gp.setLayout(null); // Disable layout manager to manually position components
        gp.add(pauseMenu);
    }

    public  void draw(Graphics2D g2)
    {
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);

        if(gp.gameState == gp.tutorialState)
        {
            pauseMenu.setVisible(false);

            drawDialouge("\nPress 'Enter' Key to Open/Close Panel \n"+
                            "\n\n Press 'C' Key to Open/Close Character Stats \n " +
                            "Press 'escape' Key to Open/Close Pause Game \n" +
                            "Press 'E' Key to Open/Close Character Dialouge \n" +
                            "Press 'WASD' Key To Move Character"

                    , 20, 50, gp.screenWidth -(gp.tileSize * 2), gp.tileSize * 11,
                    gp.tileSize , gp.tileSize / 2);
        }

        if(gp.gameState == gp.playState)
        {
            pauseMenu.setVisible(false);
        }
         if(gp.gameState == gp.pauseState)
        {
            pauseMenu.setVisible(true);

            // eto nagpapakita ng "pause" text pag naka pause
            drawPauseScreen();
        }
         if(gp.gameState == gp.characterState)
        {
            // eto nagpapakita ng character stats
            drawCharacterScreen();
            drawLoreScreen();
        }
         if(gp.gameState == gp.dialougeState)
        {
            // PWEDENG LAGYAN NG ARRAYS PARA IBA IBA MESSAGE
            drawDialouge("“This is the magic item that suppresses my mighty magical \n powers.  " +
                    "If I were ever to take this off, a great catastrophe \n would surely befall this world…  " +
                    "Well, that was a lie.\n I just wear it for looks.”", 18, 30);
        }
    }

    public  void drawLoreScreen()
    {
        // CREATE A FRAME
        final int frameX = gp.tileSize * 7;
        final  int frameY = gp.tileSize;
        final int frameWidth = gp.tileSize * 8;
        final int frameHeight = gp.tileSize * 10;

        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        // TEXTS
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(30F));

        // Adjust the x values to center the lore text and class image
        int textX = frameX + 150;
        int textY = frameY + gp.tileSize;
        int imageX = frameX+ 75;
        int imageY = frameY + gp.tileSize + 20;
        int loreX = imageX - 10;
        int loreY = textY* 2 +gp.player.imageHeight;

        // LORE
        g2.drawString("LORE", textX, textY);
        g2.drawImage(gp.player.subClassImg, imageX, imageY, null);
        g2.drawString(gp.player.Lore, loreX, loreY);
    }
    public  void drawCharacterScreen()
    {
        // CREATE A FRAME
        final int frameX = gp.tileSize * 1;
        final  int frameY = gp.tileSize;
        final int frameWidth = gp.tileSize * 5;
        final int frameHeight = gp.tileSize * 10;

        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        // TEXTS
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(20F));

        int textX = frameX+ 20;
        int textY = frameY + gp.tileSize;
        final int lineHeight = 32;

        // STATS
        g2.drawString("NAME", textX, textY);
        textY += lineHeight;
        g2.drawString("HP", textX, textY);
        textY += lineHeight;
        g2.drawString("MP", textX, textY);
        textY += lineHeight;
        g2.drawString("STR", textX, textY);
        textY += lineHeight;
        g2.drawString("INT", textX, textY);
        textY += lineHeight;
        g2.drawString("MGC CNT", textX, textY);
        textY += lineHeight;
        g2.drawString("SPD", textX, textY);
        textY += lineHeight;
        g2.drawString("LUCK", textX, textY);
        textY += lineHeight;
        g2.drawString("AGL", textX, textY);
        textY += lineHeight;
        g2.drawString("CHR", textX, textY);
        textY += lineHeight;
        g2.drawString("STM", textX, textY);
        textY += lineHeight;

        // VALUES
        int tailX = (frameX + frameWidth ) - 30;

        // Reset textY
        textY = frameY + gp.tileSize;
        String value;

        value = String.valueOf(gp.player.name);
        textX = getXforAlgignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.HP);
        textX = getXforAlgignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.MP);
        textX = getXforAlgignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.Strength);
        textX = getXforAlgignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.Intelligence);
        textX = getXforAlgignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.MagicControl);
        textX = getXforAlgignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.Speed);
        textX = getXforAlgignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.Luck);
        textX = getXforAlgignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.Agility);
        textX = getXforAlgignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.Charisma);
        textX = getXforAlgignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.Stamina);
        textX = getXforAlgignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;
    }
    public  void drawSubWindow(int x, int y, int width, int height)
    {
        Color c = new Color(0,0,0, 210);
        g2.setColor(c);
        g2.fillRoundRect(x,y, width, height, 35,35);

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width - 10, height - 10, 25,25);
    }
    public void drawPauseScreen() {
        // CREATE A FRAME
        Color c = new Color(0,0,0, 210);
        g2.setColor(c);
        g2.fillRoundRect(-50,-50, gp.getWidth() + 100, gp.getHeight() + 100, 35,35);

        // TEXTS
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(30F));

        // TEXT
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = (gp.screenHeight - pauseMenu.getHeight()) / 4;
        g2.drawString(text, x, y);
    }

    public  void drawDialouge(String message, float fontSize, int lineHeightDistance)
    {
            // CREATE A FRAME
             int frameX = gp.tileSize * 2;
              int frameY = gp.tileSize / 2;
            final int frameWidth = gp.screenWidth -(gp.tileSize * 4);
            final int frameHeight = gp.tileSize * 4;

            drawSubWindow(frameX, frameY, frameWidth, frameHeight);

            // TEXTS
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(fontSize));

           frameX += gp.tileSize;
           frameY += gp.tileSize;
           for(String line : message.split("\n"))
           {
               g2.drawString(line, frameX, frameY);
               frameY += lineHeightDistance;
           }
    }
    public  void drawDialouge(String message, float fontSize, int lineHeightDistance,
                              int frameWidth, int frameHeight, int frameX, int frameY)
    {
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        // TEXTS
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(fontSize));

        frameX += gp.tileSize;
        frameY += gp.tileSize;
        for(String line : message.split("\n"))
        {
            g2.drawString(line, frameX, frameY);
            frameY += lineHeightDistance;
        }
    }

    public int getXforCenteredText(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - length / 2;
        return x;
    }
    public int getXforAlgignToRightText(String text, int tailX) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = tailX - length;
        return x;
    }
}