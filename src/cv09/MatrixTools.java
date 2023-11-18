package src.cv09;

import java.util.Scanner;

public final class MatrixTools {
    private static final Scanner scanner = new Scanner(System.in);
    private MatrixTools() {}


    /**
     * Metoda pro scitani matice
     * @param a matice 1
     * @param b matice 2
     * @return soucet matic, null pokud nelze akci provest
     */
    public static double[][] souctetMatic(double[][] a, double[][] b){
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;
        if(rowsA != rowsB || colsA != colsB){
            return null;
        }
        double[][] r = new double[rowsA][colsA];
        for(int i=0;i<rowsA;i++){
            for(int j=0;j<colsA;j++){
                r[i][j]=a[i][j]+b[i][j];
            }
        }
        return r;
    }

    /**
     * Soucin matic.
     * @param a prvni matice
     * @param b druha mmatice
     * @return soucet matic nebo null, pokud nezle soucin vypocitat
     */
    public static double[][] soucinMatic(double[][] a, double[][] b){
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;
        if(rowsA != rowsB || colsA != colsB){
            return null;
        }
        double[][] r = new double[rowsA][colsA];
        for(int i=0;i<rowsA;i++){
            for(int j=0;j<colsB;j++){
                for (int k=0;k<colsA;k++) {
                    r[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return r;
    }
    public static double[][] maticeTransponovana(double[][] a) {
        return null;
    }
    public static void prevedDoNorm(double[][] a) {

    }
    public static boolean jeSymetrickaDleDiag(int[][] a) {
        return false;
    }
    public static boolean jeSymetrickaDleDiag2(int[][] a) {
        return false;
    }
    public static boolean jeSymetrickaDleHorizOsy(int[][] a) {
        return false;
    }
    public static boolean jeSymetrickaDleVertOsy(int[][] a) {
        return false;
    }
    public static void vypisMatici(double[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.format("%6.2f",mat[i][j]);
            }
            System.out.println();//new line
        }
    }
        public static double[][] nactiMatici(int a, int b){
        System.out.format("zadej matici %dx%d\n",a,b);
        double[][] mat = new double[a][b];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                mat[i][j] = scanner.nextInt();
        scanner.nextLine();
        return mat;

    }
}
