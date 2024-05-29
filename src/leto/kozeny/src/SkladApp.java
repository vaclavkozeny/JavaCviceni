package src.leto.kozeny.src;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class SkladApp {
    private static Scanner scanner = new Scanner(System.in);
//    public static final String path = "src/kozeny/data/";
    private static Pobocka pobocka;
    private static Objednavka objednavka = new Objednavka();

    public static void main(String[] args) throws IOException {
        System.out.println("Vitej ve skladu");
        boolean konec = false;
        while (!konec) {
            vypisMenu();
            int volba = scanner.nextInt();
            if (volba == 0) {
                konec = true;
            } else {
                obsluzVolbu(volba);
            }
        }
    }

    private static void vypisMenu() {
        System.out.println("1. Vytvor pobocku");
        System.out.println("2. Vyber pobocku");
        System.out.println("3. Pridej zaznam");
        System.out.println("4. Pridej zbozi");
        System.out.println("5. Odeber zbozi");
        System.out.println("6. Odeber zaznam");
        System.out.println("7. Vypis zbozi");
        System.out.println("8. Mega vypis");
        System.out.println("9. Kde je zbozi");
        System.out.println("10. Vytvor objednavku");
        System.out.println("0. Konec");

    }

    private static void obsluzVolbu(int volba) throws IOException {
        switch (volba) {
            case 1:
                vytvorPobocku();
                break;
            case 2:
                vyberPobocku();
                break;
            case 3:
                pridejNoveZbozi();
                break;
            case 4:
                pridejZbozi();
                break;
            case 5:
                odeberZbozi();
                break;
            case 6:
                odeberZaznam();
                break;
            case 7:
                vypisZbozi();
                break;
            case 8:
                megaVypis();
                break;
            case 9:
                kdeJeZbozi();
                break;
            case 10:
                menuObjednavka();
                break;


        }
    }

    private static void kdeJeZbozi() {
        System.out.println("\nKde je zbozi");
        System.out.println("Zadej id zbozi");
        int idZbozi = scanner.nextInt();
        try {
            String s = kdeJeZbozi(idZbozi);
            if (s == null)
                System.out.println("Zbozi neni na zadne pobocce");
            else
                System.out.println("Zbozi je na pobocce: " + s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void menuObjednavka() throws IOException {
        boolean konec = false;
        while (!konec) {
            vypisMenuObjednavka();
            int volba = scanner.nextInt();
            if (volba == 0) {
                konec = true;
            } else {
                ObsluzVolbuObjednavka(volba);
            }
        }
    }

    private static void ObsluzVolbuObjednavka(int volba) throws IOException {
        switch (volba) {
            case 1:
                pridejZboziDoObjednavky();
                break;
            case 2:
                odeberZboziZObjednavky();
                break;
            case 3:
                vypisObjednavku();
                break;
            case 4:
                dokonciObjednavku();
                break;
//            case 5:
//                jeMozneNaJednePobocce();
//                break;
            case 6:
                break;
        }
    }

//    private static void jeMozneNaJednePobocce() throws IOException{
//        System.out.println(objednavka.jeMozneRealizovatJednouPobockou());
//    }

    private static void dokonciObjednavku() throws IOException {
        if (objednavka == null) {
            System.out.println("Nejdrive musis vytvorit objednavku");
            return;
        }
        System.out.println("\nDokonceni objednavky");
        System.out.println("Cena objednavky: " + objednavka.getCena());
        int s = objednavka.dokocitObjednavku();
        if(s == 0)
            System.out.println("Objednavka byla dokoncena");
        else if (s == -1)
            System.out.println("Objednavka je prazdna");
        else
            System.out.println("Chyba pri dokonceni objednavky");
    }

    private static void vypisObjednavku() {
        if (objednavka == null) {
            System.out.println("Nejdrive musis vytvorit objednavku");
            return;
        }
        System.out.println("\nVypis objednavku");
        ArrayList<ZboziVObjednavce> zbozi = objednavka.getZbozi();
        zbozi.forEach(z -> {
            System.out.println(z);
        });
        System.out.println("Celkova cena objednavky: " + objednavka.getCena());
    }

    private static void odeberZboziZObjednavky() {
        System.out.println("\nOdebrani zbozi z objednavky");
        System.out.println("Zadej id zbozi");
        int idZbozi = scanner.nextInt();
        System.out.println("Zadej pocet kusu zbozi: ");
        int pocetZbozi = scanner.nextInt();
        int s = objednavka.odebratZbozi(idZbozi, pocetZbozi);
        if (s == 0)
            System.out.println("Zbozi bylo odebrano");
        else if (s == -1)
            System.out.println("Zbozi neexistuje");
        else
            System.out.println("Chyba pri odebirani zbozi");

        if(objednavka.getZbozi().size() == 0)
            objednavka = null;
    }

    private static void pridejZboziDoObjednavky() {
        System.out.println("\nPridani zbozi do objednavky");
        System.out.println("Zadej id zbozi");
        int idZbozi = scanner.nextInt();
        System.out.println("Zadej pocet kusu zbozi: ");
        int pocetZbozi = scanner.nextInt();
        try {
            int s = objednavka.pridatZbozi(idZbozi, pocetZbozi);
            if (s == 0)
                System.out.println("Zbozi bylo pridano");
            else if (s == -1)
                System.out.println("Zbozi neexistuje nebo není skladem");
            else
                System.out.println("Chyba pri pridavani zbozi");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void vypisMenuObjednavka() {
        System.out.println("1. Pridej zbozi do objednavky");
        System.out.println("2. Odeber zbozi z objednavky");
        System.out.println("3. Vypis objednavku");
        System.out.println("4. Dokonci objednavku");
//        System.out.println("5. Je mozne na jedne pobocce");
        System.out.println("0. Zpet");
    }


    private static void odeberZaznam() throws IOException {
        if (pobocka == null) {
            System.out.println("Nejdrive musis vybrat pobocku");
            return;
        }
        System.out.println("\nOdebrani zaznamu");
        System.out.println("Zadej id zbozi");
        int idZbozi = scanner.nextInt();
        int s = pobocka.odeberZaznam(idZbozi);
        if (s == 0)
            System.out.println("Zaznam byl odebran");
        else if (s == -1)
            System.out.println("Zbozi neexistuje");
        else
            System.out.println("Chyba pri odebirani zaznamu");
    }

    private static void vypisZbozi() {
        if (pobocka == null) {
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

    private static void pridejZbozi() throws IOException {
        if (pobocka == null) {
            System.out.println("Nejdrive musis vybrat pobocku");
            return;
        }
        System.out.println("\nPridani zbozi");
        System.out.println("Zadej id zbozi");
        int idZbozi = scanner.nextInt();
        System.out.println("Zadej pocet kusu zbozi: ");
        int pocetZbozi = scanner.nextInt();
        int s = pobocka.pridejZbozi(idZbozi, pocetZbozi);
        if (s == 0)
            System.out.println("Zbozi bylo pridano");
        else if (s == -1)
            System.out.println("Zbozi neexistuje");
        else
            System.out.println("Chyba pri pridavani zbozi");

    }

    private static void odeberZbozi() throws IOException {
        if (pobocka == null) {
            System.out.println("Nejdrive musis vybrat pobocku");
            return;
        }
        System.out.println("\nOdebrani zbozi");
        System.out.println("Zadej id zbozi");
        int idZbozi = scanner.nextInt();
        System.out.println("Zadej pocet kusu zbozi: ");
        int pocetZbozi = scanner.nextInt();
        int s = pobocka.odeberZbozi(idZbozi, pocetZbozi);
        if (s == 0)
            System.out.println("Zbozi bylo odebrano");
        else if (s == -1)
            System.out.println("Zbozi neexistuje");
        else if (s == -2)
            System.out.println("Nedostatek zbozi");
        else
            System.out.println("Chyba pri odebirani zbozi");

    }

    private static void pridejNoveZbozi() throws IOException {
        if (pobocka == null) {
            System.out.println("Nejdrive musis vybrat pobocku");
            return;
        }
        System.out.println("\nPridani zbozi");
        System.out.println("Zadej id zbozi");
        int idZbozi = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Zadej nazev zbozi: ");
        String nazevZbozi = scanner.nextLine();
        System.out.println("Zadej cenu zbozi: ");
        int cenaZbozi = scanner.nextInt();
        System.out.println("Zadej pocet kusu zbozi: ");
        int pocetZbozi = scanner.nextInt();
        Zbozi zbozi = new Zbozi(idZbozi, nazevZbozi, cenaZbozi, pocetZbozi);
        int s = pobocka.pridejNoveZbozi(zbozi);
        if (s == 0)
            System.out.println("Zbozi bylo pridano");
        else if (s == -4)
            System.out.println("Zbozi s timto id uz existuje");
        else
            System.out.println("Chyba pri pridavani zbozi");
    }

    private static void vyberPobocku() throws IOException {
        System.out.println("\nVyber jine pobocka pro dalsi aktivity");
        System.out.println("Zadej id pobocky");
        int idPobocky = scanner.nextInt();
        pobocka = Pobocka.getInstance(idPobocky, "", false);
        System.out.println("Pracuji s " + pobocka);
    }

    private static void vytvorPobocku() throws IOException {
        System.out.println("\nNova pobocka, vytvoreni souboru");
        System.out.println("Zadej id pobocky");
        int idPobocky = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Zadej nazev pobocky: ");
        String nazevPobocky = scanner.nextLine();
        pobocka = Pobocka.getInstance(idPobocky, nazevPobocky, true);
        System.out.println("Pracuji s " + pobocka);
    }

    private static void megaVypis() throws IOException {
        Path folder = Path.of(Pobocka.path);
        System.out.println("Mega vypis");
        Files.list(folder).forEach(file -> {
            try {
                Pobocka p = Pobocka.getInstance(file);
                System.out.println(p.vypisZbozi());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    private static String kdeJeZbozi(int id) throws IOException {
        StringBuilder sb = new StringBuilder();
        Path folder = Path.of(Pobocka.path);
        Files.list(folder).forEach(file -> {
            try {
                Pobocka p = Pobocka.getInstance(file);
                p.getZbozi().stream().filter(z -> z.getId() == id).findFirst().ifPresent(z -> sb.append("\n"+p.getJmeno() + " : " + z.getPocet_na_sklade() + " ks"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return sb.toString();
    }
}