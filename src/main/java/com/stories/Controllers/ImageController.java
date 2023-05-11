package com.stories.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ImageController {

  

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("Image") MultipartFile image) {
    	
        if (image.isEmpty()) {
        	
            return ResponseEntity.badRequest().body("Image file is required");
        }

        try {
        	String uploadFolder = "C:\\Users\\Saif\\Desktop\\FrontApp\\Stories\\src\\assets\\imgs";
            String fileName = image.getOriginalFilename();
            System.out.println(fileName);
            System.out.println(uploadFolder);
            File destination = new File(uploadFolder + "/" + fileName);
            image.transferTo(destination);

            return ResponseEntity.ok("Image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
        }
    }
}

