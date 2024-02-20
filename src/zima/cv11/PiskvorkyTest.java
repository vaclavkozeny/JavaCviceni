package src.zima.cv11;
import java.util.Scanner;
public class PiskvorkyTest {
    private static final Scanner scanner = new Scanner(System.in);
    private static int[][] mt = {
            {2,0,0,1,1},
            {0,2,0,1,1},
            {1,2,1,0,0},
            {0,1,1,0,0},
            {1,0,0,1,2}
    };
    public static void main(String[] args) {
        int[][] game = mt;
        int[][] vysledkyRadky = new int[game.length][game[0].length];
        int[][] vysledkySloupce = new int[game.length][game[0].length];
        int[][] vysledkyDiagonala = new int[game.length][game[0].length];
        int[][] vysledkyDiagonala2 = new int[game.length][game[0].length];

        for(int i = 0; i<game.length;i++){
            for(int j = 0; j<game[0].length;j++){
                vysledkyRadky[i][j] = PiskvorkyTools.pocetStejnychVRadce(game,i,j);
                vysledkySloupce[i][j] = PiskvorkyTools.pocetStejnychVSloupci(game,i,j);
                vysledkyDiagonala[i][j] = PiskvorkyTools.pocetStejnychVDiag1(game,i,j);
                vysledkyDiagonala2[i][j] = PiskvorkyTools.pocetStejnychVDiag2(game,i,j);
            }
        }
        vypis(mt);
        System.out.println();
        System.out.println("test po radcich");
        vypis(vysledkyRadky);
        System.out.println();
        System.out.println("test po sloupcich");
        vypis(vysledkySloupce);
        System.out.println();
        System.out.println("test po diagonale");
        vypis(vysledkyDiagonala);
        System.out.println();
        System.out.println("test po diagonale2");
        vypis(vysledkyDiagonala2);
    }
    private static void vypis(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                System.out.format("%s ",mat[i][j]);
            }
            System.out.println();
        }
    }
}
