package com.example.carparkingmanagementbe.service.Impl;

import com.example.carparkingmanagementbe.model.NewsType;
import com.example.carparkingmanagementbe.repository.NewsTypeRepository;
import com.example.carparkingmanagementbe.service.INewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsTypeService implements INewsTypeService {
    @Autowired
    NewsTypeRepository repository;

    @Override
    public List<NewsType> getAllNewsType() {
        return repository.getAllNewsType();
    }
}
