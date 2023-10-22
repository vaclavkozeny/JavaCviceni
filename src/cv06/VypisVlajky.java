package src.cv06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VypisVlajky {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int w, h, temp;
        // sem by se vice hodil char, ale char neumí emotikovy (umí jen bíly ctverecek)
        // takto mohu použít i cerveny a modry ctverecek 🟦 ⬜ 🟥
        System.out.println("Zadej sirku a vysku vlajky (vyska misi byt suda)");
        try {
            w = scanner.nextInt();
            h = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Spatny vstup");
        }
        // prohodi sirku a vysku aby byl zachovan pomer (vyska < delka)
        if(w < h){
            System.out.println("Doslo k prohozeni hodnot, aby platilo (vyska < delka) \n");
            temp = w;
            w = h;
            h = temp;
        }
        if(h % 2 != 0){
            //throw new ArithmeticException("Vyska neni suda");
            System.out.println("Vyska neni suda");
            System.exit(6);
        }
        //horni polovina vlajky
        for (int i = 0; i < h/2; i++) {
            for (int b = 0; b < i+1; b++) {
                System.out.print("🟦");
            }
            for(int a = 0; a < w-1-i; a++){
                System.out.print("⬜");
            }
            System.out.print("\n");
        }
        //spodni polovina vlajky
        for (int i = h/2; i > 0; i--) {
            for (int b = 0; b < i; b++) {
                System.out.print("🟦");
            }
            for (int a = 0; a < w-i; a++) {
                System.out.print("🟥");
            }
            System.out.print("\n");
        }
    }
}
