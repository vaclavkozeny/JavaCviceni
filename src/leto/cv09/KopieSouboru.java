package src.leto.cv09;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class KopieSouboru {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.println("Zadejte cestu k souboru, který chcete zkopírovat:");
        String cesta = sc.nextLine();
        //Path source = Path.of(cesta);
        System.out.println("Zadejte cestu, kam chcete soubor zkopírovat:");
        String cilovaCesta = sc.nextLine();
        //Path target = Path.of(cilovaCesta);
        try(BufferedInputStream fis = new BufferedInputStream(new FileInputStream(cesta)); BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(cilovaCesta))){
            int b;
            while((b = fis.read()) != -1){
                fos.write(b);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
