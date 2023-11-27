package src.cv10;

import java.util.Scanner;

public class ZpracovaniPosloupnosti {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Zadej pocet posloupnosti");
        int pocet = scanner.nextInt();
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
        int maxCisel = 0;
        int maxIndex = 0;
        for(int i = 0; i < posloupnosti.length; i++){
            ArrayTools.sort(posloupnosti[i]);
            int po = ArrayTools.pocetRuznychUsp(posloupnosti[i]);
            if(ArrayTools.pocetRuznychUsp(posloupnosti[i])>maxCisel){
                maxCisel = po;
                maxIndex = i;
            }
            System.out.format("%d: ",i);
            vypisPole(posloupnosti[i]);
            System.out.format("| %d \n",po);
        }
        System.out.format("Maximalni pocet cisel je u %d posloupnosti",maxIndex);
        //vypis(posloupnosti);
    }
    private static void vypis(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                System.out.format("%s ",mat[i][j]);
            }
            System.out.println();
        }
    }
    private static void vypisPole(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.format("%d ",a[i]);
        }
    }
}
