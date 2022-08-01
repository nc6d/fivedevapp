package com.service.filesservice.controller;

import com.service.filesservice.model.LoadFile;
import com.service.filesservice.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
//@CrossOrigin("*")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("file/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<>(fileService.addFile(file), HttpStatus.OK);
    }

    @GetMapping("file/download/{id}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable String id) throws IOException {
        LoadFile loadFile = fileService.downloadFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(loadFile.getFileType() ))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + loadFile.getFilename() + "\"")
                .body(new ByteArrayResource(loadFile.getFile()));
    }

}
