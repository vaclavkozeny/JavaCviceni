package src.cv11;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;



public final class PexesoTools {
    private static Random random = new Random();

    public PexesoTools() {}

    /**
     * permutate array
     * @param n
     * @return
     */
    public static int[] permutateArray(int n){
        int[] a = new int[n];
        for(int i = 0; i<a.length;i++){
            a[i] = i+1;
        }
        for(int i = 0; i<a.length;i++){
            int swap = random.nextInt(a.length);
            int temp = a[i];
            a[i] = a[swap];
            a[swap] = temp;
        }
        return a;
    }
    public static int[][] getMaticePexeso(int radky, int sloupce){
        //vytvori matici a umisti do ni cisla 1,2 .. n, kazde cislo 2x
        int[][]a = new int[radky][sloupce];
        int n = (radky*sloupce)/2;
        int[] g1 = permutateArray(n);
        int[] g2 = permutateArray(n);
        int[] game = ArrayUtils.addAll(g1, g2);
        int gamePosition = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length;j++){
                if(gamePosition < game.length){
                    a[i][j] = game[gamePosition];
                }else{
                    a[i][j] = 0;
                }

                gamePosition++;
            }
        }
        return a;
    }
    public static boolean jeMaticePexeso(int[][]a){
        int radky = a.length;
        int sloupce = a[0].length;
        int dvojice = (radky*sloupce)/2;
        for(int i = 1; i <= dvojice; i++){
            int counter = 0;
            for (int[]r:a) {
                for (int c:r) {
                    if(c == i){
                        counter++;
                    }
                }
            }
            if(counter != 2){
                return false;
            }
        }
        return true;
    }
    public static double rozhazenost(int[][]a){
        //TODO predelat na pole a ne list
        int radky = a.length;
        int sloupce = a[0].length;
        int dvojice = (radky*sloupce)/2;
        List<Integer> hodnoty = new ArrayList<Integer>();
        for(int i = 1; i <= dvojice; i++){
            List<Integer> indexyCisel = new ArrayList<Integer>();
            for(int j=0;j<radky;j++){
                for(int k=0;k<sloupce;k++){
                    if(a[j][k] == i){
                        indexyCisel.add(j);
                        indexyCisel.add(k);
                    }
                }
            }
            //vzdalenost = abs[r1-r2] + abs[s1-s2]
            int vzd = Math.abs(indexyCisel.get(0) - indexyCisel.get(2)) + Math.abs(indexyCisel.get(1) - indexyCisel.get(3));
            hodnoty.add(vzd);
        }
        double sum = 0;
        for (int i = 0; i < hodnoty.size(); i++) {
            sum += hodnoty.get(i);
        }
        return sum/hodnoty.size();
    }
    private static void vypisMatice(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                System.out.format("%s ",mat[i][j]);
            }
            System.out.println();
        }
    }

}
