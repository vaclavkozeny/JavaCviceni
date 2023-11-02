package src.cv08;

import java.util.Scanner;

public class HadaniCisla {
    private static final Scanner scanner = new Scanner(System.in);
    private static  int dolniMez = 1;
    //private static int horniMez = 100;
    public static void main(String[] args) {
        boolean konecProgramu = false;
        do{
            vypisMenu();
            int volba = nactiVolbu();
            obsluzVolbu(volba);
        }while(!konecProgramu);
    }

    private static boolean obsluzVolbu(int v) {
        switch (v){
            case 0: return true;
            case 1: hratHruHracHada();break;
            case 2: hratHruHracSiMysli();break;
            case 3: nastaveniProgramu();break;
            default:
                System.out.println("Neznama volba");
                break;
        }
        return false;
    }

    private static void hratHruHracHada() {
        System.out.println("Hadej");
    }

    private static void hratHruHracSiMysli() {
        System.out.println("Hadam");
    }

    private static void nastaveniProgramu() {
        System.out.println("Nastaveni");
        System.out.println("Horni mez je");
        // nastaveni horni meze
    }

    private static int nactiVolbu() {
        System.out.println("Zadej cislo volby");
        return scanner.nextInt();
    }

    private static void vypisMenu() {
        System.out.println("Hadani cisla");
        System.out.println("1. Budu hadat");
        System.out.println("2. Budu si myslet cislo");
        System.out.println("3. Nastaveni");
        System.out.println("0. Konec");
    }
}
