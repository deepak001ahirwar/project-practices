package com.file.demo.comman.controller;

import com.file.demo.comman.FileServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/FileStorage")
public class FileUploadDownloadController {

    @Autowired
    private FileServiceInterface fileService;

    // upload the file
    @PostMapping("/upload")
    public ResponseEntity<?> uploadfile(@RequestParam MultipartFile file) throws IOException {
        String Result = fileService.uploadFile(file);
        return  ResponseEntity.status(HttpStatus.CREATED).body(Result);
    }



    // download the file
    @GetMapping("/download/{fileName}")
    public ResponseEntity<?> downloadfile(@PathVariable String fileName) throws IOException {
        byte[] imageData = fileService.downloadfile(fileName);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }




}
