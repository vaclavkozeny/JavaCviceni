package src.leto.cv05.zavody;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;

class Zavodnik implements Comparable<Zavodnik>{
    private final int id; //reg cislo
    private final String jmeno;
    private final String prijmeni;
    private LocalDate narozeni;
    private boolean pohlavi; //T muz, F zena
    private String klub;
    private Zavod zavod;
    private LocalTime start;
    private LocalTime cil;
    private int startovniCislo;

    static Comparator<Zavodnik> COMP_DLE_CISEL = (o1, o2) -> o1.getId()-o2.getId();
    //static Comparator<Zavodnik> COMP_DLE_PRIJMENI = ((o1,o2) -> o1.getJmeno();

    public Zavodnik(String jmeno, String prijmeni, int rc) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.id = rc;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public int getId() {
        return id;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public String getStart() {
        if(start == null)
            return "---";
        else
            return start.getHour()+":"+start.getMinute()+":"+start.getSecond();
    }

    @Override
    public int compareTo(@NotNull Zavodnik o) {
        return this.id - o.id;
    }
    // nejaky gettery
    //zaznamenej cil / start (LocalTime cas)
}
