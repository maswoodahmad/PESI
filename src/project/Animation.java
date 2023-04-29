package project;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Animation extends JPanel {
    private int numBalls;
    private int ballSpeed;
    private int startX;
    private int endX;
    private List<Ball> balls;

    public Animation(int numBalls, int ballSpeed, int startX, int endX) {
        this.numBalls = numBalls;
        this.ballSpeed = ballSpeed;
        this.startX = startX;
        this.endX = endX;
        balls = new ArrayList<>();
        generateBalls();
    }

    private void generateBalls() {
        for (int i = 0; i < numBalls; i++) {
            Ball ball = new Ball(
                    /* Random positions from startX to endX or windowHeight */
                    (int) Math.floor(Math.random() * (endX - startX)) + startX,
                    (int) Math.floor(Math.random() * getHeight()),
                    /* Random size from 10 to 30 */
                    (int) Math.floor(Math.random() * 10) + 10,
                    /* Random RGB colors*/
                    new Color(
                            (int) Math.floor((Math.random() * 256)),
                            (int) Math.floor((Math.random() * 256)),
                            (int) Math.floor((Math.random() * 256))
                    ),
                    /* Constant velocity in the x-direction */
                    ballSpeed,
                    0
            );

            balls.add(ball);
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (Ball b: balls) {
            b.draw(graphics);
        }
    }

    public void updateBalls() {
        for (Ball b: balls) {
            b.update();
        }
    }

    public void setNumBalls(int numBalls) {
        this.numBalls = numBalls;
        generateBalls();
    }

    public void setBallSpeed(int ballSpeed) {
        this.ballSpeed = ballSpeed;
        for (Ball b: balls) {
            b.setVx(ballSpeed);
        }
    }

    public void setStartX(int startX) {
        this.startX = startX;
        generateBalls();
    }

    public void setEndX(int endX) {
        this.endX = endX;
        generateBalls();
    }

    class Ball {
        private int posX, posY, size;
        private Color color;
        private int vx, vy;

        public Ball(int posX, int posY, int size, Color color, int vx, int vy) {
            this.posX = posX;
            this.posY = posY;
            this.size = size;
            this.color = color;
            this.vx = vx;
            this.vy = vy;
        }

        void update() {
            posX += vx;
            if (posX > endX) {
                posX = startX;
            }
        }

        void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(posX, posY, size, size);
        }

        public void setVx(int vx) {
            this.vx = vx;
        }
    }
}
