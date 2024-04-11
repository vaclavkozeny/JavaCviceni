/*
 * Copyright (C) 2024 Jirina Kralovcova
 * This program is part of Java programing education. 
 * You can use it as you need to learn Java. 
 */
package src.leto.cv08.hry.pexeso;

/**
 *
 * @author Jirina
 */
public class ChybnyPocetHracuException extends PexesoException{

    public ChybnyPocetHracuException(int pocet) {
        super("Chybny pocet hracu " + pocet + ". "
                + "Musi byt od 1 do " + HraPexeso.MAX_POCET_HRACU);
    }
    
}
