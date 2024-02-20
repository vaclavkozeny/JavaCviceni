package src.zima.cv03;

import java.util.Scanner;

/*
Napište program, který načte souřadnice bodu roviny a určí a vypíše, ve kterém kvadrantu zadaný bod leží
 */
public class KvadrantBodu {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double x,y;
        int  k = 0;
        System.out.println("Zadej souradnice (X Y) ");
        try{
            x = scanner.nextDouble();
            y = scanner.nextDouble();
        }catch (Exception e){
            throw new ArithmeticException("Not a number");
        }
        if(x > 0 & y > 0){
            k = 1;
        } else if (x > 0 & y < 0) {
            k = 4;
        } else if (x < 0 & y > 0) {
            k = 2;
        }else if (x < 0 & y < 0) {
            k = 3;
        } else if (x == 0 & y > 0) {
            System.out.println("Bod je mezi 1 a 2 kvadrantem");
        } else if (x == 0 & y < 0) {
            System.out.println("Bod je mezi 3 a 4 kvadrantem");
        }else if(x > 0 & y == 0) {
            System.out.println("Bod je mezi 1 a 4 kvadrantem");
        }else if(x < 0 & y == 0) {
            System.out.println("Bod je mezi 2 a 3 kvadrantem");
        }else if(x == 0 & y == 0) {
            System.out.println("Bod je ve stredu systemu");
        }
        if(k != 0){
            System.out.format("Bod je v %d kvadrantu", k);
        }

    }
}
