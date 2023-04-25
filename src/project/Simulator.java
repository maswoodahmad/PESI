package project;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;

public class Simulator {



    public static class ImagePanelDemo extends JPanel {

        public static final int PANEL_WIDTH = 1000;
        public static final int PANEL_HEIGHT = 1000;
        


public  static  double intensity=0.5;
public static int wavelength=440;
       static public ImageIcon image;
      static   public   ImageIcon battery;
        static JLabel beamLabel;
        static  JLabel voltageMeter;
        public static JLabel batteryLabel;
        public static JLayeredPane layeredPane;
        public static  ImageIcon batteryIcon=new ImageIcon("/Users/maswoodahmad/Downloads/battery.png");
static public ImageIcon bulb;
//        public ImagePanelDemo() {
//            battery = new ImageIcon("/Users/maswoodahmad/Downloads/pngwing.com.png");
//            image= new ImageIcon("/Users/maswoodahmad/Downloads/Untitled design.png");
//            setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
//            JLayeredPane layeredPane = new JLayeredPane();
//            layeredPane.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
//            JLabel manLabel = new JLabel(image);
//            manLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
//            layeredPane.add(manLabel, 0);
//
//
//            JLabel hatLabel = new JLabel(battery);
//            hatLabel.setBounds(300, 200, battery.getIconWidth(), battery.getIconHeight());
//            layeredPane.add(hatLabel,1);
//            // load the image
//
//        }
        public  static void updateLabelState(int wave,double intensity) throws IOException {
            Bulb bulb1 = new Bulb();
            Image img = bulb1.beamImage(wave,intensity);
            beamLabel.setIcon(new ImageIcon(img));
        }
        public  static void updateVoltageState(float val){
            voltageMeter.setText(Float.toString(val));
            
        }
public static void flipBattery(){
 batteryIcon = new ImageIcon("/Users/maswoodahmad/Downloads/reversedBattery.png");

    batteryLabel.setIcon(batteryIcon );
}
public static void flipBatteryR(){
    batteryIcon = new ImageIcon("/Users/maswoodahmad/Downloads/battery.png");
    batteryLabel.setIcon(batteryIcon );
}



        public static void main(String[] args) throws IOException {
//            JFrame frame = new JFrame("Image Panel Demo");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.getContentPane().add(new ImagePanelDemo());
//            frame.pack();
//            frame.setLocationRelativeTo(null);
//            frame.setVisible(true);
            battery = batteryIcon;
            image= new ImageIcon("/Users/maswoodahmad/Downloads/Untitled_design-removebg-preview.png");
            bulb = new ImageIcon("/Users/maswoodahmad/Downloads/bulb3.png");
             layeredPane = new JLayeredPane();
            layeredPane.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            layeredPane.setBorder(border);
             batteryLabel = new JLabel(battery);
            batteryLabel.setBounds(379, 540, battery.getIconWidth(), battery.getIconHeight());
            layeredPane.add(batteryLabel, 0);
         Bulb bulb1 = new Bulb();

JLabel bulbLabel =new JLabel(bulb);
bulbLabel.setBounds(350,0, bulb.getIconWidth(),bulb.getIconHeight());
layeredPane.add(bulbLabel,JLayeredPane.PALETTE_LAYER);

            SeekBar sk = new SeekBar();


 beamLabel = new JLabel(new ImageIcon(bulb1.beamImage(wavelength, intensity)));
beamLabel.setOpaque(false);

beamLabel.setBounds(240,90, new ImageIcon(bulb1.beamImage(530,0.3)).getIconWidth(), new ImageIcon(bulb1.beamImage(430,0.3)).getIconHeight());
layeredPane.add(beamLabel,3);
JLabel voltageLabel = new JLabel("Voltmeter");
//voltageLabel.setBorder(BorderFactory.createEtchedBorder());
voltageLabel.setBounds(230,430, 150, 50);
layeredPane.add(voltageLabel);
Voltmer voltmer = new Voltmer();
JSlider vol = voltmer.voltageSlider();
vol.setBounds(200, 470, 150,70);
vol.setOpaque(false);
vol.setBorder(BorderFactory.createEtchedBorder());
vol.setFont(new Font("Arial", Font.BOLD, 14));
layeredPane.add(vol,BorderLayout.CENTER,5);

JSlider inSeekbar= sk.intensitySeekBar();

JPanel controlPanel = new JPanel(){
    protected void paintComponent(Graphics g) {
                super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int w = getWidth();
        int h = getHeight();

        // Create a gradient from black to transparent
        GradientPaint gradient = new GradientPaint(0, 0, new Color(18,18,18), 0, h, new Color(40, 40, 40, 0));

        // Fill the background with the gradient
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, w, h);

        g2d.dispose();
    }
};





controlPanel.setBorder(BorderFactory.createEtchedBorder());

controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
//controlPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
controlPanel.add(Box.createVerticalGlue());
JLabel wavel= new JLabel("Wavelength (nm)");
wavel.setFont(new Font("Arial", Font.BOLD, 18));
wavel.setForeground(new Color(255,255,240));
controlPanel.add(wavel);
controlPanel.add(new JLabel());

controlPanel.add(sk.waveSeekBar());
//controlPanel.setBackground(Color.CYAN);
//controlPanel.add(Box.createVerticalStrut(10));
JLabel inte= new JLabel("Intensity (%)");
inte.setFont(new Font("Arial", Font.BOLD, 18));
controlPanel.add(inte);
controlPanel.add(inSeekbar);
String[] values = new String[50];
values[0]="Enter the area of PS Mat.";
for (int i = 1; i < 50; i++) {
    values[i] = String.valueOf(i + 1);
}
JComboBox<String> areaComboBox = new JComboBox<>(values);
areaComboBox.setEditable(true);

JComboBox<String> unitComboBox = new JComboBox<>(new String[] {"mm", "cm", "m"});
controlPanel.add(areaComboBox);
controlPanel.add(unitComboBox);

controlPanel.setBounds(680,40, 300, 300);
layeredPane.add(controlPanel,4);
voltageMeter = new JLabel("0.0");
voltageMeter.setBounds(420, 470,50,50);
voltageMeter.setFont(new Font("Arial",1, 18));
layeredPane.add(voltageMeter);

            JLabel mainLabel = new JLabel(image);
            mainLabel.setBounds(80, 175, image.getIconWidth(), image.getIconHeight());
            layeredPane.add(mainLabel,JLayeredPane.DEFAULT_LAYER);
            JPanel grapha= new JPanel();
            grapha.setBounds(600,0,400,1000);
            grapha.add(new JButton("this"));

            JFrame frame = new JFrame("Photoelectric Effect Simulator");
            frame.setLayout(new BorderLayout());
            frame.setSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(layeredPane,BorderLayout.WEST);
            frame.add(grapha,BorderLayout.EAST);
            frame.pack();
            frame.setVisible(true);
        }
    }

}
