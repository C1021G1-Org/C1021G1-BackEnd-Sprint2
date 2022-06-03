package com.example.carparkingmanagementbe.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JUnitDeleteLocationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deleteLocation_1() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/location/delete/{id}",(Object) "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteLocation_2() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/location/delete/{id}",(Object) ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void deleteLocation_3() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/location/delete/{id}",(Object) "300"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteLocation_4() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/location/delete/{id}",(Object) "5"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
