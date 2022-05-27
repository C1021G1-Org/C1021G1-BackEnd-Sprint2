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
public class TicketController_updateTicket {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TicketController ticketController;

    @Test
    public void findCustomerPersonalInfoById_1() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/customer/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
