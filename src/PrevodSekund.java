package src;

/*
Do balíku přidejte třídu (s metodou main) nazvanou PrevodSekund. V metodě main postupně realizujte zadání úloh 1 a 2 z Úlohy02. Program má nejprve načíst tří celá čísla jako počet hodin, minut a sekund a vše převést na celkový počet sekund a vypsat uživateli. Poté program pokračuje dále načte od uživatele jediné číslo představující celkový počet sekund a vypíše časový údaj ve tvaru HH:MM:SS. Pro výpisy použijte metodu format() standardního výstupu.
Do balíku přidejte třídu UsekovaRychlost. V této třídě (v metodě main) realizujte řešení úlohy 9 z Úlohy02.
Do balíku přidejte třídu UroceniVkladu. Zde realizujte řešení úlohy 12 z Úlohy02.
 */

import java.util.Scanner;

public class PrevodSekund {

    public static void main(String[] args) {
        /*
        Zapište program, který načte počet hodin, minut a sekund (čas závodníka) a převede tyto údaje na jedinou hodnotu v sekundách
         */
        int Hours, Minutes, Seconds, Out;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadej cas ve formatu [HH MM SS]");
        Hours = scanner.nextInt();
        Minutes = scanner.nextInt();
        Seconds = scanner.nextInt();
        //System.out.println(Hours + " " + Minutes + " " + Seconds);
        Out = (Hours*3600) + (Minutes * 60) + Seconds;
        System.out.println("Cas zavodnika je: " + Out + " sekund" );
        //--------------------------------------------------------------------------------
        /*
        Zapište program, který pro zadanou hodnotu v sekundách poskytne odpovídající počet hodin, minut a sekund a výsledné údaje vypíše ve tvaru HH:MM:SS
         */
        int In;
        System.out.println("Zadej pocet sekund, ktere se prevedou na cas ve formatu [HH:MM:SS]");
        In = scanner.nextInt();
        //System.out.println(In);
        Hours = In / 3600;
        Minutes = (In / 60) - (Hours * 60);
        Seconds = In  - (Hours * 3600) - (Minutes * 60);
        //System.out.println(Hours + " " + Minutes + " " + Seconds);
        System.out.printf("%d hodin %d minut %d sekund", Hours, Minutes, Seconds);
    }
}
