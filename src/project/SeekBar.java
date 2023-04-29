package project;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.io.IOException;

import static project.ArrayToCSV.dataAdder;
import static project.JFreeChartExample.dataSeries;
import static project.PhotoelectricEffectLogic.*;
import static project.Simulator.PHET.dataFetcher;
import static project.Simulator.PHET.updateLabelState;
import static project.Variables.*;
import static project.Variables.wavelength;
import static project.WorkFunction.metals;

public class SeekBar {

     JSlider slider;
     JSlider inSlider;

    //public int waveL=440;
    public double intensity = 0.5;
    Bulb bulb = new Bulb();
    public JSlider waveSeekBar() {


        slider = new JSlider(400, 780, 440);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setPreferredSize(new Dimension( 120, 100 ));
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                int value = source.getValue();
                PhotoelectricEffectLogic lg = new PhotoelectricEffectLogic();
                lg.setWavelength(value);
                dataFetcher();

                Animation ballPanel = new Animation(0, 0, 0, 300);

                ballPanel.setBallSpeed(10);
                ballPanel.setNumBalls(6);
                ballPanel.repaint();


                double ene =photoelectricCurrent(PhotoelectricEffectLogic.wavelength, PhotoelectricEffectLogic.intensity,voltage,workFunctioOfMetal)[4];
                String va = Double.toString(ene).substring(0,2);
                dataSeries.add(value, Double.parseDouble(va));
                System.out.println(dataSeries);
                double curr =photoelectricCurrent(PhotoelectricEffectLogic.wavelength, PhotoelectricEffectLogic.intensity,voltage,workFunctioOfMetal)[0];
                dataAdder(metal,Double.toString(workFunctioOfMetal),Double.toString(ene),Double.toString(voltage),
                        Double.toString(curr),Double.toString(PhotoelectricEffectLogic.intensity));
                dataAdder(metal,Double.toString(workFunctioOfMetal),Double.toString(ene),Double.toString(voltage),
                        Double.toString(curr),Double.toString(PhotoelectricEffectLogic.intensity));
                try {
                    System.out.println("Wavelength"+ value);

                    lg.setWavelength(value);
                    updateLabelState(value,intensity);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
//                System.out.println(waveL);
            }
        });
        return slider;

    }

    public JSlider  intensitySeekBar(){
        inSlider = new JSlider(JSlider.HORIZONTAL,1,100,50 );
       inSlider.setMajorTickSpacing(10);
//        inSlider.setMinorTickSpacing(1);
        inSlider.setPaintTicks(true);
        inSlider.setPaintLabels(true);
        inSlider.setPreferredSize(new Dimension( 120, 100 ));
        inSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                double value = source.getValue()/100.00;
                dataFetcher();
                intensity=value;
                try {
                    PhotoelectricEffectLogic lg = new PhotoelectricEffectLogic();
                    lg.setIntensity(intensity);
                    System.out.println(wavelength+"sfjhbsdjfsd");
                    updateLabelState(wavelength,  intensity);
                    System.out.println("intesnity"+ value);
                    double curr= lg.photoelectricCurrent(wavelength,intensity,voltage,workFunctioOfMetal)[0];
                    double ene =photoelectricCurrent(PhotoelectricEffectLogic.wavelength, PhotoelectricEffectLogic.intensity,voltage,workFunctioOfMetal)[4];
                    dataAdder(metal,Double.toString(workFunctioOfMetal),Double.toString(ene),Double.toString(voltage),
                            Double.toString(curr),Double.toString(PhotoelectricEffectLogic.intensity));
                    Ameter am = new Ameter();
                    am.aM().setText(String.valueOf(curr).substring(0,2)+"mA");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        return inSlider;

    }
    public Color waveSetter(int waveL, int intensity)
    {
        Wavelength wl = new Wavelength();
       return wl.getColorForWavelength(waveL,intensity );
    }


}
