package src.cv05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VypisObrazcu {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int a;
        System.out.println("Zadej cislo");
        try{
            a = scanner.nextInt();
        }catch (InputMismatchException e){
            throw new InputMismatchException("Spatny vstup");
        }
        System.out.println("Radek\n");
        for(int i = 0; i < a; i++){
            System.out.print("* ");
        }
        System.out.print("\n");
        System.out.println("Ctverec\n");
        for(int i = 0; i < a; i++){
            for(int b = 0; b < a; b++){
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        System.out.println("Trojuhelnik\n");
        for(int i = 0; i < a; i++){
            for(int b = 0; b < i+1; b++){
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        System.out.println("Trojuhelnik rovnostrany\n");
        for(int i = 0; i < a; i++){
            for(int c = 0; c<a-i;c++){
                System.out.print(" ");
            }
            for(int b = 0; b < i+1; b++){
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }
}
