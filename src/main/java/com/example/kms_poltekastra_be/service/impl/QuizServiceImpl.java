package com.example.kms_poltekastra_be.service.impl;

import com.example.kms_poltekastra_be.repository.PolmanAstraRepository;
import com.example.kms_poltekastra_be.service.QuizService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {
    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    @Override
    public String getDataQuestion(Map<String, Object> data) {
        List<String> quizList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            quizList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataQuestion", quizList.toArray(new String[0]));
        System.out.println("GetDataQuestion Return Value: " + result);
        return result;
    }

    @Override
    public String getDataResultQuiz(Map<String, Object> data) {
        List<String> quizList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            quizList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataResultQuiz", quizList.toArray(new String[0]));
        System.out.println("GetDataResultQuiz Return Value: " + result);
        return result;
    }

    @Override
    public String getDataQuiz(Map<String, Object> data) {
        List<String> quizList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            quizList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataQuiz", quizList.toArray(new String[0]));
        System.out.println("GetDataQuiz Return Value: " + result);
        return result;
    }

    @Override
    public String saveDataQuiz(Map<String, Object> data) {
        List<String> quizList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            quizList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_createQuiz", quizList.toArray(new String[0]));
        System.out.println("SaveDataQuiz Return Value: " + result);
        return result;
    }

    @Override
    public String saveTransaksiQuiz(Map<String, Object> data) {
        List<String> quizList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            quizList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_createTransaksiQuiz", quizList.toArray(new String[0]));
        System.out.println("SaveTransaksiQuiz Return Value: " + result);
        return result;
    }

    @Override
    public String saveReviewQuiz(Map<String, Object> data) {
        List<String> quizList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            quizList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_saveReviewQuiz", quizList.toArray(new String[0]));
        System.out.println("SaveReviewQuiz Return Value: " + result);
        return result;
    }

    @Override
    public String getDataTransaksiQuizById(Map<String, Object> data) {
        System.out.println("TransaksiQUiz : " + data);
        List<String> quizList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            quizList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataTransaksiQuizById", quizList.toArray(new String[0]));
        System.out.println("GetDataTransaksiQuizById Return Value: " + result);
        return result;
    }

    @Override
    public String getDataTransaksiReview(Map<String, Object> data) {
        List<String> quizList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            quizList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataTransaksiReview", quizList.toArray(new String[0]));
        System.out.println("GetDataTransaksiReview Return Value: " + result);
        return result;
    }

    @Override
    public String editDataQuiz(Map<String, Object> data) {
        List<String> quizList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            quizList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_editQuiz", quizList.toArray(new String[0]));
        return result;
    }

    @Override
    public String getDataQuizByID(Map<String, Object> data) {
        List<String> quizList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            quizList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataQuizByID", quizList.toArray(new String[0]));
        System.out.println("GetQuizByID Return Value: " + result);
        return result;
    }
}