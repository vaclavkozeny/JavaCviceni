package src.leto.semPR;

import src.leto.cv10.Banka.Transakce;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.EOFException;
import java.io.IOException;
import java.time.LocalDate;

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
    public static Zbozi LoadFromFile(DataInput dis) throws IOException {
        int id = dis.readInt();
        try {
            String nazev = dis.readUTF();
            int pocet_na_sklade = dis.readInt();
            return new Zbozi(id, nazev, pocet_na_sklade);
        } catch (EOFException ex) {
            throw new IOException("Chybny format souboru");
        }
    }
}
