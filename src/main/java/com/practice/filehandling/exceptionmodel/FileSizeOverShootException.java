package com.practice.filehandling.exceptionmodel;

public class FileSizeOverShootException extends RuntimeException {

    public FileSizeOverShootException(String message) {
        super(message);
    }
}
