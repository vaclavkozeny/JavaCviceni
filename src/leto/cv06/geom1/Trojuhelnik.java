package src.leto.cv06.geom1;

import kozeny.exceptions.TrojuhelnikNeexistujeException;
import kozeny.exceptions.ZapornyGeometrickyRozmerException;

public final class Trojuhelnik extends Geom{
    public Trojuhelnik(double strA, double strB, double strC) {
        if(strA <= 0 || strB <= 0 || strC <= 0)
            throw new ZapornyGeometrickyRozmerException("Zaporny nebo nulovy rozmer");
        if(((strA+strB < strC)||(strB + strC < strA)||(strC+strA < strB)))
            throw new TrojuhelnikNeexistujeException("Trojuhelnik neexistuje");
        this.obvod = strA + strB + strC;
        double s = obvod/2;
        this.plocha = Math.sqrt(s*(s-strA)*(s-strB)*(s-strC));
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
        return String.format("Trojuhelnik: obvod = %.2f, plocha = %.2f",this.obvod, this.plocha);
    }
}
