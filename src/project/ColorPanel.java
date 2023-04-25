package project;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Hashtable;

public class ColorPanel extends JPanel {
    private int wavelength = 400;
    private JLabel colorLabel;

    public ColorPanel() {
        // Set panel size
        setPreferredSize(new Dimension(400, 350));

        // Create wavelength slider
        JSlider wavelengthSlider = new JSlider(JSlider.HORIZONTAL, 400, 780, wavelength);
        wavelengthSlider.setMajorTickSpacing(50);
        wavelengthSlider.setMinorTickSpacing(10);
        wavelengthSlider.setPaintTicks(true);
        wavelengthSlider.setPaintLabels(true);
        wavelengthSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                wavelength = wavelengthSlider.getValue();
                repaint();
            }
        });

        // Add a colored tick to the slider
        wavelengthSlider.setLabelTable(wavelengthSlider.createStandardLabels(50));
        wavelengthSlider.setPaintLabels(true);
        Hashtable<Integer, JLabel> labels = new Hashtable<Integer, JLabel>();
        labels.put(400, new JLabel("400"));
        labels.put(450, new JLabel("|"));
        labels.put(500, new JLabel("|"));
        labels.put(550, new JLabel("|"));
        labels.put(600, new JLabel("|"));
        labels.put(650, new JLabel("|"));
        labels.put(700, new JLabel("|"));
        labels.put(750, new JLabel("|"));
        labels.put(780, new JLabel("780"));
        wavelengthSlider.setLabelTable(labels);

        // Add a label to show the current color being selected
//        colorLabel = new JLabel(getColorNameForWavelength(wavelength));
//        colorLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        add(colorLabel);

        add(wavelengthSlider);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw gradient
        int x = 0;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        while (x < getWidth()) {
            Color color = getColorForWavelength(wavelength);
            g2d.setColor(color);
            g2d.drawLine(x, 0, x, getHeight());
            wavelength++;
            if (wavelength > 780) {
                wavelength = 400;
            }
            x++;
        }
    }

    private Color getColorForWavelength(int wavelength) {
        int red, green, blue;
        if (wavelength >= 400 && wavelength < 440) {
            red = (int) ((440 - wavelength) * 255 / 40);
            green = 0;
            blue = 255;
        } else if (wavelength >= 440 && wavelength < 490) {
            red = 0;
            green = (int) ((wavelength - 440) * 255 / 50);
            blue = 255;
        } else if (wavelength >= 490 && wavelength < 510) {
            red = 0;
            green = 255;
            blue = (int) ((510 - wavelength) * 255 / 20);
        } else if (wavelength >= 510 && wavelength < 580) {
            red = (int) ((wavelength - 510) * 255 / 70);
            green = 255;
            blue = 0;
        } else if (wavelength >= 580 && wavelength < 645) {
            red = 255;
            green = (int) ((645 - wavelength) * 255 / 65);
            blue = 0;
        } else if (wavelength >= 645 && wavelength < 780) {
            red = 255;
            green = 0;
            blue = 0;
        } else {
            red = 0;
            green = 0;
            blue = 0;
        }

        return new Color(red, green, blue);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ColorPanel());
        frame.pack();
        frame.setVisible(true);
    }
}




