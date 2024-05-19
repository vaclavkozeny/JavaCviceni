package src.leto.kozeny.src;

import java.io.DataOutput;
import java.io.IOException;

public class Zbozi {
    int id;
    String nazev;
    int pocet_na_sklade;
    int cena;


    public Zbozi(int id, String nazev,int cena, int pocet_na_sklade) {
        this.id = id;
        this.nazev = nazev;
        this.pocet_na_sklade = pocet_na_sklade;
        this.cena = cena;
    }
    public void SaveToFile(DataOutput dos) throws IOException {
        dos.writeInt(id);
        dos.writeUTF(nazev);
        dos.writeInt(cena);
        dos.writeInt(pocet_na_sklade);
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nazev: " + nazev + " | Cena: "+cena + " | Pocet: " + pocet_na_sklade;
    }

    public int getId() {
        return id;
    }

    public String getNazev() {
        return nazev;
    }

    public int getPocet_na_sklade() {
        return pocet_na_sklade;
    }

    public int getCena() {
        return cena;
    }
}