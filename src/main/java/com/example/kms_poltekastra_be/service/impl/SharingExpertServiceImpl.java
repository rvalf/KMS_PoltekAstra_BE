package com.example.kms_poltekastra_be.service.impl;

import com.example.kms_poltekastra_be.repository.PolmanAstraRepository;
import com.example.kms_poltekastra_be.service.SharingExpertService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SharingExpertServiceImpl implements SharingExpertService {
    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    @Override
    public String saveDataSharing(Map<String, Object> data) {
        List<String> sharingList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            sharingList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_createSharingExpert", sharingList.toArray(new String[0]));
        System.out.println("SaveDataSharing Return Value: " + result);
        return result;
    }

    @Override
    public String saveDataSharingByMateri(Map<String, Object> data) {
        List<String> sharingList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            sharingList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataSharingByMateri", sharingList.toArray(new String[0]));
        return result;
    }
}
