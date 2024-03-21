package src.leto.cv05.zavody;

import java.time.LocalTime;
import java.util.Scanner;

public class ZavodyTest {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Zavod zavod = Zavod.getZavod("50");
        zavod.registraceZavodnika("Martin","Kouble");
        zavod.registraceZavodnika("Vaclav","Kozeny");
        zavod.zaznamenejStart(1, LocalTime.now());
        System.out.println(zavod);
    }
}
