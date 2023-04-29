package project;


import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Hashtable;


import static project.ArrayToCSV.dataAdder;
import static project.PhotoelectricEffectLogic.*;
import static project.PhotoelectricEffectLogic.voltage;
import static project.Simulator.PHET.*;
import static project.Simulator.PHET.dataFetcher;
import static project.Variables.intensity;
import static project.Variables.*;
import static project.Variables.wavelength;
import static project.WorkFunction.metals;

public class Voltmer {
    float voltage= 1.0F;
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
                    PhotoelectricEffectLogic lg = new PhotoelectricEffectLogic();
                    lg.setVoltage(voltage);
//                    PhotoelectricEffectLogic lg= new PhotoelectricEffectLogic();
                    lg.setIntensity(intensity);
                    lg.setVoltage(voltage);
                    lg.setWorkF(workFunctioOfMetal);
                    dataFetcher();
                    System.out.println(Arrays.toString(dataD));
                    data= new double[]{lg.photoelectricCurrent(wavelength, intensity, voltage, workFunctioOfMetal)[0]};
                    updateVoltageState(voltage);
                    Ameter am = new Ameter();
                    am.aM().setText(String.valueOf(data[0]).substring(0,3)+"mA");
                    double curr =  photoelectricCurrent(PhotoelectricEffectLogic.wavelength, PhotoelectricEffectLogic.intensity,voltage,workFunctioOfMetal)[0];
                    double ene =photoelectricCurrent(PhotoelectricEffectLogic.wavelength, PhotoelectricEffectLogic.intensity,voltage,workFunctioOfMetal)[4];
                    dataAdder(metal,Double.toString(workFunctioOfMetal),Double.toString(ene),Double.toString(voltage),
                            Double.toString(curr),Double.toString(PhotoelectricEffectLogic.intensity));

                    System.out.println(data[0]+"curr in voltmewter");
                    if( val<0){

                        flipBattery();
                    }
                    if(val>=0){

                        flipBatteryR();
                    }
                    System.out.println("voltage"+ voltage);

                }
            });


            return slider;
        }





}
