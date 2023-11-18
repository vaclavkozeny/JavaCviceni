package src.cv05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VypisVlajky {
    private static final Scanner scanner = new Scanner(System.in);

    // neni potreba ale vlajka vypada lepe
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        int w, h, temp;
        char z1, z2, z3;
        System.out.println("Zadej sirku a vysku vlajky (vyska musi byt suda)");
        try {
            w = scanner.nextInt();
            h = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Spatny vstup");
        }
        System.out.println("Zadej znaky pro modrou, bilou a cervenou cast ");
        z1 = scanner.next().charAt(0);
        z2 = scanner.next().charAt(0);
        z3 = scanner.next().charAt(0);

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
        if(h < 4){
            System.out.println("Zadana vyska je moc mala");
            System.exit(6);
        }
        //horni polovina vlajky
        for (int i = 0; i < h / 2; i++) {
            for (int b = 0; b <= i; b++) {
                System.out.print(BLUE + z1 + " " + RESET);
            }
            for (int a = 0; a < w - 1 - i; a++) {
                System.out.print(z2 + " ");
            }
            System.out.print("\n");
        }
        //spodni polovina vlajky
        for (int i = h / 2; i > 0; i--) {
            for (int b = 0; b < i; b++) {
                System.out.print(BLUE + z1 + " " + RESET);
            }
            for (int a = 0; a < w - i; a++) {
                System.out.print(RED + z3 + " " + RESET);
            }
            System.out.print("\n");
        }
    }
}
