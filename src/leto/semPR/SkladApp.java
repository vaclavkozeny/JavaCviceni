package src.leto.semPR;


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
        System.out.println("3. Pridej nove zbozi");
        System.out.println("4. Pridej zbozi");
        System.out.println("5. Odeber zbozi");
        System.out.println("6. Vypis zbozi");
        System.out.println("0. Konec");

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
                pridejNoveZbozi();
                break;
//            case 4:
//                pridejZbozi();
//                break;
            case 5:
                odeberZbozi();
                break;
            case 6:
                vypisZbozi();
                break;
        }
    }

    private static void vypisZbozi() {
        if(pobocka == null){
            System.out.println("Nejdrive musis vybrat pobocku");
            return;
        }
        System.out.println("\nVypis zbozi");
        try {
            System.out.println(pobocka.vypisZbozi());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private static void pridejZbozi() {
//        if(pobocka == null){
//            System.out.println("Nejdrive musis vybrat pobocku");
//            return;
//        }
//        System.out.println("\nPridani zbozi");
//        System.out.println("Zadej id zbozi");
//        int idZbozi = scanner.nextInt();
//        System.out.println("Zadej pocet kusu zbozi: ");
//        int pocetZbozi = scanner.nextInt();
//        try {
//            pobocka.pridejZbozi(idZbozi,pocetZbozi);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private static void odeberZbozi() {
        if(pobocka == null){
            System.out.println("Nejdrive musis vybrat pobocku");
            return;
        }
        System.out.println("\nOdebrani zbozi");
        System.out.println("Zadej id zbozi");
        int idZbozi = scanner.nextInt();
        System.out.println("Zadej pocet kusu zbozi: ");
        int pocetZbozi = scanner.nextInt();
        try {
            pobocka.odeberZbozi(idZbozi,pocetZbozi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void pridejNoveZbozi() throws IOException {
        if(pobocka == null){
            System.out.println("Nejdrive musis vybrat pobocku");
            return;
        }
        System.out.println("\nPridani zbozi");
        System.out.println("Zadej id zbozi");
        int idZbozi = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Zadej nazev zbozi: ");
        String nazevZbozi = scanner.nextLine();
        System.out.println("Zadej pocet kusu zbozi: ");
        int pocetZbozi = scanner.nextInt();
        Zbozi zbozi = new Zbozi(idZbozi,nazevZbozi,pocetZbozi);
        pobocka.pridejNoveZbozi(zbozi);
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
        System.out.println("Pracuji s pobockou " + pobocka);
    }



}
