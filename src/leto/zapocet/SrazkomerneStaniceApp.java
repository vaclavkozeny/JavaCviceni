package src.leto.zapocet;
/*
 * Copyright (C) 2024 Jirina Kralovcova
 * This program is part of Java programing education. 
 * You can use it as you need to learn Java. 
 */

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jirina
 */
public class SrazkomerneStaniceApp {

    private static final Scanner sc = new Scanner(System.in);
    private static MeteoData meteoData;
    private static int format;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Zadej formatovani souboru: 1 - UTF-8 / 2 - CP1250");
        format = sc.nextInt();
        sc.nextLine();
        if (format == 1) {
            System.out.println("Zvoleno formatovani UTF-8");
        } else if (format == 2) {
            System.out.println("Zvoleno formatovani CP1250");
        } else {
            System.out.println("Neznama volba, koncim program");
            return;
        }
        System.out.println("Zadej cestu k povodi");
        String povodi = sc.nextLine();
        meteoData = new MeteoData();
        meteoData.readFromFile(povodi, format);
        boolean konecProgramu;
        do {
            vypisMenu();
            int volba = nactiVolbu();
            konecProgramu = obsluzVolbu(volba);
        } while (!konecProgramu);
        System.out.println("Koncim ...");
    }

    private static void vypisMenu() {
        System.out.println("");
        System.out.println("Hlavni menu programu");
        System.out.println("1. Pridani dalsich stanic nactenych ze souboru");
        System.out.println("2. Vypis povodi");
        System.out.println("3. Vypis stanic");
        System.out.println("4. Vypis stanic serazene podle zadaneho parametru");
        System.out.println("0. Konec programu");
    }

    private static int nactiVolbu() {
        int volba;
        try {
            volba = sc.nextInt();
        } catch (InputMismatchException ex) {
            volba = -1;
        }
        sc.nextLine();
        return volba;
    }

    private static boolean obsluzVolbu(int volba) {
        switch (volba) {
            case 0:
                return true;
            case 1:
                pridejStanici();
                break;
            case 2:
                vypisPovodi();
                break;
            case 3:
                vypisStanic();
                break;
            case 4:
                vypisStanice();
                break;
            default:
                System.out.println("Neznama volba");
        }
        return false;
    }

    private static void vypisStanic() {
        System.out.println("Vypis stanic");
        System.out.println(meteoData.vypisStaniceZeSouboru());
    }

    private static void vypisStanice() {
        System.out.println("Vypis stanic");
        System.out.println("Zadej zpusob razeni stanic | 1 - podle nazvu | 2 - podle cisla povodi | 3 - podle nadmorske vysky");
        int sortParam = nactiVolbu();
        System.out.println(meteoData.vypisStanice(sortParam));
    }

    private static void pridejStanici() {
        System.out.println("Zadej cestu k souboru se stanicemi");
        String stanice = sc.nextLine();
        try {
            meteoData.pridejStanici(stanice, format);
        } catch (IOException ex) {
            System.out.println("Chyba pri cteni ze souboru");
        }
    }

    private static void vypisPovodi() {
        System.out.println("Vypis povodi");
        System.out.println(meteoData.vypisPovodi());
    }

}
