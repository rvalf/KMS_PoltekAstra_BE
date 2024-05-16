package com.example.kms_poltekastra_be.service.impl;

import com.example.kms_poltekastra_be.repository.PolmanAstraRepository;
import com.example.kms_poltekastra_be.service.PICKKService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PICKKServiceImpl implements PICKKService {
    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    @Override
    public String getKKByProdi(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object> entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataPICKelompokKeahlian", dataList.toArray(new String[0]));
        return result;
    }
}