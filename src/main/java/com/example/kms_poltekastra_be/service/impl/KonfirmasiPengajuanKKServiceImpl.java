package com.example.kms_poltekastra_be.service.impl;

import com.example.kms_poltekastra_be.repository.PolmanAstraRepository;
import com.example.kms_poltekastra_be.service.KonfirmasiPengajuanKKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class KonfirmasiPengajuanKKServiceImpl implements KonfirmasiPengajuanKKService {
    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    @Override
    public String konfirmasiPengajuanKK(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_konfirmasiPengajuanKK", dataList.toArray(new String[0]));
        return result;
    }
}
