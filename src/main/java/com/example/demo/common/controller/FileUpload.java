package com.example.demo.common.controller;

import com.example.demo.common.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@RequiredArgsConstructor
@RestController
public class FileUpload {


    private final FileUploadService fileUploadService;
    private final String PATH = "C:\\spring-project\\src\\main\\resources\\static\\resources\\uploadImg\\";

    @PostMapping(value = "/fileUpload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) throws Exception {

        String uploadPath = PATH + file.getOriginalFilename();

        file.transferTo(new File(uploadPath));
        return ResponseEntity.ok().body("/resources/uploadImg/" + file.getOriginalFilename());
    }
}
