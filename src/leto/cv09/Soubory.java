package src.leto.cv09;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Soubory {
    private static final Scanner sc = new Scanner(System.in);
    private static final String EOLN = System.getProperty("line.separator");
    public static void main(String[] args) {
        String string;
        BufferedWriter fw;
        String cesta = "src/leto/cv09/a.txt";
        try {
            fw = new BufferedWriter(new FileWriter(cesta, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (!(string = sc.nextLine()).isEmpty()) {
            try {
                fw.write(string);
                fw.write(EOLN);
                fw.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
