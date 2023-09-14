package com.iba.automation.exceptions;

public class TriangleException extends RuntimeException{
    public TriangleException() {
        super("The given sides do not belong to the triangle");
    }
}
