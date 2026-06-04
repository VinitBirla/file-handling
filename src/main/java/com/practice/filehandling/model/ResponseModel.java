package com.practice.filehandling.model;

import org.springframework.http.HttpStatus;

import java.io.Serializable;


public record ResponseModel(String message, HttpStatus status) implements Serializable {
}
