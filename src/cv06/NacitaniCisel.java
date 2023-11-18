package src.cv06;

import java.util.Scanner;

public class NacitaniCisel {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int soucet = 0;
        float prumer;
        int pocet = 0;
        int a;

        do{
            a = scanner.nextInt();
            if(a < 0){
                break;
            }
            soucet = soucet + a;
            pocet++;
        }while(a > 0);
        prumer = (float)soucet / pocet;
        System.out.format("Prumer je %.1f, soucet je %d\n",prumer,soucet);

        //-------------------------
        System.out.println("Zadej pocet cislic\n");
        int s = scanner.nextInt();
        System.out.println("Zadej cisla\n");
        float min = scanner.nextFloat();
        float max = min;
        for(int i = 0; i < s-1; i++){
            float n = scanner.nextFloat();
            min = Math.min(n,min);
            max = Math.max(n,max);
        }
        System.out.format("Min %.1f, Max %.1f\n", min, max);
        //-------------------------
        System.out.println("Zadej pocet cislic\n");
        int s1 = scanner.nextInt();
        System.out.println("Zadej cisla\n");
        float last = scanner.nextFloat();
        boolean vysledek = true;
        for(int i = 0; i < s1-1; i++){
            float n = scanner.nextFloat();
            if(last > n){
                vysledek = false;
                break;
            }
            last = n;
        }
        System.out.format("Posloupnost %s\n", vysledek);

    }
}
