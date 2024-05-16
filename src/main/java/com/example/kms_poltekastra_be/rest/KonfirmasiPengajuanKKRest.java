package com.example.kms_poltekastra_be.rest;

import com.example.kms_poltekastra_be.service.KonfirmasiPengajuanKKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class KonfirmasiPengajuanKKRest {

    @Autowired
    private KonfirmasiPengajuanKKService konfirmasiPengajuanKKService;

    @PostMapping("/KonfirmasiPengajuanKK")
    public String konfirmasiPengajuanKK(@RequestBody Map<String, Object> data) {
        return konfirmasiPengajuanKKService.konfirmasiPengajuanKK(data);
    }
}
