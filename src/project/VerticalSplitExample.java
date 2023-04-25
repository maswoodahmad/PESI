package project;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VerticalSplitExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Vertical Split Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create two panels
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        // Create a JSplitPane
        Border border = BorderFactory.createLineBorder(Color.BLACK);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                topPanel, bottomPanel);
        splitPane.setBorder(border);
        splitPane.setDividerLocation(700); // Set the initial divider location

        // Set the preferred size of the JSplitPane
        splitPane.setPreferredSize(new Dimension(500, 400));

        // Add the JSplitPane to the JFrame
        frame.add(splitPane);

        // Display the JFrame
        frame.pack();
        frame.setVisible(true);
    }
}
