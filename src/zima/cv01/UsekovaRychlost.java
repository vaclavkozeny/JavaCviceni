package src.zima.cv01;

import java.util.Scanner;

/*
Zapište program pro výpočet úsekové rychlosti vozidla (průměrné rychlosti vozidla ve sledovaném úseku).
Vypisujte jak dosaženou průměrnou rychlost, tak i o kolik byla překročena maximální povolená rychlost v daném
úseku. Vstupem budou: maximální povolená rychlost v daném úseku, délka úseku a časové údaje (hh mm sec
set) průjezdu vozidla začátkem a koncem sledovaného úseku.
 */
public class UsekovaRychlost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //inputs
        int MaxSpeed, Length, HoursStart, MinutesStart, SecondsStart, HoursEnd, MinutesEnd, SecondsEnd;
        System.out.println("zadejte pozadovane udaje: [maximalní povolena rychlost] [delka useku v KM]");
        MaxSpeed = scanner.nextInt();
        Length = scanner.nextInt();
        System.out.println("zadejte cas startu [HH MM SS set]");
        HoursStart = scanner.nextInt();
        MinutesStart = scanner.nextInt();
        SecondsStart = scanner.nextInt();
        String set1 = scanner.next();
        System.out.println("zadejte cas konce [HH MM SS set]");
        HoursEnd = scanner.nextInt();
        MinutesEnd = scanner.nextInt();
        SecondsEnd = scanner.nextInt();
        String set2 = scanner.next();
        //System.out.println(MinutesEnd);
        int Hours, Minutes, Seconds, Time;
        double Speed;
        Hours = HoursEnd - HoursStart;
        Minutes = MinutesEnd - MinutesStart;
        Seconds = SecondsEnd - SecondsStart;
        Time = (Hours * 3600) + (Minutes * 60) + Seconds;
        Speed = (((double)Length*1000) / Time)*3.6;
        Speed = Math.round(Speed);
        //System.out.println(s);
        System.out.printf("Vase rychlost byla %f, povolenou rychlost jste prekrocil o %f", Speed, (Speed-MaxSpeed));

    }
}
