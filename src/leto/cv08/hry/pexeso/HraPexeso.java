/*
 * Copyright (C) 2024 Jirina Kralovcova
 * This program is part of Java programing education. 
 * You can use it as you need to learn Java. 
 */
package hry.pexeso;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Interface PexesoInterface predstavuje rozhrani trid implementujicich hru
 * PEXESO (tez MEMORY, PAIRS apod.).
 *
 * <p>Hra <TT>PEXESO</TT> je katetni hra. Predpoklada se urcity pocet dvojic karet (PD).
 * Celkovy pocet karet (PK) je dvojnasokem poctu dvojic karet. Hru hraje obecne
 * libovolny pocet hracu (PH) - minimalne jeden.
 *
 * <p>Pro implementaci hry predpokladame ocislovani karet cisly 1..PD, tedy kazde
 * cislo je v sade karet uplatneno prave 2x.
 *
 * <p>Na zacatku kazde hry jsou všechny karty obracene rubovou stranou. Cilem hry
 * je vyhledat dvojice karet se stejnymi cisly. Vyhledane dvojice jsou ze hry
 * odstanene.
 *
 * <p>Hraci se postupne ve hre stridaji dle pravidel hry. V jednom tahu hrac
 * postupne obrati postupne dve karty. Pokud se jedna o karty se stejnym cislem,
 * dvojice karet je odstranena ze hry, prislusny hrac ziskava bod a provadi
 * dalsi tah stejnym zpusobem. Pokud je pri aktualnim tahu obracena dvojice
 * karet s ruznymi cisly, karty se obrati opet rubovou stranou nahoru a ve hre
 * pokracuje dalsi hrac.
 *
 * <p>Hra konci v okamziku, kdy jsou z hraciho pole odstraneny vsechny karty - tj.
 * jsou vyhledane vsechny dvojice. Vyhrava ten hrac, ktery ma nejvetsi pocet
 * bodu (obratilnejvetsi pocet dvojic stejjnych katet).
 *
 * <p>Interface {@code HraPexeso} definuje rozhrani pro tridy implementujici hru
 * PEXESO. Predpoklada se konfigurovatelnost hry co do vybrane urovne a poctu
 * hracu.
 *
 * <p>Trida implementujici tento interface obsahuje algoritmy realizujici hru
 * PEXESO. Konkretni instance tridy pak uchovava stav jednotlivych karet, pocet
 * hracu, jejich skore, aktualni stav hry atd. Zde definovane rozhrani
 * predpoklada obraceni karet po jedne, implementace musi interne zajistovat
 * konzistenci stavu hry, kdy se jedna o obraceni prvni karty aktualniho tahu,
 * kdy o obraceni druhe karty aktualniho tahu (tj. tah je ukonceny a lze jej
 * vyhodnotit), kdy odstranit karty z hraciho pole, kdy posunout hru na dalsiho
 * hrace, kdy je mozne poskytnout informaci o vyherci atd. - to vse je
 * zalezitosti interniho stavu konkretniho objektu (konkretni instance).
 *
 * <p>Rozhrani tridy (bez ohledu na vnitni implementaci) musi v souladu s
 * dokumentaci jednotlivych metod zachovavat nasledujici cislovani: Karty maji
 * cisla od 1 do PD, kazde cislo je uplatnene 2x. Pole masky karet je indexovane
 * od 0 do PK-1. Cislovani hracu je od 1 do PH.
 *
 * @author Jirina Kralovcova
 * @version 1.0
 *
 */
public interface HraPexeso {

    /**
     * Maximalni povoleny pocet dvojit karet ve hre PEXESO.
     */
    public static final int MAX_POCET_DVOJIC = 32;
    /**
     * Maximalni povoleny pocet hracu ucastnicich se hry PEXESO.
     */
    public static final int MAX_POCET_HRACU = 4;

