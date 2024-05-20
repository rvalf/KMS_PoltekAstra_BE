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
        System.out.println("DSNNN: "+data);
        return programService.getDataKKByPIC(data);
    }

    @PostMapping("/CreateProgram")
    public String tambahProgram(@RequestBody Map<String, Object> data){
        System.out.println("PRGRM: "+data);
        return programService.createProgram(data);
    }

    @PostMapping("/GetProgramByKK")
    public String getProgramByKK(@RequestBody Map<String, Object> data){
        System.out.println("GET PRGRM: "+data);
        return programService.getProgramByKK(data);
    }
}
