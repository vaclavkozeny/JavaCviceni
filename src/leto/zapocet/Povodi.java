package src.leto.zapocet;

import java.util.ArrayList;

public class Povodi {
    private int cislo;
    private String nazev;

    public Povodi(int cislo, String nazev) {
        this.cislo = cislo;
        this.nazev = nazev;
    }

    public int getCislo() {
        return cislo;
    }

    public String getNazev() {
        return nazev;
    }
}
