package src.leto.kozeny.src;

public class ZboziVObjednavce extends Zbozi{
    int pobockaId;
    public ZboziVObjednavce(int id, String nazev, int cena, int pocet_na_sklade, int pobockaId) {
        super(id, nazev, cena, pocet_na_sklade);
        this.pobockaId = pobockaId;
    }
}
