package src.leto.cv04.date;

import java.util.Scanner;

public class VytvoreniDalsihoTextovehoRetezce {
    private static final Scanner scanner = new Scanner(System.in);

    //System independet line separator
    private static String EOLN = System.getProperty("line.separator");
    public static void main(String[] args) {
        String dalsiText;
        StringBuilder stringBuilder = new StringBuilder();
        while(!(dalsiText = scanner.nextLine()).isEmpty()){
            stringBuilder.append(dalsiText);
            stringBuilder.append(EOLN);
        }
        System.out.println("konec zadavani");
        System.out.println("bylo zadano");
        System.out.println(stringBuilder);
        System.out.println("konec programu");
    }
}
