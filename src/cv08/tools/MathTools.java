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
            aktualniclen = -aktualniclen * mocnina(x,2) / (n * (n - 1));
        }
        return sinX;
    }
    public static double log(double x, double eps){
        double term = 1;
        int i = 0;
        double temp = 0;
        double t1 = x-1,t2 = x+1;

        if(x <= 0){
            throw new IllegalArgumentException("Spatny vstup");
        }

        while(term > eps){
            int m = 2*i+1;
            term = (mocnina(t1,m)/(m*mocnina(t2,m)));
            temp = temp + term;
            i++;
        }
        return 2*temp;
    }
    public static double sqrt(double x, double eps){
        double y,ypo = x;
        double delta = 1;
        while (absolute(delta) > eps){
            y = ypo;
            ypo = 0.5*((x/ypo)+ypo);
            delta = absolute(ypo-y);
        }
        return ypo;
    }

    /**
     * @param x promenna
     * @param stupen stupen exponentu
     * @param eps presnost
     * @return {double} hledana odmocnina se zadanou presnosti
     */
    public static double rootN(double x, int stupen, double eps){
        double y,ypo = x;
        double delta = 1;
        while (absolute(delta) > eps){
            y = ypo;
            ypo = (((stupen-1)*y + x/mocnina(y,stupen-1)) / stupen);
            delta = absolute(ypo-y);
        }
        return ypo;
    }
    public static double cbrt(double x, double eps){
        return rootN(x, 3,eps);
    }
    private static double absolute(double x){
        return x<0?-x:x;
    }
}
