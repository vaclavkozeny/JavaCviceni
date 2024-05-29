package src.leto.zkouska;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataApp {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean konecProgramu;
        do {
            vypisMenu();
            int volba = nactiVolbu(); //osetrni nacteni
            konecProgramu = obsluzVolbu(volba);
        } while (!konecProgramu);
    }
    private static boolean obsluzVolbu(int volba) {
        switch (volba) {
            case 0:
                return true;
            case 1:

                break;
            default:
                System.out.println("Neznama volba");
        }
        return false;
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
    private static void vypisMenu(){
        System.out.println("1. nacti soubor velicin");
        System.out.println("2. zadej soubor mereni");
        System.out.println("3. kontrola");
        System.out.println("4. vypis");
        System.out.println("5. uloz");
    }
}
