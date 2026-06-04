package com.practice.filehandling.exceptionhandler;

import com.practice.filehandling.exceptionmodel.*;
import com.practice.filehandling.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class FileHandlingExceptionHandler {
    @ExceptionHandler(value = NoFileTobeUploadedException.class)
    public ResponseEntity<ResponseModel> handleNoFileToUploadException(NoFileTobeUploadedException noFileTobeUploadedException){
        return ResponseEntity.badRequest().body(new ResponseModel(noFileTobeUploadedException.getMessage(),HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(value = DuplicateFileUploadedException.class)
    public ResponseEntity<ResponseModel> handleDuplicateFileUploadException(DuplicateFileUploadedException duplicateFileUploadedException){
        return ResponseEntity.badRequest().body(new ResponseModel(duplicateFileUploadedException.getMessage(),HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(value = NoSuchFileFoundException.class)
    public ResponseEntity<ResponseModel> handleNoSuchFileFoundException(NoSuchFileFoundException noSuchFileFoundException){
        return ResponseEntity.badRequest().body(new ResponseModel(noSuchFileFoundException.getMessage(),HttpStatus.BAD_REQUEST));
    }
    @ExceptionHandler(value = FileUploadProcessException.class)
    public ResponseEntity<ResponseModel> handleFileUploadException(FileUploadProcessException fileUploadProcessException){
        return ResponseEntity.badRequest().body(new ResponseModel(fileUploadProcessException.getMessage(),HttpStatus.BAD_REQUEST));
    }
    @ExceptionHandler(value = FileSizeOverShootException.class)
    public ResponseEntity<ResponseModel> handleFileSizeOverShootException(FileSizeOverShootException fileSizeOverShootException){
        return ResponseEntity.badRequest().body(new ResponseModel(fileSizeOverShootException.getMessage(),HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    public ResponseEntity<ResponseModel> handleMaxSizeException(MaxUploadSizeExceededException maxUploadSizeExceededException){
        return ResponseEntity.badRequest().body(new ResponseModel(maxUploadSizeExceededException.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
