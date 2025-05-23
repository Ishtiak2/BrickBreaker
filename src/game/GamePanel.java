package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    final int WIDTH = 800, HEIGHT = 600;
    Timer timer;
    Paddle paddle;
    Ball ball;
    BrickManager brickManager;
    int score = 0;
    int lives = 3;
    boolean gameOver = false;
    boolean gameWon = false;
    Image background;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        addKeyListener(this);

        background = new ImageIcon(getClass().getResource("/background.png")).getImage();
        paddle = new Paddle(WIDTH / 2 - 50, HEIGHT - 40); // (350,560)
        ball = new Ball(WIDTH / 2 - 10, HEIGHT / 2); //(390,300)
        brickManager = new BrickManager();

        timer = new Timer(10, this); //used for auto calling methods
        timer.start();
    }

    @Override //overrides JPanels method
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);

        paddle.draw(g);
        ball.draw(g);
        brickManager.draw(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Score: " + score, 10, 20);
        g.drawString("Lives: " + lives, WIDTH - 100, 20);

        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.drawString("Game Over!", WIDTH / 2 - 100, HEIGHT / 2);
        }

        if (gameWon) {
            g.setColor(Color.GREEN);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.drawString("You Win!", WIDTH / 2 - 80, HEIGHT / 2);
        }
    }

    //It is called automatically after 10 ms
    public void actionPerformed(ActionEvent e) {
        if (!gameOver && !gameWon) {
            paddle.move();
            ball.move();
            ball.checkCollision(paddle, brickManager);

            if (ball.y > HEIGHT) {
                lives--;
                if (lives <= 0) {
                    gameOver = true;
                    repaint();
                    timer.stop();
                    exitAfterDelay();
                    return;
                } else {
                    ball = new Ball(WIDTH / 2 - 10, HEIGHT / 2);
                    paddle = new Paddle(WIDTH / 2 - 50, HEIGHT - 40);
                }
            }

            if (brickManager.allBricksDestroyed()) {
                gameWon = true;
                repaint();
                timer.stop();
                exitAfterDelay();
                return;
            }

            score = brickManager.getDestroyedCount() * 10;
        }

        repaint(); //auto call paintComponent() method
    }


    public void keyPressed(KeyEvent e) {
        paddle.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        paddle.keyReleased(e);
    }

    public void keyTyped(KeyEvent e) {
    }
    private void exitAfterDelay() {
        new Timer(3000, e -> System.exit(0)).start();
    }

}
