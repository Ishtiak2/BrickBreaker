package game;

import java.awt.*;
import javax.swing.*;

public class Ball {
    int x, y;
    int diameter = 20;
    int dx = 3;
    int dy = -4;
    Image ballImage;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;

        ballImage = new ImageIcon(getClass().getResource("/ball.png")).getImage();
    }

    public void draw(Graphics g) {
        g.drawImage(ballImage, x, y, diameter, diameter, null);
    }

    public void move() {
        x += dx;
        y += dy;

        if (x <= 0 || x + diameter >= 800) dx = -dx;
        if (y <= 0) dy = -dy;
    }

    public void checkCollision(Paddle paddle, BrickManager brickManager) {
        Rectangle ballRect = new Rectangle(x, y, diameter, diameter);
        Rectangle paddleRect = new Rectangle(paddle.x, paddle.y, paddle.width, paddle.height);

        if (ballRect.intersects(paddleRect)) {
            dy = -dy;
            y = paddle.y - diameter;
        }

        brickManager.checkBrickCollision(this);
    }
}
