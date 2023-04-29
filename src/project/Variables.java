package project;

import javax.swing.*;
import java.util.ArrayList;

public class Variables {
    public static final int PANEL_WIDTH = 1000;
    public static final int PANEL_HEIGHT = 1000;



    public  static  double intensity=0.5;
    public static int wavelength=440;
    static public ImageIcon image;
    static  public  String metal="Sodium";
    public static  boolean isStart=false;
    public  static double data[]= new double[4];
    public static ArrayList<ArrayList<String>> arrayD = new ArrayList<>();
    static   public   ImageIcon battery;
    static JLabel beamLabel;
    static  JLabel voltageMeter;
    public static JLabel batteryLabel;
    public static JLayeredPane layeredPane=layeredPane = new JLayeredPane();
    public static  ImageIcon batteryIcon=new ImageIcon("src/project/battery.png");
    public  static  ImageIcon startIcon = new ImageIcon("src/project/start.png");
    public  static ImageIcon stopIcon=new ImageIcon("src/project/stop.png");

}
