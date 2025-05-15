package game;

import javax.swing.*;
import java.awt.*;

public class Brick {
    int x, y;
    int width, height;
    boolean destroyed;
    Image brickImage;

    public Brick(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.destroyed = false;

        brickImage = new ImageIcon(getClass().getResource("/brick.png")).getImage();
    }

    public void draw(Graphics g) {
        if (!destroyed) {
            g.drawImage(brickImage, x, y, width, height, null);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
