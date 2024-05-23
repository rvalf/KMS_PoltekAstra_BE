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
    public ResponseEntity<String> getDataAnggotaKK(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = pengajuanKKService.getDataAnggotaKK(encodedData);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to Load data", e);
        }
    }

    @PostMapping("/GetDetailLampiran")
    public String getDetailLampiran(@RequestBody Map<String, Object> data){
//        System.out.println("lampiran: "+data);
        return pengajuanKKService.getDetailLampiran(data);
    }

    @PostMapping("/SaveAnggotaKK")
    public String saveDataAnggotaKK(@RequestBody Map<String, Object> data){
//        System.out.println("akk: "+data);
        return pengajuanKKService.saveDataAnggotaKK(data);
    }
}
