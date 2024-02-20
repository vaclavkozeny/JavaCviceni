package src.zima.cv06;

import java.util.Scanner;

public class VypocetVyrazu {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Zadej aritmeticky vyraz (a {znamenko} b");
        float a = scanner.nextFloat();
        char op = scanner.next().charAt(0);
        float b = scanner.nextFloat();
        float o;
        switch (op){
            case '+':
               o = a+b;
               break;
            case '-':
                o = a-b;
                break;
            case '*':
                o = a*b;
                break;
            case '/':
                o = a/b;
                break;
            default:
                o = 0;
        }
        System.out.format("Vysledek je %.2f", o);
    }
}
