package src.leto.cv01;

// Zapište program pro výpočet těžiště hmotných bodů. Každý bod má kromě souřadnic i hmotnost, která v daném bodě působí.

public class HmotneBodyProgram {
    public static void main(String[] args) {
        HmotnyBod a = new HmotnyBod(1,1,10);
        System.out.println(a.getWeight());
    }
}
