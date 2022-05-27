package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.News;
import com.example.carparkingmanagementbe.repository.NewsRepository;
import com.example.carparkingmanagementbe.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewsService implements INewsService {
    @Autowired
    private NewsRepository repository;

    @Override
    public News findNewsById(Long id) {
        return repository.findNewsById(id);
    }

    @Override
    public void createNews(News news) {
        repository.createNews(news.getCode(), news.getDate(), news.getAuthor(), news.getDelFlag(), news.getTitle(), news.getImg(), news.getDescription(), news.getNewsType().getId()    );
    }

    @Override
    public void updateNews(Long id, News news) {
        repository.updateNews(news.getDate(), news.getAuthor(), news.getTitle(), news.getImg(), news.getDescription(), news.getNewsType().getId(), id);

    }
}
