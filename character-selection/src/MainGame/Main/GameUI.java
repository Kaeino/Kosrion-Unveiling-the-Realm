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
        pauseMenu.setVisible(false); // Hide it initially
    }

//+======================+++++++++++++++++++++++++++++++++++================================
    // PSALM HELP
    public  void initializePausePanel(JFrame frame)
    {
        // Initialize JPanel for Swing components
        pauseMenu.setLayout(new GridLayout(3, 1));
        pauseMenu.setBackground(new Color(0,0,0,128));

        // Makes the whole screen dark
        pauseMenu.setSize(frame.getWidth(), frame.getHeight());
     //   pauseMenu.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        // BUTTON CODES GO THERE
        JButton continueButton = new JButton("Continue");
        JButton mainMenuButton = new JButton("Main Menu");

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

        frame.add(pauseMenu);

        frame.revalidate();
        frame.repaint();
    }
    public  void draw(Graphics2D g2)
    {
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);

        if(gp.gameState == gp.playState)
        {
            pauseMenu.hide();
            pauseMenu.setVisible(false);
        }
        if(gp.gameState == gp.pauseState)
        {
            pauseMenu.show();
            pauseMenu.setVisible(true);

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

