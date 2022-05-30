package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.CreateTicketDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TicketController_updateTicket {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateTicket_codeTicket_24() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setId(18L);
        createTicketDto.setCode("TK-1334");
        createTicketDto.setStartDate("2000-05-20");
        createTicketDto.setEndDate("2000-05-20");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setSumPrice(70000D);
        createTicketDto.setTicketType(1L);
        createTicketDto.setLocation(4L);
        createTicketDto.setCar(4L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/ticket/updateTime")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void updateTicket_codeTicket_19() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode(null);
        createTicketDto.setStartDate("2000-05-20");
        createTicketDto.setEndDate("2000-05-20");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setSumPrice(70000D);
        createTicketDto.setTicketType(2L);
        createTicketDto.setLocation(3L);
        createTicketDto.setCar(3L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/ticket/updateTime")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_startDateTicket_13() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("TK-1234");
        createTicketDto.setStartDate(null);
        createTicketDto.setEndDate("2000-05-20");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setSumPrice(70000D);
        createTicketDto.setTicketType(2L);
        createTicketDto.setLocation(3L);
        createTicketDto.setCar(3L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_endDateTicket_13() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("TK-1234");
        createTicketDto.setStartDate("2000-05-20");
        createTicketDto.setEndDate(null);
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setSumPrice(70000D);
        createTicketDto.setTicketType(2L);
        createTicketDto.setLocation(3L);
        createTicketDto.setCar(3L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_setImgCarInTicket_13() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("TK-1234");
        createTicketDto.setStartDate("2000-05-20");
        createTicketDto.setEndDate("2000-05-20");
        createTicketDto.setImgCarIn(null);
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setSumPrice(70000D);
        createTicketDto.setTicketType(2L);
        createTicketDto.setLocation(3L);
        createTicketDto.setCar(3L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_setImgCarOutTicket_13() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("TK-1234");
        createTicketDto.setStartDate("2000-05-20");
        createTicketDto.setEndDate("2000-05-20");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut(null);
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setSumPrice(70000D);
        createTicketDto.setTicketType(2L);
        createTicketDto.setLocation(3L);
        createTicketDto.setCar(3L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_setTimeInTicket_13() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("TK-1234");
        createTicketDto.setStartDate("2000-05-20");
        createTicketDto.setEndDate("2000-05-20");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn(null);
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setSumPrice(70000D);
        createTicketDto.setTicketType(2L);
        createTicketDto.setLocation(3L);
        createTicketDto.setCar(3L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_setTimeOutTicket_13() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("TK-1234");
        createTicketDto.setStartDate("2000-05-20");
        createTicketDto.setEndDate("2000-05-20");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut(null);
        createTicketDto.setSumPrice(70000D);
        createTicketDto.setTicketType(2L);
        createTicketDto.setLocation(3L);
        createTicketDto.setCar(3L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void createTicket_setSumPriceTicket_13() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("TK-1234");
        createTicketDto.setStartDate("2000-05-20");
        createTicketDto.setEndDate("2000-05-20");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setSumPrice(null);
        createTicketDto.setTicketType(2L);
        createTicketDto.setLocation(3L);
        createTicketDto.setCar(3L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void createTicket_setTicketTypeTicket_13() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("TK-1234");
        createTicketDto.setStartDate("2000-05-20");
        createTicketDto.setEndDate("2000-05-20");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setSumPrice(70000D);
        createTicketDto.setTicketType(null);
        createTicketDto.setLocation(3L);
        createTicketDto.setCar(3L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_setLocationTicket_13() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("TK-1234");
        createTicketDto.setStartDate("2000-05-20");
        createTicketDto.setEndDate("2000-05-20");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setSumPrice(70000D);
        createTicketDto.setTicketType(1L);
        createTicketDto.setLocation(null);
        createTicketDto.setCar(3L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void createTicket_setCarTicket_13() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("TK-1234");
        createTicketDto.setStartDate("2000-05-20");
        createTicketDto.setEndDate("2000-05-20");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setSumPrice(70000D);
        createTicketDto.setTicketType(1L);
        createTicketDto.setLocation(3L);
        createTicketDto.setCar(null);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_codeTicket_14() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("");
        createTicketDto.setStartDate("2000-05-20");
        createTicketDto.setEndDate("2000-05-20");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setSumPrice(70000D);
        createTicketDto.setTicketType(2L);
        createTicketDto.setLocation(3L);
        createTicketDto.setCar(3L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_startDateTicket_14() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("TK-1234");
        createTicketDto.setStartDate("");
        createTicketDto.setEndDate("2000-05-20");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setSumPrice(70000D);
        createTicketDto.setTicketType(2L);
        createTicketDto.setLocation(3L);
        createTicketDto.setCar(3L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_endDateTicket_14() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("TK-1234");
        createTicketDto.setStartDate("2000-05-20");
        createTicketDto.setEndDate("");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setSumPrice(70000D);
        createTicketDto.setTicketType(2L);
        createTicketDto.setLocation(3L);
        createTicketDto.setCar(3L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_setImgCarInTicket_14() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("TK-1234");
        createTicketDto.setStartDate("2000-05-20");
        createTicketDto.setEndDate("2000-05-20");
        createTicketDto.setImgCarIn("");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setSumPrice(70000D);
        createTicketDto.setTicketType(2L);
        createTicketDto.setLocation(3L);
        createTicketDto.setCar(3L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_setImgCarOutTicket_14() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("TK-1234");
        createTicketDto.setStartDate("2000-05-20");
        createTicketDto.setEndDate("2000-05-20");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setSumPrice(70000D);
        createTicketDto.setTicketType(2L);
        createTicketDto.setLocation(3L);
        createTicketDto.setCar(3L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_setTimeInTicket_14() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("TK-1234");
        createTicketDto.setStartDate("2000-05-20");
        createTicketDto.setEndDate("2000-05-20");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setSumPrice(70000D);
        createTicketDto.setTicketType(2L);
        createTicketDto.setLocation(3L);
        createTicketDto.setCar(3L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_setTimeOutTicket_14() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("TK-1234");
        createTicketDto.setStartDate("2000-05-20");
        createTicketDto.setEndDate("2000-05-20");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("");
        createTicketDto.setSumPrice(70000D);
        createTicketDto.setTicketType(2L);
        createTicketDto.setLocation(3L);
        createTicketDto.setCar(3L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_codeTicket_15() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("TK-12345");
        createTicketDto.setStartDate("2000-05-20");
        createTicketDto.setEndDate("2000-05-20");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("");
        createTicketDto.setSumPrice(70000D);
        createTicketDto.setTicketType(2L);
        createTicketDto.setLocation(3L);
        createTicketDto.setCar(3L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
