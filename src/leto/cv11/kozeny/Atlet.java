package cv11.kozeny;

public class Atlet {
    private int id;
    private String jmeno;
    private String prijmeni;
    public static Atlet getInstance(int id, String jmeno, String prijmeni){
        //TODO: nějaká kontrola
        return new Atlet(id, jmeno, prijmeni);
    }
    public static Atlet getInstance(String radek){
        String[] a = radek.split(" ",3);
        //TODO: nějaká kontrola
        return new Atlet(Integer.parseInt(a[0]), a[1], a[2]);
    }

    private Atlet(int id, String jmeno, String prijmeni) {
        this.id = id;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
    }

    public int getId() {
        return id;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }
    public String toString(){
        return id + " " + jmeno + " " + prijmeni;
    }
}
