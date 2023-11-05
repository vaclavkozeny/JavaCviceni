package src.cv08.tools;

public final class MathTools {
    private MathTools(){}
    public static double mocnina(double x, double y){
        if(y < 0){
            x = 1/x;
            y = -y;
        }else if(y == 0){
            return 1;
        }
        double r = x;
        for(int i = 0; i < y-1; i++){
            r = r*x;
        }
        return r;
    }
    public static double sin(double x, double eps){

        double sinX = 0;
        double aktualniclen = x;
        int n = 1;
        //tayloruv rozvoj
        while (absolute(aktualniclen) > eps) {
            sinX += aktualniclen;
            n += 2;
            aktualniclen = -aktualniclen * x * x / (n * (n - 1));
        }
        return sinX;
    }
//    public static double log(double x, double eps){
//        double lnX = 0.0;
//        double term = x - 1;
//
//        for (int i = 1; i <= eps; i++) {
//            if (i % 2 == 0) {
//                lnX -= term / i;
//            } else {
//                lnX += term / i;
//            }
//            term *= (x - 1);
//        }
//        return lnX;
//    }
//    public static double sqrt(double x, double eps){
//
//    }
//    public static double qbrt(double x, double eps){
//
//    }
    private static double absolute(double x){
        return x<0?-x:x;
    }
}
