package com.example.kms_poltekastra_be.rest;

import com.example.kms_poltekastra_be.service.KategoriProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/KategoriProgram")
public class KategoriProgramRest {
    @Autowired
    private KategoriProgramService kategoriProgramService;

    public KategoriProgramRest(KategoriProgramService kategoriProgramService) {
        this.kategoriProgramService = kategoriProgramService;
    }

    @PostMapping("/CreateKategoriProgram")
    public String createDataKatProgram(@RequestBody Map<String, Object> data){
        System.out.println("CRTKATPROG: "+data);
        return kategoriProgramService.createDataKategoriProgram(data);
    }

    @PostMapping("/GetKategoriByProgram")
    public String getKategoriProgram(@RequestBody Map<String, Object> data){
        System.out.println("GETKATPROG: "+data);
        return kategoriProgramService.getDataKategoriProgram(data);
    }

    @PostMapping("/EditKategoriProgram")
    public String editKategoriProgram(@RequestBody Map<String, Object> data){
        System.out.println("EDTKATPROG: "+data);
        return kategoriProgramService.getDataKategoriProgram(data);
    }
}
