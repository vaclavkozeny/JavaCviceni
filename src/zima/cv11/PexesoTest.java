package src.zima.cv11;

public class PexesoTest {
    public static void main(String[] args) {
//        vypis(PexesoTools.permutateArray(10));
        int[][] px = PexesoTools.getMaticePexeso(500,500);
        System.out.println("matice vygenerovana");
        //vypisMatice(px);
        System.out.println();
        System.out.println(PexesoTools.jeMaticePexeso(px));
        System.out.println();
        System.out.format("%.2f",PexesoTools.rozhazenost(px));
    }
    private static void vypis(int[] mat){
        for(int i=0;i<mat.length;i++){
            System.out.format("%s ",mat[i]);
        }
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

