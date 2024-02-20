package src.zima.testy.zkouska;

import java.util.Scanner;

public class cisla {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pc, dc;
        do{
            pc = scanner.nextInt();
            if(pc <= 0){
                break;
            }
            dc = scanner.nextInt();
            int sum1 = 0;
            int sum2 = 0;
            while(pc > 0 || dc > 0){
                sum1 += pc%10;
                sum2 += dc%10;
                pc/=10;
                dc/=10;
            }
            if(sum1 == sum2){
                System.out.println("Stejna");
            }else {
                System.out.println("jina");
            }
        }while (pc >= 0);
    }
}
