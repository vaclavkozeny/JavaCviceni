/*
 * Copyright (C) 2024 Jirina Kralovcova
 * This program is part of Java programing education. 
 * You can use it as you need to learn Java. 
 */
package src.leto.cv08.apps;

import src.leto.cv08.cmd.CmdInterface;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jirina
 */
public class CmdZakladniTest {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hra pexeso");
        String autor = null;

        System.out.println("Testovani ruznych implementaci tridy pro prikazovy radek");
        System.out.print("Zadej prijmeni autora implementace nebo ENTER pro ukonceni: ");
        while ((autor = sc.nextLine()).trim().length() > 0) {
            CmdInterface cmd;
            boolean konec = false;
            try {
                cmd = CmdInterface.getInstance(autor);
                System.out.println("\nOk");
                do {
                    System.out.print(cmd.getPrompt());
                    String prikaz = sc.nextLine();
                    String[] casti = prikaz.split(" +");
                    try {
                        switch (casti[0]) {
                            case "" -> {
                            }
                            case "cd" -> cmd.cd(casti[1]);
                            case "dir" -> {
                                if (casti.length == 1) {
                                    System.out.println(cmd.dir());
                                } else {
                                    System.out.println(cmd.dir(casti[1]));
                                }
                            }
                            case "exit" -> konec = true;
                            default -> System.out.println("Neznamy prikaz " + casti[0]);
                        }
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Chybne zadany prikaz, zkus to znovu");
                    }
                } while (!konec);
            } catch (Exception ex) {
                Logger.getLogger(CmdZakladniTest.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Pri pokusu pouziti zadane implementace nastala chyba");
                System.out.println("Lze pokracovat s novou instanci prikazove radky");
            }
            System.out.println("\n");
            System.out.print("Zadej prijmeni autora implementace nebo ENTER pro ukonceni: ");
        
        }
        System.out.println("");
        System.out.println("Testovani ukonceno");

    }
}
