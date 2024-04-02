package src.leto.cv06.geom2;

import kozeny.exceptions.ZapornyGeometrickyRozmerException;

public final class Ctverec implements GeomInterf{
    double plocha;
    double obvod;
    public Ctverec(double strA) {
        if(strA <= 0)
            throw new ZapornyGeometrickyRozmerException("Zaporny nebo nulov rozmer");
        this.plocha = strA*strA;
        this.obvod = 4*strA;
    }
    @Override
    public double getPlocha() {
        return this.plocha;
    }

    @Override
    public int compareTo(GeomInterf o) {
        return Double.compare(this.getPlocha(), o.getPlocha());
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
