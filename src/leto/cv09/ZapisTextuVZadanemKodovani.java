package src.leto.cv09;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Scanner;

public class ZapisTextuVZadanemKodovani {
    private static final Scanner sc = new Scanner(System.in);
    private static final String EOLN = System.getProperty("line.separator");
    private static final String text = "Ahoj, jak se mas aaa?";
    private static String specialText;

    public static void main(String[] args) throws IOException {
        System.out.println("Zadej cestu k vystupnimu souboru");
        String vystup = sc.nextLine();
        // System.out.println("Zadej kodovani");
        // String kodovani = sc.nextLine();
        specialText = "%%%####$$$$$";
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("src/leto/cv09/US_ASCII.txt"),
                StandardCharsets.US_ASCII, StandardOpenOption.APPEND)) {
            bw.write(text);
            bw.write(EOLN);
        }
        specialText = "ËËËËËËËËËËË";
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("src/leto/cv09/ISO_8859_1.txt"),
                StandardCharsets.ISO_8859_1, StandardOpenOption.APPEND)) {
            bw.write(text);
            bw.write(EOLN);
            bw.write(specialText);
            bw.write(EOLN);
        }
        specialText = "¼¹®©";
        try (BufferedWriter bw = Files.newBufferedWriter(Path.of("src/leto/cv09/UTF_16.txt"), StandardCharsets.UTF_16,
                StandardOpenOption.APPEND)) {
            bw.write(text);
            bw.write(EOLN);
            bw.write(specialText);
            bw.write(EOLN);
        }

    }
}
