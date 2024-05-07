package cv11.kozeny;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class AtletickyViceboj {
    private ArrayList<String> Discipliny;
    private ArrayList<Atlet> Atleti;
    private File outF;
    private File outD;
    private static boolean FileNotExists = true;
    private int DELKA_ZAZNAMU;
    private int Odstoupeni = 0;
    private int disc_in;
    private int atl_in;

    private AtletickyViceboj(String soubor) {
        Discipliny = new ArrayList<>();
        Atleti = new ArrayList<>();
        Path p = Path.of(soubor);
        Path out = Path.of(p.getParent().toString() + "/" + p.toFile().getName().split("\\.")[0] + ".vysl");
        Path outDis = Path.of(p.getParent().toString() + "/" + p.toFile().getName().split("\\.")[0] + ".dis");
        outD = outDis.toFile();
        outF = out.toFile();
        try {
            nactiVstupniSoubor(soubor);
            if(!FileNotExists){
                zapisDefaultniHodnoty();
            }
        } catch (IOException e) {
            System.err.println("Chyba při práci se souborem: " + e.getMessage());
        }
        DELKA_ZAZNAMU = 4 + Discipliny.size()*2;
    }

    public static AtletickyViceboj getInstance(String soubor) throws IOException {
        Path p = Path.of(soubor);
        if(!Files.exists(p)){
            throw new IOException("Soubor neexistuje");
        }
        Path out = Path.of(p.getParent().toString() + "/" + p.toFile().getName().split("\\.")[0] + ".vysl");
        Path outD = Path.of(p.getParent().toString() + "/" + p.toFile().getName().split("\\.")[0] + ".dis");
        if(!Files.exists(out)){
            System.out.println("Vystupni soubor neexistuje, vytvarim novy");
            Files.createFile(out);
            FileNotExists = false;
        }
        if(!Files.exists(outD)){
            System.out.println("Vystupni soubor pro diskvalifikaci neexistuje, vytvarim novy");
            Files.createFile(outD);
        }
        return new AtletickyViceboj(soubor);
    }
    public void zapisDefaultniHodnoty() throws IOException{
        try(RandomAccessFile raf = new RandomAccessFile(outF, "rw")){
            raf.writeInt(Atleti.size());
            raf.writeInt(Discipliny.size());
            for (Atlet a: Atleti) {
                raf.writeInt(a.getId());
                for (int i = 0; i < Discipliny.size(); i++) {
                    raf.writeShort(-1);
                }
            }
        }

    }
    public void zaznamenejBod(int id, int disciplina, int hodnota) throws IOException {
//        int index = Atleti.stream().filter(a -> a.getId() == id).findFirst().map(Atleti::indexOf).orElse(-1);
        try(RandomAccessFile raf = new RandomAccessFile(outF, "rw")) {
//            raf.seek(8 + (index)*DELKA_ZAZNAMU + 4);
//            raf.skipBytes(2*disciplina);
//            if(raf.readShort() != -1){
//                throw new IOException("Uz byl zaznamenany vysledek v teto discipline");
//            }
//            raf.skipBytes(-2);
//            raf.writeShort(hodnota);
            raf.seek(8);
            for (int i = 0; i < Atleti.size(); i++) {
                int f_id = raf.readInt();
                if (f_id == id) {
                    raf.skipBytes(2*disciplina);
                    if(raf.readShort() != -1){
                        throw new IOException("Uz byl zaznamenany vysledek v teto discipline");
                    }
                    raf.seek(raf.getFilePointer()-2);
                    raf.writeShort(hodnota);
                } else {
                    raf.skipBytes(6);
                }
            }
        }
    }
    public void opravBod(int id, int disciplina, int hodnota) throws IOException {
//        int index = Atleti.stream().filter(a -> a.getId() == id).findFirst().map(Atleti::indexOf).orElse(-1);
        try(RandomAccessFile raf = new RandomAccessFile(outF, "rw")) {
//            raf.seek(8 + (index*DELKA_ZAZNAMU) + 4);
//            raf.skipBytes(2*disciplina);
//            raf.writeShort(hodnota);
            raf.seek(8);
            for (int i = 0; i < Atleti.size(); i++) {
                int f_id = raf.readInt();
                if (f_id == id) {
                    raf.skipBytes(2*disciplina);
                    raf.writeShort(hodnota);
                } else {
                    raf.skipBytes(6);
                }
            }
        }
    }


    private void nactiVstupniSoubor(String soubor) throws IOException {
        try(BufferedReader br = Files.newBufferedReader(Path.of(soubor))){
            boolean eof = false;
            int len = Integer.parseInt(br.readLine());
            for(int i = 0; i < len; i++){
                String radek = br.readLine();
                Discipliny.add(radek);
            }
            while(!eof){
                String radek = br.readLine();
                if(radek == null){
                    eof = true;
                }else{
                    Atleti.add(Atlet.getInstance(radek));
                }
            }
        }
    }
    public void odstoupeniAtleta(int id) throws IOException {
        int index = Atleti.stream().filter(a -> a.getId() == id).findFirst().map(Atleti::indexOf).orElse(-1);
        Atleti.set(index, Atleti.get(Atleti.size() - 1));
        Atleti.remove(Atleti.size() - 1);

        short[] pole = new short[Discipliny.size()];
        short[] lastPole = new short[Discipliny.size()];
        int lastID;
        try(RandomAccessFile raf = new RandomAccessFile(outF, "rw")){
            raf.writeInt(Atleti.size());
            //ziskani posledniho zaznamu
            raf.seek(raf.length() - DELKA_ZAZNAMU);
            lastID = raf.readInt();
            for (int i = 0; i < Discipliny.size(); i++) {
                lastPole[i] = raf.readShort();
            }

            raf.seek(8);
            for (int i = 0; i < Atleti.size()+1; i++) {
                int f_id = raf.readInt();
                if(f_id == id) {
                    //raf.skipBytes(-4);
                    System.out.println(raf.getFilePointer());
                    raf.seek(raf.getFilePointer()-4);
                    System.out.println(raf.getFilePointer());
                    raf.writeInt(lastID);
                    System.out.println(raf.getFilePointer());
                    for (int j = 0; j < Discipliny.size(); j++) {
                        pole[j] = raf.readShort();
                    }
                    raf.seek(raf.getFilePointer()-2*Discipliny.size());
                    for (int j = 0; j < Discipliny.size(); j++) {
                        raf.writeShort(lastPole[j]);
                    }
                    raf.setLength(raf.length() - DELKA_ZAZNAMU);
                    break;
                }else{
                    raf.skipBytes(6);
                }

            }

        }
        try(RandomAccessFile raf = new RandomAccessFile(outD, "rw")){
            raf.writeInt(++Odstoupeni);
            raf.writeInt(Discipliny.size());
            raf.seek(raf.length());
            raf.writeInt(id);
            for(short s: pole){
                raf.writeShort(s);
            }
        }
    }

    public String vypisVysledky() throws IOException {
        StringBuilder sb = new StringBuilder();
        try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(outF)))) {
            int len = dis.readInt();
            sb.append("Pocet atletu: ").append(len).append("\n");
            int lenD = dis.readInt();
            sb.append("Pocet disciplin: ").append(lenD).append("\n");
            for (int i = 0; i < len; i++) {
                sb.append("Atlet ").append(dis.readInt()).append(": ");
                for (int j = 0; j < lenD; j++) {
                    sb.append(dis.readShort()).append(" ");
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    public String vypisSerazeneListiny() throws IOException {
        HashMap<Integer, Short> map = new HashMap<>();
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(outF)))) {
            int len = dis.readInt();
            int lenD = dis.readInt();
            for (int i = 0; i < len; i++) {
                int id = dis.readInt();
                short sum = 0;
                for (int j = 0; j < lenD; j++) {
                    short a = dis.readShort();
                    if(a!=-1){
                        sum += a;
                    }
                }
                map.put(id, sum);
            }
        }

        //https://www.liberiangeek.net/2024/01/sort-map-value-java/
        LinkedHashMap<Integer, Short> sorted = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Short> entry : sorted.entrySet()) {
            sb.append("Atlet ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
    public ArrayList<String> getDiscipliny() {
        return Discipliny;
    }

    public ArrayList<Atlet> getAtleti() {
        return Atleti;
    }
}
