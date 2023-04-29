package project;

import java.util.ArrayList;

import static project.Simulator.PHET.updateCurrent;
import static project.Simulator.PHET.updateVoltageState;

public class PhotoelectricEffectLogic {


static final double p = 6.626 * Math.pow(10,-34);
static final double c = 299792458.0;
static final double m =9.10938356*Math.pow(10,-31);
    static final double q = 1.602E-19;
    static  final double Na = 6.022 *Math.pow (10,23);
    static final double k = 1.38 *Math.pow(10,-23);
    static  final  double kt=8.617333262145e-5 * 300;
    static double intensity ;
//      double iph =q*area*unit*intenisty/getPhotonEnergy(wavelength);
//      double currentDenisty = (iph * q) / (p * c / (wavelength - voltage));
//      double finCurrent = (q*area*unit*currentDenisty);
    static  int area = 1;
    static  double unit = 0.01;
    static int wavelength = 440;

    static double voltage =1;

    static double  workFunctioOfMetal = 2.27;
//    static  double current = 0.0;
    double energy = getPhotonEnergy(wavelength);
    static double cutoffVoltage= workFunctioOfMetal/q;

    double electronSpeed = getElectronSpeed(energy);
    double electronEnergy = energy - workFunctioOfMetal;







    public static double calculateSaturationCurrent(double wavelength, double intensity, double workFunction) {
        double h = 6.626e-34;  // Planck's constant (J s)
        double c = 2.998e8;  // speed of light (m/s)
        double e = 1.602e-19;  // elementary charge (C)
        double energy = h * c / (wavelength * 1e-9);  // photon energy (J)
        double saturationCurrent = (intensity * 1e4 * energy - workFunction) / e;  // saturation current (A)
        return saturationCurrent;
    }




    public static double[] photoelectricCurrent(double wavelength, double intensity, double voltage, double workFunction) {
        double h = 6.626e-34; // Planck's constant in J.s
        double c = 2.998e8; // Speed of light in m/s
        double q = 1.602e-19; // Charge of an electron in Coulombs
        double k = 1.381e-23; // Boltzmann constant in J/K
        double temperature = 300; // Temperature in K
        double area = 1.0e-4; // Area in m^2
        voltage=voltage*q;
        intensity*=10;

        double p =1.98644586e-25;
        double e = 2.27*1.60218e-19;
        if((p/e)>wavelength*10e+9)
        {
         return new double[]{0.0, 0.0,0.0,0.0};
        }
        double frequency = c / (wavelength * 1e-9);
        double photonEnergy = h * frequency;

        double excessEnergy = photonEnergy - workFunction * q;
        double speed = Math.sqrt(2 * excessEnergy / q);

        if (excessEnergy < 0) {
            excessEnergy = 0;
        }

        double saturationCurrent = q*area*intensity/excessEnergy;

        double current =q* intensity * area/ (excessEnergy+voltage);
        double noOfElectrons =current/q;
//            double current = photoelectricCurrent * (Math.exp(q * voltage / (k * temperature)) - 1);

        if (current < 0) {
            current = 0;
        }

        if (current >= saturationCurrent) {
            current = saturationCurrent;
        }

        return new double[]{current, saturationCurrent,speed, noOfElectrons,excessEnergy};
    }







    public  double getPhotonEnergy(int wavelength){
            return 1.24E-6 / (wavelength*10E-9);
        }


         double calculateVelocity(double kineticEnergy) {
        // Calculate velocity in m/s
        double mass = 9.11E-31;
        double joulesPerEv = 1.602E-19;
        double energyJoules = kineticEnergy * joulesPerEv;
        return 2 * energyJoules / mass;
    }

    public static void  setUnit(String u) {
        double mili = 0.001;
        double m =1.0;
        double cm = 0.01;
        if( u=="mm") unit=mili;
        if(u=="m") unit=m;
        if(u=="cm") unit= cm;
    }

    double setFinalArea() {
        return area*unit;
    }
    void setArea(int val){
        area=val;
    }

    public void setIntensity(double value) {
        intensity=value;
    }
    public void setWavelength(int value) {
        wavelength=value;
    }

    private static double getElectronSpeed(double energy) {
        return Math.sqrt(2 * energy / q);
    }
    void setWorkF(double val){
        workFunctioOfMetal=val;
    }
    void setVoltage(double v){
        voltage = v;
    }
    void setCurrent(){


    }


    public void upDateValues(int wavelength, double workFunctioOfMetal, double intensity, double voltage) {

        wavelength=wavelength;
        workFunctioOfMetal=workFunctioOfMetal;
        intensity=intensity;
        voltage=voltage;
        System.out.println(voltage +" in a fucntion");
        updateVoltageState(voltage);
        Ameter am = new Ameter();
        double crr=photoelectricCurrent(wavelength,intensity,voltage,workFunctioOfMetal)[0];
        System.out.println(crr);
        updateCurrent(photoelectricCurrent(wavelength,intensity,voltage,workFunctioOfMetal)[0],am.aM());
    }
}

