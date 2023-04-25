package project;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        super("My Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000,1000));
        // create layered pane
        JLayeredPane layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        
        // create lamp component
        JComponent lamp = new MyLamp();
        lamp.setBounds(50, 50, 100, 100);
        layeredPane.add(lamp, JLayeredPane.DEFAULT_LAYER);
        
        // create metal surface component
        JComponent metalSurface = new MyMetalSurface();
        metalSurface.setBounds(200, 200, 400, 400);
        layeredPane.add(metalSurface, JLayeredPane.DEFAULT_LAYER);
        
        pack();
        setVisible(true);
    }

    private class MyLamp extends JComponent {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            // draw lamp shape
            g.setColor(Color.YELLOW);
            g.fillOval(0, 0, getWidth(), getHeight());
        }
    }
    
    private class MyMetalSurface extends JPanel {
        private double voltage = 0;
        
        public MyMetalSurface() {
            setOpaque(false);
        }
        
        public void setVoltage(double voltage) {
            this.voltage = voltage;
            repaint();
        }
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            // create gradient paint with color based on voltage level
            Color color1 = Color.BLUE;
            Color color2 = Color.RED;
            Color color = new Color(
                    (int) (color1.getRed() + voltage * (color2.getRed() - color1.getRed())),
                    (int) (color1.getGreen() + voltage * (color2.getGreen() - color1.getGreen())),
                    (int) (color1.getBlue() + voltage * (color2.getBlue() - color1.getBlue()))
            );
            Point startPoint = new Point(0, getHeight() / 2);
            Point endPoint = new Point(getWidth(), getHeight() / 2);
            GradientPaint gradient = new GradientPaint(startPoint, color, endPoint, color2);
            
            // draw beam of light as gradient
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setPaint(gradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.dispose();
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }

}
