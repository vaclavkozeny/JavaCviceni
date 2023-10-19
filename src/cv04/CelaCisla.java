package src.cv04;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
21. Zapište program, který vypíše všechny kladné dělitele zadaného čísla (které potenciální dělitele musíme testovat
– 2 .. n-1, 2 .. n/2). Dále upravte program tak, aby pro každé zadané číslo vypsal jeho dělitele – program má
potom ukončit činnost v případě, že na vstupu ke zpracování obdrží číslo 0 nebo. Doplňte určení počtu dělitelů.
22. Zapište program, který bude určovat, zda zadané číslo je prvočíslo. Porovnání případu, kdy budeme testovat
všechny potenciální dělitele nebo ukončíme cyklus při nalezení prvního dělitele (předčasné ukončení cyklu zajistit
podmínkou v záhlaví příkazu while a nikoli příkazem break). Modifikace pro opakované zadávání čísel.
23. Zapište program, který každé zadané číslo vypíše jako součin prvočísel. Program nechť skončí po zadání hodnoty
0 nebo záporného čísla na vstupu.
 */
public class CelaCisla {
    static private final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

    /*
    21. Zapište program, který vypíše všechny kladné dělitele zadaného čísla (které potenciální dělitele musíme testovat
    – 2 .. n-1, 2 .. n/2). Dále upravte program tak, aby pro každé zadané číslo vypsal jeho dělitele – program má
    potom ukončit činnost v případě, že na vstupu ke zpracování obdrží číslo 0 nebo. Doplňte určení počtu dělitelů.
     */
        int a;
        int p = 0;
        boolean t;

        do {
            System.out.println("Zadej cislo pro vypis jeho delitelu / nekladne pro dalsi krok");
            try{
                a = scanner.nextInt();
            }catch (InputMismatchException e){
                throw new InputMismatchException("Spatny vstup");
            }
            if(a > 0){
                for(int i = 2; i < a; i++){
                    if(a%i == 0){
                        System.out.println(i);
                    }
                }
            }


        }while(a > 0);
        do {
            System.out.println("Zadej cislo pro zjisteni poctu jeho delitelu / nekladne pro dalsi krok");
            try{
                a = scanner.nextInt();
            }catch (InputMismatchException e){
                throw new InputMismatchException("Spatny vstup");
            }
            if(a > 0) {
                for (int i = 2; i < a; i++) {
                    if (a % i == 0) {
                        //System.out.println(i);
                        p++;
                    }
                }
                System.out.format("Pocet delitelu je: %d%n",p);
                p = 0;
            }


        }while(a > 0);
        /*
        22. Zapište program, který bude určovat, zda zadané číslo je prvočíslo. Porovnání případu, kdy budeme testovat
        všechny potenciální dělitele nebo ukončíme cyklus při nalezení prvního dělitele (předčasné ukončení cyklu zajistit
        podmínkou v záhlaví příkazu while a nikoli příkazem break). Modifikace pro opakované zadávání čísel.
        */
        do {
            System.out.println("Zadej cislo pro zjisteni prvocisla / nekladne pro dalsi krok");
            try{
                a = scanner.nextInt();
            }catch (InputMismatchException e){
                throw new InputMismatchException("Spatny vstup");
            }
            if(a > 0) {
                t = true;
                if (a == 1)
                    t = false;
                for (int i = 2; i < a / 2; i++) {
                    if (a % i == 0)
                        t = false;
                }
                System.out.format(t ? "cislo je prvocislo%n" : "cislo neni prvocislo%n");
            }

        }while(a > 0);
        /*
        23. Zapište program, který každé zadané číslo vypíše jako součin prvočísel. Program nechť skončí po zadání hodnoty
        0 nebo záporného čísla na vstupu.
         */
        do{
            System.out.println("\nZadej cislo pro rozklad na prvocisla / nekladne pro konec");
            try{
                a = scanner.nextInt();
            }catch (InputMismatchException e){
                throw new InputMismatchException("Spatny vstup");
            }
            if(a > 0) {
                for (int i = 2; i <= a; i++) {
                    while (a % i == 0) {
                        System.out.print(i);
                        a = a / i;
                        if (a > 1) {
                            System.out.print(" * ");
                        }
                    }
                }
            }
        }while(a > 0);

    }


}
