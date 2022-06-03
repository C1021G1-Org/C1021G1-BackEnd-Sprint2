package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.TicketDto;
import com.example.carparkingmanagementbe.model.Location;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
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
public class TicketController_updateTicket {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    private final String PATCH_UPDATE_URL = "/api/update";

    // Test t/h null cho tổng giá tiền
    @Test
    public void updateTicket_sumPrice_19() throws Exception{
        TicketDto ticketDto = new TicketDto();

        ticketDto.setId(1L);
        ticketDto.setLocation(1L);
        ticketDto.setSumPrice(null);
        ticketDto.setTicketType(1L);
        ticketDto.setEndDate("2022-05-02");

        this.mockMvc.perform(MockMvcRequestBuilders
                .patch(PATCH_UPDATE_URL)
                .content(this.objectMapper.writeValueAsString(ticketDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }


    // Test t/h đúng tổng giá tiền. Ở đây e chọn loại vé 2L là vé tháng thì tổng số tiền cùng với ngày gia hạn sẽ cập nhật theo.
    @Test
    public void updateTicket_sumPrice_24() throws Exception{
        TicketDto ticketDto = new TicketDto();


        ticketDto.setId(1L);
        ticketDto.setLocation(1L);
        ticketDto.setSumPrice(300000.0);
        ticketDto.setTicketType(2L);
        ticketDto.setEndDate("2022-06-30");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch(PATCH_UPDATE_URL)
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
// Test t/h null cho loại vé
    @Test
    public void updateTicket_ticketType_19() throws Exception{
        TicketDto ticketDto = new TicketDto();

        ticketDto.setId(1L);
        ticketDto.setLocation(2L);
        ticketDto.setSumPrice(200000.0);
        ticketDto.setTicketType(null);
        ticketDto.setEndDate("2022-06-30");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch(PATCH_UPDATE_URL)
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

// Test t/h đúng cho loại vé
@Test
public void updateTicket_ticketType_24() throws Exception{
    TicketDto ticketDto = new TicketDto();

    ticketDto.setId(1L);
    ticketDto.setLocation(1L);
    ticketDto.setSumPrice(3000000.0);
    ticketDto.setTicketType(2L);
    ticketDto.setEndDate("2022-06-30");

    this.mockMvc.perform(MockMvcRequestBuilders
                    .patch(PATCH_UPDATE_URL)
                    .content(this.objectMapper.writeValueAsString(ticketDto))
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
            ).andDo(print())
            .andExpect(status().is2xxSuccessful());

}

// Test trường hợp null cho location
    @Test
    public void updateTicket_location_19() throws Exception{
        TicketDto ticketDto = new TicketDto();

        ticketDto.setId(1L);
        ticketDto.setLocation(null);
        ticketDto.setSumPrice(2000000.0);
        ticketDto.setTicketType(2L);
        ticketDto.setEndDate("2022-06-28");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch(PATCH_UPDATE_URL)
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is4xxClientError());

}
// Test t/h đúng cho location
    @Test
    public void updateTicket_location_24() throws Exception{
        TicketDto ticketDto = new TicketDto();

        ticketDto.setId(1L);
        ticketDto.setLocation(1L);
        ticketDto.setSumPrice(2000000.0);
        ticketDto.setTicketType(2L);
        ticketDto.setEndDate("2022-06-30");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch(PATCH_UPDATE_URL)
                        .content(this.objectMapper.writeValueAsString(ticketDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
