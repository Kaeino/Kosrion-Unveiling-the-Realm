package MainGame.Main;

import MainGame.Entity.Entity;

public class CollisionChecker
{
    GamePanel gp;
    public  CollisionChecker(GamePanel gp)
    {
        this.gp = gp;
    }
    public void checkTile(Entity entity)
    {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY/gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        switch(entity.direction)
        {
            case "up" :
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tileSize;
                tileNum1 =  gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];  //Check Left Hand
                tileNum2 =  gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow]; //Check Right Hand
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
                {
                    entity.collisionOn = true;
                }
                break;

            case "down" :
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tileSize;
                tileNum1 =  gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityBottomRow];  //Check Left Hand
                tileNum2 =  gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow]; //Check Right Hand
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
                {
                    entity.collisionOn = true;
                }
                break;

            case "left" :
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tileSize;
                tileNum1 =  gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];  //Check Left Hand
                tileNum2 =  gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityBottomRow]; //Check Right Hand
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
                {
                    entity.collisionOn = true;
                }
                break;

            case "right" :
                entityRightCol = (entityRightWorldX + entity.speed)/gp.tileSize;
                tileNum1 =  gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];  //Check Left Hand
                tileNum2 =  gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow]; //Check Right Hand
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
                {
                    entity.collisionOn = true;
                }
                break;
        }
    }
}
