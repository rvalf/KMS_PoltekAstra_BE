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
        System.out.println("DADADA: "+data);
        return pustakaService.getDataPustaka(data);
    }

    @PostMapping("/SaveDataPustaka")
    public String saveDataPustaka(@RequestBody Map<String, Object> data){
//        System.out.println("DAAA"+data);
        return pustakaService.saveDataPustaka(data);
    }
    @PostMapping("/UpdateDataPustaka")
    public String editDataPustaka(@RequestBody Map<String, Object> data){
//        System.out.println("EEEE"+data);
        return pustakaService.editDataPustaka(data);
    }

    @PostMapping("/SetStatusPustaka")
    public String setStatusPustaka(@RequestBody Map<String, Object> data){
        System.out.println("Status: "+data);
        return pustakaService.setStatusPustaka(data);
    }
}
