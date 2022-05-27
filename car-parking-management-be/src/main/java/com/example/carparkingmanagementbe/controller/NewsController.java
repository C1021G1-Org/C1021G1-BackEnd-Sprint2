package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.NewsDto;
import com.example.carparkingmanagementbe.model.News;
import com.example.carparkingmanagementbe.service.INewsService;
import com.example.carparkingmanagementbe.service.Impl.NewsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private INewsService newsService;

    @PostMapping("/createNews")
    public ResponseEntity<?> createNews(@Valid @RequestBody NewsDto newsDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            Map<String, Object> response = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });
            response.put("error", errorMap);
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        } else {
            News news = new News();
            BeanUtils.copyProperties(newsDto, news);
            newsService.createNews(news);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
    }

    @GetMapping("/findNews/{id}")
    public ResponseEntity<News> findNewsById(@PathVariable Long id) {
        News news;
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            news = newsService.findNewsById(id);
            if (news == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(news, HttpStatus.OK);
        }

    }

    @PatchMapping("/updateNews/{id}")
    public ResponseEntity<?> updateNews(@Valid @RequestBody NewsDto newsDto, @PathVariable Long id, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {

            return new ResponseEntity<>(bindingResult.getAllErrors().get(0).getDefaultMessage(), HttpStatus.NOT_ACCEPTABLE);
        } else {
            News news = new News();
            System.out.println(newsDto);
            BeanUtils.copyProperties(newsDto, news);
            newsService.updateNews(id, news);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

    //SonNH
    @GetMapping("/list")
    public ResponseEntity<?> getAllNews() {
        List<News> newsList;
        newsList = newsService.getAll();
        if (newsList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(newsList, HttpStatus.OK);
        }

    }
//SonNH

}
