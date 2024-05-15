package com.example.kms_poltekastra_be.service;

import java.util.Map;

public interface KKService {
    public String getDataKK(Map<String, Object> data);
    public String getDataKKbyID(Map<String, Object> data);
    public String getListProdi(Map<String, Object> data);
    public String getListKaryawan(Map<String, Object> data);
    public String createKK(Map<String, Object> data);
}
