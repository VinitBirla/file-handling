package com.practice.filehandling.exceptionmodel;

public class DuplicateFileUploadedException extends RuntimeException{

    public DuplicateFileUploadedException(String message){
        super(message);
    }
}
