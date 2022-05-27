package com.example.carparkingmanagementbe.repository;

import com.example.carparkingmanagementbe.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface    NewsRepository extends JpaRepository<News, Long> {
    @Modifying
    @Query(value = "insert into news (news.code, news.date, news.author, news.del_flag, news.title , news.img, news.description, news.id_news_type) " +
            "values(?1, ?2, ?3 , ?4 , ?5, ?6, ?7, ?8)", nativeQuery = true)
    void createNews(String code, String date, String author, Boolean delFlag, String title, String img, String description, Long idNewsType);

    @Modifying
    @Query(value = "update news" +
            " SET  news.date = ?1, news.author = ?2, news.title = ?3 ,news.img = ?4, news.description = ?5, news.id_news_type = ?6 " +
            "WHERE news.id = ?7", nativeQuery = true)
    void updateNews(String date, String author, String title, String img, String description, Long idNewsType, Long id);

    @Query(value = "select news.id, news.author, news.date, news.code, news.title, news.del_flag, news.img, news.description, news.id_news_type " +
            " from news " +
            "where news.id = ? ", nativeQuery = true)
    News findNewsById(Long id);

    //    SonNH
    @Query(value = "select news.id, news.author, news.date, news.code, news.title, news.del_flag, news.img, news.description, news.id_news_type " +
            " from news ", nativeQuery = true)
    List<News> getAllNews();

//    SonNH

}
