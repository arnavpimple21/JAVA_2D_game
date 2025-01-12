package main;
import javax.swing.*;
public class game {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setTitle("2D Adventure");

        // Correct the typo in GamePanel
        GamePannel gamePannel = new GamePannel();
        window.add(gamePannel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure proper termination
        window.setVisible(true); // Set visibility to true
        gamePannel.startGameThread();


    }
}

