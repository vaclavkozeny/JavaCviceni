package src.leto.cv03.hra;

import java.awt.*;
import java.util.Random;

public class HadamCislo {
//    int volba;
//    int pokusy = 0;
//    boolean win = false;
//        System.out.println("Hadej\n");
//    hadaneCislo = rand.nextInt(dolniMez, horniMez);
//        while(!win){
//        pokusy++;
//        volba = nactiVolbuHrace();
//        if(volba > hadaneCislo){
////            System.out.println("mene\n");
////        }else if(volba < hadaneCislo){
////            System.out.println("vice\n");
////        }else{
////            win = true;
////        }
//    }
//        System.out.format("Hadane cislo bylo %d, uhodnuti ti trvalo %d pokusu\n", hadaneCislo, pokusy);
//    //konecProgramu = true;
    private final Random random = new Random();
    private int pokusy;
    private int dolniMez;
    private int horniMez;
    private boolean vyhra;
    private int hadaneCislo;

    public HadamCislo(int dolniMez, int horniMez) {
        this.dolniMez = dolniMez;
        this.horniMez = horniMez;
        pokusy = 0;
        vyhra = false;
    }

    public void setDolniMez(int dm){
        if(dm < this.horniMez || dm > 0)
            this.dolniMez = dm;
    }
    public void setHorniMez(int hm){
        if(hm > this.dolniMez)
            this.horniMez = hm;
    }
    public int[] getMeze(){
        return new int[]{this.dolniMez, this.horniMez};
    }
    public boolean getVyhra(){
        return vyhra;
    }
    public void resetHry(){
        pokusy = 0;
        vyhra = false;
        hadaneCislo = random.nextInt(dolniMez,horniMez);
    }
    public String zkontrolujZadaneCislo(int cislo){
        pokusy++;
        if(cislo > hadaneCislo){
            return ("Hadane cislo je mensi");
        }else if(cislo < hadaneCislo){
            return ("Hadane cislo je vetsi");
        }
        vyhra = true;
        return String.format("Hadane cislo bylo %d, uhodnuti ti trvalo %d pokusu", hadaneCislo, pokusy);
    }

}
