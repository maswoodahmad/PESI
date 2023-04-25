package project;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Hashtable;

import static project.Simulator.ImagePanelDemo.*;

public class Voltmer {
    float voltage;
    JButton increment ;
JSlider slider;
    JButton decrement;


        public  JSlider voltageSlider(){

             slider = new JSlider(-50, 50, 0);


           slider.setMinorTickSpacing(1);
            slider.setPaintTicks(true);
            slider.setPaintLabels(true);
            slider.setLabelTable(slider.createStandardLabels(10));
            slider.setForeground(Color.YELLOW);
            slider.setBackground(Color.blue);
            slider.setLabelTable(slider.createStandardLabels(1));
            Hashtable<Integer, JLabel> labelTable = new Hashtable<>();
            labelTable.put(-50, new JLabel("-5"));
            labelTable.put(0, new JLabel("0"));
            labelTable.put(50, new JLabel("5"));
            slider.setLabelTable(labelTable);
          slider.setFocusable(false);
            slider.setBorder(new LineBorder(Color.GRAY));
            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    JSlider sli =(JSlider) e.getSource();
                    float val = sli.getValue()/10;
                    voltage=val;
                    System.out.println(voltage);
                    updateVoltageState(val);
                    if( val<0){
                        System.out.println("here");
                        flipBattery();
                    }
                    if(val>=0){

                        flipBatteryR();
                    }


                }
            });


            return slider;
        }





}
