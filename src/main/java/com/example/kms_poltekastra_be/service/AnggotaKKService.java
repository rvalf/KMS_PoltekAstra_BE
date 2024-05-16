package com.example.kms_poltekastra_be.service;

import java.util.Map;

public interface AnggotaKKService {
    String getListAnggotaByKK(Map<String, Object> data);
    String setStatusAnggota(Map<String, Object> data);
    String getListDosenNonAnggotaByKK(Map<String, Object> data);
    String tambahAnggotaByPIC(Map<String, Object> data);
}
