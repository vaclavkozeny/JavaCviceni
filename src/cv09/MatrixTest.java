package src.cv09;

public class MatrixTest {
    public static void main(String[] args) {
        double[][] matA = MatrixTools.nactiMatici(3, 3);
        double[][] matB = new double[][]{{1, 3, 2}, {3, 2, 1}, {4, 5, 6}};
        //MatrixTools.vypisMatici(MatrixTools.souctetMatic(matA, matB));
        MatrixTools.vypisMatici(matA);
    }
}
