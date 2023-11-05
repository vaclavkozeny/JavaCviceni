package src.cv08.tools;


import java.util.Scanner;

public class TestMathTool {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Zadej x");
        double x = scanner.nextDouble();
//        int y = scanner.nextInt();
//        double mocnina = MathTools.mocnina(x,y);
//        System.out.println(mocnina);
        double eps = scanner.nextDouble();
        double sin1 = MathTools.sin(x, eps);
        double sin2 = Math.sin(x);
        System.out.println(sin1);
        System.out.println(sin2);
    }
}
