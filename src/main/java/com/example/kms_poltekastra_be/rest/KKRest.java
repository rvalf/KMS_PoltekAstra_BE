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
    public String getDataKK(@RequestBody Map<String, Object> data){
        System.out.println("GetDataKK Request Body: "+data);
        return kkService.getDataKK(data);
    }

    @PostMapping("/GetDataKKByID")
    public String getDataKKbyID(@RequestBody Map<String, Object> data){
        System.out.println("GetDataKKByID Request Body: "+data);
        return kkService.getDataKKbyID(data);
    }

    @PostMapping("/GetListProdi")
    public String getListProdi(@RequestBody Map<String, Object> data){
        System.out.println("GetListProdi Request Body: "+data);
        return kkService.getListProdi(data);
    }

    @PostMapping("/GetListKaryawan")
    public String getListKaryawan(@RequestBody Map<String, Object> data){
        System.out.println("GetListKaryawan Request Body: "+ data);
        return kkService.getListKaryawan(data);
    }

    @PostMapping("/CreateKK")
    public String createKK(@RequestBody Map<String, Object> data){
        System.out.println("CreateKK Request Body: "+data);
        return kkService.createKK(data);
    }

    @PostMapping("/EditKK")
    public String editKK(@RequestBody Map<String, Object> data){
        System.out.println("EditKK Request Body: "+data);
        return kkService.editKK(data);
    }

    @PostMapping("/DeleteKK")
    public String deleteKK(@RequestBody Map<String, Object> data){
        System.out.println("DeleteKK Request Body: "+data);
        return kkService.deleteKK(data);
    }

    @PostMapping("/SetStatusKK")
    public String setStatusKK(@RequestBody Map<String, Object> data){
        System.out.println("SetStatusKK Request Body: "+data);
        return kkService.setStatusKK(data);
    }

    @PostMapping("/GetDataKKbyProdi")
    public String getDataKKbyProdi(@RequestBody Map<String, Object> data){
        System.out.println("GetDataKKbyProdi Request Body: "+data);
        return kkService.getDataKKbyProdi(data);
    }
}
