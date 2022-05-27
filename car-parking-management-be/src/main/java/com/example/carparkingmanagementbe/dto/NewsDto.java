package com.example.carparkingmanagementbe.dto;

import com.example.carparkingmanagementbe.model.NewsType;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewsDto {
    private Long id;

    @NotNull(message = "Vui lòng nhập mã bài viết")
    private String code;

    @NotNull(message = "Vui lòng nhập tên tác giả")
    @Length(min = 5, max = 50, message = "Tên tác giả phải từ 5 đến 50 kí tự")
    private String author;

    @NotNull(message = "Vui lòng nhập tiêu đề cho bài viết")
    @Size(min = 3, message = "Tên tiêu đề phải trên 3 kí tự")
    private String title;

    @NotNull(message = "Vui lòng chọn ngày")
    private String date;

    @NotNull(message = "Vui lòng nhập nội dung cho bài viết")
    @Length(min = 25, message = "Nội dung bài viết quá ngắn, Nội dung bài viết phải trên 25 kí tự")
    private String description;

    @NotNull(message = "Vui lòng chọn hình ảnh mô tả bài viết")
    private String img;

    private Boolean delFlag;

    @NotNull(message = "Vui lòng chọn loại tin tức")
    private NewsType newsType;

    public NewsDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public NewsType getNewsType() {
        return newsType;
    }

    public void setNewsType(NewsType newsType) {
        this.newsType = newsType;
    }
}
