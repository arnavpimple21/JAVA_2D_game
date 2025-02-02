//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package object;

import main.GamePannel;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX;
    public int worldY;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    public SuperObject() {
    }

    public void draw(Graphics2D g2, GamePannel gp) {
        int screenX = this.worldX - gp.player.worldX + gp.player.screenX;
        int screenY = this.worldY - gp.player.worldY + gp.player.screenY;
        int var10000 = this.worldX;
        gp.getClass();
        if (var10000 + 48 > gp.player.worldX - gp.player.screenX) {
            var10000 = this.worldX;
            gp.getClass();
            if (var10000 - 48 < gp.player.worldX + gp.player.screenX) {
                var10000 = this.worldY;
                gp.getClass();
                if (var10000 + 48 > gp.player.worldY - gp.player.screenY) {
                    var10000 = this.worldY;
                    gp.getClass();
                    if (var10000 - 48 < gp.player.worldY + gp.player.screenY) {
                        BufferedImage var10001 = this.image;
                        gp.getClass();
                        gp.getClass();
                        g2.drawImage(var10001, screenX, screenY, 48, 48, (ImageObserver)null);
                    }
                }
            }
        }

    }
}
