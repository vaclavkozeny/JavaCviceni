package src.leto.cv04.app;


import src.leto.cv04.date.Kalendar;

public class KalendarTest {
    public static void main(String[] args) {
        Kalendar kalendar = Kalendar.getKalendar(29,2,2024);
        kalendar.dalsiDen();
        System.out.println(kalendar.getKalendarovaTabulka());
//        kalendar.dalsiMesic();
//        System.out.println(kalendar.getKalendarovaTabulka());
//        kalendar.uberDen();
//        System.out.println(kalendar.getKalendarovaTabulka());
//        kalendar.dalsiDen();
//        System.out.println(kalendar.getKalendarovaTabulka());
//        kalendar.dalsiMesic();
//        System.out.println(kalendar.getKalendarovaTabulka());
//        kalendar.dalsiRok();
//        System.out.println(kalendar.getKalendarovaTabulka());
    }
}
