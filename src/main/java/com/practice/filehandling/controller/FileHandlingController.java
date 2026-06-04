package com.practice.filehandling.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@RestController
public class FileHandlingController {

    private static final long MAX_FILE_SIZE = 100 * 1024; // 100KB in bytes

    private final Path uploadDir;

    public FileHandlingController() throws IOException {
        this.uploadDir = Paths.get("uploads");
        if (!Files.exists(this.uploadDir)) {
            Files.createDirectories(this.uploadDir);
        }
    }

    @PostMapping("/uploader")
    public ResponseEntity<?> uploadFile(
            @RequestParam("fileName") String fileName,
            @RequestParam("file") MultipartFile file) throws IOException {

        // Enforce 100KB limit — return 500 if exceeded, do NOT store the file
        if (file.getSize() > MAX_FILE_SIZE) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error");
        }

        Path destination = uploadDir.resolve(fileName).normalize();
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/downloader")
    public ResponseEntity<byte[]> downloadFile(
            @RequestParam("fileName") String fileName) throws IOException {

        Path filePath = uploadDir.resolve(fileName).normalize();
        if (!Files.exists(filePath)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        byte[] content = Files.readAllBytes(filePath);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(content);
    }
}
