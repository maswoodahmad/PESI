package project;

import java.util.Arrays;

public class ColorConvertor {
   static double R ,G,B;
    int wavelength;
   static float gamma =0.8f;
//static int FrequencytoWavelength(double freq){
//    double wave = 6.626E-34 * 2.998E8/freq;
//   wave/=10E-9;
//
//    return 100;
//}



   static public double [] WavelengthtoColor(int wavelength){
        double []ans=new double[3];
//          double attenuation;
//        if(wavelength >= 380 & wavelength <= 440) {
//            attenuation = 0.3 + 0.7 * (wavelength - 380) / (440 - 380);
//            R =  Math.pow(((-(wavelength - 440) / (440 - 380)) * attenuation) , gamma);
//            G = 0.0f;
//            B = Math.pow((1.0 * attenuation) ,gamma);
//        }
//        else if (wavelength >= 440 & wavelength <= 490) {
//            R = 0.0;
//            G = Math.pow(((wavelength - 440) / (490 - 440)) , gamma);
//            B = 1.0;
//        }
//        else if (wavelength >= 490 & wavelength <= 510) {
//            R = 0.0;
//            G = 1.0;
//            B = Math.pow((-(wavelength - 510) / (510 - 490)) , gamma);
//        }
//        else if (wavelength >= 510 & wavelength <= 580) {
//            R = Math.pow((wavelength - 510) / (580 - 510) , gamma);
//            G = 1.0;
//            B = 0.0;
//        }
//        else if (wavelength >= 580 & wavelength <= 645) {
//            R = 1.0;
//            G = Math.pow((-(wavelength - 645) / (645 - 580)) ,gamma);
//            B = 0.0;
//        }
//        else if (wavelength >= 645 & wavelength <= 750) {
//            attenuation = 0.3 + 0.7 * (750 - wavelength) / (750 - 645);
//            R = Math.pow((1.0 * attenuation) , gamma);
//            G = 0.0;
//            B = 0.0;
//        }
//        else {
//            R = 0.0;
//            G = 0.0;
//            B = 0.0;
//        }
//        R = R * 255;
//        G = G * 255;
//        B = B * 255;
       float Gamma = 0.80f;
       int IntensityMax = 255;
       double  factor;
       double red, green, blue;
       if((wavelength >= 380) && (wavelength<440)){
           red = -((wavelength - 440.0) / (440.0 - 380.0));
           green = 0.0;
           blue = 1.0;
           System.out.println(red);
       }else if((wavelength >= 440) && (wavelength<490)){
           red = 0.0;
           green = (wavelength - 440.0) / (490.0 - 440.0);
           blue = 1.0;
       }else if((wavelength >= 490.0) && (wavelength<510.0)){
           red = 0.0;
           green = 1.0;
           blue = -(wavelength - 510.0) / (510.0 - 490.0);
       }else if((wavelength >= 510) && (wavelength<580)){
           red = (wavelength - 510.0) / (580.0 - 510.0);
           green = 1.0;
           blue = 0.0;
       }else if((wavelength >= 580) && (wavelength<645)){
           red = 1.0;
           green = -(wavelength - 645.0) / (645.0 - 580.0);
           blue = 0.0;
       }else if((wavelength >= 645) && (wavelength<781)){
           red = 1.0;
           green = 0.0;
           blue = 0.0;
       }else{

           red = 0.0;
           green = 0.0;
           blue = 0.0;
       };
       System.out.println(red);
       // Let the intensity fall off near the vision limits
       if((wavelength >= 380) && (wavelength<420)){
           factor = 0.3 + 0.7*(wavelength - 380) / (420 - 380);
       }else if((wavelength >= 420) && (wavelength<701)){
           factor = 1.0;
       }else if((wavelength >= 701) && (wavelength<781)){
           factor = 0.3 + 0.7*(780 - wavelength) / (780 - 700);
       }else{
           factor = 0.0;
       };
       if (red !=0){
           System.out.println(red);
           red = Math.round(IntensityMax * Math.pow(red * factor, Gamma));
       }
       if (green != 0){
           green = Math.round(IntensityMax * Math.pow(green * factor, Gamma));
       }
       if (blue != 0){
           blue = Math.round(IntensityMax * Math.pow(blue * factor, Gamma));
       }



      ans[0] = red;
      ans[1]=green;
      ans[2] =blue;
     return ans;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(WavelengthtoColor(100)));
    }


}
