package game;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("Brick Breaker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(new GamePanel());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
