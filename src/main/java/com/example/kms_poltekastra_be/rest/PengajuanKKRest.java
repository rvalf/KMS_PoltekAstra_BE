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

    @PostMapping("/GetAnggotaKK")
    public String getDataAnggotaKK(@RequestBody Map<String, Object> data){
//        System.out.println("anggota: "+data);
        return pengajuanKKService.getDataAnggotaKK(data);
    }

    @PostMapping("/GetDetailLampiran")
    public String getDetailLampiran(@RequestBody Map<String, Object> data){
        System.out.println("lampiran: "+data);
        return pengajuanKKService.getDetailLampiran(data);
    }

    @PostMapping("/SaveAnggotaKK")
    public String saveDataAnggotaKK(@RequestBody Map<String, Object> data){
//        System.out.println("akk: "+data);
        return pengajuanKKService.saveDataAnggotaKK(data);
    }
}
