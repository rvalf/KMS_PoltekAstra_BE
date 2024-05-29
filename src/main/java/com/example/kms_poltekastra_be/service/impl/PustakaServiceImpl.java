package com.example.kms_poltekastra_be.service.impl;

import com.example.kms_poltekastra_be.repository.PolmanAstraRepository;
import com.example.kms_poltekastra_be.service.PustakaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PustakaServiceImpl implements PustakaService {
    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    @Override
    public String getDataPustaka(Map<String, Object> data){
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataPustaka", dataList.toArray(new String[0]));
        System.out.println("GetDataPustaka Return Value: "+result);
        return result;
    }

    @Override
    public String saveDataPustaka(Map<String, Object> data){
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_createPustaka", dataList.toArray(new String[0]));
        System.out.println("SaveDataPustaka Return Value:"+result);
        return result;
    }

    @Override
    public String editDataPustaka(Map<String, Object> data){
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_editPustaka", dataList.toArray(new String[0]));
        System.out.println("UpdateDataPustaka Return Value: "+result);
        return result;
    }

    @Override
    public String setStatusPustaka(Map<String, Object> data) {
        List<String> pustakaList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            pustakaList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_setStatusPustaka", pustakaList.toArray(new String[0]));
        System.out.println("SetStatusPustaka Return Value: "+pustakaList);
        return result;
    }
}
