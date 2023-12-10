package src.cv12;

import java.text.DecimalFormat;
import java.util.Scanner;

public class StringTest {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String text = "abcaba";
        System.out.println(StringTools.jePalindrom(text));
        System.out.println(text);
        System.out.println(StringTools.sifruj("ahoj","QER"));
        String chars = StringTools.desifruj(StringTools.sifruj("ahoj","BAB"),"BAB");
        System.out.println(chars);

        long cislo = 5244578;
        System.out.println(StringTools.prevodZDesitkove(cislo, (byte)16));
        System.out.println(StringTools.prevodZDesitkove(cislo, (byte)8));
        System.out.println(StringTools.prevodZDesitkove(cislo, (byte)2));
        System.out.println(StringTools.prevodDoDesitkove("AABBCC", (byte)16));
        System.out.println(StringTools.prevodDoDesitkove("52535714", (byte)8));
        System.out.println(StringTools.prevodDoDesitkove("101010101011101111001100", (byte)2));
        System.out.format("%,d",StringTools.prevodDoDesitkove("AAAABBBB",(byte)16));
    }
}
