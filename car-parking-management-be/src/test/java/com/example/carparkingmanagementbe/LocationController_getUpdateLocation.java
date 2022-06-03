package com.example.carparkingmanagementbe;

import com.example.carparkingmanagementbe.dto.LocationDto;
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
public class LocationController_getUpdateLocation {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void updateLocation_Location_19() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setCode(null);
        locationDto.setNumber(null);
        locationDto.setDescription(null);
        locationDto.setHeight(null);
        locationDto.setLength(null);
        locationDto.setWidth(null);
        locationDto.setId_floor(null);
        locationDto.setId_allowedCarParkingSet(null);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/location/update/2")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateLocation_Location_20() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setCode("");
        locationDto.setNumber(1L);
        locationDto.setDescription("");
        locationDto.setHeight(3.0);
        locationDto.setLength(5.5);
        locationDto.setWidth(2.4);
        locationDto.setId_floor(1L);
        locationDto.setId_allowedCarParkingSet("");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/location/update/2")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateLocation_codeLocation_21_1() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setCode("AC-B1");
        locationDto.setNumber(1L);
        locationDto.setDescription(null);
        locationDto.setHeight(3.0);
        locationDto.setLength(5.5);
        locationDto.setWidth(2.4);
        locationDto.setId_floor(1L);
        locationDto.setId_allowedCarParkingSet("1,2");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/location/update/2")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateLocation_numberLocation_21_2() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setCode("A-1");
        locationDto.setNumber(0L);
        locationDto.setDescription(null);
        locationDto.setHeight(3.0);
        locationDto.setLength(5.5);
        locationDto.setWidth(2.4);
        locationDto.setId_floor(1L);
        locationDto.setId_allowedCarParkingSet("1,2");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/location/update/2")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateLocation_heightLocation_21_3() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setCode("A-2");
        locationDto.setNumber(3L);
        locationDto.setDescription("Xe 9 chỗ");
        locationDto.setHeight(null);
        locationDto.setLength(5.5);
        locationDto.setWidth(2.4);
        locationDto.setId_floor(1L);
        locationDto.setId_allowedCarParkingSet("4");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/location/update/2")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateLocation_lengthLocation_21_4() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setCode("A-2");
        locationDto.setNumber(3L);
        locationDto.setDescription("Xe 9 chỗ");
        locationDto.setHeight(3.0);
        locationDto.setLength(null);
        locationDto.setWidth(2.4);
        locationDto.setId_floor(1L);
        locationDto.setId_allowedCarParkingSet("4");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/location/update/2")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateLocation_withLocation_21_5() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setCode("A-2");
        locationDto.setNumber(3L);
        locationDto.setDescription("Xe 9 chỗ");
        locationDto.setHeight(3.0);
        locationDto.setLength(5.5);
        locationDto.setWidth(null);
        locationDto.setId_floor(1L);
        locationDto.setId_allowedCarParkingSet("4");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/location/update/2")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateLocation_Location_22() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setCode("");
        locationDto.setNumber(-1L);
        locationDto.setDescription(null);
        locationDto.setHeight(3.0);
        locationDto.setLength(5.5);
        locationDto.setWidth(2.4);
        locationDto.setId_floor(1L);
        locationDto.setId_allowedCarParkingSet("1,2");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/location/update/2")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFlight_codeFlight_23() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setCode("");
        locationDto.setNumber(100L);
        locationDto.setDescription(null);
        locationDto.setHeight(3.0);
        locationDto.setLength(5.5);
        locationDto.setWidth(2.4);
        locationDto.setId_floor(1L);
        locationDto.setId_allowedCarParkingSet("1,2");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/location/update/2")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateFlight_fromFlight_24() throws Exception {
        LocationDto locationDto = new LocationDto();
        locationDto.setCode("A-1");
        locationDto.setNumber(1L);
        locationDto.setDescription(null);
        locationDto.setHeight(11.0);
        locationDto.setLength(11.5);
        locationDto.setWidth(2.4);
        locationDto.setId_floor(1L);
        locationDto.setId_allowedCarParkingSet("1,2");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/location/update/2")
                        .content(this.objectMapper.writeValueAsString(locationDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
