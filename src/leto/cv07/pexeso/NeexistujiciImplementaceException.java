/*
 * Copyright (C) 2024 Jirina Kralovcova
 * This program is part of Java programing education. 
 * You can use it as you need to learn Java. 
 */
package src.leto.cv07.pexeso;

/**
 *
 * @author Jirina
 */
public class NeexistujiciImplementaceException extends PexesoException {

    public NeexistujiciImplementaceException(String cln) {
        super("Trida " + cln + " nebyla nalezena, nebo nema pozadovany konstruktor.");
    }

}
