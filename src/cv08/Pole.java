package src.cv08;

import java.util.Scanner;

public class Pole {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //nactiPole();
        System.out.format("pocet delitelu je: %d",delitele());


    }
    private static void nactiPole(){
        System.out.println("Zadej pocet cisel");
        int count = scanner.nextInt();
        int[] pole = new int[count];
        int a;
        int maxindex = 0;
        int alast = 0;
        for (int i = 0; i < pole.length; i++)
        {
            a = scanner.nextInt();
            pole[i] = a;
//            if(a > alast){
//                alast = a;
//                maxindex = i;
//            }
        }
        for(int i = 0; i < pole.length; i++){
            if(pole[i] > alast){
                alast = pole[i];
                maxindex = i;
            }
        }
        System.out.format("cislo %d na pozici %d", alast, maxindex);
    }
    private static int delitele(){
        System.out.println("Zadej cisla");
        int pole[] = new int[100];
        int a;
//        for(int i = 0; i < pole.length; i++){
//            a = scanner.nextInt();
//            if(a < 0)
//                break;
//            pole[i] = a;
//        }
        int n = 0;
        do{
            a = scanner.nextInt();
            if(a < 0)
                break;
            pole[n] = a;
            n++;
        }while(a>0);
        System.out.println("Zadej delitele");
        int d = scanner.nextInt();
        int pocet = 0;
        for(int i = 0; i < n; i++){
            if(pole[i]%d==0){
                pocet++;
            }
        }
        return pocet;
    }
}
