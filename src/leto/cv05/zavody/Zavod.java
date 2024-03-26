package src.leto.cv05.zavody;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Optional;

public class Zavod {
    //private UUID uuid;
    private int id;
    private String jmenoZavodu;
    private ArrayList<Zavodnik> zavodniks;
    private int delka;
    private int regCisla;

    private Zavod(String jmenoZavodu) {
        this.jmenoZavodu = jmenoZavodu;
        regCisla = 1;
        zavodniks = new ArrayList<Zavodnik>();
    }

    public static Zavod getZavod(String name){
        return new Zavod(name);
    }

    // pridani do listu zavodniku
    public int registraceZavodnika(String jmeno, String prijmeni){
        zavodniks.add(new Zavodnik(jmeno,prijmeni,regCisla));
        return regCisla++;
    }
    public boolean odregistraceZavodnika(int regCislo){
        ListIterator<Zavodnik> listIterator = zavodniks.listIterator();
        while(listIterator.hasNext()){
            Zavodnik zavodnik = listIterator.next();
            if(zavodnik.getId() == regCislo){
                listIterator.remove();
                return true;
            }
        }
        return false;
    }

    public String toString(MetodaRazeniZavodniku metodaRazeni){
        zavodniks.sort(metodaRazeni.getKomparator());
        StringBuilder stringBuilder = new StringBuilder();
        for (Zavodnik zav:zavodniks) {
            stringBuilder.append(String.format("%s %s id: %d cas: %s\n",zav.getJmeno(),zav.getPrijmeni(),zav.getId(),zav.getDobaNaTratiSTR()));
        }
        return stringBuilder.toString();
    }
    public void zaznamenejStart(int id, LocalTime cas){
        Optional<Zavodnik> zavOptional = zavodniks.stream().filter(i->i.getId()==id).findFirst();
        if(zavOptional.isPresent()){
            Zavodnik zav = zavOptional.get();
            zav.setStart(cas);
        }
    }
    public void zaznamenejCil(int id, LocalTime cas){
        Optional<Zavodnik> zavOptional = zavodniks.stream().filter(i->i.getId()==id).findFirst();
        if(zavOptional.isPresent()){
            Zavodnik zav = zavOptional.get();
            zav.setCil(cas);
        }
    }
    // static loadFromFile
    // zavodnici toString
    // zaznamenejStart(int rc, LocalTime start)
    // zaznamenejCil(int rc, LocalTime cil)

}
