package src.leto.cv01.automat;

import java.util.ArrayList;
import java.util.Scanner;

public class TestParkovaciAutomat {
    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<ParkovaciAutomat.mince> platba;
    private static int aktualniStavVAutomatu;
    public static void main(String[] args) {
        ParkovaciAutomat parkovaciAutomat = new ParkovaciAutomat(0.5);
        platba = new ArrayList<ParkovaciAutomat.mince>();
        vypisMenu();
        int volba = scanner.nextInt();
        obsluzVolbu(volba);
        volba = scanner.nextInt();
        obsluzVolbuParkovat(volba, parkovaciAutomat);
//        ParkovaciAutomat parkovaciAutomat = new ParkovaciAutomat(0.5);
//        ArrayList<ParkovaciAutomat.mince> platba = new ArrayList<ParkovaciAutomat.mince>();
//        platba.add(ParkovaciAutomat.mince.DVACETIKORUNA);
//        platba.add(ParkovaciAutomat.mince.DESETIKORUNA);
//        System.out.println(parkovaciAutomat.Pay(platba));
    }

    private static void obsluzVolbu(int v) {
        if(v == 1)
            vypisMenuParkovat();
    }
    private static void obsluzVolbuParkovat(int v, ParkovaciAutomat pa) {
        if(v == 1){
            aktualniStavVAutomatu = 0;
            VhazovatMince();
        } else if (v == 2) {
            System.out.println(pa.Pay(platba));
        }

    }
    private static void VhazovatMince(){
        int volba;
        do{
            vypisMenuMince();
            volba = scanner.nextInt();
            switch (volba){
                case 1: platba.add(ParkovaciAutomat.mince.KORUNA);aktualniStavVAutomatu+=1;break;
                case 2: platba.add(ParkovaciAutomat.mince.DVOUKORUNA);aktualniStavVAutomatu +=2;break;
                case 3: platba.add(ParkovaciAutomat.mince.PETIKORUNA);aktualniStavVAutomatu +=5;break;
                case 4: platba.add(ParkovaciAutomat.mince.DESETIKORUNA);aktualniStavVAutomatu +=10;break;
                case 5: platba.add(ParkovaciAutomat.mince.DVACETIKORUNA);aktualniStavVAutomatu +=20;break;
                case 6: platba.add(ParkovaciAutomat.mince.PADESATIKORUNA);aktualniStavVAutomatu +=50;break;
                case 0: break;
                default:
                    System.out.println("Neznama volba\n");
                    break;
            }
        }while (volba > 0);
    }
    private static void vypisMenu() {
        System.out.println("Parkovaci automat");
        System.out.println("1. Parkovat");
        System.out.println("0. Konec");
    }
    private static void vypisMenuParkovat() {
        System.out.println("Parkovat");
        System.out.println("1. Vlozit mince");
        System.out.println("2. Zaplatit");
        System.out.println("0. Storno");
    }
    private static void vypisMenuMince() {
        System.out.println("Vhazuj mince");
        System.out.format("Aktualni stav: %d\n",aktualniStavVAutomatu);
        System.out.println("1. Koruna");
        System.out.println("2. Dvoukoruna");
        System.out.println("3. Petikoruna");
        System.out.println("4. Desetikoruna");
        System.out.println("5. Dvacetikoruna");
        System.out.println("6. Padesatikoruna");
        System.out.println("0. Konec");
    }
}
