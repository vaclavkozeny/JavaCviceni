package src.leto.cv06.geom2;

import kozeny.exceptions.ZapornyGeometrickyRozmerException;

public final class Kruh implements GeomInterf{
    double plocha;
    double obvod;
    public Kruh(double polomer) {
        if(polomer <= 0)
            throw new ZapornyGeometrickyRozmerException("Zaporny nebo nulovy polomer");
        this.obvod = Math.PI * 2 * polomer;
        this.plocha = Math.PI * polomer * polomer;
    }
    @Override
    public int compareTo(GeomInterf o) {
        return Double.compare(this.getPlocha(), o.getPlocha());
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
        return String.format("Kruh: obvod = %.2f, plocha = %.2f", this.obvod, this.plocha);
    }
}
