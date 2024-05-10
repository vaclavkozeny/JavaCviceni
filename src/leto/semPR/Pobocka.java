package src.leto.semPR;


import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Pobocka {
    private Path soubor;
    private String jmeno;
    //TODO: Prepsat cestu
    private static final String path = "src/leto/semPR/pobocky/";
    private static final String ext = ".sklad";

    private Pobocka(Path soubor, String jmeno) {
        this.soubor = soubor;
        this.jmeno = jmeno;
    }
    public static Pobocka getInstance(int id,String name,boolean novaPobocka) throws IOException {
        if(id <= 0){
            return null; //chyba
        }
        String jmenoSouboru = String.format("U%010d%s", id, ext);
        Path soubor = Path.of(path + jmenoSouboru);
        if(novaPobocka){
            if(soubor.toFile().exists()){
                return null; //chyba
            }else{
                soubor.toFile().createNewFile();
                try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(soubor, StandardOpenOption.APPEND)))){
                    dos.writeUTF(name);
                }
                return new Pobocka(soubor, name);
            }
        }else{
            if(!soubor.toFile().exists()) {
                return null; //chyba
            }else{
                try(DataInputStream dis = new DataInputStream(Files.newInputStream(soubor, StandardOpenOption.READ))){
                    String jmeno = dis.readUTF();
                    return new Pobocka(soubor, jmeno);
                }
            }
        }
    }
    public void pridejZbozi(Zbozi zbozi) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(soubor, StandardOpenOption.APPEND)))){
            zbozi.SaveToFile(dos);
        }
    }
    public String toString() {
        return "Pobocka{ soubor=" + soubor + ", jmeno=" + jmeno + "}";
    }


}
