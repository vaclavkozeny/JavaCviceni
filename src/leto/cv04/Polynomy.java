package src.leto.cv04;

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

//    public static Polynom soucin(Polynom p1, Polynom p2) {
//
//    }
}
