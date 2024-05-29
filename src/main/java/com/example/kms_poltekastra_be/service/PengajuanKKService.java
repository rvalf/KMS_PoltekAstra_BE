package com.example.kms_poltekastra_be.service;

import java.util.Map;

public interface PengajuanKKService {
    String getDataAnggotaKK(Map<String, Object> data);
    String getDetailLampiran(Map<String, Object> data);
    String saveDataAnggotaKK(Map<String, Object> data);
    String getRiwayatPengajuan(Map<String, Object> data);
}
