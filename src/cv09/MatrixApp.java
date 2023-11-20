package src.cv09;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static double[][] matA = null;
    private static double[][] matB = null;

    public static void main(String[] args) {
        boolean konecProgramu;
        do {
            vypisMenu();
            int volba = nactiVolbu();
            konecProgramu = obsluzVolbu(volba);
        } while (!konecProgramu);
        System.out.println("Koncim ...");

    }
    private static void vypisMenu() {
        System.out.println("\nHlavni menu programu");
        System.out.println("1. Nacti prvni matici");
        System.out.println("2. Nacti druhou matici");
        System.out.println("3. Vypis matice");
        System.out.println("4. Vzajemna vymena obou matic");
        System.out.println("5. Vypocitat a vypsat soucet obou matic");
        System.out.println("6. Vypocitat a vypsat soucin obou matic");
        System.out.println("7. Transpozice prvni matice");
        System.out.println("8. Prevod druhe matice do normovaneho tvaru");
        System.out.println("9. Nacti testovaci matice");
        System.out.println("0. Konec programu");
    }
    private static int nactiVolbu() {
        int volba;
        try {
           volba = scanner.nextInt();
        } catch (InputMismatchException ex) {
            volba = -1;
        }
        scanner.nextLine();
        return volba;
    }
    private static boolean obsluzVolbu(int volba) {
        switch (volba) {
            case 0: return true;
            case 1: matA = nactiMatici();break;
            case 2: matB = nactiMatici();break;
            case 3: vypisObouMatic();break;
            case 4: vzajemnaVymenaMatic();break;
            case 5: vypocetSouctuMatic();break;
            case 6: vypocetSoucinuMatic();break;
            case 7: matA = MatrixTools.maticeTransponovana(matA);vypisMatice(matA,"Transpozice");break;
            case 8: MatrixTools.prevedDoNorm(matB);break;
            case 9:
                matA = new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
                matB = new double[][]{{-9, -8, -7}, {6, 5, 4}, {3, 2, 1}};
                break;
            default: System.out.println("Neznama volba");
        }
        return false;
    }
    private static double[][] nactiMatici() {
        System.out.println("\nNacteni matice");
        System.out.println("Zadej pocet radku a sloupcu");
        int pr = scanner.nextInt();
        int ps = scanner.nextInt();
        System.out.println("Zadej prvky matice po radcich");
        double[][] mat = new double[pr][ps];
        for (int i = 0; i < pr; i++) {
            for (int j = 0; j < ps; j++) {
                mat[i][j] = scanner.nextDouble();
            }
        }
        scanner.nextLine();
        return mat;
    }

    private static void vypisObouMatic() {
        vypisMatice(matA, "Matice A");
        vypisMatice(matB, "Matice B");
    }
    private static void vypisMatice(double[][] mat, String titulek) {
        if (mat == null) {
            System.out.println("Nastala chyba s matici");
            return;
        }
        System.out.println(titulek);
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.format("%6.2f",mat[i][j]);
            }
            System.out.println();
        }
    }
    private static void vzajemnaVymenaMatic() {
        double[][] h = matA;
        matA = matB;
        matB = h;
    }
    private static void vypocetSouctuMatic() {
        vypisMatice(MatrixTools.souctetMatic(matA, matB),"Soucet A + B");
    }
    private static void vypocetSoucinuMatic() {
        vypisMatice(MatrixTools.soucinMatic(matA,matB), "Soucin A * B");
    }
}
