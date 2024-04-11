/*
 * Copyright (C) 2024 Jirina Kralovcova
 * This program is part of Java programing education. 
 * You can use it as you need to learn Java. 
 */
package hry.pexeso;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Jirina
 */
public class PexesoTools {

    private static final Random rnd = new Random();

    private PexesoTools() {
    }

    /**
     * Vytvori pole celych cisel pro rozlozeni karet pexesa.
     *
     * <p>
     * Je treba zadat pocet dvojic karet v parametru {@code pocetDvojic}. Metoda
     * pak vytvori pole celych cisel delky 2*{@code pocetDvojic}, ktere bude
     * obsahovat kazde z cisel od 1 do {@code pocetDvojic} prave dvakrat.
     *
     * @param pocetDvojic pozadovany pocet dvojic ve vyslednem poli.
     * @return vytvorene pole celych cisel.
     */
    public static int[] getPolePexeso(int pocetDvojic) {
        if (pocetDvojic < 1) {
            throw new IllegalArgumentException("Zadany pocet musi byt kladny. Bylo zadano " + pocetDvojic);
        }
        int[] pole = new int[2 * pocetDvojic];
        for (int i = 0; i < pole.length; i++) {
            pole[i] = i / 2 + 1;
        }
        for (int i = 0; i < pole.length; i++) {
            int np = rnd.nextInt(pole.length);
            int pom = pole[i];
            pole[i] = pole[np];
            pole[np] = pom;
        }
        return pole;
    }

    /**
     * Metoda pro test, zda pole pro pexeso bylo spravne vytvoreno.
     *
     * @param pole pole celych cisel.
     * @return
     */
    public static boolean jePolePexeso(int[] pole) {
        int pd = (pole.length) / 2;
        int[] vyskyty = new int[pd + 1];
        for (int i = 0; i < pole.length; i++) {
            if (pole[i] >= 1 && pole[i] <= pd) {
                vyskyty[pole[i]]++;
            }
        }
        for (int cislo = 1; cislo <= pd; cislo++) {
            if (vyskyty[cislo] != 2) {
                return false;
            }
        }
        return true;
    }

    /**
     * Vytvori matici pro rozlozeni karet pexesa. Velikoat je urcena poctem
     * radku a poctem sloupcu.
     *
     * @param pr pocet radku.
     * @param ps pocet sloupcu.
     * @return dvourozmerne pole hodnot typu {@code int} s matici pro pexeso..
     */
    public static int[][] getMaticePexeso1(int pr, int ps) {
        int pd = (pr * ps) / 2;
        int[][] a = new int[pr][ps];
        for (int cislo = 1; cislo <= pd; cislo++) {
            for (int i = 0; i < 2; i++) {
                int r = rnd.nextInt(pr);
                int s = rnd.nextInt(ps);
                while (a[r][s] > 0) {
                    s++;
                    if (s >= ps) {
                        r++;
                        s = 0;
                    }
                    if (r >= pr) {
                        r = 0;
                        s = 0;
                    }
                }
                a[r][s] = cislo;
            }
        }
        return a;
    }

    /**
     * Vytvori matici pro rozlozeni karet pexesa. Velikoat je urcena poctem
     * radku a poctem sloupcu. Jiny algoritmus.
     *
     * @param pr pocet radku.
     * @param ps pocet sloupcu.
     * @return dvourozmerne pole hodnot typu {@code int} s matici pro pexeso..
     */
    public static int[][] getMaticePexeso2(int pr, int ps) {
        int pd = (pr * ps) / 2;
        int[][] a = new int[pr][ps];
        // init matice
        for (int i = 0; i < pr; i++) {
            for (int j = 0; j < ps; j++) {
                int poradi = i * ps + j;
                int cislo = poradi / 2 + 1;
                if (cislo <= pd) {
                    a[i][j] = cislo;
                }
            }
        }
        // rozhazeni matice
        for (int i = 0; i < pr; i++) {
            for (int j = 0; j < ps; j++) {
                int r = rnd.nextInt(pr);
                int s = rnd.nextInt(ps);
                int pom = a[i][j];
                a[i][j] = a[r][s];
                a[r][s] = pom;
            }
        }
        return a;
    }

