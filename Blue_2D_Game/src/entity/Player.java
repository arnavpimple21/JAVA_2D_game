
package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePannel;
import main.KeyHandler;

public class Player extends Entity {
    GamePannel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public int hasKey = 0;
    boolean bootsOn = false;
    int bootsCounter = 0;

    public Player(GamePannel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        gp.getClass();
        int var10001 = 768 / 2;
        gp.getClass();
        this.screenX = var10001 - 48 / 2;
        gp.getClass();
        var10001 = 576 / 2;
        gp.getClass();
        this.screenY = var10001 - 48 / 2;
        this.solidArea = new Rectangle();
        this.solidArea.x = 8;
        this.solidArea.y = 16;
        this.solidAreaDefaultX = this.solidArea.x;
        this.solidAreaDefaultY = this.solidArea.y;
        this.solidArea.width = 32;
        this.solidArea.height = 32;
        this.setDefaultValues();
        this.getPlayerImage();
    }

    public void setDefaultValues() {
        this.gp.getClass();
        this.worldX = 48 * 23;
        this.gp.getClass();
        this.worldY = 48 * 21;
        this.speed = 4;
        this.direction = "down";
    }

    public void getPlayerImage() {
        try {
            this.up1 = ImageIO.read(this.getClass().getResourceAsStream("/res/Player/boy_up_1.png"));
            this.up2 = ImageIO.read(this.getClass().getResourceAsStream("/res/Player/boy_up_2.png"));
            this.down1 = ImageIO.read(this.getClass().getResourceAsStream("/res/Player/boy_down_1.png"));
            this.down2 = ImageIO.read(this.getClass().getResourceAsStream("/res/Player/boy_down_2.png"));
            this.left1 = ImageIO.read(this.getClass().getResourceAsStream("/res/Player/boy_left_1.png"));
            this.left2 = ImageIO.read(this.getClass().getResourceAsStream("/res/Player/boy_left_2.png"));
            this.right1 = ImageIO.read(this.getClass().getResourceAsStream("/res/Player/boy_right_1.png"));
            this.right2 = ImageIO.read(this.getClass().getResourceAsStream("/res/Player/boy_right_2.png"));
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public void update() {
        if (this.keyH.upPressed || this.keyH.downPressed || this.keyH.leftPressed || this.keyH.rightPressed) {
            if (this.keyH.upPressed) {
                this.direction = "up";
            } else if (this.keyH.downPressed) {
                this.direction = "down";
            } else if (this.keyH.leftPressed) {
                this.direction = "left";
            } else if (this.keyH.rightPressed) {
                this.direction = "right";
            }

            this.collisionOn = false;
            this.gp.cChecker.checkTile(this);
            int objIndex = this.gp.cChecker.checkObject(this, true);
            this.pickUpObject(objIndex);
            if (!this.collisionOn) {
                switch (this.direction) {
                    case "up":
                        this.worldY -= this.speed;
                        break;
                    case "down":
                        this.worldY += this.speed;
                        break;
                    case "left":
                        this.worldX -= this.speed;
                        break;
                    case "right":
                        this.worldX += this.speed;
                }
            }

            ++this.spriteCounter;
            if (this.spriteCounter > 12) {
                if (this.spriteNum == 1) {
                    this.spriteNum = 2;
                } else if (this.spriteNum == 2) {
                    this.spriteNum = 1;
                }

                this.spriteCounter = 0;
            }
        }

    }

    public void pickUpObject(int i) {
        if (i != 999) { // Check if an object is present
            String objectName = gp.obj[i].name; // Get the name of the object

            switch (objectName) {
                case "Key":
                    this.gp.playSE(1);
                    ++this.hasKey;
                    this.gp.obj[i] = null;
                    this.gp.ui.showMessage("You got a key!");
                    break;
                case "Door":
                    if (this.hasKey > 0) {
                        this.gp.playSE(3);
                        this.gp.obj[i] = null;
                        --this.hasKey;
                        this.gp.ui.showMessage("You opened the door!");
                    } else {
                        this.gp.ui.showMessage("You need a key!");
                    }
                    break;
                case "Boots":
                    this.gp.playSE(2);
                    ++this.speed;
                    this.gp.obj[i] = null;
                    this.gp.ui.showMessage("Speed up!");
                    break;
                case "Chest":
                    this.gp.ui.gameFinished = true;
                    this.gp.stopMusic();
                    this.gp.playSE(4);
                    break;
            }
        }
    }


    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (this.direction) {
            case "up":
                if (this.spriteNum == 1) {
                    image = this.up1;
                }

                if (this.spriteNum == 2) {
                    image = this.up2;
                }
                break;
            case "down":
                if (this.spriteNum == 1) {
                    image = this.down1;
                }

                if (this.spriteNum == 2) {
                    image = this.down2;
                }
                break;
            case "left":
                if (this.spriteNum == 1) {
                    image = this.left1;
                }

                if (this.spriteNum == 2) {
                    image = this.left2;
                }
                break;
            case "right":
                if (this.spriteNum == 1) {
                    image = this.right1;
                }

                if (this.spriteNum == 2) {
                    image = this.right2;
                }
        }

        int var10002 = this.screenX;
        int var10003 = this.screenY;
        this.gp.getClass();
        this.gp.getClass();
        g2.drawImage(image, var10002, var10003, 48, 48, (ImageObserver)null);
    }
}
