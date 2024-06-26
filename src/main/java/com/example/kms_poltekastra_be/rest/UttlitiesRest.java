package com.example.kms_poltekastra_be.rest;

//import com.example.kms_poltekastra_be.service.UtilitiesService;
import com.example.kms_poltekastra_be.service.UtilitiesService;
import com.example.kms_poltekastra_be.service.impl.UtilitiesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/Utilities")
public class UttlitiesRest {

    @Autowired
    private UtilitiesService utilitiesService;

    public UttlitiesRest(UtilitiesServiceImpl utilitiesServiceImpl) {
        this.utilitiesService = utilitiesServiceImpl;
    }

    @PostMapping("/Login")
    public String logins (@RequestBody Map<String, Object> data) {
        System.out.println("DATATAS : "+ data);
        System.out.println("data login: "+data);
        return  utilitiesService.login(data);
    }

    @PostMapping("/GetListMenu")
    public String getListMenus (@RequestBody Map<String, Object> data) {
        System.out.println("GetListMenu Request Body: " + data);
        return utilitiesService.getListMenu(data);
    }

    @PostMapping("/GetUserLogin")
    public String getUserLogin (@RequestBody Map<String, Object> data) {
        System.out.println("GetUserLogin Request Body: "+data);
        return  utilitiesService.getUserLogin(data);
    }

    @PostMapping("/Upload")
    public ResponseEntity<?> UploadFile (@RequestBody MultipartFile file){
        System.out.println("Upload Request Body: "+file);
        return utilitiesService.uploadFile(file);
    }

    @GetMapping("/Upload/DownloadFile")
    public ResponseEntity<Resource> downloadFile(@RequestParam String namaFile) {
        System.out.println("DownloadFile Request Body: "+namaFile);
        return utilitiesService.downloadFile(namaFile);
    }
}
