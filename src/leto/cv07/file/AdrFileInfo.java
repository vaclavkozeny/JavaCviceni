package src.leto.cv07.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class AdrFileInfo {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
//        System.out.println("Path separator " + File.pathSeparator);
//        String aaStr = ".";
//        String aaStr2 = "././src";
//        Path path = Path.of(aaStr2);
//        System.out.println("Aktualni adresar: " + path.getName(0));
//        System.out.println("Nadrazeny adresar: " + path.getParent());
//        System.out.println("Absolutni cesta: " + path.toAbsolutePath());
//        System.out.println("Absolutni cesta: " + path.normalize());
//
//        System.out.println("Existuje na disku? " + Files.exists(path));
//        System.out.println("Je to adresar? " + Files.isDirectory(path));
//        System.out.println("Je to soubor? " + Files.isRegularFile(path));

        // vytvoreni adresare na disku
        System.out.println("Vytvoreni souboru");
        String aStr = "aaa";
        Path path1 = Path.of(aStr);
        System.out.println("Aktualni jmeno: "+ path1.getName(0));
        System.out.println("Existuje na disku? " + Files.exists(path1));
        System.out.println("Je to adresar? " + Files.isDirectory(path1));
        System.out.println("Je to soubor? " + Files.isRegularFile(path1));
        try {
            Files.createDirectory(path1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Existuje na disku? " + Files.exists(path1));
        System.out.println("Je to adresar? " + Files.isDirectory(path1));
        System.out.println("Je to soubor? " + Files.isRegularFile(path1));

        // vytvoreni souboru
        String fStr = "/aaa/x.txt";
        Path path = Path.of(fStr);
        System.out.println("Existuje na disku? " + Files.exists(path));
        System.out.println("Je to adresar? " + Files.isDirectory(path));
        System.out.println("Je to soubor? " + Files.isRegularFile(path));
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Existuje na disku? " + Files.exists(path));
        System.out.println("Je to adresar? " + Files.isDirectory(path));
        System.out.println("Je to soubor? " + Files.isRegularFile(path));
        


    }
}
