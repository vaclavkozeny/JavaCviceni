/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.leto.cv09;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class KopieSouboru {
        private static final Scanner sc = new Scanner(System.in, "CP1250");

    public static void main(String[] args) throws IOException {
        System.out.println("Zadej cestu k vstupnimu souboru");
        String vstup = sc.nextLine();
        System.out.println("Zadej cestu k vystupu");
        String vystup = sc.nextLine();
        
        // 1.verze
//        try(BufferedInputStream fis = new BufferedInputStream(new FileInputStream(vstup));
//           BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(vystup))) {
//            byte[] b = new byte[10];
//            int n=0;
//            while((n = fis.read(b)) != -1) {
//                fos.write(b, 0, n);
//            }
//        }
        
        // 2. verze - trochu jina
        // nepouzite bufferevane proudy
        // cely soubor nacten a ulozen najednou
        try(FileInputStream fis = new FileInputStream(vstup);
           FileOutputStream fos = new FileOutputStream(vystup)) {
            byte[] b = fis.readAllBytes();
            fos.write(b);
        }
        
        
        // 3. verze - lze to i takto
        byte[] data = Files.readAllBytes(Path.of(vstup));
        Files.write(Path.of(vystup), data, StandardOpenOption.APPEND);
        
    }
    
}
