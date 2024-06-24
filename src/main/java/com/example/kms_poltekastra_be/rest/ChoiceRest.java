package com.example.kms_poltekastra_be.rest;

import com.example.kms_poltekastra_be.service.ChoiceService;
import com.example.kms_poltekastra_be.service.impl.ChoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/Choices")
public class ChoiceRest {
    @Autowired
    private ChoiceService choiceService;

    public ChoiceRest(ChoiceServiceImpl choiceServiceImpl) {
        this.choiceService = choiceServiceImpl;
    }

    @PostMapping("/SaveDataChoice")
    public String saveDataChoice(@RequestBody Map<String, Object> data) {
        System.out.println("SaveDataChoice Request Body: " + data);
        return choiceService.saveDataChoice(data);
    }

    @PostMapping("/UpdateDataChoice")
    public String editDataChoice(@RequestBody Map<String, Object> data) {
        System.out.println("UpdateDataChoice Request Body: " + data);
        return choiceService.editDataChoice(data);
    }
}
