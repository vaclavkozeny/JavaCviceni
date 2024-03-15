package src.leto.cv04.date;

public final class DatetimeTools {
    private DatetimeTools() {
    }

    static final int[] POCTY_DNU_V_MESICI = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static final String[] JMENA_DNU = {"pondeli", "utery", "streda", "ctvrtek", "patek", "sobota", "nedele"};

    public static boolean jePrestupnyRok(int rok){
        return rok % 4 == 0 && (rok % 100 !=0 || rok % 400 == 0);
    }

    /**
     * Metoda pro zjisteni dne v tydnu
     *
     * @param   den   cislo dne
     * @param   mes   cislo mesice
     * @param   rok   rok
     * @return  cislo 1 az 7 reprezentujici den tydne pondeli az nedele
     */
    public static int denTydne(int den, int mes, int rok) {
        int K = rok % 100; //dvoji cisel roku na pozici X napr. 19XX
        int J = rok / 100; //dvoji cisel roku na pozici X napr. XX90
        if (mes < 3) { //pro leden a unor jsou nutne nasledujici operace
            mes += 12;
            K--;
        }
        int h = (den + 13*(mes+1)/5 + K + K/4 + J/4 - 2*J) % 7;
        //return JMENA_DNU[((h+5)%7)+1]; //prevedeni vystupu tak, aby 1 - 7 predstavovalo po - ne
        return ((h+5)%7)+1;
    }

    public static boolean jePlatneDatum(int den, int mes, int rok) {
        if (rok < 1 || mes < 1 || mes > 12 || den < 1 || den > 31) {
            return false;
        }

        if (den == 31) { //vyradi neplatna data, kdyz mesic nema 31 dni
            if (mes < 8) {
                if (mes % 2 == 0) {
                    return false;
                }
            } else if (mes % 2 == 1) {
                return false;
            }
        }

        if (den > 28 && mes == 2) { //vyradi neplatne unory
            if (jePrestupnyRok(rok)) {
                if (den > 29) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
    /**
     * Poskytuje pocet dnu v mesici v zadanem roce
     *
     * @param mesic mesic
     * @param rok rok
     * @return
     */
    public static int pocetDnuVMesici(int mesic, int rok) {
        int pdm = POCTY_DNU_V_MESICI[mesic - 1];
        if (mesic == 2 && jePrestupnyRok(rok)) {
            return pdm + 1;
        }
        return pdm;
    }
}
