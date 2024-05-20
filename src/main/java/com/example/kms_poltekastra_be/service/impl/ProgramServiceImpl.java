package com.example.kms_poltekastra_be.service.impl;

import com.example.kms_poltekastra_be.repository.PolmanAstraRepository;
import com.example.kms_poltekastra_be.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProgramServiceImpl implements ProgramService {
    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    @Override
    public String getDataKKByPIC(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataKelompokKeahlianByPIC", dataList.toArray(new String[0]));
        System.out.println("GETDATA "+result);
        return result;
    }

    @Override
    public String createProgram(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_createProgram", dataList.toArray(new String[0]));
        System.out.println("CREATEPRGRM "+result);
        return result;
    }

    @Override
    public String getProgramByKK(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataProgram", dataList.toArray(new String[0]));
        System.out.println("GETDATAPRGRM "+result);
        return result;
    }
}
