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
        JButton continueButton = new JButton("Continue");
        JButton mainMenuButton = new JButton("Main Menu");
        continueButton.setFocusable(false);
        mainMenuButton.setFocusable(false);


        // Adjust the bounds of the buttons
        int buttonWidth = panelWidth / 2; // Half of the panel width
        int buttonHeight = panelHeight / 4; // One-fourth of the panel height
        int buttonX = (panelWidth - buttonWidth) / 2; // Center horizontally
        int buttonY = (panelHeight - buttonHeight * 2) / 2; // Center vertically with space between buttons

        continueButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        mainMenuButton.setBounds(buttonX, buttonY + buttonHeight * 2, buttonWidth, buttonHeight);


        // Add action listeners to the buttons
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

        // Add background panel and pause menu panel to the game panel
        gp.setLayout(null); // Disable layout manager to manually position components
        gp.add(pauseMenu);
    }

    public  void draw(Graphics2D g2)
    {
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);

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
        }
    }
    public  void drawCharacterScreen()
    {
        // CREATE A FRAME
        final int frameX = gp.tileSize * 2;
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
        g2.drawString("STRENGTH", textX, textY);
        textY += lineHeight;
        g2.drawString("ATTACK", textX, textY);
        textY += lineHeight;
        g2.drawString("DEFENSE", textX, textY);
        textY += lineHeight;
        g2.drawString("AGILITY", textX, textY);
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

        value = String.valueOf(gp.player.strength);
        textX = getXforAlgignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.attack);
        textX = getXforAlgignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.defense);
        textX = getXforAlgignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gp.player.agility);
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
        // Draw a black background with 50% transparency
        g2.setColor(new Color(0, 0, 0, 128)); // Black with 50% transparency
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        // Set the color of the "PAUSED" text to white
        g2.setColor(Color.WHITE);

        // Draw the "PAUSED" text at the desired position
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = (gp.screenHeight - pauseMenu.getHeight()) / 4;
        g2.drawString(text, x, y);

        // Make the pause menu panel visible
        pauseMenu.setVisible(true);
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