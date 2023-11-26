package src.cv10;

import java.util.Scanner;

public class SachovnicovaMatice {
    private static final Scanner scanner = new Scanner(System.in);
    //nacteme obdelinkvou matici [char/int] m*n 5*7
    //velikost pole pocet 2
    //vytvori oblasti o velikosti pocet

    public static void main(String[] args) {
        System.out.println("Zadedj radky");
        int radky = scanner.nextInt();
        System.out.println("Zadej sloupce");
        int sloupce = scanner.nextInt();
        System.out.println("Zadej pocet");
        int pocet = scanner.nextInt();
        String[][] pole = new String[radky][sloupce];
        for(int i=0;i<pole.length;i++){
            if(jeLiche(i/pocet)){
                for(int j=0;j<pole[0].length;j++){
                    if(jeLiche(j/pocet)){
                        pole[i][j] = "⬜";
                    }else{
                        pole[i][j] = "🟥";
                    }
                }
            }else{
                for(int j=0;j<pole[0].length;j++){
                    if(jeLiche(j/pocet)){
                        pole[i][j] = "🟥";
                    }else{
                        pole[i][j] = "⬜";
                    }
                }
            }

        }
        vypisMatici(pole);
    }
    private static void vypisMatici(String[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.format("%s ",mat[i][j]);
            }
            System.out.println();
        }
    }
    private static boolean jeLiche(int num){
        return num%2 == 0;
    }
}
