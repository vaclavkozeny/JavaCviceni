package src.cv08;

public final class DatetimeTools {
    public DatetimeTools() {}

    public static boolean jePrestupny(int rok){
        return rok % 4 == 0 && (rok % 100 !=0 || rok % 400 == 0);
    }
    public static boolean jePlatneDatum(int den, int mesic, int rok){
        switch (mesic){
            case 1,3,5,7,8,10,12:{
                return den <= 31;
            }
            case 4,6,9,11:{
                return den <= 30;
            }
            case 2:{
                if(jePrestupny(rok)){
                    return den <= 29;
                }else {
                    return den <= 28;
                }
            }
        }
        return false;
    }
    public static int denTydne(int den, int mesic, int rok){
        int K = rok%100;
        int J = (rok - K) / 100;
        return ((den + ((int) Math.floor((double) (13 * (mesic + 1)) / 5)) + K + ((int) Math.floor((double) K / 4)) + ((int)Math.floor((double) J/4)) - 2*J) % 7);
    }
}
