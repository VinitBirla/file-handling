package com.practice.filehandling.exceptionmodel;

public class NoFileTobeUploadedException extends RuntimeException{

    public NoFileTobeUploadedException(String message){
        super(message);
    }
}
