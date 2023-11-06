package src.cv08.tools;


import java.util.Scanner;

public class TestMathTool {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Zadej x, y(exponetn) a presnost");
        double x = scanner.nextDouble();
        int y = scanner.nextInt();
        double eps = scanner.nextDouble();
        System.out.println("Mocnina");
        System.out.format("moje trida: %f | ",MathTools.mocnina(x,y));
        System.out.format("trida MATH: %f\n",Math.pow(x,y));
        System.out.println("Sinus");
        System.out.format("moje trida: %f | ",MathTools.sin(x,eps));
        System.out.format("trida MATH: %f\n",Math.sin(x));
        System.out.println("Ln");
        System.out.format("moje trida: %f | ",MathTools.log(x,eps));
        System.out.format("trida MATH: %f\n",Math.log(x));
        System.out.println("Sqrt");
        System.out.format("moje trida: %f | ",MathTools.sqrt(x,eps));
        System.out.format("trida MATH: %f\n",Math.sqrt(x));
        System.out.println("Cbrt");
        System.out.format("moje trida: %f | ",MathTools.cbrt(x,eps));
        System.out.format("trida MATH: %f\n",Math.cbrt(x));
    }
}
