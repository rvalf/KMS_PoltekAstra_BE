package com.example.kms_poltekastra_be.rest;

import com.example.kms_poltekastra_be.service.ForumService;
import com.example.kms_poltekastra_be.service.impl.ForumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/Forum")
public class ForumRest {
    @Autowired
    private ForumService forumService;

    public ForumRest(ForumServiceImpl forumServiceImpl){
        this.forumService = forumServiceImpl;
    }

    @PostMapping("/SaveDataForum")
    public String saveDataForum(@RequestBody Map<String, Object> data){
        System.out.println("SaveDataForum Request Body: "+data);
        return forumService.saveDataForum(data);
    }
    @PostMapping("/EditDataForum")
    public String editDataForum(@RequestBody Map<String, Object> data){
        System.out.println("EditDataForum Request Body: "+data);
        return forumService.updateDataForum(data);
    }

    @PostMapping("/GetDataForum")
    public String getDataForum(@RequestBody Map<String, Object> data){
        System.out.println("GetDataForum Request Body: "+data);
        return forumService.getDataForum(data);
    }
    @PostMapping("/GetDataForumByMateri")
    public String getDataForumByMateri(@RequestBody Map<String, Object> data){
        System.out.println("GetDataForumByMateri Request Body: "+data);
        return forumService.getDataForumByMateri(data);
    }

    @PostMapping("/SaveTransaksiForum")
    public String saveTransaksiForum(@RequestBody Map<String, Object> data){
        System.out.println("SaveTransaksiForum Request Body: "+data);
        return forumService.saveTransaksiForum(data);
    }
}
