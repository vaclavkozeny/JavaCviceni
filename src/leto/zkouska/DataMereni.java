package src.leto.zkouska;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;

public class DataMereni {
    ArrayList<Velicina> velicinas;
    ArrayList<Zaznam> zaznams;

    public void nactiVeliciny(String path) throws IOException {
        Path file = Path.of(path);
        try(BufferedReader bufferedReader = new BufferedReader(Files.newBufferedReader(file))) {
            String line;
            while((line = bufferedReader.readLine()) != null){
                if(line.isBlank())
                    continue;
                String[] parts = line.split(" ");
                for(int i = 0; i < parts.length; i++){
                    parts[i] = parts[i].trim();
                }
                velicinas.add(new Velicina(Byte.parseByte(parts[0]), parts[1]));
            }
        }
    }
    public void nactiMereni(String path) throws IOException{
        Path file = Path.of(path);
        boolean eof = false;
        try (DataInputStream dis = new DataInputStream(Files.newInputStream(file))) {
            while (!eof) {
                try {
                    byte id = dis.readByte();
                    if(velicinas.stream().noneMatch(v-> v.getId() == id))
                        throw new IllegalArgumentException();
                    long cas = dis.readLong();
                    double hodnota = dis.readDouble();
                    zaznams.add(new Zaznam(id,cas,hodnota));
                } catch (EOFException ex) {
                    eof = true;
                }
            }
        }
    }
    public String vypis(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Velicina v: velicinas) {
            stringBuilder.append(v.getName() + "\n");
            stringBuilder.append(zaznams.stream().filter(zaznam -> zaznam.getIdVeliciny() == v.getId()).max(Comparator.comparing(Zaznam::getNamereno)) + "\n");
            stringBuilder.append(zaznams.stream().filter(zaznam -> zaznam.getIdVeliciny() == v.getId()).min(Comparator.comparing(Zaznam::getNamereno)) + "\n");
            int p = 0;
            double val = 0;
            for (Zaznam z : zaznams.stream().filter(zaznam -> zaznam.getIdVeliciny() == v.getId()).toList()) {
                val = val + z.getNamereno();
                p++;
            }
            stringBuilder.append(val/p);
        }
        return stringBuilder.toString();
    }
    public void save(String dataFolder) throws IOException{
//        Path folder = Path.of(dataFolder);
        for (Velicina v: velicinas) {
            Path f = Path.of(dataFolder + "/"+v.getName()+".dat");
            if(!f.toFile().exists())
                f.toFile().createNewFile();
            try(DataOutputStream dataOutputStream = new DataOutputStream(Files.newOutputStream(f, StandardOpenOption.APPEND))){
                for (Zaznam z: zaznams.stream().filter(zaznam -> zaznam.getIdVeliciny() == v.getId()).toList()) {
                    z.SaveToFile(dataOutputStream);
                }
            }
        }
    }

}
