package src.leto.cv09;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Soubory {
    private static final Scanner sc = new Scanner(System.in);
    private static final String EOLN = System.getProperty("line.separator");
    public static void main(String[] args) {
        String string;
        BufferedWriter fw;
        String cesta = "src/leto/cv09/a.txt";
//        try {
//            fw = new BufferedWriter(new FileWriter(cesta, true));
//            while (!(string = sc.nextLine()).isEmpty()) {
//                fw.write(string);
//                fw.write(EOLN);
//                fw.flush();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            if(fw != null)
//                fw.close();
//        }

        try(BufferedWriter br = new BufferedWriter(new FileWriter("src/leto/cv09/b.txt", true))){
            while (!(string = sc.nextLine()).isEmpty()) {
                br.write(string);
                br.write(EOLN);
            }
            br.write("ššššššššš");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        try(BufferedWriter br = Files.newBufferedWriter(Path.of("src/leto/cv09/c.txt"), StandardOpenOption.APPEND)){
//            while (!(string = sc.nextLine()).isEmpty()) {
//                br.write(string);
//                br.write(EOLN);
//            }
//            br.write("ššššššššš");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        // kopie souboru
        try {
            Files.copy(Path.of("src/leto/cv09/a.txt"), Path.of("src/leto/cv09/d.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
