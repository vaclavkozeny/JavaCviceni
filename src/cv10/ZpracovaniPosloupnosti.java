package src.cv10;

import java.util.Scanner;

public class ZpracovaniPosloupnosti {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Zadej pocet posloupnosti");
        int pocet = scanner.nextInt();
        final int DELTA = 10;
        int[][] posloupnosti = new int[pocet][];
        for(int i = 0; i < pocet; i++){
            System.out.println("Zadej pocet hodnot posloupnosti");
            int n = scanner.nextInt();
            int[] b = new int[n];
            for(int j = 0; j < n; j++){
                b[j] = scanner.nextInt();
            }
            posloupnosti[i] = b;
        }
        vypisMatici(posloupnosti);
    }
    private static void vypisMatici(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                System.out.format("%s ",mat[i][j]);
            }
            System.out.println();
        }
    }
}
