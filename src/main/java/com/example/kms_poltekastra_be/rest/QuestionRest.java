package com.example.kms_poltekastra_be.rest;

import com.example.kms_poltekastra_be.service.QuestionService;
import com.example.kms_poltekastra_be.service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/Questions")
public class QuestionRest {
    @Autowired
    private QuestionService questionService;

    public QuestionRest(QuestionServiceImpl questionServiceImpl)    {
        this.questionService = questionServiceImpl;
    }

    @PostMapping("/SaveDataQuestion")
    public String saveDataQuestion(@RequestBody Map<String, Object> data) {
        System.out.println("SaveDataQuestion Request Body: " + data);
        return questionService.saveDataQuestion(data);
    }

    @PostMapping("/UpdateDataQuestion")
    public String editDataQuestion(@RequestBody Map<String, Object> data){
        System.out.println("UpdateDataQuestion Request Body: "+data);
        return questionService.editDataQuestion(data);
    }
}
