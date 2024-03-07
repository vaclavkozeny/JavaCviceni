package src.zima.cv04;

import java.util.Scanner;

/*
Napište program, který bude řešit zadanou soustavu dvou rovnic o dvou neznámých. Pomocí podmínky je nutno
vyloučit případ lineární závislosti rovnic (nejednoznačné řešení). Proveďte rozbor úlohy, stanovte základní výrazy
pro existenci řešení a výpočet x a y, poté zapište kód programu.
 */
public class DveRovnice {
    static private final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double a,b,c,d,e,f,x,y;
        // a b = c
        // d e = f
        System.out.println("zadej prvni rovnici (ax + by = c)");
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();
        System.out.println("zadej druhou rovnici (ax + by = c)");
        d = scanner.nextDouble();
        e = scanner.nextDouble();
        f = scanner.nextDouble();
        if(((a == 0 && b == 0) && c != 0)||((d == 0 && e == 0) && f != 0)){
            System.out.println("rovnice neni zadana jako rovnice");
            System.exit(6);
        }
        double D = a*e - b*d;
        double Dx = c*e - b*f;
        double Dy = a*f - c*d;
        if(D == 0 && Dx == 0 && Dy == 0){
            System.out.println("Rovnice ma nekonecne mnoho reseni");
        } else if (D == 0 && (Dx != 0 || Dy != 0)) {
            System.out.println("Rovnice nema reseni");
        }else{
            x = Dx/D;
            y = Dy/D;
            System.out.format("Resenim je X = %.2f a Y = %.2f",x,y);
        }

    }
}
