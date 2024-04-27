package MainGame.Tile;

import MainGame.Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TIleManager {
    GamePanel gp;
    public Tile[] tile;
  public   int mapTileNum [][];

    public TIleManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];

        mapTileNum= new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap();
    }
public  void loadMap()
{
    try
    {
        InputStream is = getClass().getResourceAsStream("/res/MainGameResources/Maps/world01.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        int col = 0;
        int row = 0;

        while(col  < gp.maxWorldCol && row < gp.maxWorldRow)
        {
            String line = br.readLine();

            while(col < gp.maxWorldCol)
            {
                String numbers[] = line.split(" ");
                int num = Integer.parseInt(numbers[col]);

                mapTileNum[col][row]  = num;
                col++;
            }
            if(col == gp.maxWorldCol)
            {
                col = 0;
                row++;
            }
        }
        br.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    public void getTileImage() {
        try {
            tile[0]  = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/MainGameResources/Tiles/grass.png"));

            tile[1]  = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/MainGameResources/Tiles/wall.png"));
            tile[1].collision = true;

            tile[2]  = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/MainGameResources/Tiles/water.png"));
            tile[2].collision = true;

            tile[3]  = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/MainGameResources/Tiles/earth.png"));

            tile[4]  = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/MainGameResources/Tiles/tree.png"));
            tile[4].collision = true;

            tile[5]  = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/MainGameResources/Tiles/sand.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void draw(Graphics2D g2) {
        // THIS IS HOW YOU MANUALLY PLACE TILES
  //      g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);

        int worldCol = 0;
        int worldRow = 0;


        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow )
        {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;    // worlc x[0] * tilesize[48] = 48 and so on [players position]
            int worldY = worldRow * gp.tileSize;    // worlc x[0] * tilesize[48] = 48 and so on [players position]
            int screenX = worldX - gp.player.worldX + gp.player.screenX;    // Offset [para pag nasa 0,0 coordinates hindi lumalampas]
            int screenY = worldY - gp.player.worldY + gp.player.screenY;    // Offset [para pag nasa 0,0 coordinates hindi lumalampas]

            // Makes sure to only draw what the camera shows on the screen, without this statement the program
            // will draw the tiles that are not even seen on camera which slows down the game significantly
            if(worldX + gp.tileSize> gp.player.worldX - gp.player.screenX && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize> gp.player.worldY - gp.player.screenY && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY)
            {
                g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

            }

            worldCol++;

            if(worldCol == gp.maxWorldCol)
            {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
