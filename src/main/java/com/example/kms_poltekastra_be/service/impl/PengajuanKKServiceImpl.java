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
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getDataAnggotaKeahlian", dataList.toArray(new String[0]));
        System.out.println("GetAnggotaKK Return Value: "+result);
        return result;
    }

    @Override
    public String getDetailLampiran(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getdetaillampiran", dataList.toArray(new String[0]));
        System.out.println("GetDetailLampiran Return Value: "+result);
        return result;
    }

    @Override
    public String saveDataAnggotaKK(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }

        // Calling 1st Procedure for msanggotakeahlian
        String resultAnggotaKeahlian = polmanAstraRepository.callProcedure("kms_createAnggotaKeahlian", dataList.toArray(new String[0]));
        System.out.println("SaveAnggotaKK Return Value: "+resultAnggotaKeahlian);

        JSONArray jsonArray = new JSONArray(resultAnggotaKeahlian);
        JSONObject jsonObject = jsonArray.getJSONObject(0);
        int hasil = jsonObject.getInt("hasil");
        String idanggota = String.valueOf(hasil);

        System.out.println("SaveAnggotaKK Result ID Anggota for Lampiran: " + hasil);

        // Calling Every Procedure for mslampirananggotakeahlian
        List<Map<String, String>> lampirans = (List<Map<String, String>>) data.get("lampirans");
        for (Map<String, String> lampiran : lampirans) {
            // Membuat array parameter untuk pemanggilan stored procedure kedua
            List<String> lampiranParams = new ArrayList<>();
            lampiranParams.add(idanggota);
            lampiranParams.add(lampiran.get("pus_file")); // Menambahkan nama berkas
            lampiranParams.add(data.get("creaby").toString()); // Menambahkan 'creaby'

            System.out.println("SaveAnggotaKK Request Body Lampiran: "+lampiranParams);

            // Memanggil stored procedure untuk setiap lampiran
            String result = polmanAstraRepository.callProcedure("kms_createLampiranKK", lampiranParams.toArray(new String[0]));
            System.out.println("SaveAnggotaKK Return Value for lampiran " + lampiran.get("pus_file") + ": " + result);
        }

        // Mengembalikan hasil dari pemanggilan stored procedure utama
        return resultAnggotaKeahlian;
    }

    @Override
    public String getRiwayatPengajuan(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for(Map.Entry<String, Object>entry : data.entrySet()){
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("kms_getRiwayatPengajuan", dataList.toArray(new String[0]));
        System.out.println("GetRiwayat Return Value: "+result);
        return result;
    }
}
