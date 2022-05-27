package com.example.carparkingmanagementbe;

import com.example.carparkingmanagementbe.controller.NewsController;
import com.example.carparkingmanagementbe.dto.NewsDto;
import com.example.carparkingmanagementbe.model.NewsType;
import com.example.carparkingmanagementbe.service.Impl.NewsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NewsController_createNews {
    @Autowired
    private NewsController controller;

    @Autowired
    private NewsService service;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void createNews_code_13() throws Exception{
        NewsDto newsDto = new NewsDto();
        newsDto.setId(1L);
        newsDto.setCode("ne-0001");
        newsDto.setAuthor("Nguyễn Ngọc Long Tiên");
        newsDto.setTitle("Con gà ăn cơm tấm");
        newsDto.setDate("2022-01-01 18:00:00");
        newsDto.setDescription("Tádknsadbsahdbasgdaygsdhjabsdhjbashdjavjhgdsad");
        newsDto.setImg("img");
        newsDto.setDelFlag(true);
//        newsDto.setNewsType()


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
