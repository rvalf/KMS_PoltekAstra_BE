package com.example.kms_poltekastra_be.service.impl;

import com.example.kms_poltekastra_be.repository.PolmanAstraRepository;
import com.example.kms_poltekastra_be.service.QuestionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    @Override
    public String saveDataQuestion(Map<String, Object> data) {
        List<String> questionList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            // Verifikasi bahwa nilai tidak null sebelum mengonversi ke String
            if (entry.getValue() != null) {
                questionList.add(entry.getValue().toString());
            } else {
                // Tindakan yang sesuai jika nilai null, seperti memberikan nilai default atau melewatkan nilai ini
                questionList.add(null);
            }
        }
        String result = polmanAstraRepository.callProcedure("kms_createQuestion", questionList.toArray(new String[0]));
        System.out.println("SaveDataQuestion Return Value: " + result);
        return result;
    }

    @Override
    public String editDataQuestion(Map<String, Object> data) {
        List<String> questionList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            // Verifikasi bahwa nilai tidak null sebelum mengonversi ke String
            if (entry.getValue() != null) {
                questionList.add(entry.getValue().toString());
            } else {
                // Tindakan yang sesuai jika nilai null, seperti memberikan nilai default atau melewatkan nilai ini
                questionList.add(null);
            }
        }
        String result = polmanAstraRepository.callProcedure("kms_editQuestion", questionList.toArray(new String[0]));
        System.out.println("UpdateDataQuestion Return Value: " + result);
        return result;
    }
}
