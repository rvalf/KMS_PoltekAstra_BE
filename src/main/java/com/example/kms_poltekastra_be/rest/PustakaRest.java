package com.example.kms_poltekastra_be.rest;

//import com.example.kms_poltekastra_be.service.PustakaService;
import com.example.kms_poltekastra_be.service.PustakaService;
import com.example.kms_poltekastra_be.service.impl.PustakaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/Pustakas")
public class PustakaRest {
    @Autowired
    private PustakaService pustakaService;

    public PustakaRest(PustakaServiceImpl pustakaServiceImpl) {
        this.pustakaService = pustakaServiceImpl;
    }

    @PostMapping("/GetDataPustaka")
    public String getDataPustaka(@RequestBody Map<String, Object> data){
        System.out.println("GetDataPustaka Request Body: "+data);
        return pustakaService.getDataPustaka(data);
    }

    @PostMapping("/SaveDataPustaka")
    public String saveDataPustaka(@RequestBody Map<String, Object> data){
        System.out.println("SaveDataPustaka Request Body: "+data);
        return pustakaService.saveDataPustaka(data);
    }
    @PostMapping("/UpdateDataPustaka")
    public String editDataPustaka(@RequestBody Map<String, Object> data){
        System.out.println("UpdateDataPustaka Request Body: "+data);
        return pustakaService.editDataPustaka(data);
    }

    @PostMapping("/SetStatusPustaka")
    public String setStatusPustaka(@RequestBody Map<String, Object> data){
        System.out.println("SetStatusPustaka Request Body: "+data);
        return pustakaService.setStatusPustaka(data);
    }
}
