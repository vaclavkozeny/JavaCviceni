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
public class ChybnyIndexKartyException extends PexesoException{
    
    public ChybnyIndexKartyException(int index) {
        super("Chybny index karty " + index);
    }
    
}
