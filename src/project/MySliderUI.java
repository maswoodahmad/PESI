package project;//package project;
//
//import javax.swing.*;
//import javax.swing.plaf.basic.BasicSliderUI;
//import java.awt.*;
//import java.awt.geom.Point2D;
//import java.util.Arrays;
//
////slider.setUI(new MySliderUI(slider));
////
//
//
//
//
//
//    public class MySliderUI extends JPanel {
//        private static final int WIDTH = 425;
//        private static final int HEIGHT = 100;
//        private static final int NUM_PARTS = 425;
//JPanel jp=new JPanel() ;
//        public void paintComponent(Graphics g) {
//            super.paintComponent(g);
//
//            int partWidth = WIDTH / NUM_PARTS;
//
//            for (int i = 0; i < 425; i++) {
//                double[] col = ColorConvertor.WavelengthtoColor(i * 2 + 100);
//                int red = (int) col[0];
//                System.out.println(Arrays.toString(col));
////           (int) (255 * ((double) i / NUM_PARTS));
//                int green = (int) col[1];
//                int blue = (int) col[2];
//
//                Color color = new Color(red, green, blue);
//
//                g.setColor(color);
//                g.fillRect((i * partWidth), 0, partWidth, 40);
//
//            }
//        }
//        jp.add()
//    }
//
//
//
//
//