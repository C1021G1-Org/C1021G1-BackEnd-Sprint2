package com.example.carparkingmanagementbe.service;

import com.example.carparkingmanagementbe.model.News;

import java.util.Optional;

public interface INewsService {
    News findNewsById(Long id);
    void createNews(News news);
    void updateNews(Long id, News news);
}
