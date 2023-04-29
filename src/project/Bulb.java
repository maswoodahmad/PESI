package project;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class Bulb {
Color col;
    public Image bulbImage(int wavelength, double intensity) throws IOException {
        BufferedImage image= ImageIO.read(new File("src/project/bulb.png"));
        BufferedImage beam = ImageIO.read(new File("src/project/NicePng_light-png_16663.png"));
        // BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

  Wavelength wl = new Wavelength();
     Color col = wl.getColorForWavelength(wavelength,intensity);

            int width = image.getWidth();
            int height = image.getHeight();
            WritableRaster raster = image.getRaster();

            for (int xx = 0; xx < width; xx++) {
                for (int yy = 0; yy < height; yy++) {
                    int[] pixels = raster.getPixel(xx, yy, (int[]) null);

                    pixels[0] =col.getRed();
                    pixels[1] = col.getGreen();
                    pixels[2] = col.getBlue();
                    raster.setPixel(xx, yy, pixels);
                }
            }
            return image;
        }


    public Image beamImage(int wavelength, double intensity) throws IOException {

        BufferedImage beam = ImageIO.read(new File("src/project/beamcan1.png"));

        Wavelength wl = new Wavelength();
         col = wl.getColorForWavelength(wavelength,intensity);
        System.out.println(col+"coplor");
        int width = beam.getWidth();
        int height = beam.getHeight();
        WritableRaster raster = beam.getRaster();

        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                int[] pixels = raster.getPixel(xx, yy, (int[]) null);

                pixels[0] =col.getRed();
                pixels[1] = col.getGreen();
                pixels[2] = col.getBlue();
                raster.setPixel(xx, yy, pixels);
            }
        }
        return beam;
    }
    public void upDateColor(Color color){
        col= color;
    }
}







