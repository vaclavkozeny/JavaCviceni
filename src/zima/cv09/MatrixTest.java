package src.zima.cv09;

import java.util.Scanner;

public class MatrixTest {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //double[][] matA = MatrixTools.nactiMatici(3, 3);
        int[][] matB = new int[][]{{3, 2, 1}, {4, 1, 2}, {1, 4, 3}};
        //MatrixTools.vypisMatici(MatrixTools.souctetMatic(matA, matB));
        System.out.println(MatrixTools.jeSymetrickaDleDiag(matB));
        System.out.println(MatrixTools.jeSymetrickaDleDiag2(matB));
        System.out.println(MatrixTools.jeSymetrickaDleHorizOsy(matB));
        System.out.println(MatrixTools.jeSymetrickaDleVertOsy(matB));
        vypisMaticiTest(MatrixTools.jednotkovaMatice(6));
    }
    private static void vypisMaticiTest(double[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.format("%.0f ",mat[i][j]);
            }
            System.out.println();
        }
    }
    private static double[][] nactiMaticiTest(int a, int b){
        System.out.format("zadej matici %dx%d\n",a,b);
        double[][] mat = new double[a][b];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                mat[i][j] = scanner.nextInt();
        scanner.nextLine();
        return mat;
    }
}
