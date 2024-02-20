package src.zima.cv09;

import java.util.Scanner;

public class VypisCisel {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Zadej cisla");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Zadej delitele");
        int d = scanner.nextInt();
        System.out.println("Zadej pocet cisel na radce");
        int pr = scanner.nextInt();
//        System.out.println("Zadej na kolika pozicich napsat cislo");
//        int pocetMist = scanner.nextInt();

        //vypis vsechna cisla od a do b delitelna delitelem
        //na kazde radce vypdat pouze pr cisel

        int counter = 0;
        int maxLenght = pocetCifer(b);
        String form = String.format("%%%dd ",maxLenght);
        System.out.println(form);
        for(int i = a; i <= b; i++){
            if(jeMozneDelit(i,d)){
//                if(counter == pr){
//                    System.out.print("\n");
//                    counter = 0;
//                }
                if(jeMozneDelit(counter,pr)){
                    System.out.print("\n");
                }
                System.out.format(form, i);
                counter++;
            }
        }
        System.out.format("\nPocet cisel je %d",counter);

    }

    private static int pocetCifer(int b) {
//        return Integer.toString(b).length();
        int length = 0;
        int tempNumber = Math.abs(b);
        do {
            tempNumber /= 10;
            length++;
        } while (tempNumber != 0);
        return length;
    }

    private static boolean jeMozneDelit(int n, int d){
        return n%d==0;
    }
}
