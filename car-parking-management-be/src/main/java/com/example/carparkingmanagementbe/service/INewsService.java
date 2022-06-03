package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.dto.NewsDto;
import com.example.carparkingmanagementbe.model.News;

import java.util.List;


public interface INewsService {
    News findNewsById(Long id);
    void createNews(NewsDto newsDto);
    void updateNews(Long id, NewsDto newsDto);

    List<News> getAll();
}
