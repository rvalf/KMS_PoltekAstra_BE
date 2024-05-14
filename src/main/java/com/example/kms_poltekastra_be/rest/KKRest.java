package com.example.kms_poltekastra_be.rest;

import com.example.kms_poltekastra_be.service.KKService;
import com.example.kms_poltekastra_be.service.impl.KKServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/KKs")
public class KKRest {
    @Autowired
    private KKService kkService;

    public KKRest(KKServiceImpl kkServiceImpl) {
        this.kkService = kkServiceImpl;
    }

    @PostMapping("/GetDataKK")
    public String getDataPustaka(@RequestBody Map<String, Object> data){
//        System.out.println("DAAAA: "+data);
        return kkService.getDataKK(data);
    }
}
