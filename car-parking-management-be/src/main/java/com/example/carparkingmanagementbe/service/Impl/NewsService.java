package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.dto.NewsDto;
import com.example.carparkingmanagementbe.model.News;
import com.example.carparkingmanagementbe.repository.NewsRepository;
import com.example.carparkingmanagementbe.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements INewsService {
    @Autowired
    private NewsRepository repository;

    @Override
    public News findNewsById(Long id) {
        return repository.findNewsById(id);
    }

    @Override
    public void createNews(NewsDto newsDto) {
        repository.createNews(newsDto.getCode(), newsDto.getDate(), newsDto.getAuthor(), newsDto.getDelFlag(), newsDto.getTitle(), newsDto.getImg(), newsDto.getDescription(), newsDto.getNewsType());
    }

    @Override
    public void updateNews(Long id, NewsDto newsDto) {
        repository.updateNews(newsDto.getDate(), newsDto.getAuthor(), newsDto.getTitle(), newsDto.getImg(), newsDto.getDescription(), newsDto.getNewsType(), id);

    }

    //    SonNH
    @Override
    public List<News> getAll() {
        return repository.getAllNews();
    }
    //    SonNH

}
