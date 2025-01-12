//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package main;

import entity.Entity;
import java.awt.Rectangle;

public class CollisionChecker {
    GamePannel gp;

    public CollisionChecker(GamePannel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
        this.gp.getClass();
        int entityLeftCol = entityLeftWorldX / 48;
        this.gp.getClass();
        int entityRightCol = entityRightWorldX / 48;
        this.gp.getClass();
        int entityTopRow = entityTopWorldY / 48;
        this.gp.getClass();
        int entityBottomRow = entityBottomWorldY / 48;
        int tileNum1;
        int tileNum2;
        int var10000;
        switch (entity.direction) {
            case "up":
                var10000 = entityTopWorldY - entity.speed;
                this.gp.getClass();
                entityTopRow = var10000 / 48;
                tileNum1 = this.gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = this.gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (this.gp.tileM.tile[tileNum1].collision || this.gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                var10000 = entityBottomWorldY + entity.speed;
                this.gp.getClass();
                entityBottomRow = var10000 / 48;
                tileNum1 = this.gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = this.gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (this.gp.tileM.tile[tileNum1].collision || this.gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                var10000 = entityLeftWorldX - entity.speed;
                this.gp.getClass();
                entityLeftCol = var10000 / 48;
                tileNum1 = this.gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = this.gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (this.gp.tileM.tile[tileNum1].collision || this.gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                var10000 = entityRightWorldX + entity.speed;
                this.gp.getClass();
                entityRightCol = var10000 / 48;
                tileNum1 = this.gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = this.gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (this.gp.tileM.tile[tileNum1].collision || this.gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
        }

    }

    public int checkObject(Entity entity, boolean player) {
        int index = 999;

        for(int i = 0; i < this.gp.obj.length; ++i) {
            if (this.gp.obj[i] != null) {
                entity.solidArea.x += entity.worldX;
                entity.solidArea.y += entity.worldY;
                this.gp.obj[i].solidArea.x += this.gp.obj[i].worldX;
                this.gp.obj[i].solidArea.y += this.gp.obj[i].worldY;
                Rectangle var10000;
                switch (entity.direction) {
                    case "up":
                        var10000 = entity.solidArea;
                        var10000.y -= entity.speed;
                        if (entity.solidArea.intersects(this.gp.obj[i].solidArea)) {
                            if (this.gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }

                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        var10000 = entity.solidArea;
                        var10000.y += entity.speed;
                        if (entity.solidArea.intersects(this.gp.obj[i].solidArea)) {
                            if (this.gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }

                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        var10000 = entity.solidArea;
                        var10000.x -= entity.speed;
                        if (entity.solidArea.intersects(this.gp.obj[i].solidArea)) {
                            if (this.gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }

                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        var10000 = entity.solidArea;
                        var10000.x += entity.speed;
                        if (entity.solidArea.intersects(this.gp.obj[i].solidArea)) {
                            if (this.gp.obj[i].collision) {
                                entity.collisionOn = true;
                            }

                            if (player) {
                                index = i;
                            }
                        }
                }

                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                this.gp.obj[i].solidArea.x = this.gp.obj[i].solidAreaDefaultX;
                this.gp.obj[i].solidArea.y = this.gp.obj[i].solidAreaDefaultY;
            }
        }

        return index;
    }
}
