package src.cv10;

import java.util.Arrays;
import java.util.Scanner;

public class MagickyCtverec {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Zadej pocet radku");
        int radky = scanner.nextInt();
        System.out.println("Zadej pocet sloupcu");
        int slupce = scanner.nextInt();
        int[][] mat = nactiMatici(radky,slupce);
        System.out.println(containNumbers(mat));

    }
    private static void vypisMatici(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                System.out.format("%s ",mat[i][j]);
            }
            System.out.println();
        }
    }
    private static int[][] nactiMatici(int a, int b){
        int[][] mat = new int[a][b];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                mat[i][j] = scanner.nextInt();
        scanner.nextLine();
        return mat;
    }
    private static boolean containNumbers(int[][] a){
        int n = a.length;
        int[] cisla = new int[n*n];
        int numero = 0;
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n;j++){
                cisla[numero] = a[i][j];
                numero++;
            }
        }
        Arrays.sort(cisla);
        for(int i = 0; i<cisla.length;i++){
            if(cisla[i] != i+1){
                return false;
            }
        }
        return true;
    }
    private static boolean soucty(int[][] a){
        int n = a.length;
        int soucet = 0;
        int temp = 0;
        for(int i = 0; i<n; i++){
            temp = temp + a[i][i];
        }
        soucet = temp;
        temp = 0;
        for(int i = 0; i<n; i++){
            temp = temp + a[n-(i-1)][n-(i-1)];
        }
        if(soucet != temp){
            return false;
        }
        return true;
    }
}
