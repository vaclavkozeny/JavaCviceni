/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.leto.cv09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 *
 * @author Kralovcova-J-e8f2
 */
public class CteniZapisTextSouboru {

    private static final Scanner sc = new Scanner(System.in, "CP1250");
    private static final String EOLN = System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {
        String vst;
        String cesta = "a.txt";
        // nacitani informaci od uzovatele
        // zapis dat do textoveho souboru
        // korektni uzavreni
        System.out.println("");
        System.out.println("Zadavej text pro ulozeni o souboru: ");
        BufferedWriter fr = null;
        try {
            fr = new BufferedWriter(new FileWriter(cesta, true));
            while ((vst = sc.nextLine()).length() > 0) {
                fr.write(vst);
                fr.write(EOLN);
            }
        } finally {
            if (fr != null) {
                fr.close();
            }
        }
        // znova totez
        // pouziti try-with-resources konstrukce
        // instance BufferedWriter ziskana pomoci metody Files.newBufferedWriter
        System.out.println("");
        System.out.println("Zadavej text pro ulozeni o souboru: ");
        cesta = "b.txt";
        try ( BufferedWriter br = Files.newBufferedWriter(Path.of(cesta),
                StandardOpenOption.APPEND)) {
            while ((vst = sc.nextLine()).length() > 0) {
                br.write(vst);
                br.write(EOLN);
            }

        } catch(NoSuchFileException nsfe) {
            System.out.println("Soubor neexistuje zapis");
        }
        // cteni textoveho souboru
        // nacteni druheho vytvoreneho souboru
        // instance BufferedWriter ziskana pomoci metody Files.newBufferedReader
        System.out.println("");
        System.out.println("Do souboru bylo zapsano: ");
        try ( BufferedReader br = Files.newBufferedReader(Path.of("b.txt"))) {
            while ((vst = br.readLine()) != null) {
                System.out.println(vst);
            }
        } catch(NoSuchFileException nsfe) {
            System.out.println("Soubor neexistuje cteni");
        }

    }
}
