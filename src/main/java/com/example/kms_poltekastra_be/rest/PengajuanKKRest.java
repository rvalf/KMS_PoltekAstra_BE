package com.example.kms_poltekastra_be.rest;

import com.example.kms_poltekastra_be.service.PengajuanKKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/Pengajuans")
public class PengajuanKKRest {
    @Autowired
    private PengajuanKKService pengajuanKKService;

    public PengajuanKKRest(PengajuanKKService pengajuanKKService) {
        this.pengajuanKKService = pengajuanKKService;
    }

    @PostMapping("/SaveAnggotaKK")
    public String saveDataAnggotaKK(@RequestBody Map<String, Object> data){
        System.out.println("akk: "+data);
//        return pengajuanKKService.saveDataAnggotaKK(data);
        return "dad";
    }
}
