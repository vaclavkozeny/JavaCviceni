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
public class ChybneCisloHraceException
        extends PexesoException {

    public ChybneCisloHraceException(int cislo) {
        super("Chybny index karty " + cislo);
    }
}
