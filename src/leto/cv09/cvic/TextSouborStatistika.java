package src.leto.cv09.cvic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class TextSouborStatistika {
    /*
    Vytvořte třídu TextSouborStatistika, která načte zadaný textový soubor a zjistí kolik je v něm
    znaků, z toho písmen a číslic, kolik obsahuje řádků, z toho kolik je neprázdných (obsahují nějaký text
    kromě mezer a tabulátorů).
     */
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        System.out.println("Zadejte cestu k souboru: ");
        String cesta = scanner.nextLine();
        Path file = Path.of(cesta);
        int znaky = 0;
        int pismena = 0;
        int cisla = 0;
        int radky = 0;
        int neprazdneRadky = 0;
        try(BufferedReader br = Files.newBufferedReader(file)){
            String line;
            while((line = br.readLine()) != null){
                znaky += line.length();
                radky++;
                if(!line.isBlank()){
                    neprazdneRadky++;
                }
                for(int i = 0; i < line.length(); i++){
                    char c = line.charAt(i);
                    if(Character.isLetter(c)){
                        pismena++;
                    }
                    if(Character.isDigit(c)){
                        cisla++;
                    }
                }
            }
            System.out.format("Znaky: %d\nPismena: %d\nCisla: %d\nRadky: %d\nNeprazdne radky: %d\n", znaky, pismena, cisla, radky, neprazdneRadky);
        }
//        System.out.println(file.getFileName());
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of(file.getParent() + "/" + file.getFileName() + ".stats.txt"))){
            bufferedWriter.write("Znaky: " + znaky + "\n");
            bufferedWriter.write("Pismena: " + pismena + "\n");
            bufferedWriter.write("Cisla: " + cisla + "\n");
            bufferedWriter.write("Radky: " + radky + "\n");
            bufferedWriter.write("Neprazdne radky: " + neprazdneRadky + "\n");
        }

    }
}
