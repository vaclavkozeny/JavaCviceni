package src.zima.cv04;

import java.util.Scanner;

public class PrestupnyRok {
    static private final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int rok;
        do{
            System.out.println("Zadej letopocet");
            try{
                rok = scanner.nextInt();
            }catch (Exception e){
                throw new ArithmeticException("Not a number");
            }

            // otestovat zda je rok prechodny
            boolean prestupny = rok % 4 == 0 && (rok % 100 !=0 || rok % 400 == 0);
        /*if (rok % 4 == 0 && (rok % 100 !=0 || rok % 400 == 0)) {
            prestupny = true;
        } else {
            prestupny = false;
        }*/
            System.out.println("Rok " + rok + ((prestupny)?(" je"):(" neni")) + " prestupny" );
        }while(rok > 0);
    }
}
