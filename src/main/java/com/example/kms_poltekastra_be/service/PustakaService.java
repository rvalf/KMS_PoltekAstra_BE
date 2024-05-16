package com.example.kms_poltekastra_be.service;

import java.util.Map;

public interface PustakaService {

    public String getDataPustaka(Map<String, Object> data);
    public String saveDataPustaka(Map<String, Object> data);
    public String editDataPustaka(Map<String, Object> data);
    public String setStatusPustaka(Map<String, Object> data);
}
