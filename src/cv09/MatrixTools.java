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
        if(a == null && b == null){
            return null;
        }
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
        if(a == null && b == null){
            return null;
        }
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;
        if(colsA != rowsB){
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

    /**
     * Matoda pro tranpozici zadane matice
     * @param a Vstupni matice
     * @return Transponovana matice
     */
    public static double[][] maticeTransponovana(double[][] a) {
        if(a == null){
            return null;
        }
        int rowsA = a.length;
        int colsA = a[0].length;
        double[][] r = new double[colsA][rowsA];
        for(int i=0;i<rowsA;i++){
            for(int j=0;j<colsA;j++){
                r[i][j] = a[j][i];
            }
        }
        return r;
    }

    /**
     * Metoda pro vytvoreni jednotkove matice o zadanem rozmeru
     * @param n rozmer
     * @return jednotkova matice
     */
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

    /**
     * Prevede matici do "normaloveho" tvaru, tedy prvky (-1,1)
     * @param a vstupni matice
     */
    public static void prevedDoNorm(double[][] a) {
        if(a == null){
            return;
        }
        int rowsA = a.length;
        int colsA = a[0].length;
        double max = 0;
        for(int i=0;i<rowsA;i++){
            for(int j=0;j<colsA;j++){
                if(Math.abs(a[i][j]) > max){
                    max = Math.abs(a[i][j]);
                }
            }
        }
        for(int i=0;i<rowsA;i++){
            for(int j=0;j<colsA;j++){
                a[i][j] /= max;
            }
        }
    }

    /**
     * Varti zdali je matice symetricka podle hlavni diagonaly
     * @param a vstupni matice
     * @return true/false
     */
    public static boolean jeSymetrickaDleDiag(int[][] a) {
        if(a == null){
            return false;
        }
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j] != a[j][i]){
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Varti zdali je matice symetricka podle vedlejsi diagonaly
     * @param a vstupni matice
     * @return true/false
     */
    public static boolean jeSymetrickaDleDiag2(int[][] a) {
        if(a == null){
            return false;
        }
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if (a[i][j] != a[a.length-1-j][a[0].length-1-i]) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Varti zdali je matice symetricka podle horizontalni osy
     * @param a vstupni matice
     * @return true/false
     */
    public static boolean jeSymetrickaDleHorizOsy(int[][] a) {
        if(a == null){
            return false;
        }
        int rowsA = a.length;
        int colsA = a[0].length;
        if(rowsA != colsA){
            return false;
        }
        int stred = (int) Math.ceil((double) colsA / 2);
        for(int i=0;i<stred;i++){
            for(int j=0;j<colsA;j++){
                if(a[i][j] != a[rowsA-1-i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Varti zdali je matice symetricka podle vertikalni osy
     * @param a vstupni matice
     * @return true/false
     */
    public static boolean jeSymetrickaDleVertOsy(int[][] a) {
        if(a == null){
            return false;
        }
        int rowsA = a.length;
        int colsA = a[0].length;
        if(rowsA != colsA){
            return false;
        }
        int stred = (int) Math.ceil((double) colsA / 2);
        for(int i=0;i<rowsA;i++){
            for(int j=0;j<stred;j++){
                if(a[i][j] != a[i][colsA-1-j]){
                    return false;
                }
            }
        }
        return true;
    }

}
