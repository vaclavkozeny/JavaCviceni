package src.leto.semPR;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;

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
    public void pridejNoveZbozi(Zbozi zbozi) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(soubor, StandardOpenOption.APPEND)))){
            zbozi.SaveToFile(dos);
        }
    }
//    public void pridejZbozi(int id, int pocet) throws IOException {
//        boolean eof = false;
//        try(RandomAccessFile randomAccessFile = new RandomAccessFile(soubor.toFile(), "rw")) {
//            String pobocka = randomAccessFile.readUTF();
//            while(!eof){
//                try{
//                    int idZbozi = randomAccessFile.readInt();
//                    String nazev = randomAccessFile.readUTF();
//                    int pocetNaSklade = randomAccessFile.readInt();
//                    if(idZbozi == id){
//                        randomAccessFile.seek(randomAccessFile.getFilePointer() - 4);
//                        randomAccessFile.writeInt(pocetNaSklade + pocet);
//                        return;
//                    }
//                }catch (EOFException ex){
//                    eof = true;
//                }
//            }
//        }
//    }
    public String vypisZbozi() throws IOException{
        StringBuilder sb = new StringBuilder();
        boolean eof = false;
        try(DataInputStream dis = new DataInputStream(Files.newInputStream(soubor, StandardOpenOption.READ))){
            String pobocka = dis.readUTF();
            sb.append(pobocka).append("\n");
            while(!eof){
                try{
                    int id = dis.readInt();
                    String nazev = dis.readUTF();
                    int pocet = dis.readInt();
                    sb.append("ID: ").append(id).append(" Nazev: ").append(nazev).append(" Pocet: ").append(pocet).append("\n");
                }catch (EOFException ex){
                    eof = true;
                }
            }
        }
        return sb.toString();
    }
    public void odeberZbozi(int id, int pocet) throws IOException {
        boolean eof = false;
        try(RandomAccessFile randomAccessFile = new RandomAccessFile(soubor.toFile(), "rw")) {
            String pobocka = randomAccessFile.readUTF();
            while(!eof){
                try{
                    int idZbozi = randomAccessFile.readInt();
                    String nazev = randomAccessFile.readUTF();
                    int pocetNaSklade = randomAccessFile.readInt();
                    if(idZbozi == id){
                        if(pocetNaSklade - pocet < 0){
                            System.out.println(pobocka + ": Nedostatek zbozi " + nazev + " na sklade");
                            return;
                        }
                        randomAccessFile.seek(randomAccessFile.getFilePointer() - 4);
                        randomAccessFile.writeInt(pocetNaSklade - pocet);
                        return;
                    }
                }catch (EOFException ex){
                    eof = true;
                }
            }
        }
    }
    private void odeberZaznamZbozi(int id) throws IOException{
        LinkedList<Zbozi> zbozi = new LinkedList<>();
        boolean eof = false;
        try(DataInputStream dis = new DataInputStream(Files.newInputStream(soubor, StandardOpenOption.READ))){
            String pobocka = dis.readUTF();
            while(!eof){
                try{
                    int idZbozi = dis.readInt();
                    String nazev = dis.readUTF();
                    int pocetNaSklade = dis.readInt();
                    zbozi.add(new Zbozi(idZbozi,nazev,pocetNaSklade));
                }catch (EOFException ex){
                    eof = true;
                }
            }
        }
        int rmIndex = zbozi.stream().filter(z -> z.id == id).map(zbozi::indexOf).findFirst().orElse(-1);
        if(rmIndex != -1){
            zbozi.remove(rmIndex);
        }

    }
    public String toString() {
        return "Pobocka: " + jmeno;
    }


}
