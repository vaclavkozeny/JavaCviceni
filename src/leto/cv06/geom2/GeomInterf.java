package src.leto.cv06.geom2;


public interface GeomInterf extends Comparable<GeomInterf> {
    double getPlocha();
    @Override
    int compareTo(GeomInterf o);

    double getObvod();
}
