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
public class NedovolenyPozadavekException extends PexesoException{

    public NedovolenyPozadavekException() {
        super("Pozadovanou informaci nelze poskytnout nebo akci nelze provest");
    }
    
}
