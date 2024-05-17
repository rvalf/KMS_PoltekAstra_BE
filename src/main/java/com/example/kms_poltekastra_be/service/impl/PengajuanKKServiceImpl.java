package com.example.kms_poltekastra_be.service.impl;

import com.example.kms_poltekastra_be.repository.PolmanAstraRepository;
import com.example.kms_poltekastra_be.service.PengajuanKKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PengajuanKKServiceImpl implements PengajuanKKService {

    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    @Override
    public String getDataAnggotaKK(Map<String, Object> data) {
        List<String> pustakaList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            pustakaList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataAnggotaKeahlian", pustakaList.toArray(new String[0]));
//        System.out.println("from Java: "+pustakaList);
        return result;
    }

    @Override
    public String saveDataAnggotaKK(Map<String, Object> data) {
        List<String> pustakaList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            pustakaList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_createAnggotaKeahlian", pustakaList.toArray(new String[0]));
        System.out.println("akk Java: "+pustakaList);
        return result;
    }
}
