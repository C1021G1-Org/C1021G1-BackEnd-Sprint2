package com.example.carparkingmanagementbe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String author;
    private String title;
    @Column(columnDefinition = "DATETIME")
    private String date;
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    @Column(columnDefinition = "LONGTEXT")
    private String img;
    private Boolean delFlag;

    @ManyToOne
    @JoinColumn(name = "id_news_type", referencedColumnName = "id")
    private NewsType newsType;
}
