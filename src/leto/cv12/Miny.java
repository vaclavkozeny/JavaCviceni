package src.leto.cv12;

import javax.swing.text.MaskFormatter;
import java.util.logging.XMLFormatter;

public class Miny {
    private static int[][] pole ={
            {0,-1,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,-1,0,0},
            {0,-1,0,0,0,0,0,0,0},
            {0,0,0,-1,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,-1,0},
            {0,0,0,0,-1,0,0,0,0},
            {0,-1,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0}};
    private static boolean[][] mask = {
            {false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false},
            {false,false,false,false,false,false,false,false,false}
    };
    public static void main(String[] args) {
        vypis(pole);
        System.out.println("");

        long startTime = System.nanoTime();
            prepocitejMatici();
        long endTime = System.nanoTime();
        long totalTime = (endTime - startTime);
        System.out.println("Kód běžel " + totalTime + " nano.");

        vypis(pole);
        System.out.println("");
        vypisOdkryti(pole);
    }
    public static void prepocitejMatici(){

        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole[i].length; j++) {
                if(pole[i][j] == -1){
                    if(i > 0 && j > 0 && i<pole.length-1 && j<pole[i].length-1) {
                        if (pole[i - 1][j - 1] != -1) pole[i - 1][j - 1]++;
                        if (pole[i - 1][j] != -1) pole[i - 1][j]++;
                        if (pole[i - 1][j + 1] != -1) pole[i - 1][j + 1]++;
                        if (pole[i][j - 1] != -1) pole[i][j - 1]++;
                        if (pole[i][j + 1] != -1) pole[i][j + 1]++;
                        if (pole[i + 1][j - 1] != -1) pole[i + 1][j - 1]++;
                        if (pole[i + 1][j] != -1) pole[i + 1][j]++;
                        if (pole[i + 1][j + 1] != -1) pole[i + 1][j + 1]++;
                    }
                    if(i == 0 && j == 0){
                        if (pole[i][j + 1] != -1) pole[i][j + 1]++;
                        if (pole[i + 1][j] != -1) pole[i + 1][j]++;
                        if (pole[i + 1][j + 1] != -1) pole[i + 1][j + 1]++;
                    }
                    if(i == pole.length && j == pole[i].length){
                        if (pole[i][j - 1] != -1) pole[i][j - 1]++;
                        if (pole[i - 1][j] != -1) pole[i - 1][j]++;
                        if (pole[i - 1][j - 1] != -1) pole[i - 1][j - 1]++;
                    }
                    if(i == 0 && j == pole[i].length){
                        if (pole[i][j - 1] != -1) pole[i][j - 1]++;
                        if (pole[i + 1][j] != -1) pole[i + 1][j]++;
                        if (pole[i + 1][j - 1] != -1) pole[i + 1][j - 1]++;
                    }
                    if(i == pole.length && j == 0){
                        if (pole[i][j + 1] != -1) pole[i][j + 1]++;
                        if (pole[i - 1][j] != -1) pole[i - 1][j]++;
                        if (pole[i - 1][j + 1] != -1) pole[i - 1][j + 1]++;
                    }
                    if(i == 0 && j > 0 && j < pole[i].length){
                        if (pole[i][j - 1] != -1) pole[i][j - 1]++;
                        if (pole[i][j + 1] != -1) pole[i][j + 1]++;
                        if (pole[i + 1][j - 1] != -1) pole[i + 1][j - 1]++;
                        if (pole[i + 1][j] != -1) pole[i + 1][j]++;
                        if (pole[i + 1][j + 1] != -1) pole[i + 1][j + 1]++;
                    }
                    if(i == pole.length && j > 0 && j < pole[i].length){
                        if (pole[i][j - 1] != -1) pole[i][j - 1]++;
                        if (pole[i][j + 1] != -1) pole[i][j + 1]++;
                        if (pole[i - 1][j - 1] != -1) pole[i - 1][j - 1]++;
                        if (pole[i - 1][j] != -1) pole[i - 1][j]++;
                        if (pole[i - 1][j + 1] != -1) pole[i - 1][j + 1]++;
                    }
                    if(j == 0 && i > 0 && i < pole.length){
                        if (pole[i - 1][j] != -1) pole[i - 1][j]++;
                        if (pole[i + 1][j] != -1) pole[i + 1][j]++;
                        if (pole[i - 1][j + 1] != -1) pole[i - 1][j + 1]++;
                        if (pole[i][j + 1] != -1) pole[i][j + 1]++;
                        if (pole[i + 1][j + 1] != -1) pole[i + 1][j + 1]++;
                    }
                    if(j == pole[i].length && i > 0 && i < pole.length){
                        if (pole[i - 1][j] != -1) pole[i - 1][j]++;
                        if (pole[i + 1][j] != -1) pole[i + 1][j]++;
                        if (pole[i - 1][j - 1] != -1) pole[i - 1][j - 1]++;
                        if (pole[i][j - 1] != -1) pole[i][j - 1]++;
                        if (pole[i + 1][j - 1] != -1) pole[i + 1][j - 1]++;
                    }

//                    for (int k = i-1; k < i+1; k++) {
//                        for (int l = j-1; l < j+1; l++) {
//                            if(k >= 0 && l >= 0 && k < pole.length && l < pole[i].length){
//                                if(pole[k][l] != -1) pole[k][l]++;
//                            }
//                        }
//                    }

                }
            }
        }
    }
    public static void odkryj(int x, int y) {
        if(mask[x][y]){
            return;
        }
        mask[x][y] = true;
        if(pole[x][y] == 0){
            if(x > 0) odkryj(x-1,y);
            if(y > 0) odkryj(x,y-1);
            if(x < pole.length-1) odkryj(x+1,y);
            if(y < pole[x].length-1) odkryj(x,y+1);
        }
    }
    public static void vypis(int[][] pole) {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole[i].length; j++) {
                System.out.format(" %2d", pole[i][j]);
            }
            System.out.println("");
        }
    }
    public static void vypisOdkryti(int[][] pole) {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole[i].length; j++) {
                if(mask[i][j]){
                    System.out.format(" %2d", pole[i][j]);
                }else{
                    System.out.format(" %2s", "X");
                }
            }
            System.out.println("");
        }
    }
}
