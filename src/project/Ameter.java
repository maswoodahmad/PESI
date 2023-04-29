package project;

import javax.swing.*;
import java.awt.*;

public class Ameter {

    static JLabel ameter = new JLabel("0.0 mA",SwingConstants.CENTER);
   public JLabel aM(){


ameter.setOpaque(true);
       ameter.setBounds(550, 555, 100,30);
       ameter.setBackground(Color.WHITE);
       ameter.setBorder(BorderFactory.createEtchedBorder());
       return ameter;


   }
   public   void currentChanger(double  current){

       //current = Math.round(current);
       System.out.println("current"+ current);
       ameter.setText(String.valueOf(current).substring(0,2)+"mA");
   }
}


