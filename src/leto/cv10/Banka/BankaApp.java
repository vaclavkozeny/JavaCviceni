package src.leto.cv10.Banka;

import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankaApp {
    private static final Scanner sc = new Scanner(System.in);
    private static Ucet ucet;
    public static void main(String[] args) throws IOException {
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
        System.out.println("Banka - zaznamenavani transakci do souboru uctu");
        System.out.println("1. Vytvorit novy ucet");
        System.out.println("2. Vybrat ucet");
        System.out.println("3. Zaznamenat prijem na ucet");
        System.out.println("4. Zaznamenat vydej z uctu");
        System.out.println("5. Vypsat vsechny pohyby na uctu");
        System.out.println("6. Bilance uctu");
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

    private static boolean obsluzVolbu(int volba) throws IOException {
        switch (volba) {
            case 0:
                return true;
            case 1:
                vytvoreniSouboruNovehoUctu();
                break;
            case 2:
                vyberJinehoUctu();
                break;
            case 3:
                zaznamenatVyber();
                break;
            case 4:
                zaznamenatVydej();
                break;
            case 5:
                vypisTransakciNaVybranemUctu();
                break;
            case 6:
                vypisBilanceVybranehoUctu();
                break;
            default:
                System.out.println("Neznama volba");
        }
        return false;
    }

    private static void vytvoreniSouboruNovehoUctu() throws IOException {
        System.out.println("");
        System.out.println("Novy ucet, vytvoreni souboru");
        System.out.println("Zadej cislo uctu");
        int cisloUctu = sc.nextInt();
        ucet = Ucet.getInstance(cisloUctu, true);
        System.out.println("Pracuji s uctem " + ucet);
    }

    private static void vyberJinehoUctu() throws IOException {
        System.out.println("");
        System.out.println("Vyber jineho uctu pro dalsi aktivity");
        System.out.println("Zadej cislo uctu");
        int cisloUctu = sc.nextInt();
        ucet = Ucet.getInstance(cisloUctu, false);
        System.out.println("Pracuji s uctem " + ucet);
    }

    private static void zaznamenatVyber() throws IOException {
        System.out.println("");
        System.out.println("Zaznamenat prijem na ucet");
        int den = sc.nextInt();
        int mesic = sc.nextInt();
        int rok = sc.nextInt();
        double castka = sc.nextDouble();
        Transakce transakce = new Transakce(LocalDate.of(rok,mesic,den), castka);
        ucet.ZaznamenejTrancakci(transakce);
    }

    private static void zaznamenatVydej() throws IOException {
        System.out.println("");
        System.out.println("Zaznamenat vydaj z uctu");
        int den = sc.nextInt();
        int mesic = sc.nextInt();
        int rok = sc.nextInt();
        double castka = sc.nextDouble();
        Transakce transakce = new Transakce(LocalDate.of(rok,mesic,den), -castka);
        ucet.ZaznamenejTrancakci(transakce);
    }

    private static void vypisTransakciNaVybranemUctu() {
        System.out.println("");
        System.out.println("Vypis vsech transakci na aktualnim uctu");;
    }

    private static void vypisBilanceVybranehoUctu() {
        System.out.println("");
        System.out.println("Vypis vbilance aktualniho uctu");
    }
    //method for testing



}
