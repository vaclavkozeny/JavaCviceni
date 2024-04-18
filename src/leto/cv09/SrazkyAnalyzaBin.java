package src.leto.cv09;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SrazkyAnalyzaBin {
    public static void main(String[] args) throws IOException {
        // nacteni souboru
        // nacteni pomoci DataInputStream
        byte den, mesic;
        short rok;
        float srazky;
        boolean eof = false;
        while(!eof){
            try (DataInputStream dataInputStream = new DataInputStream(Files.newInputStream(Path.of("src/leto/cv09/srazky.bin")))) {
                {
                    den = dataInputStream.readByte();
                    mesic = dataInputStream.readByte();
                    rok = dataInputStream.readShort();
                    srazky = dataInputStream.readFloat();
                }
                System.out.println("Den: " + den + ", Mesic: " + mesic + ", Rok: " + rok + ", Srazky: " + srazky);
            }
            catch (EOFException e){
                eof = true;
            }
        }
    }
}
