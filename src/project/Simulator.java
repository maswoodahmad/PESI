package project;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import java.util.Arrays;


import static project.ArrayToCSV.dataAdder;
import static project.PhotoelectricEffectLogic.*;
import static project.PhotoelectricEffectLogic.intensity;
import static project.PhotoelectricEffectLogic.wavelength;
import static project.Variables.*;
import static project.WorkFunction.metals;

public class Simulator {
    public static class PHET {

static  public double [] dataD ={0,0,0,0,0};
static public ImageIcon bulb;


        private  static void removeAnimation(Animation animation, JLayeredPane panel) {
            panel.remove(animation);
            panel.revalidate();
            panel.repaint();
        }

        public  static void updateLabelState(int wave,double intensity) throws IOException {
            Bulb bulb1 = new Bulb();
            Image img = bulb1.beamImage(wave,intensity);
            beamLabel.setIcon(new ImageIcon(img));
        }
        public static  void dataFetcher()
        {
           dataD = photoelectricCurrent(wavelength,intensity,voltage,workFunctioOfMetal);
            System.out.println(Arrays.toString(dataD));

        }



        public  static void updateVoltageState(double val){
            voltageMeter.setText(Double.toString(val));
            
        }
        public static void updateCurrent(double curr,JLabel j){
            j.setText(Double.toString(curr));

        }
public static void flipBattery(){
 batteryIcon = new ImageIcon("src/project/reversedBattery.png");

    batteryLabel.setIcon(batteryIcon );
}
public static void flipBatteryR(){
    batteryIcon = new ImageIcon("src/project/battery.png");
    batteryLabel.setIcon(batteryIcon );
}


public static void main(String[] args) throws IOException {

            battery = batteryIcon;
            image= new ImageIcon("src/project/mainbg.png");
            bulb = new ImageIcon("src/project/bulb3.png");


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

            System.out.println("voltage"+ voltage);



controlPanel.setBorder(BorderFactory.createEtchedBorder());

controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
//controlPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
controlPanel.add(Box.createVerticalGlue());
JLabel wavel= new JLabel("Wavelength (nm)",0);
wavel.setFont(new Font("Arial", Font.BOLD, 18));
wavel.setForeground(new Color(255,255,240));
controlPanel.add(wavel);
controlPanel.add(new JLabel());

controlPanel.add(sk.waveSeekBar());
//controlPanel.setBackground(Color.CYAN);
//controlPanel.add(Box.createVerticalStrut(10));
JLabel inte= new JLabel("Intensity (%)",0);
inte.setFont(new Font("Arial", Font.BOLD, 18));
controlPanel.add(inte);
controlPanel.add(inSeekbar);


WorkFunction wf = new WorkFunction();
JComboBox wfb = wf.workFunction();


controlPanel.setBounds(680,40, 300, 300);
layeredPane.add(controlPanel,4);
voltageMeter = new JLabel(String.valueOf(voltage));
voltageMeter.setBounds(420, 470,50,50);
voltageMeter.setFont(new Font("Arial",1, 18));
layeredPane.add(voltageMeter);
            JToggleButton startButton = new JToggleButton(startIcon);
            startButton.setBounds(300, 700, 120,60);
            startButton.setOpaque(true);
            startButton.setBorderPainted(false);
            startButton.setFocusPainted(false);
            startButton.setBackground(new Color(245,203,69));
            Ameter am = new Ameter();
            JLabel ameter = am.aM();
            layeredPane.add(ameter);


            Animation ballPanel = new Animation(0, 0, 0, 300);

            ballPanel.setBallSpeed(3);
            ballPanel.setNumBalls(5);
            ballPanel.repaint();
            ballPanel.setOpaque(false);
            ballPanel.setBounds(250, 350, 700, 700);
           layeredPane.add(ballPanel);

            Timer timer = new Timer(16, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ballPanel.updateBalls();
                    ballPanel.repaint();
                }
            });

startButton.addActionListener(new ActionListener(){

    @Override
    public void actionPerformed(ActionEvent e) {






        if(startButton.isSelected()){
            System.out.println("selecterd");
            startButton.setOpaque(true);
            startButton.setBorderPainted(false);
            startButton.setFocusPainted(false);
            startButton.setBackground(new Color(77,157,146));
            startButton.setIcon(stopIcon);
            PhotoelectricEffectLogic lg= new PhotoelectricEffectLogic();
            lg.setIntensity(intensity);
            lg.setVoltage(voltage);
            dataFetcher();
            ballPanel.repaint();
            timer.start();


            System.out.println(Arrays.toString(dataD));
            System.out.println("in button");
            lg.setWorkF(workFunctioOfMetal);
            double curr2= lg.photoelectricCurrent(wavelength,intensity,voltage,workFunctioOfMetal)[0];
            System.out.println(curr2+" in button");
            System.out.println(curr2 + "there");
            ElectronEmission ee= new ElectronEmission();
           double curr =  ee.startEmission(wavelength);
            System.out.println(curr);
            ameter.setText(Double.toString(curr2)+"\t"+"mA");
            System.out.println(wavelength);

            isStart=true;

        }else{

            startButton.setIcon(startIcon);
            startButton.setFocusPainted(false);
            startButton.setOpaque(true);
            startButton.setBorderPainted(false);
            startButton.setBackground(new Color(245,203,69));
            System.out.println("not selected");
            timer.stop();


        }
    }
});

layeredPane.add(startButton);

//metal
JLabel metalName = new JLabel("Choose the Metal",0);
//metalName.setBounds( 700, 350, 200, 100);
controlPanel.add(metalName);

WorkFunction workfuncion = new WorkFunction();

