package src.cv08;

import java.util.Scanner;
/*
15. Zapište program, který načte dvě celá čísla (do proměnných celočíselného typu) představující první a druhou část
rodného čísla, a otestuje, zda se jedná o platné rodné číslo. Jednoduchý test na platnost rodného čísla je
dělitelnost 11. Rodná čísla jsou zpravidla dělitelná číslem 11. Nicméně, toto neplatí pro všechna přidělená rodná
čísla. Ve skutečnosti je algoritmus přidělování rodných čísel následující:

(1) vypočti zbytek po dělení prvních devíti číslic a čísla 11;
(2) je-li zbytek 10,poslední číslice musí být 0;
(3) jinak je poslední číslice rovna zbytku.

780123/3540 je tak platné rodné číslo, přestože není dělitelné 11. Pravidla pro rodná čísla též například na.
V kontextu této skupiny úloh realizujte program s využitím základních prostředků
pro rozhodování (if) a výpočtu výrazů bez využití cyklů, byť by se použití cyklu v tomto případě nabízelo.
 */
/*
Zapište program, který načte celé číslo a ověří, zda se jedná o platné IČ. Maximální délka IČ je 8, pokud je kratší,
úvodní nuly není nutno zadávat. Pro ověření platnosti proveďte:

(1) první až sedmou číslici vynásobte postupně čísly 8, 7, 6, 5, 4, 3, 2 a součiny sečtěte;
(2) zjistěte zbytek po vydělení vzniklého součtu jedenácti;
(3) pro poslední číslici musí platit: je-li zbytek 0 poslední číslice je 1,
je-li zbytek 1 poslední číslice je 0, v ostatních případech je poslední číslice rovna 11-zbytek.

Zadané IČ načtěte do proměnné celočíselného typu. V kontextu
této skupiny úloh realizujte požadovaný program bez využití cyklů, byť by se použití cyklu v tomto případě
nabízelo.
*/
public class TestovaniRC {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        long cislo = 0;
        do{
            cislo = scanner.nextLong();
            if(cislo < 0){
                break;
            }
            boolean valid = IsValidIN(cislo);
            if(valid){
                System.out.println("Je platne");
            }else{
                System.out.println("Neni platne");
            }
        }while(cislo > 0);
    }
    private static boolean IsValid(long c){
        /*
        (1) vypočti zbytek po dělení prvních devíti číslic a čísla 11;
        (2) je-li zbytek 10,poslední číslice musí být 0;
        (3) jinak je poslední číslice rovna zbytku.
         */
        long lastDigit = c % 10;
        c = c / 10;
        if((c % 11 == 10 && lastDigit == 0 ) || (c%11 == lastDigit)){
            return true;
        }

        return false;
    }

    private static boolean IsValidIN(long c){
        /*
        (1) první až sedmou číslici vynásobte postupně čísly 8, 7, 6, 5, 4, 3, 2 a součiny sečtěte;
        (2) zjistěte zbytek po vydělení vzniklého součtu jedenácti;
         */
        long sum = 0;
        long LastDigit = c%10;
        //sum = sum + (c%10);
        c = c/10;
        sum = sum + (c%10 * 2);
        c = c/10;
        sum = sum + (c%10 * 3);
        c = c/10;
        sum = sum + (c%10 * 4);
        c = c/10;
        sum = sum + (c%10 * 5);
        c = c/10;
        sum = sum + (c%10 * 6);
        c = c/10;
        sum = sum + (c%10 * 7);
        c = c/10;
        sum = sum + (c%10 * 8);
        /*
        (3) pro poslední číslici musí platit: je-li zbytek 0 poslední číslice je 1,
        je-li zbytek 1 poslední číslice je 0, v ostatních případech je poslední číslice rovna 11-zbytek.
         */
        long zbytek = sum % 11;
        if((zbytek == 0 && LastDigit == 1) || (zbytek == 1 && LastDigit == 0) || (LastDigit == 11-zbytek)){
            return true;
        }
        return false;
    }
}
