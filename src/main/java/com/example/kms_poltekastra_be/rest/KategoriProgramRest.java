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
        System.out.println("CreateKategoriProgram Request Body: "+data);
        return kategoriProgramService.createDataKategoriProgram(data);
    }

    @PostMapping("/GetKategoriByProgram")
    public String getKategoriProgram(@RequestBody Map<String, Object> data){
        System.out.println("GetKategoriByProgram Request Body: "+data);
        return kategoriProgramService.getDataKategoriProgram(data);
    }

    @PostMapping("/EditKategoriProgram")
    public String editKategoriProgram(@RequestBody Map<String, Object> data){
        System.out.println("EditKategoriProgram Request Body: "+data);
        return kategoriProgramService.editKategoriProgram(data);
    }

    @PostMapping("/DeleteKategoriProgram")
    public String deleteKategoriProgram(@RequestBody Map<String, Object> data){
        System.out.println("DeleteKategoriProgram Request Body: "+data);
        return kategoriProgramService.deleteKategoriProgram(data);
    }

    @PostMapping("/SetStatusKategoriProgram")
    public String setStatusKategoriProgram(@RequestBody Map<String, Object> data){
        System.out.println("SetStatusKategoriProgram Request Body: "+data);
        return kategoriProgramService.setStatusKategoriProgram(data);
    }
}
