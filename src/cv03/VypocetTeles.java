package src.cv03;

import java.util.Scanner;

/*
Zapište program, který načte délky tří stran kvádru a vypočte a vypíše jeho objem a následně i délku strany
krychle (poloměr koule, délku strany pravidelného čtyřstěnu), která by měla stejný objem jako zadaný kvádr.
Doplňte program o řešení obdobné úlohy s plochou pláště kvádru, krychle, koule a čtyřstěnu.
 */
public class VypocetTeles {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Zadej delky stran (a b c)");
        //inputs / p = pomocne promene
        double a, b, c, volume, p1, p2, p3, surface;
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();
        volume = a * b * c;
        System.out.format("Objem je %.2f%n", volume);
        p1 = (double) 1 / 3;
        System.out.format("Strana krychle se stejnym objemem je %.2f%n", Math.pow(volume, p1));
        p2 = Math.pow((3 * volume) / (4 * Math.PI), p1);
        System.out.format("Polomer koule se stejnym objemem je %.2f%n", p2);
        p3 = Math.pow((12 * volume) / Math.sqrt(2), p1);
        System.out.format("Strana ctyruhelniku se stejnym objemem je %.2f%n", p3);
        //--------------------------------
        surface = 2 * ((a * b) + (a * c) + (c * b));
        System.out.format("Povrch kvadru je %.2f%n", surface);
        System.out.format("Strana krychle se stejnym povrchem je %.2f%n", Math.sqrt(surface / 6));
        System.out.format("Polomer koule se stejnym povrchem je %.2f%n", Math.sqrt(surface / (4 * Math.PI)));
        System.out.format("Strana ctyruhelniku se stejnym povrchem je %.2f%n", Math.sqrt(surface / Math.sqrt(3)));
    }
}
