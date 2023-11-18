package src.cv06;


import java.util.Scanner;
public class KalkulatorBezPriority {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Zadej aritmeticky vyraz (a {znamenko} b)");
        float o;
        char op;

        o = scanner.nextFloat();
        do{
            op = scanner.next().charAt(0);
            switch (op){
                case '+':
                    o = o + scanner.nextFloat();
                    break;
                case '-':
                    o = o - scanner.nextFloat();
                    break;
                case '*':
                    o = o * scanner.nextFloat();
                    break;
                case '/':
                    o = o / scanner.nextFloat();
                    break;
            }
        }while(op!='=');

        System.out.format("Vysledek je %.2f", o);
    }
}
