package src.cv05;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
Do balíku přidejte třídu NejvetsiPocetDelitelu. Program má načíst dvě celá kladná čísla a, b, taková že a<=b.
Pokud bude některé z načtených čísel nekladné vypište informaci uživateli a program ukončete.
Pokud nebude splněna vzájemná relace, proměnné navzájem vyměňte, informujte o tomto uživatele.
Pro platná čísla vymezující množinu všech přirozených čísel {a, a+1, a+2, ... b-1, b} zjistěte, které z těchto čísel má největší počet vlastních (netriviálních dělitelů).
Uživateli vypište jaký tento maximální počet vlastních dělitelů je, následně vypište číslo, pro které byl tento počet zjištěn.
Čísel se zjištěným maximálním počtem může být v dané množině několik, algoritmus zapište tak, aby určil a a uživateli vypsal nejmenší z nich.
 */
public class NejvetsiPocetDelitelu {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int a,b,temp;
        int p = 0;
        int plast = 0;
        int nlast = 0;
        System.out.println("Zadej dve cela kladna cisla (prvni musi byt mensi)");
        try{
            a = scanner.nextInt();
            b = scanner.nextInt();
        }catch (InputMismatchException e){
            throw new InputMismatchException("Spatny vstup");
        }
        // ukonci progarm kdyz bude jedno z cislic mensi nez 0
        if(a < 0 || b < 0){
            //throw new ArithmeticException("Zadane cislo je nekladne");
            System.out.println("Zadane cislo je nekladne");
            System.exit(6);
        }
        // prohodi cisla podle velikosti (a < b)
        if(b < a){
            System.out.println("Zadal jsi cisla spatne, doslo k jejich prohozeni");
            temp = a;
            a = b;
            b = temp;
        }
        for(int i = a; i < b; i++){
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    p++;
                }
            }
            if(plast < p){
                plast = p;
                nlast = i;
            }
            p = 0;
        }
        System.out.format("Cislo %d ma nejvetsi pocet delitelu: %d",nlast, plast);


    }
}
