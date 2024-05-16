package src.leto.cv13;

public class Bludiste {
    static int[][] bludiste = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 1, 1, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    static int[] pocatek = {1, 1};
    static int[] konec = {6, 8};
    public static void main(String[] args) {
        vypisBludiste();
    }
    private static void vypisBludiste() {
        for (int i = 0; i < bludiste.length; i++) {
            for (int j = 0; j < bludiste[i].length; j++) {
                if(bludiste[i][j] != 0) {
                    System.out.print(" x ");
                } else if (i == pocatek[0] && j == pocatek[1]) {
                    System.out.print(" P ");
                } else if (i == konec[0] && j == konec[1]) {
                    System.out.print(" K ");
                } else {
                    System.out.print("   ");

                }
            }
            System.out.println();
        }
    }
    int cesta = 0;
    private static boolean cesta(int x, int y) {
        for(int i = -1; i < 1; i++) {
            if(bludiste[x + i][y] == 0) {
                cesta(x + i, y);
            }
        }
    }
}
