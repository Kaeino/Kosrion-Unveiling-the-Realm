package MainGame.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import mainselection.MainSelection;

public class Entity{

    public  int worldX, worldY, facing;
    public  int x,y;
    public  int speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public  String direction;
    public  int spriteCounter = 0;
    public  int spriteNum = 1;
    public Rectangle solidArea;
    public boolean collisionOn = false;

    // CHARACTER ATTRIBUTES
    public  String name;
    public int HP;
    public int MP;
    public String Lore;
    public int Strength;
    public int Intelligence;
    public int MagicControl;
    public int Speed;
    public int Luck;
    public int Agility;
    public int Charisma;
    public int Stamina;
    public Image subClassImg;
    public Image subClassImg2;
}
