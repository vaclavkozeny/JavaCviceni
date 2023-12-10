package src.cv12;

import java.util.Scanner;

public class VyskytyHodnot {
    /*
    Program má sekvenčně načítat celá čísla do zadání nekladné hodnoty. Tato vstupní data nenačítejte všechna do paměti programu (pole).
    Program má určit jaké hodnoty se mezi zadanými vyskytují a počet jejich výskytů. Tyto informace postupně určit a uchovat v interních proměnných (poli) programu.ve vhodných strukturách (poli/polích).
    Následně vyhledané hodnoty uspořádat vzestupně dle hodnot.
    Určit hodnotu s maximálním počtem výskytů.
    Před ukončením programu vypsat výsledky - vypsat hodnoty u každé počet výskytů, zjištěná hodnota s max. výskytem.
     */
    private static final Scanner scanner = new Scanner(System.in);
    private static final int DELTA = 5;
    public static void main(String[] args) {
        int a;
        int[] vyskyty = new int[10];
        int[] poctyVyskytu = new int[10];
        int iterator = 0;
        boolean pridatDoPole;
        do{
            pridatDoPole = true;
            a = scanner.nextInt();
            if(a <= 0){
                break;
            }
            if(iterator >= vyskyty.length){
                vyskyty = zvetsiPole(vyskyty);
                poctyVyskytu = zvetsiPole(poctyVyskytu);
            }
            for (int i = 0; i < vyskyty.length; i++) {
                if(vyskyty[i] == a){
                    poctyVyskytu[i]++;
                    pridatDoPole = false;
                    break;
                }
            }
            if(pridatDoPole){
                vyskyty[iterator] = a;
                poctyVyskytu[iterator]++;
                iterator++;
            }

        }while(a>0);
        int l = poctyVyskytu.length;
        for (int i = 0; i < l; i++){
            int minIndex = i;
            for (int j = i + 1; j < l; j++) {
                if (poctyVyskytu[j] < poctyVyskytu[minIndex]) {
                    minIndex = j;
                }
            }
            int tempPocet = poctyVyskytu[minIndex];
            int tempVyskyt = vyskyty[minIndex];
            poctyVyskytu[minIndex] = poctyVyskytu[i];
            vyskyty[minIndex] = vyskyty[i];
            poctyVyskytu[i] = tempPocet;
            vyskyty[i] = tempVyskyt;
        }
//        for (int i = vyskyty.length - 1; i > 0; i--) {
//            if(poctyVyskytu[i]!=0) {
//                System.out.format("\nvyskyt: %d - pocet %d", vyskyty[i], poctyVyskytu[i]);
//            }
//        }
        int maxIndex = poctyVyskytu.length-1;
        for(int i = poctyVyskytu.length-1; i > 1; i--) {
            if(poctyVyskytu[i] == poctyVyskytu[i-1]){
                if(poctyVyskytu[i]!=0){
                    maxIndex--;
                }
            }else{
                break;
            }
        }
        for (int i = maxIndex; i < vyskyty.length; i++) {
            if(vyskyty[i] != 0) {
                System.out.format("\nvyskyt: %d, pocet vyskytu: %d  a to je maximum vysyktu", vyskyty[i], poctyVyskytu[i]);
            }
        }
        for(int i = maxIndex-1; i > 0; i--) {
            if(vyskyty[i] != 0){
                System.out.format("\nvyskyt: %d, pocet vyskytu: %d",vyskyty[i],poctyVyskytu[i]);
            }

        }

    }
    private static int[] zvetsiPole(int [] oldArray){
        int[] newArray = new int[oldArray.length + DELTA];
        //System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }
}
