package com.example.kms_poltekastra_be.service.impl;

import com.example.kms_poltekastra_be.repository.PolmanAstraRepository;
import com.example.kms_poltekastra_be.service.MateriService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MateriServiceImpl implements MateriService {
    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    @Override
    public String getDataMateri(Map<String, Object> data) {
        List<String> materiList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            materiList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataMateri", materiList.toArray(new String[0]));
        System.out.println("GetDataMateri Return Value: " + result);
        return result;
    }

    @Override
    public String getDataMateriById(Map<String, Object> data) {
        List<String> materiList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            materiList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataMateriById", materiList.toArray(new String[0]));
        System.out.println("GetDataMateriById Return Value: " + result);
        return result;
    }

    @Override
    public String getDataMateriByKategori(Map<String, Object> data) {
        List<String> materiList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            materiList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataMateriByKategori", materiList.toArray(new String[0]));
        System.out.println("GetDataMateriByKategori Return Value: " + result);
        return result;
    }

    @Override
    public String saveDataMateri(Map<String, Object> data) {
        System.out.println("Materis : " + data);
        List<String> materiList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            materiList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_createMateri", materiList.toArray(new String[0]));
        System.out.println("SaveDataMateri Return Value: " + result);
        return result;
    }

    @Override
    public String getListKategoriProgram(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataKategoriProgram", dataList.toArray(new String[0]));
        System.out.println("GetListKategoriProgram Return Value: " + result);
        return result;
    }

    @Override
    public String updateDataMateri(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_editMateri", dataList.toArray(new String[0]));
        System.out.println("EditDataMateri Return Value: " + result);
        return result;
    }

    @Override
    public String setStatusMateri(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_setStatusMateri", dataList.toArray(new String[0]));
        System.out.println("setStatusMateri Return Value: " + result);
        return result;
    }

    @Override
    public String saveProgresMateri(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_saveProgresMateri", dataList.toArray(new String[0]));
        System.out.println(("SaveProgresMateri Return Value: " + result));
        return result;
    }

    @Override
    public String updatePoinProgresMateri(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_updateMateriPoinProgress", dataList.toArray(new String[0]));
        System.out.println("UpdatePoinProgresMateri Return Value: " + result);
        return result;
    }

    @Override
    public String getProgresMateri(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getPoinProgress", dataList.toArray(new String[0]));
        System.out.println("GetProgresMateri Return Value: " + result);
        return result;
    }

    @Override
    public String saveDataSharingExpert(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_createSharingExpert", dataList.toArray(new String[0]));
        System.out.println("SaveDataSharingExpert Return Value: " + result);
        return result;
    }
}
