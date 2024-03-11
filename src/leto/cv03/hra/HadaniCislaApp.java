package src.leto.cv03.hra;

import src.leto.cv03.Matematika.MainClass;

import java.util.InputMismatchException;
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
//    public static void main(String[] args) {
//        int v;
//        MyslimSiCislo myslimSiCislo = new MyslimSiCislo(1,100);
//        myslimSiCislo.resetHry();
//        while (!myslimSiCislo.getVyhra()){
//            myslimSiCislo.generujCislo();
//            System.out.printf("Myslim si cislo %d\n",myslimSiCislo.getMysleneCislo());
//            vypisMenuHadani();
//            v = scanner.nextInt();
//            myslimSiCislo.zkontolujCislo(v);
//        }
//        System.out.println(myslimSiCislo.konecHryVypis());
//    }

    private static final int MIN_ROZSAH = 10;
    private static int dolniMez = 10;
    private static int horniMez = 20; // program testovat s mensim rozsahem

    public static void main(String[] args) {
        boolean konecProgramu = false;
        do {
            vypisMenu();
            int volba = nactiVolbu();
            konecProgramu = obsluzVolbu(volba);
        } while (!konecProgramu);
    }

    private static void vypisMenu() {
        System.out.println("1. Budu hadat");
        System.out.println("2. Budu si myslet cislo");
        System.out.println("3. Nastaveni programu");
        System.out.println("0. Konec programu");
    }

    private static int nactiVolbu() {
        System.out.print("Zadej volbu: ");
        int volba;
        try {
            volba = scanner.nextInt();
            return volba;
        } catch (InputMismatchException ex) {
            return -1;
        } finally {
            scanner.nextLine();
        }
    }

    private static boolean obsluzVolbu(int volba) {
        switch (volba) {
            case 0:
                return true;
            case 1:
                hratHruHracHadaCislo();
                break;
            case 2:
                hratHruHracSiMysliCislo();
                break;
            case 3:
                nastaveniParanetru();
                break;
            default:
                System.out.println("Neplatna volba " + volba);
        }
        return false;
    }

    private static void hratHruHracHadaCislo() {
        System.out.println("Myslim si cislo, budes hadat");
        HadamCislo hadamCislo = new HadamCislo(dolniMez,horniMez);
        hadamCislo.resetHry();
        while(!hadamCislo.getVyhra()){
            System.out.println(hadamCislo.zkontrolujZadaneCislo(nactiVolbu()));
        }
    }

    private static void hratHruHracSiMysliCislo() {
        System.out.println("Mysli si cislo, budu hadat");
        MyslimSiCislo myslimSiCislo = new MyslimSiCislo(dolniMez,horniMez);
        myslimSiCislo.resetHry();
        while (!myslimSiCislo.getVyhra()){
            myslimSiCislo.generujCislo();
            System.out.printf("\nMyslim si cislo %d\n",myslimSiCislo.getMysleneCislo());
            vypisMenuHadani();
            myslimSiCislo.zkontolujCislo(nactiVolbu());
        }
        System.out.println(myslimSiCislo.konecHryVypis());

    }
    private static void vypisMenuHadani(){
        System.out.println("1. Hadene cislo je mensi");
        System.out.println("2. Hadene cislo je vetsi");
        System.out.println("3. Uhodl jsi cislo");
    }
    private static void nastaveniParanetru() {
        // viz staticke atributy dolniMez, horniMez splnujici MIN_ROZSAH
        System.out.println("Aktualni nastaveni");
        System.out.format("min: %d | max: %d ROZSAH: %d\n",dolniMez, horniMez, MIN_ROZSAH);

        System.out.println("Zadej nove hodnoty");
        int dm = scanner.nextInt();
        int hm = scanner.nextInt();
        if(dm < 0)
            throw new IllegalArgumentException("Dolni hodnota nemuze byt zaporna");
        if(dm > hm){
            int a = dm;
            dm = hm;
            hm = a;
        }
        if(hm-dm < MIN_ROZSAH)
            throw new IllegalArgumentException("Hodnoty jsou mimo rozsah");
        dolniMez = dm;
        horniMez = hm;

        System.out.println("Nove aktualni nastaveni");
        System.out.format("min: %d | max: %d\n",dolniMez, horniMez);
    }
}
