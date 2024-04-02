package src.leto.cv06.geom1;

public abstract class Geom implements Comparable<Geom> {
    @Override
    public int compareTo(Geom o) {
        return Double.compare(this.plocha, o.plocha);
    }

    protected double plocha;
    protected double obvod;
    public abstract double getPlocha();
    public abstract double getObvod();
    public abstract String toString();
}
