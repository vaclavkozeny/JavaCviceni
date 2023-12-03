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
     * vytvori zamichane pole o velikosti n
     * @param n velikost pole
     * @return zamichane pole
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

    /**
     * vytvori hraci plochu pro pexeso
     * @param radky pocet radku
     * @param sloupce pocet sloupcu
     * @return dvourozmerne pole pro hru pexeso
     */
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

    /**
     * vrati zda-li je matice pexesem (tedy je zde spravny pocet dvojic)
     * @param a vstupni matice
     * @return T/F
     */
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

    /**
     * vrati prumernou vzdalenost mezi dvema prvky
     * @param a vstupni matice
     * @return prumerna vzdalenost
     */
    public static double rozhazenost(int[][]a){
        int radky = a.length;
        int sloupce = a[0].length;
        int dvojice = (radky*sloupce)/2;
        int[] hodnoty = new int[dvojice];
        for(int i = 1; i <= dvojice; i++){
            int tempj = -1,tempk = -1;
            iterace:
            for(int j=0;j<radky;j++){
                for(int k=0;k<sloupce;k++){
                    if(a[j][k] == i){
                        if(tempj > -1 && tempk > -1){
                            int vzd = Math.abs(tempj - j) + Math.abs(tempk - k);
                            hodnoty[i-1] = vzd;
                            break iterace;
                        }
                        tempj = j;
                        tempk = k;
                    }
                }
            }
            if((tempj == -1 || tempk == -1)){
                return -i;
            }
        }
        double sum = 0;
        for (int i = 0; i < hodnoty.length; i++) {
            sum += hodnoty[i];
        }
        return sum/hodnoty.length;

        /**
         * Chtel bych se zeptat jestli je zakomentovane reseni taky dobre nebo ne?
         **/
//        //TODO predelat na pole
//        int radky = a.length;
//        int sloupce = a[0].length;
//        int dvojice = (radky*sloupce)/2;
//        List<Integer> hodnoty = new ArrayList<Integer>();
//        for(int i = 1; i <= dvojice; i++){
//            List<Integer> indexyCisel = new ArrayList<Integer>();
//            for(int j=0;j<radky;j++){
//                for(int k=0;k<sloupce;k++){
//                    if(a[j][k] == i){
//                        indexyCisel.add(j);
//                        indexyCisel.add(k);
//                    }
//                }
//            }
//            //vzdalenost = abs[r1-r2] + abs[s1-s2]
//            int vzd = Math.abs(indexyCisel.get(0) - indexyCisel.get(2)) + Math.abs(indexyCisel.get(1) - indexyCisel.get(3));
//            hodnoty.add(vzd);
//        }
//        double sum = 0;
//        for (int i = 0; i < hodnoty.size(); i++) {
//            sum += hodnoty.get(i);
//        }
//        return sum/hodnoty.size();
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
