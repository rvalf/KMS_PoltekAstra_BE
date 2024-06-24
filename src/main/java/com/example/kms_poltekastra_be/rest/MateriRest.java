package com.example.kms_poltekastra_be.rest;

import com.example.kms_poltekastra_be.service.MateriService;
import com.example.kms_poltekastra_be.service.impl.MateriServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/Materis")
public class MateriRest {
    @Autowired
    private MateriService materiService;

    public MateriRest(MateriServiceImpl materiServiceImpl) {
        this.materiService = materiServiceImpl;
    }

    @PostMapping("/GetDataMateri")
    public String getDataMateri(@RequestBody Map<String, Object> data) {
        System.out.println("GetDataMateri Request Body: " + data);
        return materiService.getDataMateri(data);
    }

    @PostMapping("/GetDataMateriById")
    public String getDataMateriById(@RequestBody Map<String, Object> data) {
        System.out.println("GetDataMateriById Request Body: " + data);
        return materiService.getDataMateriById(data);
    }

    @PostMapping("/GetDataMateriByKategori")
    public String getDataMateriByKategori(@RequestBody Map<String, Object> data) {
        System.out.println("GetDataMateriByKategori Request Body: " + data);
        return materiService.getDataMateriByKategori(data);
    }

    @CrossOrigin
    @PostMapping("/SaveDataMateri")
    public String saveDataMateri(@RequestBody Map<String, Object> data) {
        System.out.println("SaveDataMateri Request Body: " + data);
        return materiService.saveDataMateri(data);
    }

    @PostMapping("/SaveDataSharingExpert")
    public String saveDataSharingExpert(@RequestBody Map<String, Object> data) {
        System.out.println("SaveDataSharingExpert Request Body: " + data);
        return materiService.saveDataSharingExpert(data);
    }

    @PostMapping("/EditDataMateri")
    public String editDataMateri(@RequestBody Map<String, Object> data) {
        System.out.println("EditDataMateri Request Body: " + data);
        return materiService.updateDataMateri(data);
    }

    @PostMapping("/GetListKategoriProgram")
    public String getListKategoriProgram(@RequestBody Map<String, Object> data) {
        System.out.println("GetListKategoriProgram Request Body: " + data);
        return materiService.getListKategoriProgram(data);
    }

    @CrossOrigin
    @PostMapping("/SaveProgresMateri")
    public String saveProgresMateri(@RequestBody Map<String, Object> data) {
        System.out.println("SaveProgresMateri Request Body: " + data);
        return materiService.saveProgresMateri(data);
    }

    @CrossOrigin
    @PostMapping("/UpdatePoinProgresMateri")
    public String updatePoinProgresMateri(@RequestBody Map<String, Object> data) {
        System.out.println("UpdatePoinProgresMateri Request Body: " + data);
        return materiService.updatePoinProgresMateri(data);
    }

    @PostMapping("/setStatusMateri")
    public String setStatusMateri(@RequestBody Map<String, Object> data) {
        System.out.println("setStatusMateri Request Body: " + data);
        return materiService.setStatusMateri(data);
    }

    @PostMapping("/GetProgresMateri")
    public String getProgresMateri(@RequestBody Map<String, Object> data) {
        System.out.println("GetProgresMateri Request Body: " + data);
        return materiService.getProgresMateri(data);
    }

}
