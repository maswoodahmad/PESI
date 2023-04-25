package project;

import javax.swing.*;
import java.awt.*;

public class CustomSeekBar extends JComponent {
    private int value;
    private Color backgroundColor = Color.LIGHT_GRAY;
    private Color foregroundColor = Color.BLUE;
    private Color tickColor = Color.BLACK;
    private Font tickFont = new Font("Arial", Font.PLAIN, 12);
    private int tickWidth = 10;
    private int tickHeight = 20;

    public CustomSeekBar() {
        this.setPreferredSize(new Dimension(200, 50));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw background
        g2d.setColor(backgroundColor);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Draw foreground
        int foregroundWidth = (int) (getWidth() * (value / 100.0));
        g2d.setColor(foregroundColor);
        g2d.fillRect(0, 0, foregroundWidth, getHeight());

        // Draw ticks
        g2d.setColor(tickColor);
        g2d.setFont(tickFont);
        for (int i = 0; i <= 100; i += 10) {
            int tickX = (int) ((i / 100.0) * getWidth());
            int tickY = getHeight() - tickHeight;
            g2d.fillRect(tickX - tickWidth / 2, tickY, tickWidth, tickHeight);
            g2d.drawString(String.valueOf(i), tickX - tickWidth / 2, tickY - 5);
        }
    }

    public void setValue(int value) {
        this.value = value;
        repaint();
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        repaint();
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
        repaint();
    }

    public void setTickColor(Color tickColor) {
        this.tickColor = tickColor;
        repaint();
    }

    public void setTickFont(Font tickFont) {
        this.tickFont = tickFont;
        repaint();
    }

    public void setTickWidth(int tickWidth) {
        this.tickWidth = tickWidth;
        repaint();
    }

    public void setTickHeight(int tickHeight) {
        this.tickHeight = tickHeight;
        repaint();
    }

    public static void main(String[] args) {
        CustomSeekBar seekBar = new CustomSeekBar();
        JFrame frame = new JFrame();
        seekBar.setValue(50);
        seekBar.setBackgroundColor(Color.WHITE);
//        seekBar.setForegroundColor(Color.GREEN);
        seekBar.setTickColor(Color.RED);
        seekBar.setTickFont(new

                Font("Arial",Font.BOLD, 14));
        seekBar.setTickWidth(20);
        seekBar.setTickHeight(30);
        frame.getContentPane().add(seekBar);
frame.setSize(new Dimension(200,200));
                frame.setVisible(true);

    }


}