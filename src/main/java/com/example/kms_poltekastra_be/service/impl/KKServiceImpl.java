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
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataKelompokKeahlian", dataList.toArray(new String[0]));
        System.out.println("GetDataKK Return Value: " + result);
        return result;
    }

    @Override
    public String getDataKKbyID(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataKelompokKeahlianById", dataList.toArray(new String[0]));
        System.out.println("GetDataKKByID Return Value: "+result);
        return result;
    }

    @Override
    public String getListProdi(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getListProdi", dataList.toArray(new String[0]));
        System.out.println("GetListProdi Return Value: " + result);
        return result;
    }

    @Override
    public String getListKaryawan(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getListKaryawan", dataList.toArray(new String[0]));
        System.out.println("GetListKaryawan Return Value: "+ result);
        return result;
    }

    @Override
    public String createKK(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_createKelompokKeahlian", dataList.toArray(new String[0]));
        System.out.println("CreateKK Return Value: "+result);
        return result;
    }

    @Override
    public String editKK(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_editKelompokKeahlian", dataList.toArray(new String[0]));
        System.out.println("EditKK Return Value: "+result);
        return result;
    }

    @Override
    public String deleteKK(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_deleteKelompokKeahlian", dataList.toArray(new String[0]));
        System.out.println("DeleteKK Return Value: "+result);
        return result;
    }

    @Override
    public String setStatusKK(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_setStatusKelompokKeahlian", dataList.toArray(new String[0]));
        System.out.println("SetStatusKK Return Value: "+result);
        return result;
    }

    @Override
    public String getDataKKbyProdi(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataKelompokKeahlianByProdi", dataList.toArray(new String[0]));
        System.out.println("GetDataKKbyProdi Return Value: "+result);
        return result;
    }
}
