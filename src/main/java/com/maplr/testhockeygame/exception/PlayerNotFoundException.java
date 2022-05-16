package com.maplr.testhockeygame.exception;

/**
 * Exception thrown if no player is found.
 */
public class PlayerNotFoundException extends Exception{

    public PlayerNotFoundException (){
        super("No player found for the given id.");
    }
}
