package src.leto.zapocet;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

public class MeteoData {
    public MeteoData() {
        povodi = new ArrayList<>();
        stanice = new ArrayList<>();
    }

    private ArrayList<Povodi> povodi;
    private ArrayList<Stanice> stanice;

    public void readFromFile(String fileName, int format) throws IOException {
        Path path = Path.of(fileName);
        //read text file
        try(BufferedReader bufferedReader = new BufferedReader(Files.newBufferedReader(path, format == 1 ? java.nio.charset.StandardCharsets.UTF_8 : java.nio.charset.Charset.forName("CP1250")))) {
            String line;
            bufferedReader.readLine(); // skip header
            while ((line = bufferedReader.readLine()) != null) {
                if(line.isBlank())
                    continue;
                String[] parts = line.split(";");
                for (int i = 0; i < parts.length; i++) {
                    parts[i] = parts[i].trim();
                }
                int cislo = Integer.parseInt(parts[0]);
                String nazev = parts[1];
                Povodi povod = new Povodi(cislo, nazev);
                povodi.add(povod);
            }
        }
    }
    public void pridejStanici(String filename, int format) throws IOException {
        Path path = Path.of(filename);
        try(BufferedReader bufferedReader = new BufferedReader(Files.newBufferedReader(path, format == 1 ? java.nio.charset.StandardCharsets.UTF_8 : java.nio.charset.Charset.forName("CP1250")))){
            String line;
            bufferedReader.readLine(); // skip header
            while ((line = bufferedReader.readLine()) != null) {
                if(line.isBlank())
                    continue;
                String[] parts = line.split(";");
                for (int i = 0; i < parts.length; i++) {
                    parts[i] = parts[i].trim();
                }
                String nazev = parts[0];
                int cisloPovodi = Integer.parseInt(parts[1]);
                int mnm = Integer.parseInt(parts[2]);
                Stanice stanice = new Stanice(nazev, cisloPovodi, mnm);
                this.stanice.add(stanice);
            }
        }
    }
    public String vypisPovodi() {
        StringBuilder sb = new StringBuilder();
        for (Povodi povod : povodi) {
            sb.append("Povodi: " + povod.getCislo() + ", " + povod.getNazev() + "\n");
        }
        return sb.toString();
    }
    public String vypisStanice(int sortParam){
        StringBuilder sb = new StringBuilder();
        ArrayList<Stanice> stanice = new ArrayList<>(this.stanice);
        switch (sortParam) {
            case 1:
                Collections.sort(stanice, (s1, s2) -> s1.getNazev().compareTo(s2.getNazev()));
                break;
            case 2:
                Collections.sort(stanice, (s1, s2) -> s2.getCisloPovodi() - s1.getCisloPovodi());
                break;
            case 3:
                Collections.sort(stanice, (s1, s2) -> s2.getMnm() - s1.getMnm());
                break;
            default:
                break;
        }
        for (Stanice stan : stanice) {
            sb.append("Stanice: " + stan.getNazev() + ", Povodi:  " + povodi.stream().filter(p -> p.getCislo() == stan.getCisloPovodi()).findFirst().get().getNazev() + ", Nadmorska vyska: " + stan.getMnm() + "\n");
        }
        return sb.toString();
    }
    public String vypisPovodiZeSouboru(){
        StringBuilder sb = new StringBuilder();
        for (Povodi povodi : povodi) {
            sb.append(povodi.getCislo() + ";" + povodi.getNazev() + "\n");
        }
        return sb.toString();
    }
    public String vypisStaniceZeSouboru(){
        StringBuilder sb = new StringBuilder();
        for (Stanice stanice : stanice) {
            sb.append("Stanice: " + stanice.getNazev() + ", Povodi: " + stanice.getCisloPovodi() + ", Nadmorska vyska: " + stanice.getMnm() + "\n");
        }
        return sb.toString();
    }
}
