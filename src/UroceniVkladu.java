package src;

import java.util.Scanner;

/*
Je dána výše jednorázově vloženého počátečního kapitálu K0 (například termínovaný vklad, vklad na spořící účet),
roční úročení vkladu ve výši u, počet let n a hodnota m, představující informaci, kolikrát do roka je připisován
úrok. Předpokládáme složené úročení, při kterém se úrok v každém úrokovacím období připočítá k počátečnímu
kapitálu a v dalším úrokovacím období se úročí celý takto navýšený kapitál. Zapište program, který na vstupu
obdrží údaje K0, u, m, n a na výstupu vypíše výslednou hodnotu kapitálu (tj. výše kapitálu Kn po n letech) za
předpokladu, že se hodnota kapitálu nemění jiným způsobem než úročením.
𝐾𝑛 = 𝐾0(1 + 𝑢/𝑚)^𝑛𝑚
 */
public class UroceniVkladu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //inputs
        int K0, U, M, N;
        double Out;
        System.out.println("Zadej vstupni kapital");
        K0 = scanner.nextInt();
        System.out.println("Zadej urok v %");
        U = scanner.nextInt();
        System.out.println("Zadej dobu uroceni");
        N = scanner.nextInt();
        System.out.println("Zadej kolikrat za rok se pripisuje urok");
        M = scanner.nextInt();
        double z1 = 1+(((double)U/100)/M);
        double z2 = Math.pow(z1, (N*M));
        Out = K0*z2;
        Out = Math.round(Out);
        System.out.println("Na uctu budete mit: "+Out);
    }
}
