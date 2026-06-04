package com.practice.filehandling.exceptionmodel;

public class NoSuchFileFoundException extends RuntimeException{

    public NoSuchFileFoundException(String message){
        super(message);
    }
}
