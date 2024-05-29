package src.leto.zapocet;

public class Stanice {
    private String nazev;
    private int cisloPovodi;
    private int mnm;

    public Stanice(String nazev, int cisloPovodi, int mnm) {
        this.nazev = nazev;
        this.cisloPovodi = cisloPovodi;
        this.mnm = mnm;
    }

    public String getNazev() {
        return nazev;
    }

    public int getCisloPovodi() {
        return cisloPovodi;
    }

    public int getMnm() {
        return mnm;
    }
}
