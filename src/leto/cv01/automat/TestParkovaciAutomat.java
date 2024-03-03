package src.leto.cv01.automat;

import java.util.ArrayList;
import java.util.Scanner;

public class TestParkovaciAutomat {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // vytvori automat
        ParkovaciAutomat parkovaciAutomat = new ParkovaciAutomat(0.5);

        //vypise a obslouzi 1. menu
        vypisMenu();
        int volba = scanner.nextInt();
        obsluzVolbu(volba);

        //vypise a obslouzi 2. menu
        volba = scanner.nextInt();
        obsluzVolbuParkovat(volba, parkovaciAutomat);

        //vypise a obslouzi 3. menu
        vypisMenuPlatit(parkovaciAutomat);
        volba = scanner.nextInt();
        System.out.println(obsluzVolbuPlatit(volba, parkovaciAutomat));
    }

    private static void obsluzVolbu(int v) {
        if(v == 1)
            vypisMenuParkovat();
        else
            System.exit(0);
    }
    private static void obsluzVolbuParkovat(int v, ParkovaciAutomat pa) {
        if(v == 1){
            MinceCyklus(pa);
        }
        else
            System.exit(0);

    }
    private static void MinceCyklus(ParkovaciAutomat pa){
        int v;
        do {
            vypisMenuMince(pa);
            v = scanner.nextInt();
            pa.VhodMinci(v);
        }while (v > 0);
    }
    private static String obsluzVolbuPlatit(int v, ParkovaciAutomat pa) {
        if(v == 1){
            return pa.Pay();
        }
        else if(v == 0){
            return String.format("Bylo vam vraceno %d korun",pa.getAktualniStavVAutomatu());
        }
        return "Neznama volba";
    }

    private static void vypisMenu() {
        System.out.println("Parkovaci automat");
        System.out.println("1. Parkovat");
        System.out.println("0. Konec");
    }
    private static void vypisMenuParkovat() {
        System.out.println("Parkovat");
        System.out.println("1. Vlozit mince");
        System.out.println("0. Konec");
    }
    private static void vypisMenuPlatit(ParkovaciAutomat pa) {
        System.out.format("Aktualni stav je: %d\n",pa.getAktualniStavVAutomatu());
        System.out.println("1. Zaplatit");
        System.out.println("0. Storno");
    }
    private static void vypisMenuMince(ParkovaciAutomat pa) {
        System.out.println("Vhazuj mince");
        System.out.format("Aktualni stav: %d\n",pa.getAktualniStavVAutomatu());
        System.out.println("1. Koruna");
        System.out.println("2. Dvoukoruna");
        System.out.println("3. Petikoruna");
        System.out.println("4. Desetikoruna");
        System.out.println("5. Dvacetikoruna");
        System.out.println("6. Padesatikoruna");
        System.out.println("0. Konec");
    }
}
