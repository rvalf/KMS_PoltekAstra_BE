package com.example.kms_poltekastra_be.service.impl;

import com.example.kms_poltekastra_be.repository.PolmanAstraRepository;
import com.example.kms_poltekastra_be.service.PengajuanKKService;
import org.json.JSONArray;
import org.json.JSONObject;
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
    public String getDetailLampiran(Map<String, Object> data) {
        List<String> pustakaList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            pustakaList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getdetaillampiran", pustakaList.toArray(new String[0]));
        System.out.println("from Java: "+result);
        return result;
    }

    @Override
    public String saveDataAnggotaKK(Map<String, Object> data) {
        // Panggil stored procedure pertama
        System.out.println("Data : "+data);
        List<String> pustakaList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            pustakaList.add(entry.getValue().toString());
        }
        String resultAnggotaKeahlian = polmanAstraRepository.callProcedure("kms_createAnggotaKeahlian", pustakaList.toArray(new String[0]));
        System.out.println(resultAnggotaKeahlian);
        JSONArray jsonArray = new JSONArray(resultAnggotaKeahlian);
        JSONObject jsonObject = jsonArray.getJSONObject(0); // Mengambil objek pertama dari array
        int hasil = jsonObject.getInt("hasil");
        String idanggota = String.valueOf(hasil);
        System.out.println("Result for kms_createAnggotaKeahlian: " + hasil);

        // Panggil stored procedure kedua untuk setiap lampiran
        List<Map<String, String>> lampirans = (List<Map<String, String>>) data.get("lampirans");
        for (Map<String, String> lampiran : lampirans) {
            // Membuat array parameter untuk pemanggilan stored procedure kedua
            List<String> lampiranParams = new ArrayList<>();
            lampiranParams.add(idanggota);
            lampiranParams.add(lampiran.get("pus_file")); // Menambahkan nama berkas
            lampiranParams.add(data.get("creaby").toString()); // Menambahkan 'creaby'
            System.out.println(lampiranParams);
            // Memanggil stored procedure untuk setiap lampiran
            String result = polmanAstraRepository.callProcedure("kms_createLampiranKK", lampiranParams.toArray(new String[0]));
            System.out.println("Result for lampiran " + lampiran.get("pus_file") + ": " + result);
        }

        // Mengembalikan hasil dari pemanggilan stored procedure utama
        return resultAnggotaKeahlian;
    }
}
