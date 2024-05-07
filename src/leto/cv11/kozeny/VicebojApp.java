package cv11.kozeny;

import java.io.IOException;
import java.util.Scanner;

public class VicebojApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static AtletickyViceboj viceboj;
    public static void main(String[] args) throws IOException {
        System.out.println("Zadej soubor");
        //String soubor = scanner.nextLine();
        String soubor = "C:\\Users\\kozen\\IdeaProjects\\reseni-vaclavkozeny\\data\\vb.txt";
        viceboj = AtletickyViceboj.getInstance(soubor);
        System.out.println("Vitej na viceboji");
        boolean konec = false;
        while(!konec){
            VypisMenu();
            int volba = scanner.nextInt();
            if(volba == 0){
                konec = true;
            }else{
                ObsluzVolbu(volba);
            }
        }

    }

    private static void VypisMenu(){
        System.out.println("1. Vypis disciplin");
        System.out.println("2. Vypis atletu");
        System.out.println("3. Zaznamenai bodu atleta");
        System.out.println("4. Oprava vysledku atleta");
        System.out.println("5. Odstoupeni atleta");
        System.out.println("6. Vypis aktualnich vysledku");
        System.out.println("7. Vypis serazene listiny");

    }
    private static void ObsluzVolbu(int volba) throws IOException {
        switch (volba){
            case 1:
                vypisDisciplin();
                break;
            case 2:
                vypisAtlety();
                break;
            case 3:
                zaznamenejBod();
                break;
            case 4:
                opravVysledek();
                break;
            case 5:
                odstoupeniAtleta();
                break;
            case 6:
                vypisVysledky();
                break;
            case 7:
                vypisSerazeneListiny();
                break;
            default:
                System.out.println("Neplatna volba");
        }
    }

    private static void vypisSerazeneListiny() throws IOException {
        System.out.println(viceboj.vypisSerazeneListiny());
    }

    private static void vypisVysledky() throws IOException {
        System.out.println(viceboj.vypisVysledky());
    }

    private static void odstoupeniAtleta() {
        System.out.println("Zadej id atleta");
        int id = scanner.nextInt();
        try {
            viceboj.odstoupeniAtleta(id);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    private static void zaznamenejBod() {
        System.out.println("Zadej id atleta");
        int id = scanner.nextInt();
        System.out.println("Zadej cislo discipliny");
        int disciplina = scanner.nextInt();
        System.out.println("Zadej hodnotu");
        int hodnota = scanner.nextInt();
        try {
            viceboj.zaznamenejBod(id, disciplina, hodnota);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void vypisAtlety() {
        StringBuilder sb = new StringBuilder();
        for (Atlet atlet : viceboj.getAtleti()) {
            sb.append(atlet + "\n");
        }
        System.out.println(sb);
    }

    private static void vypisDisciplin() {
        StringBuilder sb = new StringBuilder();
        for (String disciplina : viceboj.getDiscipliny()) {
            sb.append(disciplina + "\n");
        }
        System.out.println(sb);
    }
    private static void opravVysledek() {
        System.out.println("Zadej id atleta");
        int id = scanner.nextInt();
        System.out.println("Zadej cislo discipliny");
        int disciplina = scanner.nextInt();
        System.out.println("Zadej hodnotu");
        int hodnota = scanner.nextInt();
        try {
            viceboj.opravBod(id, disciplina, hodnota);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
