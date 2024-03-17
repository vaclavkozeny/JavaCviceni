package src.leto.cv04.polynomy;

public final class Polynomy {


    private Polynomy() {
    }

    public static Polynom soucet(Polynom p1, Polynom p2) {
        double[] koef = new double[Math.max(p1.pocetKoef(), p1.pocetKoef())];
        for (int i = 0; i < koef.length; i++) {
            koef[i] = p1.getKoef(i)+p2.getKoef(i);
        }
        return new Polynom(koef);
    }

    public static Polynom soucin(Polynom p1, Polynom p2) {
        int ps1 = p1.getStupen();
        int ps2 = p2.getStupen();
        double[] koef = new double[ps1+ps2+1];
        for(int i = 0; i<p1.pocetKoef();i++){
            for (int j = 0; j < p2.pocetKoef(); j++) {
                koef[i+j] += p1.getKoef(i)*p2.getKoef(j);
            }
        }
        return new Polynom(koef);

    }
}
