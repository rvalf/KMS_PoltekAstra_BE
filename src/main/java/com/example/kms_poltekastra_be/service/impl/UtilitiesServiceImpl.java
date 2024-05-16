package com.example.kms_poltekastra_be.service.impl;

import com.example.kms_poltekastra_be.repository.PolmanAstraRepository;
import com.example.kms_poltekastra_be.service.UtilitiesService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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

    @Override
    public String getListMenu(Map<String, Object> data){
        System.out.println("Menus : "+data);
        List<String> menuList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            menuList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("all_getListMenuKMS", menuList.toArray(new String[0]));
        System.out.println("Hasil Menu"+result);
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
        System.out.println("Return Login" + result);
        return result;
    }


    public String getDataModel(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("pro_getDataModel", dataList.toArray(new String[0]));
        return result;
    }

    public String getDataModelById(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("pro_getDataModelById", dataList.toArray(new String[0]));
        return result;
    }

    public String createModel(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("pro_createModel", dataList.toArray(new String[0]));
        return result;
    }

    public String detailModel(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("pro_detailModel", dataList.toArray(new String[0]));
        return result;
    }

    public String editModel(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("pro_editModel", dataList.toArray(new String[0]));
        return result;
    }

    public String setStatusModel(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("pro_setStatusModel", dataList.toArray(new String[0]));
        return result;
    }

    public String getListModel(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("pro_getListModel", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public ResponseEntity<?> uploadFile( MultipartFile file) {
        try {
            String uploadDir = "src/main/resources/assets/";
            String originalFilename = file.getOriginalFilename();
            String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName = "FILE_" + System.currentTimeMillis() + fileExtension;

            Path filePath = Paths.get(uploadDir + newFileName);
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
}