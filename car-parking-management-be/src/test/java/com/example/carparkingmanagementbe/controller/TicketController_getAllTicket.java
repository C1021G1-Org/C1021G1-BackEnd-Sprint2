package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.model.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TicketController_getAllTicket {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private TicketController ticketController;

    @Test
    public void getAllTicket_5() {
        ResponseEntity<Page<Ticket>> responseEntity = this.ticketController.getAllTicket(5);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    @Test
    public void getAllTicket_6(){
        ResponseEntity<Page<Ticket>> responseEntity = this.ticketController.getAllTicket(0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
    }
}
