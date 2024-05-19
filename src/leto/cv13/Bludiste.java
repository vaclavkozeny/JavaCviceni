package src.leto.cv13;

public class Bludiste {
    static int[][] bludiste = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 1, 1, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    static int[] pocatek = {1, 1};
    static int[] konec = {6, 8};
    public static void main(String[] args) {
        vypis(bludiste);
        System.out.println();
        System.out.println(cesta(pocatek[0], pocatek[1]));
    }
    private static void vypis(int[][] bludiste) {
        for (int i = 0; i < bludiste.length; i++) {
            for (int j = 0; j < bludiste[i].length; j++) {
                if(i == 2 && j == 1){
                    System.out.print(" t ");
                    continue;
                }
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
//    private static boolean cesta(int x, int y) {
//        int[][] b = new int[bludiste.length][bludiste[0].length];
//        for (int i = 0; i < bludiste.length; i++) {
//            for (int j = 0; j < bludiste[0].length; j++) {
//                b[i][j] = 0;
//            }
//        }
//        vypis(b);
//        return false;
//    }
    private static boolean cesta(int x, int y){
        int a = x;
        int b = y;
        while(a != konec[0] && b != konec[1]) {
            System.out.println(bludiste[a][b+1]);
            if (bludiste[a + 1][b] == 0) {
               a++;
            } else if (bludiste[a][b + 1] == 0) {
                b++;
            } else if (bludiste[a - 1][b] == 0) {
                a--;
            } else if (bludiste[a][b - 1] == 0) {
                b--;
            } else {
                return false;
            }

        }
        return true;
    }
}
