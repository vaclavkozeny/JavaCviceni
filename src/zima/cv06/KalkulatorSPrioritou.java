package src.zima.cv06;

import java.util.Scanner;

public class KalkulatorSPrioritou {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Zadej aritmeticky vyraz");
        float o;
        float lasto = 0;
        char op = 'e';
        char lastop = 'e';
        o = scanner.nextFloat();
        while(op!='='){
            op = scanner.next().charAt(0);
            switch (op){
                case '+', '-':
                    switch (lastop){
                        case '+':
                            o = lasto + o;
                            lastop = op;
                            break;
                        case '-':
                            o = lasto - o;
                            lastop = op;
                            break;
                        default:
                            break;
                    }
                    lasto = o;
                    lastop = op;
                    o = scanner.nextInt();
                    break;
                case '*':
                    o = o * scanner.nextFloat();
                    break;
                case '/':
                    o = o / scanner.nextFloat();
                    break;
                case '=':
                    switch (lastop){
                        case '+':
                            o = lasto + o;
                            break;
                        case '-':
                            o = lasto - o;
                            break;
                    }
            }
        }

        System.out.format("Vysledek je %.2f", o);
    }
}
