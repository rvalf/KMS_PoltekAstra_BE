package com.example.kms_poltekastra_be.rest;

import com.example.kms_poltekastra_be.service.SharingExpertService;
import com.example.kms_poltekastra_be.service.impl.SharingExpertServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/SharingExperts")
public class SharingExpertRest {
    @Autowired
    private SharingExpertService sharingExpertService;

    public SharingExpertRest(SharingExpertServiceImpl sharingExpertServiceImpl){
        this.sharingExpertService = sharingExpertServiceImpl;
    }

    @PostMapping("/SaveDataSharing")
    public String saveDataForum(@RequestBody Map<String, Object> data){
        System.out.println("SaveDataSharing Request Body: "+data);
        return sharingExpertService.saveDataSharing(data);
    }
}
