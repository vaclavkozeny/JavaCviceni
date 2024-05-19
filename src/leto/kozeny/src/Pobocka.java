package src.leto.kozeny.src;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * CHYBY: -1 Zbozi neexistuje, -2 Nedostatek zbozi, -3 Chyba prace se soubory, 0 OK, -4 Zbozi uz existuje
 */
public class Pobocka {
    private Path soubor;
    private String jmeno;
    int id;
    //TODO: Prepsat cestu
    public static final String path = "C:\\Users\\kozen\\IdeaProjects\\javacviceni\\src\\leto\\kozeny\\data\\";
    private static final String ext = ".sklad";

    private Pobocka(Path soubor, String jmeno, int id) {
        this.soubor = soubor;
        this.jmeno = jmeno;
        this.id = id;
    }

    /**
     * Vytvori novou pobocku
     *
     * @param id
     * @param name
     * @param novaPobocka
     * @return Pobocka / null
     * @throws IOException
     */
    public static Pobocka getInstance(int id, String name, boolean novaPobocka) throws IOException {
        if (id <= 0) {
            return null; //chyba
        }
        String jmenoSouboru = String.format("P%010d%s", id, ext);
        Path soubor = Path.of(path + jmenoSouboru);
        if (novaPobocka) {
            if (soubor.toFile().exists()) {
                return null; //chyba
            } else {
                soubor.toFile().createNewFile();
                try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(soubor, StandardOpenOption.APPEND)))) {
                    dos.writeUTF(name);
                }
                return new Pobocka(soubor, name, id);
            }
        } else {
            if (!soubor.toFile().exists()) {
                return null; //chyba
            } else {
                try (DataInputStream dis = new DataInputStream(Files.newInputStream(soubor, StandardOpenOption.READ))) {
                    String jmeno = dis.readUTF();
                    return new Pobocka(soubor, jmeno, id);
                }
            }
        }
    }

    public static Pobocka getInstance(Path soubor) throws IOException {
        String fid = soubor.toFile().getName().split("\\.")[0];
        fid = fid.substring(1);
        fid = fid.replaceFirst("^0+(?!$)", "");
        int id = Integer.parseInt(fid);
        try (DataInputStream dis = new DataInputStream(Files.newInputStream(soubor, StandardOpenOption.READ))) {
            String jmeno = dis.readUTF();
            return new Pobocka(soubor, jmeno, id);
        }
    }

    /**
     * Prida nove zbozi do skladu (zaznam)
     *
     * @param zbozi
     * @return -3 Chyba zapisu, 0 OK, -4 Zbozi uz existuje
     * @throws IOException
     */
    public int pridejNoveZbozi(Zbozi zbozi) throws IOException {
        boolean eof = false;
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(soubor.toFile(), "rw")) {
            String pobocka = randomAccessFile.readUTF();
            while (!eof) {
                try {
                    int idZbozi = randomAccessFile.readInt();
                    String nazev = randomAccessFile.readUTF();
                    int pocetNaSklade = randomAccessFile.readInt();
                    if (idZbozi == zbozi.getId()) {
                        return -4; //Zbozi uz existuje
                    }
                } catch (EOFException e) {
                    eof = true;
                }
            }
        }
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(soubor, StandardOpenOption.APPEND)))) {
            zbozi.SaveToFile(dos);
        } catch (IOException e) {
            return -3; //chyba zapisu
        }
        return 0; //OK
    }
        /**
         * Prida zbozi do skladu, increment pocetNaSklade
         * @param id
         * @param pocet
         * @return -1 Zbozi neexistuje, -2 Nedostatek zbozi, 0 OK
         * @throws IOException
         */
        public int pridejZbozi ( int id, int pocet) throws IOException {
            boolean eof = false;
            try (RandomAccessFile randomAccessFile = new RandomAccessFile(soubor.toFile(), "rw")) {
                String pobocka = randomAccessFile.readUTF();
                while (!eof) {
                    try {
                        int idZbozi = randomAccessFile.readInt();
                        String nazev = randomAccessFile.readUTF();
                        int pocetNaSklade = randomAccessFile.readInt();
                        if (idZbozi == id) {
                            randomAccessFile.seek(randomAccessFile.getFilePointer() - 4);
                            randomAccessFile.writeInt(pocetNaSklade + pocet);
                            return 0; //OK
                        }
                    } catch (EOFException e) {
                        eof = true;
                    }
                }
                return -1; //Zbozi neexistuje
            }
        }

        /**
         * Vypis zbozi
         * @return
         * @throws IOException
         */
        public String vypisZbozi () throws IOException {
            StringBuilder sb = new StringBuilder();
            boolean eof = false;
            try (DataInputStream dis = new DataInputStream(Files.newInputStream(soubor, StandardOpenOption.READ))) {
                String pobocka = dis.readUTF();
                sb.append(pobocka).append("\n");
                while (!eof) {
                    try {
                        int id = dis.readInt();
                        String nazev = dis.readUTF();
                        int cena = dis.readInt();
                        int pocet = dis.readInt();
                        sb.append("ID: ").append(id).append(" | Nazev: ").append(nazev).append(" | Cena: ").append(cena).append(" | Pocet: ").append(pocet).append("\n");
                    } catch (EOFException ex) {
                        eof = true;
                    }
                }
            }
            return sb.toString();
        }

    public ArrayList<Zbozi> getZbozi() throws IOException {
        ArrayList<Zbozi> zbozi = new ArrayList<>();
        boolean eof = false;
        try(DataInputStream dis = new DataInputStream(Files.newInputStream(soubor, StandardOpenOption.READ))){
            String pobocka = dis.readUTF();
            while(!eof){
                try{
                    int id = dis.readInt();
                    String nazev = dis.readUTF();
                    int cena = dis.readInt();
                    int pocet = dis.readInt();
                    zbozi.add(new Zbozi(id,nazev,cena,pocet));
                }catch (EOFException ex){
                    eof = true;
                }
            }
        }
        return zbozi;
    }

        /**
         * Odebere zbozi ze skladu, decrement pocetNaSklade
         * @param id
         * @param pocet
         * @return -1 Zbozi neexistuje, -2 Nedostatek zbozi, 0 OK
         * @throws IOException
         */
        public int odeberZbozi ( int id, int pocet) throws IOException {
            boolean eof = false;
            try (RandomAccessFile randomAccessFile = new RandomAccessFile(soubor.toFile(), "rw")) {
                String pobocka = randomAccessFile.readUTF();
                while (!eof) {
                    try {
                        int idZbozi = randomAccessFile.readInt();
                        String nazev = randomAccessFile.readUTF();
                        int cena = randomAccessFile.readInt();
                        int pocetNaSklade = randomAccessFile.readInt();
                        if (idZbozi == id) {
                            if (pocetNaSklade - pocet < 0) {
                                System.out.println(pobocka + ": Nedostatek zbozi " + nazev + " na sklade");
                                return -2; //Nedostatek zbozi
                            }
                            randomAccessFile.seek(randomAccessFile.getFilePointer() - 4);
                            randomAccessFile.writeInt(pocetNaSklade - pocet);
                            return 0; //OK
                        }
                    } catch (EOFException ex) {
                        eof = true;
                    }
                }
                return -1; //Zbozi neexistuje
            }
        }

        /**
         * Odebere zaznam zbozi ze skladu, vymaze zaznam
         * @param id
         * @return -1 Zbozi neexistuje, -3 Chyba prace se soubory, 0 OK
         * @throws IOException
         */
        public int odeberZaznam ( int id) throws IOException {
            LinkedList<Zbozi> zbozi = new LinkedList<>();
            boolean eof = false;
            try (DataInputStream dis = new DataInputStream(Files.newInputStream(soubor, StandardOpenOption.READ))) {
                String pobocka = dis.readUTF();
                while (!eof) {
                    try {
                        int idZbozi = dis.readInt();
                        String nazev = dis.readUTF();
                        int cena = dis.readInt();
                        int pocetNaSklade = dis.readInt();
                        zbozi.add(new Zbozi(idZbozi, nazev, cena, pocetNaSklade));
                    } catch (EOFException ex) {
                        eof = true;
                    }
                }
            } catch (IOException e) {
                return -3; //chyba cteni souboru
            }
            int rmIndex = zbozi.stream().filter(z -> z.id == id).map(zbozi::indexOf).findFirst().orElse(-1);
            if (rmIndex != -1) {
                zbozi.remove(rmIndex);
            } else {
                return -1; //Zbozi neexistuje
            }
            try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(soubor)))) {
                dos.writeUTF(jmeno);
                for (Zbozi z : zbozi) {
                    z.SaveToFile(dos);
                }
            } catch (IOException e) {
                return -3; //chyba zapisu souboru
            }
            return 0;
        }

        public String getJmeno () {
            return jmeno;
        }

        public String toString () {
            return "Pobocka: " + jmeno;
        }

    public int getId() {
        return id;
    }
}