    /**
     * Metoda poskytujici konkretni objekt implementujici hru PEXESO.
     *
     * <p>Konkretni implementace je urcena v prvnim parametru metody, kterym je
     * prijmeni autora. Pro zadane prijmeni musi v tomto baliku existovat trida
     * PrijmeniPexeso. Dana trida musi mit konstruktor se dvema celociselnymi
     * parametry predstavujicimi pocet dvojic karet a pocet hracu hry. Pokud
     * takova trida neexistuje nemo nema pozadovany konstruktor, je to
     * indikovano vyjimkou {@code NeexistujiciImplementaceException}.
     *
     * <p>Pro kazdou hru je dale nutne zadat celkovy pocet dvojic karet a pocet
     * hracu, kteri se hry ucastni. Celkovy pocet dvojic karet musi byt
     * minimalne 2, maximalni hodnota je dana konstantou {@code MAX_POCET_DVOJIC}.
     * Chybny pocet dvojic karet je indikovan vyjimkou. Pocet hracu je hodnota
     * od jedne do {@code MAX_POCET_HRACU}. Chybny pocet hracu je indikovan vyjimkou.
     *
     * @param jmAutor prijmeni autora tridy implementujici tento interface.
     * @param pocetDvojic pozadovany pocet dvojic karet pro hru.
     * @param pocetHracu pocet hracu, kteri se budou hry ucastnit.
     * @return objekt {@code HraPexeso}, tj. referenci na instanci objektu hry PEXESO.
     * @throws ChybnyPocetKaretException v pripade chybne zadaneho poctu dvojic
     * karet.
     * @throws ChybnyPocetHracuException v pripade chybne zadaneho poctu hracu.
     * @throws NeexistujiciImplementaceException v pripade, ze implementace
     * zadaneho autora v tomto baliku neexistuje.
     */
    public static HraPexeso getInstance(String jmAutor, int pocetDvojic, int pocetHracu) {
        if (pocetDvojic < 2 || pocetDvojic > MAX_POCET_DVOJIC) {
            throw new ChybnyPocetKaretException(pocetDvojic);
        }
        if (pocetHracu < 1 || pocetHracu > MAX_POCET_HRACU) {
            throw new ChybnyPocetHracuException(pocetDvojic);
        }
        String fullClassName = "hry.pexeso." + jmAutor + "Pexeso";
        try {
            Class<?> cls = Class.forName(fullClassName);
            //Method m = cls.getDeclaredMethod("getInstance", int.class, int.class);
            //HraPexeso obj = (HraPexeso) m.invoke(null, pocetDvojic, pocetHracu);
            Constructor<?> construct = cls.getDeclaredConstructor(int.class, int.class);
            HraPexeso hra = (HraPexeso) construct.newInstance(pocetDvojic, pocetHracu);
            return hra;
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException
                | InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException ex) {
            Logger.getLogger(HraPexeso.class.getName()).log(Level.SEVERE, null, ex);
            throw new NeexistujiciImplementaceException(fullClassName);
        }
    }

    /**
     * Metoda poskytujici konkretni objekt implementujici hru PEXESO. Jedna o
     * hru se zadanym poctem dvojic karet pro jednoho hrace. Konkretni
     * implementace je urcena parametrem jmAutor.
     *
     * @param @param jmAutor prijmeni autora tridy implementujici tento
     * interface.
     * @param pocetDvojic celkovy pocet dvojic karet.
     * @return objekt (referenci na instanci) objektu hry PEXESO.
     * @throws ChybnyPocetKaretException v pripade chybne zadaneho poctu dvojic
     * karet.
     * @throws NeexistujiciImplementaceException v pripade, ze implementace
     * zadaneho autora v tomto baliku neexistuje.
     */
    public static HraPexeso getInstance(String jmAutor, int pocetDvojic) {
        return getInstance(jmAutor, pocetDvojic, 1);
    }

    /**
     * Metoda poskytujici konkretni objekt implementujici hru PEXESO. Jedna o
     * hru ctyrmi dvojicemi karet pro jednoho hrace. Konkretni implementace je
     * urcena parametrem jmAutor.
     *
     * @param jmAutor prijmeni autora tridy implementujici tento interface.
     * @return objekt (referenci na instanci) objektu hry PEXESO..
     * @throws NeexistujiciImplementaceException v pripade, ze implementace
     * zadaneho autora v tomto baliku neexistuje.
     */
    public static HraPexeso getInstance(String jmAutor) {
        return getInstance(jmAutor, 4, 1);
    }

