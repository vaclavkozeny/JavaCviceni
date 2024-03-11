package src.leto.cv03.hra;

import java.util.Random;

public class MyslimSiCislo {
//    System.out.println("Mysli si cislo");
//    int MAX = horniMez, MIN = dolniMez, volba, cislo = 0;
//    boolean win = false;
//        while(!win){
//        cislo = getNumber(MIN,MAX);
//        System.out.format("Myslim si %d\n", cislo);
//        vypisMenuHadani();
//        volba = nactiVolbuMenu();
//        switch (volba){
//            case 1:
//                MAX = cislo;
//                break;
//            case 2:
//                MIN = cislo;
//                break;
//            case 3:
//                win = true;
//        }
//    }
//        System.out.format("Hadane cislo bylo %d\n", cislo);

    private final Random random = new Random();
    private int max;
    private int min;
    private int horniMez;
    private int dolniMez;
    private boolean vyhra;
    private int pokusy;
    private int mysleneCislo;

    public MyslimSiCislo(int dolniMez, int horniMez) {
        this.horniMez = horniMez;
        this.dolniMez = dolniMez;
        min = dolniMez;
        max = horniMez;
    }

//    public void setDolniMez(int dm){
//        if(dm < this.horniMez || dm > 0)
//            this.dolniMez = dm;
//    }
//    public void setHorniMez(int hm){
//        if(hm > this.dolniMez)
//            this.horniMez = hm;
//    }
//    public int[] getMeze(){
//        return new int[]{this.dolniMez, this.horniMez};
//    }
    public boolean getVyhra(){
        return vyhra;
    }
    public void resetHry(){
        pokusy = 0;
        vyhra = false;
    }
    public int getMysleneCislo(){
        return mysleneCislo;
    }
    public void zkontolujCislo(int volba){
        pokusy++;
        switch(volba){
            case 1:
                max = mysleneCislo;
                break;
            case 2:
                min = mysleneCislo;
                break;
            case 3:
                vyhra = true;
        }
    }
    public String konecHryVypis(){
        return String.format("Hadani mi trvalo %d pokusu\n",pokusy);
    }
    public void generujCislo(){
        mysleneCislo = random.nextInt(min,max);
    }
    public void generujCisloNezabavnaVerze(){
        mysleneCislo = (int) Math.floor((min+max)/2);
    }
}
