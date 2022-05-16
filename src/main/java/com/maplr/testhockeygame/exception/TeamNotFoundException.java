package com.maplr.testhockeygame.exception;

/**
 * Exception thrown if no team is found.
 */
public class TeamNotFoundException extends Exception{

    public TeamNotFoundException (){
        super("No team found for the given year.");
    }
}