    /**
     * Poskytne informaci o celkovem poctu karet. Celkovy pocet karet je
     * dvojnasobkem poctu dvojic karet.
     *
     * @return celkovy pocet karet jako hodnoty typu int.
     */
    public int getPocetKaret();

    /**
     * Poskytne informaci o celkovem poctu dvojic karet.
     *
     * @return celkovy pocet dvojic karet jako hodnoty typu int
     */
    public int getPocetDvojic();

    /**
     * Poskytne informaci o celkovem poctu hracu zapojenych do hry.
     *
     * @return celkovy pocet hracu jako hodnoty typu int
     */
    public int getPocetHracu();

    /**
     * Poskytne informaci o tom, ktery hrac je na rade. Tuto informaci si
     * interne instance hry aktualizuje dle pravidel hry
     *
     * @return cislo hrace tj. hodnota od 1 do getPocetHracu() jako hodnota typu
     * int.
     */
    public int getHrajeHrac();

    /**
     * Poskytne informaci o poctu dvojic karet, ktere jsou aktualne stale ve
     * hre.
     *
     * @return pocet dvojic karet, ktere jsou stale ve hre.
     */
    public int getPocetDvojicKaretVeHre();

    /**
     * Poskytne pole delky odpovidajici hodnote getPocetKaret(), ve kterem je
     * pro kazdou kartu informace, zda je stale ve hre, ci nikoli.
     *
     * @return pole hodnot typu int, kde na kazde pozici se vyskytuje nezaporna
     * hodnota, pokud je prislusna karta stale ve hre, a hodnota zaporna, pokud
     * prislusna karta byla jiz odstranena.
     */
    public int[] getPoleKaretMask();

    /**
     * Poskytne vysledek obraceni karty. Vraci bud hodnotu od 1 do
     * getPocetDvojic() v pripade, ze je mozne kartu obratit, nebo zaporne
     * cislo, pokud kartu obratit nelze (je aktualne obracena, nebo je dana
     * karta mimo hru).
     *
     * @param indexKarty cislo karty, kterou pozadujeme obratit, jako hodnota
     * typu int. Parametr musi mit hodnotu od 0 do getPocetKaret()-1.
     * @return cislo pozadovane karty, nebo zapornou hodnotu v pripade, ze kartu
     * na zadane pozici nelze obratit.
     * @throws ChybnyIndexKartyException v pripade chybneho indexu kartu, tj.
     * kdy index je mimo povoleny rozsah.
     * @throws NedovolenyPozadavekException v pripade jiz ukoncene hry.
     */
    public int otocKartu(int indexKarty);

    /**
     * Poskytuje informaci, zda je hra ukoncena ci nikoli.
     *
     * @return informaci o stavu hry neukoncena/ukoncena jako hodnotu typu
     * boolean.
     */
    public boolean isKonecHry();

    /**
     * Po ukonceni aktualni hry poskytuje cislo hrace, ktery hru vyhral.
     *
     * Hraci jsou cislovani od 1. Pokud nelze vyherce jednoznacne urrcit, potom
     * metoda vraci 0 a lze vyuzit metodu
     *
     * @return cislo hrace tj, hodnotu od 1 do getPocetHracu() jako int, nebo
     * hodnotu 0, pokud vyherce nezlze jednoznacne urcit tj. existuje vice hracu
     * s max. poctem ziskanych bodu.
     * @throws NedovolenyPozadavekException v pripade nepripustneho pouziti
     * metody v okamziku doposud nedohrane hry.
     */
    public int getCisloVyherce();

    /**
     * Poskytuje pole s cisly hracu v poradi dle dosazenych bodu. Usporadano
     * sestupne.
     *
     * @return pole delky pocet hracu s cisly hracu dle poradi.
     */
    public int[] getPoradiHracu();

    /**
     * Poskytuje informaci o poctu aktualne dosazenych bodu zadaneho hrace
     *
     * @param cisloHrace cislo hrace jako hodnota typu int.
     * @return pocet bodu dosazenych zadanym hracem.
     * @throws ChybneCisloHraceException v pripade, ze zadane cislo hrace je
     * mimo povoleny rozsah.
     */
    public int getPocetBoduHrace(int cisloHrace);

}
