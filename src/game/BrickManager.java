package game;

import java.awt.*;
import java.util.ArrayList;

public class BrickManager {
    ArrayList<Brick> bricks;

    public BrickManager() {
        bricks = new ArrayList<>();

        int brickWidth = 60;
        int brickHeight = 20;
        int panelWidth = 800;

        int topY = 50;
        for (int x = 50; x + brickWidth <= panelWidth - 50; x += brickWidth + 10) {
            bricks.add(new Brick(x, topY, brickWidth, brickHeight));
        }

        int middleX = panelWidth / 2 - brickWidth / 2;
        for (int y = topY + brickHeight + 10; y <= topY + 4 * (brickHeight + 10); y += brickHeight + 10) {
            bricks.add(new Brick(middleX, y, brickWidth, brickHeight));
        }

        int bottomY = topY + 5 * (brickHeight + 10);
        for (int x = 50; x + brickWidth <= panelWidth - 50; x += brickWidth + 10) {
            bricks.add(new Brick(x, bottomY, brickWidth, brickHeight));
        }
    }

    public void draw(Graphics g) {
        for (Brick brick : bricks) {
            brick.draw(g);
        }
    }
    public void checkBrickCollision(Ball ball) {
        Rectangle ballRect = new Rectangle(ball.x, ball.y, ball.diameter, ball.diameter);

        for (Brick brick : bricks) {
            if (!brick.destroyed && ballRect.intersects(brick.getBounds())) {
                brick.destroyed = true;
                ball.dy = -ball.dy;
                SoundPlayer.playSound("hit.wav");
                break;
            }
        }
    }

    public boolean allBricksDestroyed() {
        for (Brick b : bricks) {
            if (!b.destroyed) return false;
        }
        return true;
    }

    public int getDestroyedCount() {
        int count = 0;
        for (Brick b : bricks) {
            if (b.destroyed) count++;
        }
        return count;
    }
}
