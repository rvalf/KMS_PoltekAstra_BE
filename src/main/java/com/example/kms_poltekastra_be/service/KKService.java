package com.example.kms_poltekastra_be.service;

import java.util.Map;

public interface KKService {
    String getDataKK(Map<String, Object> data);
    String getDataKKbyID(Map<String, Object> data);
    String getListProdi(Map<String, Object> data);
    String getListKaryawan(Map<String, Object> data);
    String createKK(Map<String, Object> data);
    String editKK(Map<String, Object> data);
    String deleteKK(Map<String, Object> data);
    String setStatusKK(Map<String, Object> data);
}
