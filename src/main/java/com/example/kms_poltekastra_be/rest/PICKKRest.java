package com.example.kms_poltekastra_be.rest;

import com.example.kms_poltekastra_be.service.PICKKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/PICKKs")
public class PICKKRest {
    @Autowired
    private PICKKService pickkService;

    @PostMapping("/GetKKByProdi")
    public String getKKByProdi(@RequestBody Map<String, Object> data){
        return pickkService.getKKByProdi(data);
    }
}
