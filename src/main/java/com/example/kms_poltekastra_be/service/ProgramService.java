package com.example.kms_poltekastra_be.service;

import java.util.Map;

public interface ProgramService {
    String getDataKKByPIC(Map<String, Object> data);
    String createProgram(Map<String, Object> data);
    String getProgramByKK(Map<String, Object> data);
    String editProgram(Map<String, Object> data);
    String deleteProgram(Map<String, Object> data);
    String setStatusProgram(Map<String, Object> data);
}
