package src.leto.kozeny.src;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;

public class Objednavka {
    ArrayList<ZboziVObjednavce> zbozi;
//    int id;
    int cena;
    private String path;

    public Objednavka() {
        this.zbozi = new ArrayList<>();
//        this.id = id;
        path = Pobocka.path;
    }

    public ArrayList<ZboziVObjednavce> getZbozi() {
        return zbozi;
    }

//    public int getId() {
//        return id;
//    }

    public int getCena() {
        cena = 0;
        for (ZboziVObjednavce z : zbozi) {
            cena += z.getCena() * z.getPocet_na_sklade();
        }
        return cena;
    }
    public int pridatZbozi(int id, int pocet) throws IOException {
        int lastL = zbozi.size();
        Path folder = Path.of(path);
        Files.list(folder).forEach(file -> {
            try {
                Pobocka p = Pobocka.getInstance(file);
                p.getZbozi().stream().filter(z -> z.getId() == id).findFirst().ifPresent(z -> this.zbozi.add(new ZboziVObjednavce(id, z.getNazev(), z.getCena(), pocet, p.getId())));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        if (lastL == zbozi.size()) {
            return -1;
        }else {
            return 0;
        }
    }
    public void odebratZbozi(int id, int pocet){
        Iterator<ZboziVObjednavce> iterator = zbozi.iterator();
        while (iterator.hasNext()) {
            ZboziVObjednavce z = iterator.next();
            if (z.getId() == id) {
                if (z.getPocet_na_sklade() <= pocet) {
                    iterator.remove(); // Bezpečné odstranění prvku
                } else {
                    z.pocet_na_sklade -= pocet;
                }
            }
        }
    }
    public int dokocitObjednavku() throws IOException {
        if (zbozi.size() == 0) {
            return -1; // Objednavka je prazdna
        }
        Path folder = Path.of(path);
        Files.list(folder).forEach(file -> {
            try {
                Pobocka p = Pobocka.getInstance(file);
                zbozi.forEach(z -> {
                    if (z.pobockaId == p.getId()) {
                        try {
                            p.odeberZbozi(z.getId(), z.getPocet_na_sklade()); //sice se to jmenuje pocet na sklade ale je to pocet v objdnavce
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        zbozi.clear();
        return 0; //ok
    }
//    public int jeMozneRealizovatJednouPobockou() throws IOException {
//        if (zbozi.size() == 0) {
//            return -1; // Objednavka je prazdna
//        }
//        Path folder = Path.of(path);
//        Files.list(folder).forEach(file -> {
//            try {
//                Pobocka p = Pobocka.getInstance(file);
//
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//    }
}
