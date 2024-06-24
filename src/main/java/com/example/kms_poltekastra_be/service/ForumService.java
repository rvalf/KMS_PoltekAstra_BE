package com.example.kms_poltekastra_be.service;

import java.util.Map;

public interface ForumService {
    public String saveDataForum(Map<String, Object> data);
    public String updateDataForum(Map<String, Object> data);
    public String getDataForum(Map<String, Object> data);
    public String getDataForumByMateri(Map<String, Object> data);

    public String saveTransaksiForum(Map<String, Object> data);
}
