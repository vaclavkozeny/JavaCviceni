package src.leto.cv03.hra;

import src.leto.cv03.Matematika.MainClass;

import java.util.Scanner;

public class HadaniCislaApp {
    private static final Scanner scanner = new Scanner(System.in);
//    public static void main(String[] args) {
//        int v;
//        HadamCislo hadamCislo = new HadamCislo(1,100);
//        hadamCislo.resetHry();
//        while(!hadamCislo.getVyhra()){
//            System.out.println("Zadej cislo");
//            v = scanner.nextInt();
//            System.out.println(hadamCislo.zkontrolujZadaneCislo(v));
//        }
//    }
    public static void main(String[] args) {
        int v;
        MyslimSiCislo myslimSiCislo = new MyslimSiCislo(1,100);
        myslimSiCislo.resetHry();
        while (!myslimSiCislo.getVyhra()){
            myslimSiCislo.generujCislo();
            System.out.printf("Myslim si cislo %d\n",myslimSiCislo.getMysleneCislo());
            vypisMenuHadani();
            v = scanner.nextInt();
            myslimSiCislo.zkontolujCislo(v);
        }
        System.out.println(myslimSiCislo.konecHryVypis());
    }
    private static void vypisMenuHadani(){
        System.out.println("1. Hadene cislo je mensi");
        System.out.println("2. Hadene cislo je vetsi");
        System.out.println("3. Uhodl jsi cislo");
    }
}
