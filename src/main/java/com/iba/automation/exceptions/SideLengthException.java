package com.iba.automation.exceptions;

public class SideLengthException extends RuntimeException{
    public SideLengthException() {
        super("Side length can not be 0");
    }
}
