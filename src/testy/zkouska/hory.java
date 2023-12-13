package src.testy.zkouska;

public class hory {
    public static void main(String[] args) {
        int[][]a = new int[][]{{1,1,1,1,1},{1,1,1,1,1},{1,1,100,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        int pocetV = 0;
        for (int i = 2; i < a.length-2; i++) {
            for (int j = 2; j < a[0].length-1; j++) {
                int v = a[i][j];
                boolean jeVrchol = true;
                for (int k = i-2; k < i+2; k++) {
                    for (int m = j-2; m < j+2 ; m++) {
                        if(v-a[k][m] >= 5){
                            jeVrchol = false;
                        }
                    }
                }
                if(jeVrchol)
                    pocetV++;
            }
        }
        System.out.println(pocetV);
    }
}