    /**
     * Testuje zda matice obsahuje rozlozeni karet pro pexeso.
     *
     * @param a dvourozmerne pole celych cisel typu {@code int}
     * @return {@code true} pokud ma matice v parametru spravny tvar, jina vraci
     * {@code false}
     */
    public static boolean jeMaticePexeso(int[][] a) {
        int pd = (a.length * a[0].length) / 2;
        int[] vyskyty = new int[pd + 1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] >= 1 && a[i][j] <= pd) {
                    vyskyty[a[i][j]]++;
                }
            }
        }
        for (int cislo = 1; cislo <= pd; cislo++) {
            if (vyskyty[cislo] != 2) {
                return false;
            }
        }
        return true;
    }

    /**
     * Pro zadanou matici urci stredni vzdalenost dvojic cisel v matici pro pexeso.
     * @param a dvouroamerne pole typu {@code int}
     * @return prumernou vzdalenost dvojic cisel v zadane matici.
     */
    public static float rozhazenost(int[][] a) {
        int pd = (a.length * a[0].length) / 2;
        int[][] poziceCisel = new int[pd + 1][4];
        for (int cislo = 1; cislo <= pd; cislo++) {
            for (int j = 0; j < 4; j++) {
                poziceCisel[cislo][j] = -1;
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                int cislo = a[i][j];
                if (cislo >= 1 && cislo <= pd) {
                    if (poziceCisel[cislo][0] < 0) {
                        poziceCisel[cislo][0] = i;
                        poziceCisel[cislo][1] = j;
                    } else if (poziceCisel[a[i][j]][2] < 0) {
                        poziceCisel[cislo][2] = i;
                        poziceCisel[cislo][3] = j;
                    } else {
                        // nektere z cisel se vyskytuje vicekrat 
                        return -3;
                    }
                }
            }
        }
        int soucet = 0;
        for (int cislo = 1; cislo <= pd; cislo++) {
            if (poziceCisel[cislo][0] < 0) {
                // prvni vyskyt cisla nenalezen
                return -1;
            }
            if (poziceCisel[cislo][2] < 0) {
                // druhy vyskyt cisla nenalezen
                return -2;
            }
            int vzd = Math.abs(poziceCisel[cislo][0] - poziceCisel[cislo][2])
                    + Math.abs(poziceCisel[cislo][1] - poziceCisel[cislo][3]);
            soucet += vzd;
        }
        return (float) soucet / pd;
    }

    /**
     * Vytvori a v poli celych cisel vrati nahodnou permutaci cisel 1, 2, 3 ...
     * n.
     *
     * @param n velikost permutace
     * @return pole s vytvorenou permutaci
     */
    public static int[] getPetmutace1(int n) {
        int[] a = new int[n];
        for (int cislo = 1; cislo <= n; cislo++) {
            int pos = rnd.nextInt(n);
            while (a[pos] != 0) {
                pos = (pos + 1) % n;
            }
            a[pos] = cislo;
        }
        return a;
    }

    /**
     * Vytvori a v poli celych cisel vrati nahodnou permutaci cisel 1, 2, 3 ...
     * n.
     *
     * @param n velikost permutace
     * @return pole s vytvorenou permutaci
     */
    public static int[] getPermutace2(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        for (int i = 0; i < n; i++) {
            int pos = rnd.nextInt(n);
            int pom = a[i];
            a[i] = a[pos];
            a[pos] = pom;
        }
        return a;
    }

    /**
     * Vytvori a v poli celych cisel vrati nahodnou permutaci cisel 1, 2, 3 ...
     * n.
     *
     * @param n velikost permutace
     * @return pole s vytvorenou permutaci
     */
    public static int[] getPermutace3(int n) {
        int[] a = new int[n];
        // nejak jinak
        for (int cislo = 1; cislo <= n; cislo++) {
            int kolikataVolna = rnd.nextInt(n - cislo + 1);
            int k = 0;
            for (int j = 0; j < n; j++) {
                if (a[j] == 0) {
                    if (k == kolikataVolna) {
                        a[j] = cislo;
                        break;
                    }
                    k++;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) {
        // testovaci kod - generovani permutaci
        // test generovani pole pro pexeso
        int pocetTestu = 100;
        int pocetChyb = 0;
        for (int i = 0; i < pocetTestu; i++) {
            int[] p = getPolePexeso(rnd.nextInt(40) + 1);
            System.out.println(Arrays.toString(p));
            boolean vt = jePolePexeso(p);
            if (!vt) pocetChyb++;
            System.out.println("Je pole pro pexeso? " + (vt?"ano":"ne"));
            System.out.println("");
        }
        System.out.println("Pocet testu " + pocetTestu);
        System.out.println("Pocet chybne vytvorenych poli " + pocetChyb);
        System.out.println("");
    }

}
