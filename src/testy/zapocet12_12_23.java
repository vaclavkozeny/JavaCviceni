package src.testy;

import java.util.Scanner;

public class zapocet12_12_23 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int vyska = sc.nextInt();
        char znak1 = sc.next().charAt(0);
        char znak2 = sc.next().charAt(0);
        char[][] res = ukraqineFlag(vyska, znak1, znak2);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.format("%s  ",res[i][j]);
            }
            System.out.println();
        }
        System.out.println(sumThreeDigits(new int []{111,5,222,3333,44,555}));
        System.out.println(isFibonachi(new int[]{0,1,1,2,3,5,8,13,21}));
    }
    public static int sumThreeDigits(int[]a){
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if ((a[i]/100) >= 1 && (a[i]/100) <= 9){
                sum += a[i];
            }
        }
        return sum;
    }
    public static boolean isFibonachi(int[]a){
        int laster = 0;
        int last = 1;
        if(a[0] != 0 || a[1] != 1){
            return false;
        }
        for (int i = 2; i < a.length; i++) {
            if(a[i] != last + laster){
                return false;
            }
            laster = last;
            last = a[i];
        }
        return true;
    }
    public static char[][] ukraqineFlag(int vyska, char z1, char z2){
        char[][] ret = new char[vyska][(int)(1.5*vyska)];
        for (int i = 0; i <= ret.length/2; i++) {
            for (int j = 0; j < ret[0].length; j++) {
                ret[i][j] = z1;
            }
        }
        for (int i = ret.length/2; i < ret.length; i++) {
            for (int j = 0; j < ret[0].length; j++) {
                ret[i][j] = z2;
            }
        }
        return ret;
    }
}
