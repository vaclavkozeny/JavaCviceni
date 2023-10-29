package src.cv07;

import java.util.Scanner;

public class TriMaxima {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int a;
        int max1 = 0, max2 = 0, max3 = 0, pocet1 = 0, pocet2 = 0, pocet3 = 0;

        do{
            a = scanner.nextInt();
            if(a < 0){
                break;
            }
            if(a > max1){
                max3 = max2;
                max2 = max1;
                max1 = a;
                pocet3 = pocet2;
                pocet2 = pocet1;
                pocet1 = 1;
                continue;
            }
            if(a == max1){
                pocet1++;
                continue;
            }
            if(a > max2){
                max3 = max2;
                max2 = a;
                pocet3 = pocet2;
                pocet2 = 1;
                continue;
            }
            if(a == max2){
                pocet2++;
                continue;
            }
            if(a > max3){
                max3 = a;
                pocet3 = 1;
                continue;
            }
            if(a == max3){
                pocet3++;
            }
        }while(a > 0);
        System.out.format("%d,%d,%d jsou nejvesti cisla a vyskytla se %d,%d,%d krat",max1,max2,max3, pocet1, pocet2, pocet3);
    }
}
