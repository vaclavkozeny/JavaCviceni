package src.leto.cv01.automat;

import java.util.ArrayList;
import java.util.Scanner;

public class TestParkovaciAutomat {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ParkovaciAutomat parkovaciAutomat = new ParkovaciAutomat(0.5);
        ArrayList<ParkovaciAutomat.mince> platba = new ArrayList<ParkovaciAutomat.mince>();
        platba.add(ParkovaciAutomat.mince.DVACETIKORUNA);
        platba.add(ParkovaciAutomat.mince.DESETIKORUNA);
        System.out.println(parkovaciAutomat.Pay(platba));
    }
}
