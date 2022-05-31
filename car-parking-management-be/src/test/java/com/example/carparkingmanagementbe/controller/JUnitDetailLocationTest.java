package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.LocationDetailDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JUnitDetailLocationTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void detailLocation_1() throws Exception{
         this.mockMvc.perform(
                 MockMvcRequestBuilders.get("/api/location/detail/{id}",(Object) "null"))
             .andDo(print())
             .andExpect(status().is4xxClientError());
    }
    @Test
    public void detailLocation_2() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/location/detail/{id}",(Object) ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void detailLocation_3() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/location/detail/{id}",(Object) "300"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void detailLocation_4() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api/location/detail/{id}",(Object) "5"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}



