package src.cv04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Trojuhelnik {
    static private final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double a,b,c;
        System.out.println("Zadej delky stran");
        try{
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            c = scanner.nextDouble();
        }catch(InputMismatchException e){
            throw new InputMismatchException("Bad input");
        }
        if((a + b > c ) && (Math.abs(a-b) < c)){
            System.out.println("Triangle is Valid");
        } else {
            System.out.println("Triangle is not Valid");
        }
    }
}
