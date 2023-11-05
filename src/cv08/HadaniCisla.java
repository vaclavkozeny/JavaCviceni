package src.cv08;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class HadaniCisla {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random rand = new Random();
    private static  int dolniMez = 1;
    private static int horniMez = 100;
    private static int hadaneCislo;
    private static boolean konecProgramu = false;
    public static void main(String[] args) {
        do{
            vypisMenu();
            int volba = nactiVolbuMenu();
            obsluzVolbu(volba);
        }while(!konecProgramu);
    }

    private static boolean obsluzVolbu(int v) {
        switch (v){
            case 0: return konecProgramu = true;
            case 1: hratHruHracHada();break;
            case 2: hratHruHracSiMysli();break;
            case 3: nastaveniProgramu();break;
            default:
                System.out.println("Neznama volba\n");
                break;
        }
        return konecProgramu = false;
    }

    private static void hratHruHracHada() {
        int volba;
        int pokusy = 0;
        boolean win = false;
        System.out.println("Hadej\n");
        hadaneCislo = rand.nextInt(dolniMez, horniMez);
        while(!win){
            pokusy++;
            volba = nactiVolbuHrace();
            if(volba > hadaneCislo){
                System.out.println("mene\n");
            }else if(volba < hadaneCislo){
                System.out.println("vice\n");
            }else{
                win = true;
            }
        }
        System.out.format("Hadane cislo bylo %d, uhodnuti ti trvalo %d pokusu\n", hadaneCislo, pokusy);
        //konecProgramu = true;
    }

    private static void hratHruHracSiMysli() {
        System.out.println("Mysli si cislo");
        int MAX = horniMez, MIN = dolniMez, volba, cislo = 0;
        boolean win = false;
        while(!win){
            cislo = getNumber(MIN,MAX);
            System.out.format("Myslim si %d\n", cislo);
            vypisMenuHadani();
            volba = nactiVolbuMenu();
            switch (volba){
                case 1:
                    MAX = cislo;
                    break;
                case 2:
                    MIN = cislo;
                    break;
                case 3:
                    win = true;
            }
        }
        System.out.format("Hadane cislo bylo %d\n", cislo);


    }
    private static int getNumber(int min, int max){
        //hadani pres prostredni hodnotu, efektivní ale hrani neni zabava
//        double v = (double) (min + max) /2;
//        return (int) Math.round(v);

        return rand.nextInt(min,max);
    }

    private static void nastaveniProgramu() {
        System.out.println("Nastaveni");
        System.out.format("Horni mez je %d\n", horniMez);
        // nastaveni horni meze
        System.out.println("Nastaveni horni meze:");
        try{
            horniMez = scanner.nextInt();
            System.out.println("Horni mez modifikovana\n");
        }catch (InputMismatchException e){
            System.out.println("Spatny vstup\n");
        }
    }
    private static int nactiVolbuMenu() {
        System.out.println("Zadej cislo volby");
        return scanner.nextInt();
    }
    private static int nactiVolbuHrace() {
        System.out.format("Zadej cislo ktere si myslim v rozsahu %d - %d\n", dolniMez, horniMez);
        return scanner.nextInt();
    }

    private static void vypisMenu() {
        System.out.println("Hadani cisla");
        System.out.println("1. Budu hadat");
        System.out.println("2. Budu si myslet cislo");
        System.out.println("3. Nastaveni");
        System.out.println("0. Konec");
    }
    private static void vypisMenuHadani(){
        System.out.println("1. Hadene cislo je mensi");
        System.out.println("2. Hadene cislo je vetsi");
        System.out.println("3. Uhodl jsem cislo");
    }
}
