package src.leto.cv10.Banka;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Ucet {
    //private final int cisloUctu;
    private final Path soubor;
    private static final String path = "src/leto/cv10/Banka/ucty/";
    private static final String ext = ".dat";

    private Ucet(Path soubor) {
        this.soubor = soubor;
    }

    public static Ucet getInstance(long cisloUctu, boolean novyUcet) throws IOException {
        if(cisloUctu <= 0){
            return null; //chyba
        }
        String jmenoSouboru = String.format("U%010d%s", cisloUctu, ext);
        Path soubor = Path.of(path + jmenoSouboru);
        if(novyUcet){
            if(soubor.toFile().exists()){
                return null;
            }else{
                soubor.toFile().createNewFile();
                return new Ucet(soubor);
            }
        }else{
            if(!soubor.toFile().exists()) {
                return null; //chyba
            }
            return new Ucet(soubor);
        }
    }
    public void ZaznamenejTrancakci(Transakce transakce) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(soubor, StandardOpenOption.APPEND)))){
            transakce.SaveToFile(dos);
        }
    }
    //vypis transakci z uctu
    public List<Transakce> getTransakce() throws IOException {
        ArrayList<Transakce> transakce = new ArrayList<>();
        try(DataInputStream dis = new DataInputStream(new BufferedInputStream(Files.newInputStream(soubor, StandardOpenOption.READ)))){
            boolean konec = false;
            while(!konec){
                try{
                    transakce.add(Transakce.LoadFromFile(dis));
                }catch (EOFException ex){
                    konec = true;
                }
            }
        }
        return transakce;
    }
    //vypis bilance uctu

    @Override
    public String toString() {
        return "Ucet{" +
                "soubor=" + soubor +
                '}';
    }
}
