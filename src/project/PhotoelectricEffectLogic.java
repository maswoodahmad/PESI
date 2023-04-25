package project;

public class PhotoelectricEffectLogic {


static final double p = 6.626 * Math.pow(10,-34);
static final double c = 299792458.0;
static final double m =9.10938356*Math.pow(10,-31);
    static final double q = 1.602*Math.pow(10,-19);
    static  final double Na = 6.022 *Math.pow (10,23);
    static final double k = 1.38 *Math.pow(10,-23);

    public  static double energy( int wave){
        return p* c/wave;
    }
    public static double maxKE(int wave, double wf)
    {
        return  (p* c/wave)-wf;
    }
    public static double speed(double KE){
        return  Math.sqrt(2*KE/m);
    }
}
