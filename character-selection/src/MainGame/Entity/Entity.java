package MainGame.Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

import mainselection.MainSelection;

public class Entity{

    public  int worldX, worldY;
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
    public String Lore;
    public int HP;  // IDK what other stats are
    public int MP;
    public  int strength;
    public  int attack;
    public  int defense;
    public  int agility;

}
