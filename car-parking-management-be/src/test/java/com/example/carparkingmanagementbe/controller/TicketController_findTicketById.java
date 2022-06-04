package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.model.Ticket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TicketController_findTicketById {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TicketController ticketController;

    @Test
    public void findTicketById_1() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/edit/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findTicketById_2() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/edit/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findTicketById_3() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/edit/{id}", "12"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findTicketById_4() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/edit/{id}","1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.id").value(1L))
//                .andExpect(jsonPath("$.code").value("TK-0001"))
//                .andExpect(jsonPath("$.ticket.customer.name").value("Trần Lê"))
//                .andExpect(jsonPath("$.ticket.car.car_plate").value(null))
//                .andExpect(jsonPath("$.ticket.customer.phone").value("0906456789"))
//                .andExpect(jsonPath("$.ticket.startDate").value("2022-05-01"))
//                .andExpect(jsonPath("$.ticket.endDate").value("2022-05-02"))
//                .andExpect(jsonPath("$.ticket.floor.name").value("1"))
//                .andExpect(jsonPath("$.ticket.location.number").value(1))
//                .andExpect(jsonPath("$.ticket.sumPrice").value(2000000.0))
//                .andExpect(jsonPath("$.ticket.ticket_type.id").value(1L))
////                Ngày gia hạn của lần gia hạn vé tiếp theo
//                .andExpect(jsonPath("$.ticket.endDate").value("2022-05-02"))
        ;

    }

}
