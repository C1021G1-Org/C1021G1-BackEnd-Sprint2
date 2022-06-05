package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.News;
import com.example.carparkingmanagementbe.model.NewsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface NewsTypeRepository extends JpaRepository<NewsType, Long> {
    @Query(value = "SELECT  news_type.id, news_type.name from news_type", nativeQuery = true)
    List<NewsType> getAllNewsType();
}
