package src.leto.cv08.apps;


import src.leto.cv08.hry.pexeso.HraPexeso;

public class KozenyTestApp {
    public static void main(String[] args) {
        HraPexeso hraPexeso = HraPexeso.getInstance("Kozeny", 10, 2);
        System.out.println("Pocet karet: " + hraPexeso.getPocetKaret());
        for (int i:hraPexeso.getPoradiHracu()) {
            System.out.println(i+1 + " hrac | body: " + hraPexeso.getPocetBoduHrace(i+1));
        }
        System.out.println(hraPexeso.otocKartu(2));
        System.out.println(hraPexeso.otocKartu(3));
        System.out.println(hraPexeso.otocKartu(0));
        System.out.println(hraPexeso.otocKartu(1));
        //System.out.println(hraPexeso.otocKartu(1));
        //System.out.println(hraPexeso.otocKartu(0));
        System.out.println("------------------");
        for (int i: hraPexeso.getPoleKaretMask()) {
            System.out.println(i);
        }
        for (int i:hraPexeso.getPoradiHracu()) {
            System.out.println(i+1 + " hrac | body: " + hraPexeso.getPocetBoduHrace(i+1));
        }
        System.out.println("Pocet dvojic ve hre: "+hraPexeso.getPocetDvojicKaretVeHre());
    }
}
