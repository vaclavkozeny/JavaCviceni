/*
 * Copyright (C) 2024 Jirina Kralovcova
 * This program is part of Java programing education. 
 * You can use it as you need to learn Java. 
 */
package hry.pexeso;

/**
 *
 * @author Jirina
 */
public class ChybnyPocetKaretException extends PexesoException{

    public ChybnyPocetKaretException(int pocet) {
        super("Chybny pocet dvojic karet " + pocet + ". "
                + "Musi byt od 1 do " + HraPexeso.MAX_POCET_DVOJIC);
    }
    
}
