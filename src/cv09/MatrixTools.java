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
        int rowsA = a.length;
        int colsA = a[0].length;
        double[][] r = new double[rowsA][colsA];
        for(int i=0;i<rowsA;i++){
            for(int j=0;j<colsA;j++){
                r[i][j] = a[j][i];
            }
        }
        return r;
    }
    public static double[][] jednotkovaMatice(int n){
        double[][] r = new double[n][n];
        for(int i=0;i<r.length;i++){
            for(int j=0;j<r[0].length;j++){
                if(i == j){
                    r[i][j] = 1;
                }else{
                    r[i][j] = 0;
                }
            }
        }
        return r;
    }
    public static void prevedDoNorm(double[][] a) {
        int rowsA = a.length;
        int colsA = a[0].length;
        double max = 0;
        for(int i=0;i<rowsA;i++){
            for(int j=0;j<colsA;j++){
                if(a[i][j] > max){
                    max = a[i][j];
                }
            }
        }
        for(int i=0;i<rowsA;i++){
            for(int j=0;j<colsA;j++){
                a[i][j] /= Math.abs(max);
            }
        }
    }
    public static boolean jeSymetrickaDleDiag(int[][] a) {
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j] != a[j][i]){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean jeSymetrickaDleDiag2(int[][] a) {
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[j][i] != a[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean jeSymetrickaDleHorizOsy(int[][] a) {
        return false;
    }
    public static boolean jeSymetrickaDleVertOsy(int[][] a) {
        return false;
    }
    public static void vypisMaticiTest(double[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.format("%.0f ",mat[i][j]);
            }
            System.out.println();
        }
    }
        public static double[][] nactiMaticiTest(int a, int b){
        System.out.format("zadej matici %dx%d\n",a,b);
        double[][] mat = new double[a][b];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                mat[i][j] = scanner.nextInt();
        scanner.nextLine();
        return mat;

    }
}
