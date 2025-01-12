
package main;

import java.awt.Component;
import javax.swing.JFrame;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(3);
        window.setResizable(false);
        window.setTitle("2D Adventure");
        GamePannel gamePannel = new GamePannel();
        window.add(gamePannel);
        window.pack();
        window.setLocationRelativeTo((Component)null);
        window.setVisible(true);
        gamePannel.setupGame();
        gamePannel.startGameThread();
    }
}
