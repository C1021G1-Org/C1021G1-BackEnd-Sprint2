package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.ticket.TicketDtoSearch;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import sun.security.krb5.internal.Ticket;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TicketController_getSearchTicketPge {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getSearchTicketPge_7_floor()throws Exception {
        TicketDtoSearch ticketDtoSearch = new TicketDtoSearch();
        ticketDtoSearch.setFloor(null);
        ticketDtoSearch.setTicketTypeName("");
        ticketDtoSearch.setEndDate("");
        ticketDtoSearch.setNameCustomer("");
        ticketDtoSearch.setPhoneCustomer("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/search?page=0")
                        .content(this.objectMapper.writeValueAsString(ticketDtoSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void getSearchTicketPge_7_ticketTypeName()throws Exception {
        TicketDtoSearch ticketDtoSearch = new TicketDtoSearch();
        ticketDtoSearch.setFloor("");
        ticketDtoSearch.setTicketTypeName(null);
        ticketDtoSearch.setEndDate("");
        ticketDtoSearch.setNameCustomer("");
        ticketDtoSearch.setPhoneCustomer("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/search?page=0")
                        .content(this.objectMapper.writeValueAsString(ticketDtoSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void getSearchTicketPge_7_endDate()throws Exception {
        TicketDtoSearch ticketDtoSearch = new TicketDtoSearch();
        ticketDtoSearch.setFloor("");
        ticketDtoSearch.setTicketTypeName("");
        ticketDtoSearch.setEndDate(null);
        ticketDtoSearch.setNameCustomer("");
        ticketDtoSearch.setPhoneCustomer("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/search?page=0")
                        .content(this.objectMapper.writeValueAsString(ticketDtoSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    @Test
    public void getSearchTicketPge_7_NameCustomer()throws Exception {
        TicketDtoSearch ticketDtoSearch = new TicketDtoSearch();
        ticketDtoSearch.setFloor("");
        ticketDtoSearch.setTicketTypeName("");
        ticketDtoSearch.setEndDate("");
        ticketDtoSearch.setNameCustomer(null);
        ticketDtoSearch.setPhoneCustomer("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/search?page=0")
                        .content(this.objectMapper.writeValueAsString(ticketDtoSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    @Test
    public void getSearchTicketPge_7_PhoneCustomer()throws Exception {
        TicketDtoSearch ticketDtoSearch = new TicketDtoSearch();
        ticketDtoSearch.setFloor("");
        ticketDtoSearch.setTicketTypeName("");
        ticketDtoSearch.setEndDate("");
        ticketDtoSearch.setNameCustomer("");
        ticketDtoSearch.setPhoneCustomer(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/search?page=0")
                        .content(this.objectMapper.writeValueAsString(ticketDtoSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void getSearchTicketPge_11_success()throws Exception {
        TicketDtoSearch ticketDtoSearch = new TicketDtoSearch();
        ticketDtoSearch.setFloor("");
        ticketDtoSearch.setTicketTypeName("");
        ticketDtoSearch.setEndDate("");
        ticketDtoSearch.setNameCustomer("");
        ticketDtoSearch.setPhoneCustomer("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/search?page=0")
                        .content(this.objectMapper.writeValueAsString(ticketDtoSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void getSearchTicketPge_10_PhoneCustomer()throws Exception {
        TicketDtoSearch ticketDtoSearch = new TicketDtoSearch();
        ticketDtoSearch.setFloor("");
        ticketDtoSearch.setTicketTypeName("");
        ticketDtoSearch.setEndDate("");
        ticketDtoSearch.setNameCustomer("");
        ticketDtoSearch.setPhoneCustomer("sdkjfhsedrkuhgfersoitrseo");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/search?page=0")
                        .content(this.objectMapper.writeValueAsString(ticketDtoSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
    @Test
    public void getSearchTicketPge_10_NameCustomer()throws Exception {
        TicketDtoSearch ticketDtoSearch = new TicketDtoSearch();
        ticketDtoSearch.setFloor("");
        ticketDtoSearch.setTicketTypeName("");
        ticketDtoSearch.setEndDate("");
        ticketDtoSearch.setNameCustomer("");
        ticketDtoSearch.setPhoneCustomer("sdkjfhsedrkuhgfersoitrseo");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/api/search?page=0")
                        .content(this.objectMapper.writeValueAsString(ticketDtoSearch))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

}
