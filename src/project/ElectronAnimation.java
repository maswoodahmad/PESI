package project;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class ElectronAnimation extends JPanel implements ActionListener {

    private ArrayList<Ball> balls = new ArrayList<>(); // List of balls
    private Timer timer; // Animation timer

    public ElectronAnimation() {
        add(new JLabel("nallss"));
        timer = new Timer(10, this); // Create a new timer with a 10ms delay and this object as the ActionListener
        timer.start(); // Start the timer
    }

    public void actionPerformed(ActionEvent e) {
        for (Ball ball : balls) {
            ball.move(); // Move the ball
        }
        repaint(); // Redraw the screen
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls) {
            ball.draw(g); // Draw each ball on the screen
        }
    }

    public Ball createBall(float speed, boolean moveRight, Color color, int maxBalls) {
        if (balls.size() >= maxBalls) {
            return null; // Return null if the maximum number of balls has been reached
        }
        float x = moveRight ? 0 : 300; // Set the x position based on the moveRight parameter
        float y = (float) (Math.random() * 300);
        float direction = moveRight ? 0 : 180; // Set the direction based on the moveRight parameter
        Ball ball = new Ball(x, y, speed, direction, color);
        balls.add(ball);
        return ball;
    }


}

class Ball {
    private float x, y, speed, direction;
    private Color color;

    public Ball(float x, float y, float speed, float direction, Color color) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
        this.color = color;
    }

    public void move() {
        x += speed * Math.cos(Math.toRadians(direction)); // Move the ball along the x-axis
        if (x < 0) { // Reverse direction if the ball goes off the left edge of the screen
            x = 0;
            direction = 360 - direction;
        } else if (x >  300) { // Reverse direction if the ball goes off the right edge of the screen
            x =  300;
            direction = 360 - direction;
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int) x - 10, (int) y - 10, 20, 20); // Draw the ball on the screen
    }
}
