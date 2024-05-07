package src.leto.cv10.Banka;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.EOFException;
import java.io.IOException;
import java.time.LocalDate;

public class Transakce {
    private final LocalDate cas;
    private final double castka;

    public Transakce(LocalDate cas, double castka) {
        this.cas = cas;
        this.castka = castka;
    }
    public static Transakce newPrijem(LocalDate datum, double castka){
        if (castka <= 0) {
            throw new IllegalArgumentException("Nekladna castka " + castka);
        }
        return new Transakce(datum, castka);
    }

    public static Transakce newVydaj(LocalDate datum, double castka){
        if (castka <= 0) {
            throw new IllegalArgumentException("Nekladna castka " + castka);
        }
        return new Transakce(datum, -castka);
    }

    public void SaveToFile(DataOutput dos) throws IOException {
        dos.writeInt(cas.getDayOfMonth());
        dos.writeInt(cas.getMonthValue());
        dos.writeInt(cas.getYear());
        dos.writeDouble(castka);
    }
    public static Transakce LoadFromFile(DataInput dis) throws IOException {
        int den = dis.readInt();
        try {
            int mesic = dis.readInt();
            int rok = dis.readInt();
            double castka = dis.readDouble();
            return new Transakce(LocalDate.of(rok, mesic, den), castka);
        } catch (EOFException ex) {
            throw new IOException("Chybny format souboru");
        }
    }
    public String toString() {
        return String.format("%s: %.2f", cas, castka);
    }
}
