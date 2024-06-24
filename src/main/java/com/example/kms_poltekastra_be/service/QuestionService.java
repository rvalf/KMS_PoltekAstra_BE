package com.example.kms_poltekastra_be.service;

import java.util.Map;

public interface QuestionService {

    //public String getDataQuestion(Map<String, Object> data);
    public String saveDataQuestion(Map<String, Object> data);
    public String editDataQuestion(Map<String, Object> data);
}
