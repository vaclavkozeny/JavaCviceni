package src.leto.cv04.date;

/**
 * <h1>Kalendář</h1>
 * <p>- obsahuje metody pro praci s kalendarem a pohybu v nem</p>
 * <p>- zbyle metody jsou v knihovni tride DatetimeTools.java</p>
 * <p style="color:red">Pravdepodobne \t nebude system independent</p>
 * @author <a href="https://github.com/vaclavkozeny">Vaclav Kozeny</a>
 */
public class Kalendar {
    private final String EOLN = System.getProperty("line.separator");
    private final String[] mesice = {"Leden", "Unor", "Brezen", "Duben", "Kveten", "Cerven", "Cervenec", "Srpen", "Zari", "Rijen", "Listopad", "Prosinec"};
    private int den;
    private int mesic;
    private int rok;
    //testovaci konstruktor
//    public Kalendar(){
//        this.den = 29;
//        this.mesic = 2;
//        this.rok = 2024;
//    }
    private Kalendar(int den, int mesic, int rok) {
        this.den = den;
        this.mesic = mesic;
        this.rok = rok;
    }

    /**
     * <h1>Tovarni metoda</h1>
     * <h3>pro ziskani instance kalendare</h3>
     * @param den
     * @param mesic
     * @param rok
     * @return Kalendar - pokud je datum platne
     * @throws IllegalArgumentException pokud datum neni platne
     */
    public static Kalendar getKalendar(int den, int mesic, int rok){
        if(DatetimeTools.jePlatneDatum(den,mesic,rok))
            return new Kalendar(den,mesic,rok);
        else
            throw new IllegalArgumentException("Datum neni platne");
    }
    //Vim ze \t asi nebude system independent, jako line.separator

    /**
     * <h3>metoda pro ziskani tabuly kalendare</h3>
     * @return String - formatovana tabulka kalendare
     */
    public String getKalendarovaTabulka(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t\t"+mesice[mesic-1]+"\t"+rok+EOLN);
        stringBuilder.append(" PO\t UT\t ST\t CT\t PA\t SO\t NE");
        stringBuilder.append(EOLN);
        int prvniDen = DatetimeTools.denTydne(1,this.mesic,this.rok);
        int pocetDnu = DatetimeTools.pocetDnuVMesici(this.mesic,this.rok);
        for(int i = 1; i < pocetDnu+1;i++){
            if(i == 1)
                stringBuilder.append("\t".repeat(Math.max(0, prvniDen - 1)));
            if(i==this.den){
                stringBuilder.append(String.format("[%2d]",i));
            }else
                stringBuilder.append(String.format(" %2d ",i));
            if((i+prvniDen-1)%7==0){
                stringBuilder.append(EOLN);
            }
        }
        return stringBuilder.toString();
    }

    //Moving in calendar
    public void dalsiDen(){
        this.den++;
        if(this.den > pocetDnu()){
            this.mesic++;
            if(this.mesic > 12)
                this.rok++;
        }
        if(!platneDatum())
            throw new IllegalStateException("neplatne datum");
    }
    public void uberDen(){
        this.den--;
        if(this.den<1){
            this.mesic--;
            if(mesic < 1){
                this.rok--;
                this.mesic = 12;
            }
            this.den = pocetDnu();
        }
        if(!platneDatum())
            throw new IllegalStateException("neplatne datum");
    }
    public void dalsiMesic(){
        this.mesic++;
        if(this.mesic > 12){
            this.rok++;
        }
        if(!platneDatum())
            throw new IllegalStateException("neplatne datum");
    }
    public void uberMesic(){
        this.mesic--;
        if(mesic < 1){
            this.rok--;
            this.mesic = 12;
        }
        if(!platneDatum())
            throw new IllegalStateException("neplatne datum");
    }
    public void dalsiRok(){
        this.rok++;
        if(!platneDatum())
            throw new IllegalStateException("neplatne datum");
    }
    public void uberRok(){
        this.rok--;
        if(!platneDatum())
            throw new IllegalStateException("neplatne datum");
    }

    /**
     * Getter pro den
     * @return den
     */
    public int getDen() {
        return den;
    }
    /**
     * Getter pro mesic
     * @return mesic
     */
    public int getMesic() {
        return mesic;
    }
    /**
     * Getter pro rok
     * @return rok
     */
    public int getRok() {
        return rok;
    }

    /**
     * <h3>Pomocna metoda pro zjisteni platneho data</h3>
     *  <p>- bere hodnoty ulozene v aktualnim objektu</p>
     *  <p>- dojde k volani metody z DatetimeTools</p>
     * @return platnost datumu
     */
    private boolean platneDatum(){
        return DatetimeTools.jePlatneDatum(this.den, this.mesic, this.rok);
    }

    /**
     * <h3>Pomocna metoda pro pocet dni v mesici</h3>
     * <p>- bere hodnoty ulozene v aktualnim objektu</p>
     * <p>- dojde k volani metody z DatetimeTools</p>
     * @return pocet dnu v mesici
     */
    private int pocetDnu(){
        return DatetimeTools.pocetDnuVMesici(this.mesic,this.rok);
    }
}
