package com.example.smartevent.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileStorageService {

    public String storeFile(MultipartFile file, String directory) {
        // Implement your file storage logic here (local, S3, etc.)
        // For now, returning a placeholder URL
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        return "/uploads/" + directory + "/" + filename;
    }
}
