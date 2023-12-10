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
        System.out.println(StringTools.prevodZDesitkove(16 ,8));
        System.out.format("%,d",StringTools.prevodDoDesitkove("AAAABBBB"));
    }
}
