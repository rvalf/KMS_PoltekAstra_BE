package com.example.kms_poltekastra_be.service;

import java.util.Map;

public interface KategoriProgramService {
    String getDataKategoriProgram(Map<String, Object> data);
    String createDataKategoriProgram(Map<String, Object> data);
    String editKategoriProgram(Map<String, Object> data);
}
