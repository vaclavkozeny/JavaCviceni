package src.cv10;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MagickyCtverec {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Zadej pocet radku");
        int radky = scanner.nextInt();
        System.out.println("Zadej pocet sloupcu");
        int slupce = scanner.nextInt();
        int[][] mat = nactiMatici(radky,slupce);
//        int[][] mat = {{2,7,6},{9,5,1},{4,3,8}};
//        System.out.println(containNumbers(mat));
        System.out.format(isMagical(mat)?"Je magicky":"Neni magicky");

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
    public static boolean isMagical(int[][]a){
        if(!containNumbers(a)){
            throw new InputMismatchException("Ctverec neobsahuje vsechna cisla");
        }
        int l = a.length;
        int suma = l*(l*l+1)/2;
        for (int i = 0; i < l; i++) {
            int sumaRadku = 0;
            for (int j = 0; j < l; j++) {
                sumaRadku += a[i][j];
            }
            if (sumaRadku != suma) {
                return false;
            }
        }
        for (int i = 0; i < l; i++) {
            int sumaSloupcu = 0;
            for (int j = 0; j < l; j++) {
                sumaSloupcu += a[j][i];
            }
            if (sumaSloupcu != suma) {
                return false;
            }
        }
        int diagSuma = 0;
        for (int i = 0; i < l; i++) {
            diagSuma += a[i][i];
        }
        if (diagSuma != suma) {
            return false;
        }
        diagSuma = 0;
        for (int i = 0; i < l; i++) {
            diagSuma += a[i][l - 1 - i];
        }
        if (diagSuma != suma) {
            return false;
        }
        return true;
    }
}
