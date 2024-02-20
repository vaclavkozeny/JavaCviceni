package src.zima.cv03;

import java.util.Scanner;

/*
Napište program, který bude řešit polynomiální rovnice maximálně druhého řádu ax2 + bx + c (tj. rovnice lineární,
kvadratické v reálném i komplexním oboru).
 */
public class KvadratickaRovnice {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double a,b,c,x1,x2,D;
        a = b = c = -1;
        System.out.println("Zadej koeficienty (ax^2 + bx + c = 0)");
        try {
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            c = scanner.nextDouble();
        }
        catch (Exception e) {
            throw new ArithmeticException("Not a number");
        }
        D =  Math.pow(b,2) - 4*a*c;
        if(a == 0){
            x1 = (-c)/b;
            System.out.format("linearni rovnice, %nprusecik s osou x = %.2f",x1);
        } else if (D > 0) {
            x1 = (-b + Math.sqrt(D)) / (2 * a);
            x2 = (-b - Math.sqrt(D)) / (2 * a);
            System.out.format("x1 = %.2f%n",x1);
            System.out.format("x2 = %.2f%n",x2);
        } else if (D == 0) {
            x1 = x2 = -b / (2 * a);
            System.out.format("x1,x2 = %.2f", x1);
        } else if (D < 0) {
            double real = -b / (2 * a);
            double imaginary = Math.sqrt(-D) / (2 * a);
            if(real == 0){
                System.out.format("x1 = +%.2f i%n", imaginary);
                System.out.format("x2 = -%.2f i", imaginary);
            }else{
                System.out.format("x1 = %.2f+%.2f i%n", real, imaginary);
                System.out.format("x2 = %.2f-%.2f i", real, imaginary);
            }

        }

    }
}
