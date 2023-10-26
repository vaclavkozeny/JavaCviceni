package src.cv07;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.Scanner;

public class NacitaniCisel {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        int soucet = 0;
//        int prumer;
//        int pocet = 0;
//        int a;
//
//        do{
//            a = scanner.nextInt();
//            if(a < 0){
//                break;
//            }
//            soucet = soucet + a;
//            pocet++;
//        }while(a != -1);
//        prumer = soucet / pocet;
//        System.out.format("Prumer je %d, soucet je %d",prumer,soucet);

        //-------------------------
//        System.out.println("Zadej pocet cislic");
//        int s = scanner.nextInt();
//        System.out.println("Zadej cisla");
//        float min = scanner.nextFloat();
//        float max = min;
//        for(int i = 0; i < s-1; i++){
//            float n = scanner.nextFloat();
//            min = Math.min(n,min);
//            max = Math.max(n,max);
//        }
//        System.out.format("Min %.1f, Max %.1f", min, max);
        //-------------------------
        System.out.println("Zadej pocet cislic");
        int s = scanner.nextInt();
        System.out.println("Zadej cisla");
        float last = scanner.nextFloat();
        String vysledek = "je vzestupna";
        for(int i = 0; i < s-1; i++){
            float n = scanner.nextFloat();
            if(last > n){
                vysledek = "neni vzestupna";
                break;
            }
            last = n;
        }
        System.out.format("Posloupnost %s", vysledek);

    }
}
