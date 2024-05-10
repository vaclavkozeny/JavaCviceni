package src.leto.semPR;

import src.leto.cv10.Banka.Ucet;

import java.io.IOException;
import java.util.Scanner;

public class SkladApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Pobocka pobocka;
    public static void main(String[] args) throws IOException {
        System.out.println("Vitej ve skladu");
        boolean konec = false;
        while(!konec){
            VypisMenu();
            int volba = scanner.nextInt();
            if(volba == 0){
                konec = true;
            }else{
                ObsluzVolbu(volba);
            }
        }
    }
    private static void VypisMenu(){
        System.out.println("1. Vytvor pobocku");
        System.out.println("2. Vyber pobocku");
        System.out.println("3. Pridej zbozi");
        System.out.println("4. Odeber zbozi");

    }
    private static void ObsluzVolbu(int volba) throws IOException {
        switch (volba){
            case 1:
                vytvorPobocku();
                break;
            case 2:
                vyberPobocku();
                break;
            case 3:
                pridejZbozi();
                break;
            case 4:
                odeberZbozi();
                break;
        }
    }

    private static void odeberZbozi() {
    }

    private static void pridejZbozi() throws IOException {
        System.out.println("\nPridani zbozi");
        System.out.println("Zadej id zbozi");
        int idZbozi = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Zadej nazev zbozi: ");
        String nazevZbozi = scanner.nextLine();
        System.out.println("Zadej pocet kusu zbozi: ");
        int pocetZbozi = scanner.nextInt();
        Zbozi zbozi = new Zbozi(idZbozi,nazevZbozi,pocetZbozi);
        pobocka.pridejZbozi(zbozi);
    }

    private static void vyberPobocku() throws IOException{
        System.out.println("\nVyber jine pobocka pro dalsi aktivity");
        System.out.println("Zadej id pobocky");
        int idPobocky = scanner.nextInt();
        pobocka = Pobocka.getInstance(idPobocky,"",false);
        System.out.println("Pracuji s uctem " + pobocka);
    }

    private static void vytvorPobocku() throws IOException {
        System.out.println("\nNova pobocka, vytvoreni souboru");
        System.out.println("Zadej id pobocky");
        int idPobocky = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Zadej nazev pobocky: ");
        String nazevPobocky = scanner.nextLine();
        pobocka = Pobocka.getInstance(idPobocky,nazevPobocky,true);
        System.out.println("Pracuji s uctem " + pobocka);
    }


}
