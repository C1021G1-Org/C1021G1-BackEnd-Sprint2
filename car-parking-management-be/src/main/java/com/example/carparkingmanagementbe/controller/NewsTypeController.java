package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.model.NewsType;
import com.example.carparkingmanagementbe.service.INewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/newsType")
public class NewsTypeController {
    @Autowired
    private INewsTypeService service;

    @GetMapping("/newsType")
    public ResponseEntity<List<NewsType>> getAllNewsType(){
        List<NewsType> newsTypeList = service.getAllNewsType();
        if(newsTypeList == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(newsTypeList, HttpStatus.OK);
        }
    }

}
