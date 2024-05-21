package com.example.kms_poltekastra_be.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UtilitiesService {
    public String login(Map<String, Object> data);
    public String getListMenu(Map<String, Object> data);
    public String getUserLogin(Map<String, Object> data);
    public ResponseEntity<?> uploadFile(MultipartFile file);
    public ResponseEntity<Resource> downloadFile(String fileName);
}
