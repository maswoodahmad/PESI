package project;

import java.awt.*;

import static project.Variables.isStart;

public class Wavelength {

    public Color getColorForWavelength(int wavelength, double intensity) {
        int red, green, blue;
        if (wavelength >= 400 && wavelength < 440) {
            red = (int) ((440 - wavelength) * 255 / 40);
            green = 0;
            blue = 255;
        } else if (wavelength >= 440 && wavelength < 490) {
            red = 0;
            green = (int) ((wavelength - 440) * 255 / 50);
            blue = 255;
        } else if (wavelength >= 490 && wavelength < 510) {
            red = 0;
            green = 255;
            blue = (int) ((510 - wavelength) * 255 / 20);
        } else if (wavelength >= 510 && wavelength < 580) {
            red = (int) ((wavelength - 510) * 255 / 70);
            green = 255;
            blue = 0;
        } else if (wavelength >= 580 && wavelength < 645) {
            red = 255;
            green = (int) ((645 - wavelength) * 255 / 65);
            blue = 0;
        } else if (wavelength >= 645 && wavelength < 780) {
            red = 255;
            green = 0;
            blue = 0;
        } else {
            red = 0;
            green = 0;
            blue = 0;
        }
        System.out.println(wavelength+"in color");
        System.out.println(intensity+"in wl");
            red = (int)Math.round(red*intensity);
            green = (int)   Math.round(green*intensity);
            blue= (int) Math.round(blue*intensity);

return new Color(red ,green, blue);
    }

}
