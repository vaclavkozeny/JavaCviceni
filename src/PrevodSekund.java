package src;
/*
1: Zapište program, který načte počet hodin, minut a sekund (čas závodníka) a převede tyto údaje na jedinou hodnotu v sekundách
2: Zapište program, který pro zadanou hodnotu v sekundách poskytne odpovídající počet hodin, minut a sekund a výsledné údaje vypíše ve tvaru HH:MM:SS
*/


import java.util.Scanner;

public class PrevodSekund {

    public static void main(String[] args) {
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
