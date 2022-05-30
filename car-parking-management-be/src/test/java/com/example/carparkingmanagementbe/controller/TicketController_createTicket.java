package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.CreateTicketDto;
import com.example.carparkingmanagementbe.model.Car;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.model.Ticket;
import com.example.carparkingmanagementbe.model.TicketType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TicketController_createTicket {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createTicket_codeTicket_18() throws Exception {
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
        createTicketDto.setLocation(9L);
        createTicketDto.setCar(9L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createTicket_codeTicket_13() throws Exception {
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
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_codeTicket_15() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("12334");
        createTicketDto.setStartDate("30-05-2022");
        createTicketDto.setEndDate("30-06-2022");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setTicketType(1L);
        createTicketDto.setLocation(1L);
        createTicketDto.setCar(1L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_startDate_13() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();

        createTicketDto.setCode("TK-0001");
        createTicketDto.setStartDate(null);
        createTicketDto.setEndDate("2022-5-20");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setChecking(false);
        createTicketDto.setDelFlag(true);
        createTicketDto.setTicketType(1L);
        createTicketDto.setLocation(1L);
        createTicketDto.setCar(1L);
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(createTicketDto,ticket);
        Car car = new Car();
        car.setId(createTicketDto.getCar());
        Location location = new Location();
        location.setId(createTicketDto.getLocation());
        TicketType ticketType = new TicketType();
        ticketType.setId(createTicketDto.getTicketType());
        ticket.setCar(car);
        ticket.setLocation(location);
        ticket.setTicketType(ticketType);
        BeanUtils.copyProperties(createTicketDto,ticket);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(ticket))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_startDate_14() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();

        createTicketDto.setCode("TK-0001");
        createTicketDto.setStartDate("");
        createTicketDto.setEndDate("30-06-2022");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setChecking(false);
        createTicketDto.setDelFlag(true);
        createTicketDto.setTicketType(1L);
        createTicketDto.setLocation(1L);
        createTicketDto.setCar(1L);
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(createTicketDto,ticket);
        Car car = new Car();
        car.setId(createTicketDto.getCar());
        Location location = new Location();
        location.setId(createTicketDto.getLocation());
        TicketType ticketType = new TicketType();
        ticketType.setId(createTicketDto.getTicketType());
        ticket.setCar(car);
        ticket.setLocation(location);
        ticket.setTicketType(ticketType);
        BeanUtils.copyProperties(createTicketDto,ticket);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(ticket))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_startDate_15() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();

        createTicketDto.setCode("TK-0001");
        createTicketDto.setStartDate("30-4-2022");
        createTicketDto.setEndDate("30-06-2022");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 17:30:00");
        createTicketDto.setTimeOut("2022-05-13 17:30:00");
        createTicketDto.setChecking(false);
        createTicketDto.setDelFlag(true);
        createTicketDto.setTicketType(1L);
        createTicketDto.setLocation(1L);
        createTicketDto.setCar(1L);
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(createTicketDto,ticket);
        Car car = new Car();
        car.setId(createTicketDto.getCar());
        Location location = new Location();
        location.setId(createTicketDto.getLocation());
        TicketType ticketType = new TicketType();
        ticketType.setId(createTicketDto.getTicketType());
        ticket.setCar(car);
        ticket.setLocation(location);
        ticket.setTicketType(ticketType);
        BeanUtils.copyProperties(createTicketDto,ticket);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(ticket))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createTicket_startDate_18() throws Exception {
        CreateTicketDto createTicketDto = new CreateTicketDto();
        createTicketDto.setCode("TK-0001");
        createTicketDto.setStartDate("2022-02-12");
        createTicketDto.setEndDate("2022-03-12");
        createTicketDto.setImgCarIn("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setImgCarOut("https://otovina.net/wp-content/uploads/2021/01/lambiensodai.jpg");
        createTicketDto.setTimeIn("2022-05-13 00:00:00");
        createTicketDto.setTimeOut("2022-05-13 00:00:00");
        createTicketDto.setSumPrice(700000D);
        createTicketDto.setChecking(false);
        createTicketDto.setDelFlag(true);
        createTicketDto.setTicketType(1L);
        createTicketDto.setLocation(10L);
        createTicketDto.setCar(10L);
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(createTicketDto,ticket);
        Car car = new Car();
        car.setId(createTicketDto.getCar());
        Location location = new Location();
        location.setId(createTicketDto.getLocation());
        TicketType ticketType = new TicketType();
        ticketType.setId(createTicketDto.getTicketType());
        ticket.setCar(car);
        ticket.setLocation(location);
        ticket.setTicketType(ticketType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/ticket/create")
                        .content(this.objectMapper.writeValueAsString(createTicketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}

