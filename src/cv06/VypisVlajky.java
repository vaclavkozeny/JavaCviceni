package src.cv06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VypisVlajky {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int w, h, temp;

        // sem by se vice hodil char, ale char neumí emotikovy (umí jen bily ctverecek ⬜)
        // takto lze pouzit i cerveny a modry ctverecek 🟦 🟥 a vlajka vypada lepe
        String z1, z2, z3;
        System.out.println("Zadej sirku a vysku vlajky (vyska misi byt suda)");
        try {
            w = scanner.nextInt();
            h = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Spatny vstup");
        }
        System.out.println("Zadej znaky pro modrou, bilou a cervenou cast (Muzes zkopirovat:\uD83D\uDFE6 ⬜ \uD83D\uDFE5)");
        z1 = scanner.next();
        z2 = scanner.next();
        z3 = scanner.next();

        // ostreni proti delsim slovum
        // maximalne dva znaky / nebo jeden emotikon
        if(z1.length() > 2){
            z1 = z1.substring(0,1);
        }
        if(z2.length() > 2){
            z2 = z2.substring(0,1);
        }
        if(z3.length() > 2){
            z3 = z3.substring(0,1);
        }

        // prohodi sirku a vysku aby byl zachovan pomer (vyska < delka)
        if (w < h) {
            System.out.println("Doslo k prohozeni hodnot, aby platilo (vyska < delka) \n");
            temp = w;
            w = h;
            h = temp;
        }
        if (h % 2 != 0) {
            //throw new ArithmeticException("Vyska neni suda");
            System.out.println("Vyska neni suda");
            System.exit(6);
        }
        //horni polovina vlajky
        for (int i = 0; i < h / 2; i++) {
            for (int b = 0; b <= i; b++) {
                System.out.print(z1);
            }
            for (int a = 0; a < w - 1 - i; a++) {
                System.out.print(z2);
            }
            System.out.print("\n");
        }
        //spodni polovina vlajky
        for (int i = h / 2; i > 0; i--) {
            for (int b = 0; b < i; b++) {
                System.out.print(z1);
            }
            for (int a = 0; a < w - i; a++) {
                System.out.print(z3);
            }
            System.out.print("\n");
        }
    }
}
