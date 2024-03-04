package src.leto.cv01.automat;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ParkovaciAutomat {

    LocalDateTime odjezd;
    // minutová taxa
    private final double taxa;
    //private int aktualniStavVAutomatu;
    private ArrayList<mince> platba;

    /**
     * Konstuktor, vytvori novy parkovaci automat s minutovou taxou
     * @param taxa minutova taxa
     */
    public ParkovaciAutomat(double taxa) {
        this.taxa = taxa;
        //aktualniStavVAutomatu = 0;
        platba = new ArrayList<mince>();
    }

    /**
     * ziska aktualni stav penez v automatu
     * - popuziti pro vypis pri zadavani penez a pri stornu (vraceni penez)
     * - projde pole micni a spocte jejich hodnotu
     * - vim, ze by to slo udelat pouze pomoci int hodnot, ale chtel jsem si vyzkouset enum v jave
     * @return stav penez v automatu
     */
    public int getAktualniStavVAutomatu() {
        int penize = 0;
        for (mince p:platba) {
            penize += p.getValue();
        }
        //return aktualniStavVAutomatu;
        return penize;
    }

    /**
     * tato metoda zpostredkuje platbu
     * @return String s cesem do ktereho mame zaplacene parkovani
     */
    public String Pay(){
        odjezd = LocalDateTime.now();
        int penize = 0;
        int posun;
        for (mince p:platba) {
            penize += p.getValue();
        }
        posun = (int) Math.floor(penize/taxa);
        odjezd = odjezd.plusMinutes(posun);
        return String.format("Zaplaceno do %d:%d",odjezd.getHour(), odjezd.getMinute());
    }

    /**
     * metoda pro vlozeni minci (z enumu) do pole platba
     * @param volba zvolena volba v obsluzne metode (po vypisu menu)
     */
    public void VhodMinci(int volba){
            switch (volba){
                case 1: platba.add(mince.KORUNA);/*aktualniStavVAutomatu+=1*/;break;
                case 2: platba.add(mince.DVOUKORUNA);/*aktualniStavVAutomatu +=2*/;break;
                case 3: platba.add(mince.PETIKORUNA);/*aktualniStavVAutomatu +=5*/;break;
                case 4: platba.add(mince.DESETIKORUNA);/*aktualniStavVAutomatu +=10*/;break;
                case 5: platba.add(mince.DVACETIKORUNA);/*aktualniStavVAutomatu +=20*/;break;
                case 6: platba.add(mince.PADESATIKORUNA);/*aktualniStavVAutomatu +=50*/;break;
                case 0: break;
                default:
                    throw new IllegalArgumentException("Neznama volba");
            }
    }

    /**
     * podporovane mince a jejich hodnota
     */
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
