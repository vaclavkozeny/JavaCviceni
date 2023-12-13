package src.testy.zkouska;

import java.util.Scanner;

public class Avg2D {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Zadej pocet bodu");
        int pocet = scanner.nextInt();
        int[]x = new int[pocet];
        int[]y = new int[pocet];
        for (int i = 0; i < pocet; i++) {
            System.out.format("zadavas %d. bod\n",i+1);
            int xi = scanner.nextInt();
            int yi = scanner.nextInt();
            x[i] = xi;
            y[i] = yi;
        }
        double df = 0;
        for (int i = 0; i < pocet; i++) {
            for (int j = 0; j < pocet; j++) {
                if(i==j)
                    continue;
                df = df + Math.sqrt(Math.pow((x[i]-x[j]),2) + Math.pow((y[i]-y[j]),2));
            }
        }
        System.out.format("%.2f",df/((pocet)*(pocet-1)));
    }
}
