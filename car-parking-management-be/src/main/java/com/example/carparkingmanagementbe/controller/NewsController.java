package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.model.News;
import com.example.carparkingmanagementbe.service.Impl.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private NewsService service;

    @PostMapping("/createNews")
    public ResponseEntity<?> createNews(@RequestBody News news){
        service.createNews(news);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
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
    public ResponseEntity<?> updateNews(@PathVariable Long id, @RequestBody News news) {
        if (news == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            service.updateNews(id, news);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }



}
