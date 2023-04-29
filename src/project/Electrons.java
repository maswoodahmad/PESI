//package project;
//
//import java.awt.*;
//
//public class Electrons {
//
//    float x;
//float y;
//  float speed;
// float direction;
//
//    public  Electrons(float x , float y, float speed, float direction)
//{
//    this.x=x;
//    this.y=y;
//    this.speed=speed;
//    this.direction=direction;
//
//}
//
//    public void move() {
//        x += speed * Math.cos(Math.toRadians(direction)); // Move the ball along the x-axis
//        if (x < 0) { // Reverse direction if the ball goes off the left edge of the screen
//            x = 0;
//            direction = 360 - direction;
//        } else if (x > ElectronAnimation.WIDTH) { // Reverse direction if the ball goes off the right edge of the screen
//            x = ElectronAnimation.WIDTH;
//            direction = 360 - direction;
//        }
//    }
//
//    public void draw(Graphics g) {
//        g.setColor(Color.BLACK);
//        g.fillOval((int) x - 10, (int) y - 10, 20, 20); // Draw the ball on the screen
//    }
//public void ballCreated()
//{
//    System.out.println("crea4ed");
//}
//
//
//
//
//
//}
//
