package src.leto.cv04;

import java.util.Arrays;
import java.util.DuplicateFormatFlagsException;

/**
 *
 * @author Jirina
 */
public class Polynom {
    private final double[] koef;

    // Tyto prvni tri konstruktory nejsou potreba
    // ctvrty je plne nahrazuje
    // nicmene tyto konstruktory nejsou v kolizi se ctvrtym
    public Polynom(double a) {
        this.koef = new double[]{a};
    }
    public Polynom(double a, double b) {
        this.koef = new double[]{a, b};
    }
    public Polynom(double a, double b, double c) {
        this.koef = new double[]{a, b, c};
    }

    public Polynom(double... a) {
        // neukladat primo poskytnutou referenci na měnitelna data
        // zde si vytvorime kopii
        // reference na interni pole je pak mimi objekt nedostupna
        this.koef = new double[a.length];
        System.arraycopy(a, 0, this.koef, 0, a.length);;
    }

    // Tento konstruktor je v kolizi s predchozim!!
//    public Polynom(double[] koef) {
//        this.koef = new double[koef.length];
//        System.arraycopy(koef, 0, this.koef, 0, koef.length);
//    }

    // Takto ne!!
//    public double[] getKoef() {
//        // nelze poskytovat reference na interni menitelna data
//        return koef;
//        // nutno pripadne poskytnout kopii
//        // lepe ale nahradit metodou uvedenou nize
//    }

    /**
     * Poskytuje hodnotu koeficientu polynomu na pozici zadanou parametrem index.
     * Koeficienty jsou indexovany od 0, pocinaje absolutnim clenem vyse.
     * @param index
     * @return
     */
    public double getKoef(int index){
        if (index >= koef.length) return 0.0;
        return koef[index];
    }

    /** Poskytuje pocet koeficientu polynomu.
     *  Do poctu jsou zahrnuty všechny i nulove do nejvyssiho nenuloveho koeficientu.
     * @return pocet koeficientu.
     */
    public int pocetKoef(){
        return koef.length;
    }

    /**
     * Poskytuje stupen polynomu.
     * @return stupen polynomu.
     */
    public int getStupen() {
        return koef.length-1;
    }

    /**
     * Poskytuje hodnotu polynomu pro konkrotni x dane parametrem.
     * @param x realne cislo pro ktere ma byt hodnota polynomu vypoctena.
     * @return hodnota polynomu pro zadane x.
     */
//    public double getHodnota(double x) {
//
//    }
//    public double[] getDerivace(){
//
//    }
    /**
     * Poskytuje textovy retezec s polynomem.
     * Textovy retezec je v implicitnim formatu.
     * @return testovy retezec s formatovanym polynomem.
     */
    public String toStringFmt() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < pocetKoef(); i++){
            if(i==0)
                stringBuilder.append(koef[i] + " + ");
            if(i==1)
                stringBuilder.append(koef[i] + "x");
            stringBuilder.append(koef[i] + "x^" + i + " + ");
        }
        return stringBuilder.toString();
    }

    /**
     * Poskytuje textovy retezec s polynomem.
     * Textovy retezec, kde jednotlivé koeficienty jsou ve formátu daném parametrem..
     * @param formatCisel format koeficientu polynomu.
     * @return testovy retezec s formatovanym polynomem.
     */
//    public String toStringFmt(String formatCisel) {
//
//    }

    /**
     * Poskytuje textovy retezec s polynomem.
     * Textovy retezec, kde jednotlivé koeficienty jsou ve formátu daném parametrem..
     * @param desMist pocet desetinnych mist formatu koeficientů.
     * @return testovy retezec s formatovanym polynomem.
     */
//    public String toStringFmt(int desMist) {
//
//    }

    @Override
    public String toString() {
        return "Polynom{" + "koef=" + Arrays.toString(koef) + '}';
    }

}
