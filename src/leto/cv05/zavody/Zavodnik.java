package src.leto.cv05.zavody;

import org.jetbrains.annotations.NotNull;

import java.text.Collator;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.Locale;
import static java.time.temporal.ChronoUnit.SECONDS;

class Zavodnik implements Comparable<Zavodnik>{
    private final int id; //reg cislo
    private final String jmeno;
    private final String prijmeni;
    private LocalDate narozeni;
    private boolean pohlavi; //T muz, F zena
    private String klub;
    private Zavod zavod;
    private LocalTime casStartu;
    private LocalTime casCile;
    private LocalTime dobaNaTrati;
    private StavZavodnika stavZavodnika;
    private int startovniCislo;
    public Zavodnik(String jmeno, String prijmeni, int rc) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.id = rc;
        this.stavZavodnika = StavZavodnika.REGISTROVAN;
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
    public String getStart() {
        if(casStartu == null)
            return "---";
        else
            return casStartu.getHour()+":"+casStartu.getMinute()+":"+casStartu.getSecond();
    }

    public LocalTime getDobaNaTrati() {
        return dobaNaTrati;
    }
    public String getDobaNaTratiSTR(){
        return dobaNaTrati.getHour() +"h: "+dobaNaTrati.getMinute()+"m: "+dobaNaTrati.getSecond()+"s";
    }

    public LocalTime getCasCile() {
        return casCile;
    }

    public LocalTime getCasStartu() {
        return casStartu;
    }

    public void setStart(LocalTime casStartu) {
        assert stavZavodnika == StavZavodnika.REGISTROVAN;
        this.casStartu = casStartu;
        stavZavodnika = StavZavodnika.ODSTARTOVAL;
    }
    public void setCil(LocalTime casCile) {
        assert stavZavodnika == StavZavodnika.ODSTARTOVAL;
        this.casCile = casCile;
        stavZavodnika = StavZavodnika.DORAZIL_DO_CILE;
        Duration duration = Duration.between(casStartu,casCile);
        dobaNaTrati = LocalTime.of((int)duration.toHours(),(int)duration.toMinutes()%60,(int)duration.toSeconds()%60);
    }


    public StavZavodnika getStavZavodnika() {
        return stavZavodnika;
    }


    @Override
    public int compareTo(@NotNull Zavodnik o) {
        return this.id - o.id;
    }
    // nejaky gettery
    //zaznamenej cil / start (LocalTime cas)
}
