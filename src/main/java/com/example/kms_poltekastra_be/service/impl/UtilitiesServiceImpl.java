package com.example.kms_poltekastra_be.service.impl;

import com.example.kms_poltekastra_be.repository.PolmanAstraRepository;
import com.example.kms_poltekastra_be.service.UtilitiesService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UtilitiesServiceImpl implements UtilitiesService {
    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    private final String fileBasePath = "src/main/resources/assets/";

    @Override
    public String getListMenu(Map<String, Object> data){
        System.out.println("Menus : "+data);
        List<String> menuList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            menuList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("all_getListMenuKMS", menuList.toArray(new String[0]));
        return result;
    }

    @Override
    public String login(Map<String, Object> data){
        System.out.println("Users : "+data);
        List<String> userList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            userList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("sso_getAuthenticationKMS", userList.toArray(new String[0]));
        return result;
    }

    @Override
    public ResponseEntity<?> uploadFile( MultipartFile file) {
        try {
            String originalFilename = file.getOriginalFilename();
            String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName = "FILE_" + System.currentTimeMillis() + fileExtension;

            Path filePath = Paths.get(fileBasePath + newFileName);
            Files.copy(file.getInputStream(), filePath);

            Map<String, String> response = new HashMap<>();
            response.put("newFileName", newFileName);
            response.put("message", "File uploaded successfully");

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Gagal Upload");
        }
    }

    @Override
    public ResponseEntity<Resource> downloadFile(String fileName) {
        try {
            Path filePath = Paths.get(fileBasePath, fileName);
            File file = filePath.toFile();

            if (!file.exists()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());
            headers.add(HttpHeaders.CONTENT_TYPE, getContentType(file.getName()));

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(file.length())
                    .body(resource);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    private String getContentType(String fileName) {
        String contentType;
        if (fileName.endsWith(".jpg")) {
            contentType = "image/jpeg";
        } else if (fileName.endsWith(".png")) {
            contentType = "image/png";
        } else if (fileName.endsWith(".pdf")) {
            contentType = "application/pdf";
        } else if (fileName.endsWith(".mp4")) {
            contentType = "video/mp4";
        } else {
            contentType = "application/octet-stream";
        }
        return contentType;
    }
}