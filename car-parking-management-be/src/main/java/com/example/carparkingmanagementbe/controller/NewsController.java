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
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
            newsService.createNews(newsDto);
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
            Map<String, String> errorMap = new HashMap<>();
            Map<String, Object> response = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errorMap.put(error.getField(), error.getDefaultMessage());
            });
            response.put("error", errorMap);
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }

            newsService.updateNews(id, newsDto);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
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
