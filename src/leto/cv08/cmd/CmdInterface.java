/*
 * Copyright (C) 2024 Jirina Kralovcova
 * This program is part of Java programing education. 
 * You can use it as you need to learn Java. 
 */
package src.leto.cv08.cmd;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Zaklad trid objektu "prikazove radky".
 * <p>
 * Kazdy objekt prikazove radky pracuje nad jistym "aktualnim adresarem".
 * <p>
 * Objekt umoznuje prochazet souborovy system, menit aktualni adresar a
 * vypisovat obsah aktualniho nebo zadaneho adresare.Nekterymi prikazy dochazi
 * ke zmene aktulniho adresare {@code cd()} jinymi nikoli {@code dir()}.
 * <p>
 * Trida <i>PrijmeniCmd</i> implementujici texto interface musi mit jeden
 * konstruktor s jednim parametrem typu textovy retezec: <tt>PrijmeniCmd (String
 * path) </tt>. V tomto parametru konstruktor obdrzi absolutni cestu k adresari
 * existujicimu na disku. V konstruktoru toto neni nutno znovu overovat, viz
 * implementace metody {@code getInstance()} v tomto interface.
 *
 * @author Jirina
 */
public interface CmdInterface {

    /**
     * Poskytne objekt "prikazove radky".
     * <p>
     * Vytvoreny objekt je typu PrijemniCmd, kde Prijmeni je zadano v prvnim
     * parametru autor.
     * <p>
     * Po vytvoreni objektu prikazove je aktualnim adresarem adresar zadany
     * parametrem {@code adrPath}. Cesta muze byt absolutni nebo relativni.
     * Relativni cesta je vztazena k {@code System.getProperty("user.dir")}.
     * <p>
     * Trida <i>PrijmeniCmd</i> implementujici texto interface musi mit jeden
     * konstruktor s jednim parametrem typu textovy retezec: <tt>PrijmeniCmd
     * (String path) </tt>. V tomto parametru konstruktor obdrzi absolutni cestu
     * k adresari existujicimu na disku. V konstruktoru toto neni nutno znovu
     * overovat.
     *
     * @param jmAutor prijmeni autora konkretni implementace tohoto interface.
     * @param adrPath cesta k adresari, ktery ma byt vychozim aktualnim
     * adresarem prikazove radky.
     * @return objekt "prikazove radky".
     * @throws IOException
     * @throws AdresarNeexistujeException pokud adresar zadany v adrPath na
     * disku neexistuje.
     */
    public static CmdInterface getInstance(String jmAutor, String adrPath) throws Exception {
        // pouziti java.io.File
        //File f = (new File(adrPath)).getCanonicalFile();
        //if (!f.isDirectory()) {
        //    throw new AdresarNeexistujeException("Adresar " + f.getPath() + "na disku neexistuje!");
        //}
        // pouziti java.nio.Path
        Path p = Path.of(adrPath).toRealPath();
        if (!Files.isDirectory(p)){
            throw new AdresarNeexistujeException(
                    "Adresar " + p.toString() + "na disku neexistuje!");
        }
        String fullClassName = "cmd." + jmAutor + "Cmd";
        Class<?> cls = Class.forName(fullClassName);
        Constructor<?> construct = cls.getDeclaredConstructor(String.class);
        CmdInterface cmd = (CmdInterface) construct.newInstance(adrPath);
        return cmd;
    }

    public static CmdInterface getInstance(String autor) throws Exception {
        //return getInstance(autor, System.getProperty("user.dir"));
        return getInstance(autor, ".");
    }

    /**
     * Poskytuje textovy retezec "vyzvy prikazove radky" tzv. "prompt". Textovy
     * retezec je ve tvaru, jak jej poskytuje bezna konzole.
     *
     * @return Textovy retezec s promptem prikazove radky.
     */
    public String getPrompt();

    /**
     * Poskytuje textovy retezec s celou cestou k aktualnimu adresari.
     *
     * @return textovy retezec s cestou k aktualnimu adresari.
     */
    public String getAktDir();

    /**
     * Umoznuje menit aktualni adresar. Novy adresar je zadan parametrem
     * adrPath, ktery obsahuje relativni nebo absolutni cestu k adresari. V
     * pripade zadani relativni cesty je tato vztazena k adresari, ktery je
     * doposud aktualni v danem objektu tj. k adresari {@code getAktAdr()}
     * (nikoli k adresari danemu cestou {@code System.getProperty("user.dir")}.
     *
     * <p>
     * Provedenim tohoto prikazu dojde ke zmene aktualniho adresare.
     *
     * @param adrPath cesta k adresari.
     * @throws AdresarNeexistujeException pokud adresar zadany v adrPath na
     * disku neexistuje.
     */
    public void cd(String adrPath);

    /**
     * Poskytne textovy retezec s vypisem aktualniho adresare.
     * <p>
     * Jedna se o viceradkovy textovy retezec. Naprvni radce je nejprve
     * informace o tom jaky adresar je vypisovan. Nasledne jsou zde vypsany
     * podadresare adresare a soubory z prislusneho adresare. Vypis je
     * formatovany a obsahuje obdobne informace jako obdrzime prikazem dir
     * prikazove radky Windows.
     *
     * @return textovy retezec s formatovanym vypisem obsahu aktualniho
     * adresare.
     */
    public String dir();

    /**
     * Poskytne textovy retezec s vypisem zadaneho adresare.
     * <p>
     * Cesta k adresari je zadana v parametru {@code adrPath}. Zadana cesta muze
     * byt bud relativni nebo absolutni. Relativni cesta se vztahuje k
     * aktualnimu adresari {@code getAktAdr()}. Provedenim tohoto prikazu
     * nedochazi ke zmene aktualniho adresare.
     * <p>
     * Vypis adresare je viceradkovy textovy retezec. Na prvni radce je nejprve
     * informace o tom jaky adresar je vypisovan. Nasledne jsou zde vypsany
     * podadresare a soubory z prislusneho adresare. Vypis je formatovany a
     * obsahuje obdobne informace jako obdrzime prikazem dir prikazove radky
     * Windows.
     *
     * @return textovy retezec s formatovanym vypisem obsahu zadaneho adresare.
     * @throws AdresarNeexistujeException pokud adresar zadany v adrPath na
     * disku neexistuje.
     */
    public String dir(String adrPath);
}
