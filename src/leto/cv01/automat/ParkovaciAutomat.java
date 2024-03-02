package src.leto.cv01.automat;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ParkovaciAutomat {

    LocalDateTime odjezd;
    // minutová taxa
    private double taxa;

    public ParkovaciAutomat(double taxa) {
        this.taxa = taxa;
    }
    public String Pay(ArrayList<mince> m){
        odjezd = LocalDateTime.now();
        int platba = 0;
        int posun;
        for (mince p:m) {
            platba += p.getValue();
        }
        posun = (int) Math.floor(platba/taxa);
        odjezd = odjezd.plusMinutes(posun);
        return String.format("Zaplaceno do %d:%d",odjezd.getHour(), odjezd.getMinute());
    }
    public enum mince{
        KORUNA(1),
        DVOUKORUNA(2),
        PETIKORUNA(5),
        DESETIKORUNA(10),
        DVACETIKORUNA(20),
        PADESATIKORUNA(50)
        ;
        final int value;
        mince(int hodnota){
            this.value = hodnota;
        }

        int getValue() {
            return value;
        }
    }

}
