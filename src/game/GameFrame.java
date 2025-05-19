package game;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("Brick Breaker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit on the close button
        add(new GamePanel());
        pack(); // fit the size of the game panel
        setLocationRelativeTo(null); //centers the window
        setVisible(true);
    }
}
