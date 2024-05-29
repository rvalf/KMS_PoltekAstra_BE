package com.example.kms_poltekastra_be.service.impl;

import com.example.kms_poltekastra_be.repository.PolmanAstraRepository;
import com.example.kms_poltekastra_be.service.KategoriProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class KategoriProgramImpl implements KategoriProgramService {
    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    @Override
    public String getDataKategoriProgram(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataKategoriProgram", dataList.toArray(new String[0]));
        System.out.println("GetKategoriByProgram Return Value: "+result);
        return result;
    }

    @Override
    public String createDataKategoriProgram(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_createKategoriProgram", dataList.toArray(new String[0]));
        System.out.println("CreateKategoriProgram Return Value: "+result);
        return result;
    }

    @Override
    public String editKategoriProgram(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_editKategoriProgram", dataList.toArray(new String[0]));
        System.out.println("EditKategoriProgram Return Value: "+result);
        return result;
    }

    @Override
    public String deleteKategoriProgram(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_deleteKategoriProgram", dataList.toArray(new String[0]));
        System.out.println("DeleteKategoriProgram Return Value: "+result);
        return result;
    }

    @Override
    public String setStatusKategoriProgram(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_setStatusKategoriProgram", dataList.toArray(new String[0]));
        System.out.println("SetStatusKategoriProgram Return Value: "+result);
        return result;
    }
}
