package src.cv09;

import java.util.Scanner;

public final class MatrixTools {
    private static final Scanner scanner = new Scanner(System.in);
    //predpoklad - maji stejne dlouhe radky
    public static double[][] matA = null;
    public static double[][] matB = null;
    private MatrixTools() {}
    //scitani
    //nasobeni
    public static void main(String[] args) {
        //matA = new double[][]{{1, 3, 2}, {3, 2, 1}, {4, 5, 6}};
        matA = nactiMatici(3,3);
        matB = new double[][]{{1, 3, 2}, {3, 2, 1}, {4, 5 ,6}};
        vypisMatici(souctetMatic(matA, matB));
    }

    /**
     * Metoda pro scitani matice
     * @param a matice 1
     * @param b matice 2
     * @return soucet matic, null pokud nelze akci provest
     */
    public static double[][] souctetMatic(double[][] a, double[][] b){
        /*
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                a[i][j] = sc.nextInt();

         */
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
                r[i][j]=a[i][j]+b[i][j];    //use - for subtraction
            }
        }
        return r;
    }

    /**
     * Metoda pro nasobeni matice
     * @param a matice 1
     * @param b matice 2
     * @return soucet matic, null pokud nelze akci provest
     */
    public static double[][] soucinMatic(double[][] a, double[][] b){
        /*
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                a[i][j] = sc.nextInt();

         */
        return null;
    }
    public static double[][] nactiMatici(int a, int b){
        scanner.nextLine();
        System.out.println("zadej matici");
        double[][] mat = new double[a][b];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                mat[i][j] = scanner.nextInt();
        return mat;

    }
    public static void vypisMatici(double[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.format("%6.2f",mat[i][j]);
            }
            System.out.println();//new line
        }
    }
    private static void vypisMenu(){
        System.out.println("\nHlavni menu programu");
        System.out.println("1. nacti prvni matici");
        System.out.println("2. nacti druhou matici");
        System.out.println("3. vypis matice");
        System.out.println("4. prohodit matice");
        System.out.println("5. vypocitat a vypsat soucet matic");
        System.out.println("6. vypocitat a vypsat soucin matic");
    }
}
