package src.zima.cv11;

public final class  PiskvorkyTools {
    public PiskvorkyTools() {}
     /**
     * pocet hodnot radku
     * @param a vstupni matice
     * @param radek cislo radku
     * @param sloupec cislo sloupce
     * @return pocet stejnych hodnot ve smeru doprava + smeru doleva
     */
    public static int pocetStejnychVRadce(int[][]a, int radek, int sloupec){
        int hodnota = a[radek][sloupec];
        int pocet = 1;
        for(int i = sloupec; i < a[0].length-1; i++){
            if(a[radek][i+1] != hodnota){
                break;
            }
            pocet++;
        }

        for(int i = sloupec; i > 0; i--){
            if(a[radek][i-1] != hodnota){
                break;
            }
            pocet++;
        }
        return pocet;
    }
    /**
     * pocet hodnot sloupce
     * @param a vstupni matice
     * @param radek cislo radku
     * @param sloupec cislo sloupce
     * @return pocet stejnych hodnot ve smeru nahoru + smeru dolu
     */
    public static int pocetStejnychVSloupci(int[][] a, int radek, int sloupec) {
        int hodnota = a[radek][sloupec];
        int pocet = 1;
        for(int i = radek; i < a.length-1; i++){
            if(a[i+1][sloupec] != hodnota){
                break;
            }
            pocet++;
        }

        for(int i = radek; i > 0; i--){
            if(a[i-1][sloupec] != hodnota){
                break;
            }
            pocet++;
        }
        return pocet;
    }
    /**
     * pocet hodnot diagonaly
     * @param a vstupni matice
     * @param radek cislo radku
     * @param sloupec cislo sloupce
     * @return pocet stejnych hodnot ve smeru diagonaly nahoru + smeru diagonaly dolu
     */
    public static int pocetStejnychVDiag1(int[][] a, int radek, int sloupec) {
        int hodnota = a[radek][sloupec];
        int pocet = 1;
        for(int i = radek, j = sloupec; (i < a.length-1)&&(j < a[0].length-1); i++,j++){
            if(a[i+1][j+1] != hodnota){
                break;
            }
            pocet++;
        }

        for(int i = radek, j = sloupec; (i > 0)&&(j > 0); i--,j--){
            if(a[i-1][j-1] != hodnota){
                break;
            }
            pocet++;
        }
        return pocet;
    }
    /**
     * pocet hodnot antidiagonaly
     * @param a vstupni matice
     * @param radek cislo radku
     * @param sloupec cislo sloupce
     * @return pocet stejnych hodnot ve smeru antidiagonaly nahoru + smeru antidiagonaly dolu
     */
    public static int pocetStejnychVDiag2(int[][] a, int radek, int sloupec) {
        int hodnota = a[radek][sloupec];
        int pocet = 1;
        for(int i = radek, j = sloupec; (i < a.length-1)&&(j > 0); i++,j--){
            if(a[i+1][j-1] != hodnota){
                break;
            }
            pocet++;
        }

        for(int i = radek, j = sloupec; (i > 0)&&(j < a[0].length-1); i--,j++){
            if(a[i-1][j+1] != hodnota){
                break;
            }
            pocet++;
        }
        return pocet;
    }
}
