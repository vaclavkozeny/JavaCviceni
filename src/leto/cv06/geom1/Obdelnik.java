package src.leto.cv06.geom1;

import kozeny.exceptions.ZapornyGeometrickyRozmerException;


public final class Obdelnik extends Geom{
    public Obdelnik(double strA, double strB) {
        if(strA <= 0 || strB <= 0)
            throw new ZapornyGeometrickyRozmerException("Zaporny nebo nulovy rozmer");
        this.obvod = (2*strA)+(2*strB);
        this.plocha = strA*strB;
    }

    @Override
    public double getPlocha() {
        return this.plocha;
    }

    @Override
    public double getObvod() {
        return this.obvod;
    }

    @Override
    public String toString() {
        return String.format("Obdelnik: obvod = %.2f, plocha = %.2f",this.obvod, this.plocha);
    }
}
