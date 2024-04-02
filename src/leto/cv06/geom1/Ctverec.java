package src.leto.cv06.geom1;

import kozeny.exceptions.ZapornyGeometrickyRozmerException;

public final class Ctverec extends Geom{
    public Ctverec(double strA) {
        if(strA <= 0)
            throw new ZapornyGeometrickyRozmerException("Zaporny nebo nulovy rozmer");
        this.plocha = strA*strA;
        this.obvod = 4*strA;
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
    public String toString(){
        return String.format("Ctverec: obvod = %.2f, plocha = %.2f",this.obvod, this.plocha);
    }
}
