package src.leto.cv03.Matematika;

import java.util.Scanner;

public final class MathTools {

    private MathTools() {
    }
    // konstruktor private
    // metody static

    /**
     * <h2>Nejvetsi spolecny delitel</h2>
     * <p>- V pripade nektereho zapotneho cisla poskytne nsd odpovidajicich kladnych</p>
     * <p>- Pokud je nejaky paramet nula, vyhodime vyjimku</p>
     * @param a
     * @param b
     * @return
     */
    public static int nejvetsiSpolecnyDelitel(int a, int b){
        if(a<0)
            a = Math.abs(a);
        if(b<0)
            b = Math.abs(b);
        if(a == 0 || b == 0)
            throw new IllegalArgumentException("Zadane cislo je nulove");
        int c;
        while (b != 0) {
            c = b;
            b = a % b;
            a = c;
        }
        return a;
    }
}
