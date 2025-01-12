//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_Boots extends SuperObject {
    public OBJ_Boots() {
        this.name = "Boots";

        try {
            this.image = ImageIO.read(this.getClass().getResourceAsStream("/res/objects/boots.png"));
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }
}
