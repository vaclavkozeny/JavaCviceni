package src.leto.cv05.zavody;

public class CasDen {
    private final int hod,min,sek;
    private final int celkemSekund;

    public CasDen(int hod, int min, int sek) {
        this.hod = hod;
        this.min = min;
        this.sek = sek;
        this.celkemSekund = sek + min*60 + hod*3600;
    }

    public CasDen(int cs){
        this.celkemSekund = cs;
        this.sek = cs % 60;
        cs = cs/60;
        this.min = cs % 60;
        this.hod = cs / 60;
    }

    public int getHod() {
        return hod;
    }

    public int getMin() {
        return min;
    }

    public int getSek() {
        return sek;
    }

    public int getCelkemSekund() {
        return celkemSekund;
    }

    @Override
    public String toString() {
        return "CasDne{" + "hod=" + hod + ", min=" + min + ", sek=" + sek + ", celkemSekund=" + celkemSekund + '}';
    }

    public static void main(String[] args){

    }
}
