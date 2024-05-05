package MainGame.Entity;

import MainGame.Main.GamePanel;
import MainGame.Main.KeyHandler;
import mainselection.MainSelection;

import com.sun.nio.sctp.AbstractNotificationHandler;

import Classes.MiddleMan;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity
{
    GamePanel gp;
    KeyHandler keyH;


    public  final int screenX;
    public  final  int screenY;
    public  final int ImageWidth = 220;
    public  final int imageHeight = 200;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        // Makes sure that the camera always look at the center [The player]
        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);   // Division makes sure that the player is really in the center. {if not divided then the position of
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);  //  the player will be a little bit placed on top left corner}

        // Default character size is 48 by 48 pixels, this only creates a box collider in the specified location
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();
    }

    public void setCharacterStats(int main, int sub){ //New method that sets the character's Stats which uses passed values

        MiddleMan mid = new MiddleMan(main, sub); // This object is ung sa class that sets the character's Stats (Under Classes Package)

                // Player status [ETO DAPAT PALITAN PAG NEED NA INTEGRATE VALUES CODE NI PSALM] (Done!)
                name    = mid.getName();
                HP = mid.getHP(); //Methods from Final Pick class (Also under Classes Package)
                MP = mid.getMP();
                Strength = mid.getStrength();
                Intelligence = mid.getIntelligence();
                MagicControl = mid.getMagicControl();
                Speed = mid.getSpeed();
                Luck = mid.getLuck();
                Agility = mid.getAgility();
                Charisma = mid.getCharisma();
                Stamina = mid.getStamina();
                Lore = mid.getLore();
                subClassImg = mid.getImg().getImage(); // Converts ImageIcon to Image so that we can use it for g2.draw (Di pwede ImageIcon)
                subClassImg = subClassImg.getScaledInstance(ImageWidth, imageHeight, Image.SCALE_DEFAULT); // Changes Size of image for Character Panel


    }
    public void setDefaultValues() {
        worldX = gp.tileSize * 23;  // Used to set player starting position [can write 1000 or this]
        worldY = gp.tileSize * 21;  // Used to set player starting position [can write 1000 or this]
        speed = 4;
        direction = "down";


    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/MainGameResources/Player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/MainGameResources/Player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/MainGameResources/Player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/MainGameResources/Player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/MainGameResources/Player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/MainGameResources/Player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/MainGameResources/Player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/MainGameResources/Player/boy_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        // THIS CODE MAKES SURE THAT THE ANIMATION ONLY PLAYS WHEN ANY OF THE KEYS ARE GETTING PRESSED
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
            if (keyH.upPressed == true) {
                direction = "up";
            } else if (keyH.downPressed == true) {
                direction = "down";
            } else if (keyH.leftPressed == true) {
                direction = "left";
            } else if (keyH.rightPressed == true) {
                direction = "right";
            }

            // CHECK TILE COLLISION
            collisionOn = false;
            gp.cCHecker.checkTile(this);

            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if(collisionOn == false)
            {
                switch(direction) {

                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;

                }

            }

            // REMEMBER THAT UPDATE 1 FRAMES EVERY 0.16 SECONDS. NOW THIS IS CALLED 10 FRAMES EVERY 1 SECONDS SO IT'S GOING TO
            // TURN 1 / 2 / 1 / 2 EVERY 10 FRAMES

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                    System.out.println(1);

                } else if (spriteNum == 2) {
                    spriteNum = 1;
                    System.out.println(2);
                }
                spriteCounter = 0;
            }
        }
    }


    public  void draw(Graphics g2)
    {

        BufferedImage image = null;

        switch (direction)
        {
            case "up":
                if(spriteNum == 1)
                {
                    image = up1;
                }
                if(spriteNum == 2)
                {
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1)
                {
                    image = down1;
                }
                if(spriteNum == 2)
                {
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1)
                {
                    image = left1;
                }
                if(spriteNum == 2)
                {
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1)
                {
                    image = right1;
                }
                if(spriteNum == 2)
                {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);


       /* g2.setColor(Color.white);
        g2.fillRect(x,y, gp.tileSize,gp.tileSize);*/
    }
}
