package MainGame.Tile;

import MainGame.Main.GamePanel;
import MainGame.Main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
//import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TIleManager {
    GamePanel gp;
    public Tile[] tile;
    public   int mapTileNum [][][];

    ArrayList<String> fileNames = new ArrayList<>(  );
    ArrayList<String> collisionStatus = new ArrayList<>(  );



    public TIleManager(GamePanel gp) {
        this.gp = gp;

        // READ TILE DATA FILE
        InputStream is = getClass().getResourceAsStream("/res/MainGameResources/Maps/TIleEditorResources/mapTileData2"); // Yung may collisions true false
        BufferedReader br = new BufferedReader(new InputStreamReader(is)); // GG RESET CASE STUDY NA
        // repush test lang


        // GETTING TILE NAMES AND COLLISIONS INFO FROM THE FILE
        String line ;

        try {

            while ((line = br.readLine()) != null)
            {
                fileNames.add(line);
                collisionStatus.add(br.readLine());
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


        tile = new Tile[fileNames.size()];
        getTileEditorImage();
  //      getTileImage();

        // GET THE WORLD COL AND ROW
        is = getClass().getResourceAsStream("/res/MainGameResources/Maps/TIleEditorResources/mapProject2"); // yung may 0 0 0 1 1 2 3 4 1 1 1 numbers
        br = new BufferedReader(new InputStreamReader(is));

        try{
            String line2 = br.readLine();
            String maxTile[] = line2.split(" ");

            gp.maxWorldCol= maxTile.length;
            gp.maxWorldRow = maxTile.length;

            mapTileNum = new int[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];

            br.close();
        }
        catch (IOException e)
        {
            System.out.println("Exeption ");
        }


        loadMap("/res/MainGameResources/Maps/TIleEditorResources/mapProject2", 0);
    }
    public void loadMap(String filePath,int map)
    {
        try
        {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is)); // to read from txt

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow)
            {
                String line = br.readLine();

                while(col < gp.maxWorldCol)
                {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[map][col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol)
                {
                    col = 0;
                    row++;
                }
            }
            br.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public  void getTileEditorImage()
    {
        for (int i = 0; i < fileNames.size(); i++) {
            String fileName;
            boolean collision;

            //Get a file name
            fileName = fileNames.get(i);

            // get a file name
            if(collisionStatus.get(i).equals("true"))
            {
                collision = true;
            }
            else
            {
                collision = false;
            }

            setup(i, fileName, collision);
        }
    }
    public  void setup (int index, String imageNamge, boolean collision)
    {
        UtilityTool uTool = new UtilityTool();
        try
        {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/res/MainGameResources/TilesV2/" + imageNamge));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void getTileImage() {

        try {
            // WATERS

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/MainGameResources/TilesV2/Water/tile320.png"));

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

    // PARA D MAWALA OLD VERSION
    private  void loadOldMap()
    {
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
            int tileNum = mapTileNum[gp.currentMap][worldCol][worldRow]; //drawing current map

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
