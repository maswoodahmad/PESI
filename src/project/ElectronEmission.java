package project;

import java.util.ArrayList;

import static project.PhotoelectricEffectLogic.*;

public class ElectronEmission {
PhotoelectricEffectLogic lg = new PhotoelectricEffectLogic();
    double cut = lg.electronEnergy;
public double startEmission(int wavelength){
    double photonEnergy = p*c/wavelength;
 if( cut-(q*voltage)<=0){
     System.out.println("no current");
        }
 else{
     PhotoelectricEffectLogic lg = new PhotoelectricEffectLogic();
     double area=lg.setFinalArea();



 }
 return 0.0 ;

    }
    double speed = lg.calculateVelocity(cut-(q*voltage));


}
