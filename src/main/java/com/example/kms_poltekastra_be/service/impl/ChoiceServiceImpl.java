package com.example.kms_poltekastra_be.service.impl;

import com.example.kms_poltekastra_be.repository.PolmanAstraRepository;
import com.example.kms_poltekastra_be.service.ChoiceService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ChoiceServiceImpl implements ChoiceService {
    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    @Override
    public String saveDataChoice(Map<String, Object> data) {
        List<String> choiceList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            choiceList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_createChoice", choiceList.toArray(new String[0]));
        System.out.println("SaveDataChoice Return Value: " + result);
        return result;
    }

    @Override
    public String editDataChoice(Map<String, Object> data) {
        List<String> choiceList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            choiceList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_editChoice", choiceList.toArray(new String[0]));
        System.out.println("UpdateDataChoice Return Value: " + result);
        return result;
    }
}
