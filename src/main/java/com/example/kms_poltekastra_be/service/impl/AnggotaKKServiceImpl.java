package com.example.kms_poltekastra_be.service.impl;

import com.example.kms_poltekastra_be.repository.PolmanAstraRepository;
import com.example.kms_poltekastra_be.service.AnggotaKKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AnggotaKKServiceImpl implements AnggotaKKService {
    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    @Override
    public String getListAnggotaByKK(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getListAnggotaKeahlian", dataList.toArray(new String[0]));
        System.out.println("HASL ANGGTA"+result);
        return result;
    }

    @Override
    public String setStatusAnggota(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_setStatusAnggotaKeahlian", dataList.toArray(new String[0]));
        System.out.println("HAsl STTS"+result);
        return result;
    }

    @Override
    public String getListDosenNonAnggotaByKK(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getListDosen", dataList.toArray(new String[0]));
        System.out.println("HAsl DSN"+result);
        return result;
    }

    @Override
    public String tambahAnggotaByPIC(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_tambahAnggotaByPIC", dataList.toArray(new String[0]));
        System.out.println("HAsl TMBH"+result);
        return result;
    }
}
