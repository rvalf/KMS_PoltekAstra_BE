package com.example.kms_poltekastra_be.rest;

import com.example.kms_poltekastra_be.helper.EncodeData;
import com.example.kms_poltekastra_be.service.PengajuanKKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/Pengajuans")
public class PengajuanKKRest {
    @Autowired
    private PengajuanKKService pengajuanKKService;

    @Autowired
    private EncodeData encodeData;

    public PengajuanKKRest(PengajuanKKService pengajuanKKService) {
        this.pengajuanKKService = pengajuanKKService;
    }

    @PostMapping("/GetAnggotaKK")
    public String getDataAnggotaKK(@RequestBody Map<String, Object> data) {
        System.out.println("GetAnggotaKK Request Body: "+data);
        return pengajuanKKService.getDataAnggotaKK(data);
    }

    @PostMapping("/GetDetailLampiran")
    public String getDetailLampiran(@RequestBody Map<String, Object> data){
        System.out.println("GetDetailLampiran Request Body: "+data);
        return pengajuanKKService.getDetailLampiran(data);
    }

    @PostMapping("/SaveAnggotaKK")
    public String saveDataAnggotaKK(@RequestBody Map<String, Object> data){
        System.out.println("SaveAnggotaKK Request Body: "+data);
        return pengajuanKKService.saveDataAnggotaKK(data);
    }

    @PostMapping("/GetRiwayat")
    public String getRiwayat(@RequestBody Map<String, Object> data){
        System.out.println("GetRiwayat Request Body: "+data);
        return pengajuanKKService.getRiwayatPengajuan(data);
    }
}
