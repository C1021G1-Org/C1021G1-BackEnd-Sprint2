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
public class TicketController_deleteTicket {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TicketController ticketController;

    @Test
    public void deleteTicket_20() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/api/delete/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }
    @Test
    public void deleteTicket_19() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/delete/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }
    @Test
    public void deleteTicket_21() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/delete/{id}","abcd"))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }
    @Test
    public void deleteTicket_24() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .patch("/api/delete/{id}","1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());


    }
}
