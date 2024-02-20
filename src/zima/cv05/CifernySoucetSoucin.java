package src.zima.cv05;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CifernySoucetSoucin {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        long a;
        do{
            System.out.println("Zadej cislo");
            try{
                a = scanner.nextLong();
            }catch (InputMismatchException e){
                throw new InputMismatchException("Spatny vstup");
            }
            if(a <= 0)
                return;

//            String b = Long.toString(a);
//            //System.out.println(b);
//            long d = 0;
//            for (int i = 0;i < b.length(); i++){
//                //System.out.println(b.charAt(i));
//                int e=Integer.parseInt(String.valueOf(b.charAt(i)));
//                d = d+e;
//            }
//            System.out.println(d);
            long soucet = 0;
            long b = a;
            while(b > 0){
                soucet = soucet + b%10;
                b = b / 10;
            }
            System.out.println(soucet);
        }while(a > 0);
    }
}
