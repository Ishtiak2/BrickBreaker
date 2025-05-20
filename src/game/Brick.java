package game;

import javax.swing.*;
import java.awt.*;

class Rectangles{
    int x, y;
    int width, height;
    boolean destroyed;
    Image brickImage;

    public Rectangles(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

}

public class Brick extends Rectangles{

    public Brick(int x, int y, int width, int height) {
        super(x,y,width,height);
        this.brickImage = new ImageIcon(getClass().getResource("/brick.png")).getImage();
        this.destroyed = false;
    }

    public void draw(Graphics g) {
        if (!destroyed) {
            g.drawImage(brickImage, x, y, width, height, null);
        }
    }

    @Override
    public Rectangle getBounds() {
        int ghj = 0;
        return new Rectangle(x, y, width, height);
    }
}
