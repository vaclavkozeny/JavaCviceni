package src.cv04;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Trojuhelnik {
    static private final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double x,y,z,a,b,c;
        System.out.println("Zadej delky stran");
        try{
            x = scanner.nextDouble();
            y = scanner.nextDouble();
            z = scanner.nextDouble();
        }catch(InputMismatchException e){
            throw new InputMismatchException("Spatny vstup");
        }
        if (x <= 0 || y <= 0 || z <= 0) {
            System.out.println("Nutno zadat kladna cisla, se zadanymi cisly nelze ulohu resit ");
            return;
        }
        if((x + y > z ) && (Math.abs(x-y) < z)){
            System.out.println("Trojuhelnik je platny");

            // priradit delky do promennych a, b, c tak aby a <= b <= c
            double[] arr = {x,y,z};
            Arrays.sort(arr);
            a = arr[0];
            b = arr[1];
            c = arr[2];
            System.out.format("Strana a je %.02f (nejmensi), strana b je %.02f, strana c je %.02f (nejvetsi) %n",a,b,c);

            // vypocitat plochu a obvod trojuhelnika (se stranami a, b, c)
            double Obvod, Obsah,s;
            Obvod = a+b+c;
            s = Obvod/2;
            Obsah = Math.sqrt(s*(s-a)*(s-b)*(s-c));
            System.out.format("Obvod trojuhelniku je: %.02f a obsah je: %.02f %n",Obvod, Obsah);
            // urcit typ trojuhelnika (se stranami a, b, c) dle stran - rovnostranny, rovnoramenny, obecny
            String Ts;
            if(a == b && a == c){
                Ts = "rovnostrany";
            }else if((a == b) || (a == c) || (c==b)){
                Ts = "rovnorameny";
            }else{
                Ts = "obecny";
            }
            System.out.format("Trojuhelnik je %s %n",Ts);
            // urcit typ trojuhelnika (se stranami a, b, c) dle uhlu
            String Tu;
            double p = Math.pow(a,2) + Math.pow(b,2);
            if(Math.pow(c, 2) == p){
                Tu = "pravouhly";
            }else if(Math.pow(c, 2) > p){
                Tu = "tupouhly";
            }else{
                Tu = "ostrouhly";
            }
            System.out.format("Trojuhelnik je %s%n",Tu);
        } else {
            System.out.println("Trojuhelni neni platny");
        }

    }
}
