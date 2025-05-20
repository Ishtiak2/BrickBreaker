package game;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle {
    int x, y;
    int width = 100;
    int height = 10;
    int speed = 7;
    int dx = 0;

    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public void move() {
        x += dx;

        if (x < 0) x = 0;
        if (x + width > 800) x = 800 - width;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            dx = -speed;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dx = speed;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            dx = 0;
        }
    }
}
