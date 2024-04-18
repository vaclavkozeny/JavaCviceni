package src.leto.cv09;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class SrazkyZaznamBin {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //System.out.println("Zadej cestu k souboru");
        //String cesta = sc.nextLine();
        System.out.println("Zadej: den, mesic, rok, srazky");
        byte den = sc.nextByte();
        byte mesic = sc.nextByte();
        short rok = sc.nextShort();
        float srazky = sc.nextFloat();
        // zapis do binarniho souboru
        // zapis pomoci DataOutputStream
        try(DataOutputStream dataOutputStream = new DataOutputStream(Files.newOutputStream(Path.of("src/leto/cv09/srazky.bin")))) {
            dataOutputStream.write(den);
            dataOutputStream.write(mesic);
            dataOutputStream.writeShort(rok);
            dataOutputStream.writeFloat(srazky);
        }
    }
}
