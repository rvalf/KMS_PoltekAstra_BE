package com.example.kms_poltekastra_be.service.impl;

import com.example.kms_poltekastra_be.repository.PolmanAstraRepository;
import com.example.kms_poltekastra_be.service.KKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class KKServiceImpl implements KKService {
    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    @Override
    public String getDataKK(Map<String, Object> data){
//        System.out.println("KKs : "+data);
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataKelompokKeahlian", dataList.toArray(new String[0]));
        return result;
    }


}
