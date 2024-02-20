package src.zima.testy.zkouska;


import java.util.Scanner;

public class matice {
    private static final Scanner scanner = new Scanner(System.in);
    private static final double EPS = 1e-5;

    public static void main(String[] args) {
        System.out.println("Zadej rozmer");
        int r = scanner.nextInt();
        double[][] mat = new double[r][r];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = scanner.nextDouble();
            }
        }
        for (int i = 0; i < mat.length; i++) {
            double sum = 0;
            for (int j = 0; j < mat[0].length; j++) {
                sum += mat[i][j];
            }
            if(!(Math.abs(sum-1)<EPS)){
                System.out.println("Neni schonicka");
                System.exit(0);
            }
        }
        System.out.println("Je schonicka");
    }
}
