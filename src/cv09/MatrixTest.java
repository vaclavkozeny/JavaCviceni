package src.cv09;

public class MatrixTest {
    public static void main(String[] args) {
        //double[][] matA = MatrixTools.nactiMatici(3, 3);
        int[][] matB = new int[][]{{3, 2, 1}, {4, 1, 2}, {1, 4, 3}};
        //MatrixTools.vypisMatici(MatrixTools.souctetMatic(matA, matB));
        System.out.println(MatrixTools.jeSymetrickaDleDiag2(matB));
    }
}
