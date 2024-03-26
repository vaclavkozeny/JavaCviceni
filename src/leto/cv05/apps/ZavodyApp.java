package src.leto.cv05.apps;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import src.leto.cv05.zavody.*;
public class ZavodyApp {
    static Zavod zavod;
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        zavod = Zavod.getZavod("Jiz50");
        registraceZavodnika("Hynek","Hejna");
        registraceZavodnika("Adam","Adam");
        zadaniStartu(1,LocalTime.of(12,15,30));
        zadaniCile(1,LocalTime.of(15,25,0));
        zadaniStartu(2,LocalTime.of(15,20,0));
        zadaniCile(2,LocalTime.of(15,31,0));
        System.out.println(vypisZavodniky(MetodaRazeniZavodniku.DLE_DOBY_ZAVODU));
    }
    public static void registraceZavodnika(String jmeno, String prijmeni){
        zavod.registraceZavodnika(jmeno,prijmeni);
    }
    public static String vypisZavodniky(MetodaRazeniZavodniku metodaRazeni){
        return zavod.toString(metodaRazeni);
    }
    public static void Odregistrace(int regCislo){

    }
    public static void zadaniStartu(int regCislo, LocalTime start){
        zavod.zaznamenejStart(regCislo, start);
    }
    public static void zadaniCile(int regCislo, LocalTime cil){
        zavod.zaznamenejCil(regCislo, cil);
    }
}
