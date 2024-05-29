package src.leto.kozeny.src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

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

    /**
     * Vrátí cenu objednávky
     * @return
     */
    public int getCena() {
        cena = 0;
        for (ZboziVObjednavce z : zbozi) {
            cena += z.getCena() * z.getPocet_na_sklade();
        }
        return cena;
    }

    /**
     * Přidá zboží do objednávky
     * @param id id zboží
     * @param pocet počet kusů
     * @return 0 Ok, -1 zboží neexistuje
     * @throws IOException
     */
    public int pridatZbozi(int id, int pocet) throws IOException {
//        for (ZboziVObjednavce z : zbozi) {
//            if (z.getId() == id) {
//                z.pocet_na_sklade += pocet;
//                return 0;
//            }
//        }
        int lastL = zbozi.size();
        AtomicBoolean added = new AtomicBoolean(false);
        Path folder = Path.of(path);
        for (Path file : Files.list(folder).filter(file -> file.toString().endsWith(".sklad")).toList()) {

            try {
                Pobocka p = Pobocka.getInstance(file);
                p.getZbozi().stream().filter(z -> z.getId() == id && z.pocet_na_sklade >= pocet).findFirst().ifPresentOrElse(z -> {this.zbozi.add(new ZboziVObjednavce(id, z.getNazev(), z.getCena(), pocet, p.getId()));
                    added.set(true);},
                        () -> {
                    added.set(false);});
                if(added.get()) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!added.get()) {
            return -1;
        }else {
            return 0;
        }
    }

    /**
     * Odebere zboží z objednávky
     * @param id id zboží
     * @param pocet počet kusů
     * @return 0 Ok, -1 zboží neexistuje
     */
    public int odebratZbozi(int id, int pocet){
        Iterator<ZboziVObjednavce> iterator = zbozi.iterator();
        while (iterator.hasNext()) {
            ZboziVObjednavce z = iterator.next();
            if (z.getId() == id) {
                if (z.getPocet_na_sklade() <= pocet) {
                    iterator.remove(); // Bezpečné odstranění prvku
                } else {
                    z.pocet_na_sklade -= pocet;
                }
                return 0; // Zboží bylo odebráno
            }
        }
        return -1; // Zboží nebylo nalezeno
    }

    /**
     * Dokončí objednávku
     * @return 0 Ok, -1 objednávka je prázdná
     * @throws IOException
     */
    public int dokocitObjednavku() throws IOException {
        if (zbozi.size() == 0) {
            return -1; // Objednavka je prazdna
        }
        Path folder = Path.of(path);
        Files.list(folder).filter(file -> file.toString().endsWith(".sklad")).forEach(file -> {
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
//        for (Path p: Files.list(folder).toList()) {
//            //check if all items are in one store
//            boolean allItemsInStore = true;
//            for (ZboziVObjednavce z : zbozi) {
//                boolean itemInStore = false;
//                Pobocka pobocka = Pobocka.getInstance(p);
//                for (Zbozi zbozi : pobocka.getZbozi()) {
//                    if (zbozi.getId() == z.getId() && zbozi.getPocet_na_sklade() >= z.getPocet_na_sklade()){
//                        itemInStore = true;
//                        break;
//                    }
//                }
//                if (!itemInStore) {
//                    allItemsInStore = false;
//                    break;
//                }
//                else{
//
//                }
//            }
//        }
//    }

}
