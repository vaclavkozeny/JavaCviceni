package src.leto.cv06.apps;


import src.leto.cv06.geom2.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Geom2Test {
    public static void main(String[] args) {
        ArrayList<GeomInterf> geomInterfs = new ArrayList<>();
        Ctverec ctverec = new Ctverec(5);
//        System.out.println(ctverec);
        Kruh kruh = new Kruh(10);
//        System.out.println(kruh);
        Obdelnik obdelnik = new Obdelnik(10,20);
//        System.out.println(obdelnik);
        Trojuhelnik trojuhelnik = new Trojuhelnik(5,7,6);
//        System.out.println(trojuhelnik);
        geomInterfs.add(ctverec);
        geomInterfs.add(kruh);
        geomInterfs.add(obdelnik);
        geomInterfs.add(trojuhelnik);
        GeomInterf max = geomInterfs.get(0);
        double plochaSoucet = 0;
        for (GeomInterf g:geomInterfs) {
            System.out.println(g.toString());
            if(max.getPlocha() < g.getPlocha())
                max = g;
            plochaSoucet += g.getPlocha();
        }
        System.out.println("Max plocha " + max);
        System.out.println("Souhrna plocha " + plochaSoucet);
        Collections.sort(geomInterfs,Collections.reverseOrder());
        for (GeomInterf g: geomInterfs) {
            System.out.println(g);
        }

    }
}
