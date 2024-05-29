package com.example.kms_poltekastra_be.rest;

import com.example.kms_poltekastra_be.service.AnggotaKKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/AnggotaKK")
public class AnggotaKKRest {
    @Autowired
    private AnggotaKKService anggotaKKService;

    public AnggotaKKRest(AnggotaKKService anggotaKKService) {
        this.anggotaKKService = anggotaKKService;
    }

    @PostMapping("/GetAnggotaKK")
    public String getListAnggota(@RequestBody Map<String, Object> data){
        System.out.println("GetAnggotaKK Request Body: "+data);
        return anggotaKKService.getListAnggotaByKK(data);
    }

    @PostMapping("/SetStatusAnggotaKK")
    public String setStatusAnggota(@RequestBody Map<String, Object> data){
        System.out.println("SetStatusAnggotaKK Request Body: "+data);
        return anggotaKKService.setStatusAnggota(data);
    }

    @PostMapping("/GetListDosen")
    public String getListDosenNonAnggotaByKK(@RequestBody Map<String, Object> data){
        System.out.println("GetListDosen Request Body: "+data);
        return anggotaKKService.getListDosenNonAnggotaByKK(data);
    }

    @PostMapping("/TambahAnggotaByPIC")
    public String tambahAnggotaByPIC(@RequestBody Map<String, Object> data){
        System.out.println("TambahAnggotaByPIC Request Body: "+data);
        return anggotaKKService.tambahAnggotaByPIC(data);
    }
}
