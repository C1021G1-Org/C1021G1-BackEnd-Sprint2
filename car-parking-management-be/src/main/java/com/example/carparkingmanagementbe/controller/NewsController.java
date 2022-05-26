package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.NewsDto;
import com.example.carparkingmanagementbe.model.News;
import com.example.carparkingmanagementbe.service.Impl.NewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private NewsService service;

    @PostMapping("/createNews")
    public ResponseEntity<?> createNews(@Valid @RequestBody NewsDto newsDto, BindingResult bindingResult ) {
        if (bindingResult.hasFieldErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            Map<String, Object> response = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });
            response.put("error", errorMap);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        } else {
            News news = new News();
            BeanUtils.copyProperties(newsDto, news);
            service.createNews(news);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
    }

    @GetMapping("/findNews/{id}")
    public ResponseEntity<News> findNewsById(@PathVariable Long id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            News news = service.findNewsById(id);
            return new ResponseEntity<News>(news, HttpStatus.OK);
        }
    }

@PatchMapping("/updateNews/{id}")
public ResponseEntity<?> updateNews(@Valid @RequestBody NewsDto newsDto, @PathVariable Long id ,BindingResult bindingResult) {
    if (bindingResult.hasFieldErrors()) {
        Map<String, String> errorMap = new HashMap<>();
        Map<String, Object> response = new HashMap<>();
        bindingResult.getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        response.put("error", errorMap);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
    } else {
        News news = new News();
        System.out.println(newsDto);
        BeanUtils.copyProperties(newsDto, news);
        service.updateNews(id, news);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    }



}
