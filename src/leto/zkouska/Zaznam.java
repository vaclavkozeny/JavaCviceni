package src.leto.zkouska;

import java.io.DataOutput;
import java.io.IOException;

public class Zaznam {
    private final byte idVeliciny;
    private final long casMereni;
    private final double namereno;

    public Zaznam(byte idVeliciny, long casMereni, double namereno) {
        this.idVeliciny = idVeliciny;
        this.casMereni = casMereni;
        this.namereno = namereno;
    }

    public void SaveToFile(DataOutput dos) throws IOException {
        dos.writeByte(idVeliciny);
        dos.writeLong(casMereni);
        dos.writeDouble(namereno);
    }

    public byte getIdVeliciny() {
        return idVeliciny;
    }

    public long getCasMereni() {
        return casMereni;
    }

    public double getNamereno() {
        return namereno;
    }
}
