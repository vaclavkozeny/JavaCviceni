package src.leto.cv06.apps;

import src.leto.cv06.geom1.*;

import java.util.ArrayList;
import java.util.Collections;

public class Geom1Test {
    public static void main(String[] args) {
        Geom ctverec = new Ctverec(5);
//        System.out.println(ctverec);
        Geom kruh = new Kruh(10);
//        System.out.println(kruh);
        Geom obdelnik = new Obdelnik(10,20);
//        System.out.println(obdelnik);
        Geom trojuhelnik = new Trojuhelnik(5,6,7);
//        System.out.println(trojuhelnik);
        ArrayList<Geom> geoms = new ArrayList<Geom>();
        geoms.add(ctverec);
        geoms.add(kruh);
        geoms.add(obdelnik);
        geoms.add(trojuhelnik);
        Geom max = geoms.get(0);
        double plochaSoucet = 0;
        for (Geom g:geoms) {
            System.out.println(g.toString());
            if(max.getPlocha() < g.getPlocha())
                max = g;
            plochaSoucet += g.getPlocha();
        }
        System.out.println("Max plocha " + max);
        System.out.println("Souhrna plocha " + plochaSoucet);
        Collections.sort(geoms,Collections.reverseOrder());
        for (Geom g: geoms) {
            System.out.println(g);
        }
    }
}
