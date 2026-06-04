package com.practice.filehandling.exceptionmodel;

public class MaxUploadSizeExceededException extends RuntimeException{

    public MaxUploadSizeExceededException(String message){
        super(message);
    }
}
