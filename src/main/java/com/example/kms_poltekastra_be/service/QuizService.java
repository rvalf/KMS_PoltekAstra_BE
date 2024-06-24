package com.example.kms_poltekastra_be.service;

import java.util.Map;

public interface QuizService {

    public String getDataQuestion(Map<String, Object> data);
    public String getDataResultQuiz(Map<String, Object> data);
    public String getDataQuiz(Map<String, Object> data);
    public String getDataQuizByID(Map<String, Object> data);
    public String getDataTransaksiQuizById(Map<String, Object> data);
    public String getDataTransaksiReview(Map<String, Object> data);
    public String saveDataQuiz(Map<String, Object> data);
    public String saveTransaksiQuiz(Map<String, Object> data);
    public String saveReviewQuiz(Map<String, Object> data);
    public String editDataQuiz(Map<String, Object> data);
}
