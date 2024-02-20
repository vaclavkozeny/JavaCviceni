package src.zima.cv04;

import java.util.Scanner;

public class FaktorialCisla {
    static private final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n;
        long out = 1;
        System.out.println("Zadej cele kladne cislo");
        n = scanner.nextInt();
//        while(n > 0){
//            out = out * n;
//            n--;
//        }
        for(int i = 1; i <= n; i++){
            out = out * i;
        }
        System.out.println(out);
    }
}
