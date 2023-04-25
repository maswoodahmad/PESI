package project;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.io.IOException;

import static project.Simulator.ImagePanelDemo.updateLabelState;

public class SeekBar {

     JSlider slider;
     JSlider inSlider;

    public int waveL=440;
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
                waveL=value;
                try {
                    updateLabelState(waveL,intensity);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println(waveL);
            }
        });
        return slider;

    }

    public JSlider  intensitySeekBar(){
        inSlider = new JSlider(JSlider.HORIZONTAL,0,100,50 );
       inSlider.setMajorTickSpacing(10);
        inSlider.setMinorTickSpacing(1);
        inSlider.setPaintTicks(true);
        inSlider.setPaintLabels(true);
        inSlider.setPreferredSize(new Dimension( 120, 100 ));
        inSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                double value = source.getValue()/100.0;
                intensity=value;
                try {
                    updateLabelState(waveL,  intensity);
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
