package src.leto.cv06.geom2;

import kozeny.geom1.Geom;

public interface GeomInterf extends Comparable<GeomInterf> {
    double getPlocha();
    @Override
    int compareTo(GeomInterf o);

    double getObvod();
}
