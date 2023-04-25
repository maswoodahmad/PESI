package project;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;

public class BallSliderUI extends BasicSliderUI {
    private final int diameter;

    public BallSliderUI(JSlider slider, int diameter) {
        super(slider);
        this.diameter = diameter;
    }

    @Override
    protected Dimension getThumbSize() {
        return new Dimension(diameter, diameter);
    }

    @Override
    public void paintThumb(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int x = thumbRect.x + diameter / 2 - 1;
        int y = thumbRect.y + diameter / 2 - 1;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(slider.getBackground());
        g2d.fillOval(x, y, diameter, diameter);
        g2d.setColor(slider.getForeground());
        g2d.drawOval(x, y, diameter, diameter);
    }
}
