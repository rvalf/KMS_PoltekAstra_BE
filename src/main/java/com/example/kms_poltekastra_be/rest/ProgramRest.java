package com.example.kms_poltekastra_be.rest;

import com.example.kms_poltekastra_be.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/Program")
public class ProgramRest {
    @Autowired
    private ProgramService programService;

    public ProgramRest(ProgramService programService) {
        this.programService = programService;
    }

    @PostMapping("/GetDataKKByPIC")
    public String getDataKKByPIC(@RequestBody Map<String, Object> data){
        System.out.println("GetDataKKByPIC Request Body: "+data);
        return programService.getDataKKByPIC(data);
    }

    @PostMapping("/GetDataKKByAKK")
    public String getDataKKByAKK(@RequestBody Map<String, Object> data){
        System.out.println("GetDataKKByAKK Request Body: "+data);
        return programService.getDataKKByAKK(data);
    }

    @PostMapping("/CreateProgram")
    public String tambahProgram(@RequestBody Map<String, Object> data){
        System.out.println("CreateProgram Request Body: "+data);
        return programService.createProgram(data);
    }

    @PostMapping("/GetProgram")
    public String getProgramByKK(@RequestBody Map<String, Object> data){
        System.out.println("GetProgramByKK Request Body: "+data);
        return programService.getProgramByKK(data);
    }

    @PostMapping("/GetProgramByKK")
    public String getDataProgramByKK(@RequestBody Map<String, Object> data){
        System.out.println("program"+data);
        return programService.getDataProgramByKK(data);
    }

    @PostMapping("/EditProgram")
    public String editProgram(@RequestBody Map<String, Object> data){
        System.out.println("EditProgram Request Body: "+data);
        return programService.editProgram(data);
    }

    @PostMapping("/DeleteProgram")
    public String deleteProgram(@RequestBody Map<String, Object> data){
        System.out.println("DeleteProgram Request Body: "+data);
        return programService.deleteProgram(data);
    }

    @PostMapping("/SetStatusProgram")
    public String setStatusProgram(@RequestBody Map<String, Object> data){
        System.out.println("SetStatusProgram Request Body: "+data);
        return programService.setStatusProgram(data);
    }

    @PostMapping("/GetKategoriByProgram")
    public String getDataKategoriByProgram(@RequestBody Map<String, Object> data){
//        System.out.println("kategori"+data);
        return programService.getDataKategoriByProgram(data);
    }
    @PostMapping("/CountAnggotaByKK")
    public String countAnggotaByKK(@RequestBody Map<String, Object> data){
//        System.out.println("Anggota"+data);
        return programService.countAnggotaByKK(data);
    }
    @PostMapping("/CountProgramByKK")
    public String countProgramByKK(@RequestBody Map<String, Object> data){
//        System.out.println("Program"+data);
        return programService.countProgramByKK(data);
    }
    @PostMapping("/CountMateriByKategori")
    public String countMateriByKategori(@RequestBody Map<String, Object> data){
        System.out.println("Materi"+data);
        return programService.countMateriByKategori(data);
    }
    @PostMapping("/GetKategoriKKById")
    public String getDataKategoriKKById(@RequestBody Map<String, Object> data){
        System.out.println("Materi"+data);
        return programService.getDataKategoriKKById(data);
    }
}
