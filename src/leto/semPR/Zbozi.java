package src.leto.semPR;

import java.io.DataOutput;
import java.io.IOException;

public class Zbozi {
    int id;
    String nazev;
    int pocet_na_sklade;

    public Zbozi(int id, String nazev, int pocet_na_sklade) {
        this.id = id;
        this.nazev = nazev;
        this.pocet_na_sklade = pocet_na_sklade;
    }
    public void SaveToFile(DataOutput dos) throws IOException {
        dos.writeInt(id);
        dos.writeUTF(nazev);
        dos.writeInt(pocet_na_sklade);
    }

}
