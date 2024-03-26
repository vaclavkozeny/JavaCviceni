package src.leto.cv05.zavody;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public enum MetodaRazeniZavodniku {
    DLE_CISEL(),
    DLE_JMEN(),
    DLE_DOBY_ZAVODU(),
    DLE_CASU_STARTU(),
    DLE_CASU_CILE();

    public Comparator<Zavodnik> getKomparator() {
        return komps[this.ordinal()];
    }
    private static Collator colCZ = Collator.getInstance(new Locale("cs","cz"));

    private static Comparator<Zavodnik> COMP_DLE_CISEL = (o1, o2) -> o1.getId()-o2.getId();
    //static Comparator<Zavodnik> COMP_DLE_PRIJMENI = (o1,o2) -> o1.getPrijmeni().compareTo(o2.getPrijmeni());

    private static Comparator<Zavodnik> COMP_DLE_JMEN = (Zavodnik o1, Zavodnik o2) -> {
        //int vysl = o1.prijmeni.compareTo(o2.prijmeni);
        int vysl = colCZ.compare(o1.getPrijmeni(),o2.getPrijmeni());
        if(vysl == 0){
            //return o1.jmeno.compareTo(o2.jmeno);
            return colCZ.compare(o1.getJmeno(),o2.getJmeno());
        }
        return vysl;
    };
    private static Comparator<Zavodnik> COMP_DLE_DOBY_NA_TRATI = (Zavodnik o1, Zavodnik o2) -> {
        int vysl = o1.getStavZavodnika().ordinal() - o2.getStavZavodnika().ordinal();
        if(vysl == 0 && o1.getStavZavodnika().equals(o2.getStavZavodnika())){
            return vysl;
        }
        return o1.getDobaNaTrati().compareTo(o2.getDobaNaTrati());
    };
    private static Comparator<Zavodnik> COMP_DLE_CASU_STARTU
            = (Zavodnik o1, Zavodnik o2) -> {
        // jak lepe?
        return o1.getCasStartu().compareTo(o2.getCasStartu());
    };
    private static Comparator<Zavodnik> COMP_DLE_CASU_CILE
            = (Zavodnik o1, Zavodnik o2) -> {
        // jak lepe?
        return o1.getCasCile().compareTo(o2.getCasCile());
    };
    private final static Comparator[] komps
            = {COMP_DLE_CISEL,
            COMP_DLE_JMEN,
            COMP_DLE_DOBY_NA_TRATI,
            COMP_DLE_CASU_STARTU,
            COMP_DLE_CASU_CILE};
}
