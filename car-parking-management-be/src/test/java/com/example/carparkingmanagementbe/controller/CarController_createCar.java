package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.CarDto;
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
public class CarController_createCar {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createCar_code_13() throws Exception {
        CarDto carDto = new CarDto();
        carDto.setCode(null);
        carDto.setName("X7");
        carDto.setCarPlate("43A-389.92");
        carDto.setCarCompany("BMW");
        carDto.setCarType(1L);
        carDto.setCustomer(1L);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/api/car/create")
                .content(this.objectMapper.writeValueAsString(carDto))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
             .andDo(print())
             .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCar_code_14() throws Exception {
        CarDto carDto = new CarDto();
        carDto.setCode("");
        carDto.setName("X7");
        carDto.setCarPlate("43A-389.92");
        carDto.setCarCompany("BMW");
        carDto.setCarType(1L);
        carDto.setCustomer(1L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/car/create")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCar_code_15() throws Exception {
        CarDto carDto = new CarDto();
        carDto.setCode("XE-AAA");
        carDto.setName("X7");
        carDto.setCarPlate("43A-389.92");
        carDto.setCarCompany("BMW");
        carDto.setCarType(1L);
        carDto.setCustomer(1L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/car/create")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCar_name_13() throws Exception {
        CarDto carDto = new CarDto();
        carDto.setCode("XE-009");
        carDto.setName(null);
        carDto.setCarPlate("43A-389.92");
        carDto.setCarCompany("BMW");
        carDto.setCarType(1L);
        carDto.setCustomer(1L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/car/create")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCar_name_14() throws Exception {
        CarDto carDto = new CarDto();
        carDto.setCode("XE-009");
        carDto.setName("");
        carDto.setCarPlate("43A-389.92");
        carDto.setCarCompany("BMW");
        carDto.setCarType(1L);
        carDto.setCustomer(1L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/car/create")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCar_name_16() throws Exception {
        CarDto carDto = new CarDto();
        carDto.setCode("XE-009");
        carDto.setName("X");
        carDto.setCarPlate("43A-389.92");
        carDto.setCarCompany("BMW");
        carDto.setCarType(1L);
        carDto.setCustomer(1L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/car/create")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCar_name_117() throws Exception {
        CarDto carDto = new CarDto();
        carDto.setCode("XE-009");
        carDto.setName("Xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        carDto.setCarPlate("43A-389.92");
        carDto.setCarCompany("BMW");
        carDto.setCarType(1L);
        carDto.setCustomer(1L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/car/create")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCar_carPlate_13() throws Exception {
        CarDto carDto = new CarDto();
        carDto.setCode("XE-009");
        carDto.setName("X7");
        carDto.setCarPlate(null);
        carDto.setCarCompany("BMW");
        carDto.setCarType(1L);
        carDto.setCustomer(1L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/car/create")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCar_carPlate_14() throws Exception {
        CarDto carDto = new CarDto();
        carDto.setCode("XE-009");
        carDto.setName("X7");
        carDto.setCarPlate("");
        carDto.setCarCompany("BMW");
        carDto.setCarType(1L);
        carDto.setCustomer(1L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/car/create")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCar_carPlate_15() throws Exception {
        CarDto carDto = new CarDto();
        carDto.setCode("XE-009");
        carDto.setName("X7");
        carDto.setCarPlate("43A-3892");
        carDto.setCarCompany("BMW");
        carDto.setCarType(1L);
        carDto.setCustomer(1L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/car/create")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCar_carCompany_13() throws Exception {
        CarDto carDto = new CarDto();
        carDto.setCode("XE-009");
        carDto.setName("X7");
        carDto.setCarPlate("43A-389.92");
        carDto.setCarCompany(null);
        carDto.setCarType(1L);
        carDto.setCustomer(1L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/car/create")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCar_carCompany_14() throws Exception {
        CarDto carDto = new CarDto();
        carDto.setCode("XE-009");
        carDto.setName("X7");
        carDto.setCarPlate("43A-389.92");
        carDto.setCarCompany("");
        carDto.setCarType(1L);
        carDto.setCustomer(1L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/car/create")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCar_carCompany_16() throws Exception {
        CarDto carDto = new CarDto();
        carDto.setCode("XE-009");
        carDto.setName("X7");
        carDto.setCarPlate("43A-389.92");
        carDto.setCarCompany("b");
        carDto.setCarType(1L);
        carDto.setCustomer(1L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/car/create")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCar_carCompany_117() throws Exception {
        CarDto carDto = new CarDto();
        carDto.setCode("XE-009");
        carDto.setName("X7");
        carDto.setCarPlate("43A-389.92");
        carDto.setCarCompany("Xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        carDto.setCarType(1L);
        carDto.setCustomer(1L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/car/create")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCar_customer_13() throws Exception {
        CarDto carDto = new CarDto();
        carDto.setCode("XE-009");
        carDto.setName("X7");
        carDto.setCarPlate("43A-389.92");
        carDto.setCarCompany("BMW");
        carDto.setCarType(1L);
        carDto.setCustomer(null);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/car/create")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCar_carType_13() throws Exception {
        CarDto carDto = new CarDto();
        carDto.setCode("XE-009");
        carDto.setName("X7");
        carDto.setCarPlate("43A-389.92");
        carDto.setCarCompany("BMW");
        carDto.setCarType(null);
        carDto.setCustomer(1L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/car/create")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCar_18() throws Exception {
        CarDto carDto = new CarDto();
        carDto.setCode("XE-009");
        carDto.setName("X7");
        carDto.setCarPlate("43A-389.92");
        carDto.setCarCompany("BMW");
        carDto.setCarType(1L);
        carDto.setCustomer(1L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/car/create")
                        .content(this.objectMapper.writeValueAsString(carDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