    JComboBox<String> workF= workfuncion.workFunction();

    controlPanel.add(workF);
workF.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String metalName = (String)workF.getSelectedItem();
        System.out.println(metalName);
        int index = workF.getSelectedIndex();
        PhotoelectricEffectLogic lg = new PhotoelectricEffectLogic();
        lg.setWorkF(Double.parseDouble(metals[index][1]));
        lg.upDateValues(wavelength,workFunctioOfMetal,intensity,voltage);
        metal=metals[index][0];
       double curr =  photoelectricCurrent(wavelength,intensity,voltage,workFunctioOfMetal)[0];
        System.out.println("crr in wffg    "+ curr);
       Ameter am = new Ameter();
       updateCurrent(curr,am.aM());
        dataFetcher();
       double ene =photoelectricCurrent(wavelength,intensity,voltage, Double.parseDouble(metals[index][1]))[4];
        dataAdder(metal,Double.toString(workFunctioOfMetal),Double.toString(ene),Double.toString(voltage),
                Double.toString(curr),Double.toString(intensity));
    }
});
// end
//
PhotoelectricEffectLogic  lg = new PhotoelectricEffectLogic();
double[] data = photoelectricCurrent(wavelength,intensity,voltage,workFunctioOfMetal);
 int numofballs = (int) (data[3]/1.6e+18);
 int speed = (int) data[2]/1000;


            JLabel mainLabel = new JLabel(image);
            mainLabel.setBounds(80, 175, image.getIconWidth(), image.getIconHeight());
            layeredPane.add(mainLabel,JLayeredPane.DEFAULT_LAYER);
            JPanel grapha= new JPanel(new BorderLayout());
            SaveButton SB = new SaveButton();
            //panel.setBounds(600,0,400,1000);
            grapha.add(SB.saveButton());

            JFrame frame = new JFrame("Photoelectric Effect Simulator");
            frame.setTitle("Photoelectric Effect Simulator");
            frame.setLayout(new BorderLayout());
            frame.setSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(layeredPane,BorderLayout.WEST);
            frame.add(grapha,BorderLayout.EAST);
            FileChooser fc = new FileChooser();
            fc.createUI(grapha);
            JButton start = new JButton("Plot graph");
           start.setSize(new Dimension(50,50));
            grapha.add(start);
            start.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
              JFreeChartExample jf = new JFreeChartExample();
//                    jf.setBounds(700,200, 500,500);
                    grapha.add(jf,BorderLayout.SOUTH);
                    grapha.revalidate();
                    grapha.repaint();

                }
            });


            frame.pack();
            frame.setVisible(true);
        }
    }

}
