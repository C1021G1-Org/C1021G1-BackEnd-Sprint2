package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.EmployeeDto;
import com.example.carparkingmanagementbe.model.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerCreate {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void createEmployee13_1() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("ddlinh@gmail.com");
                "password": "duiLinh1",
                "name": "Đặng Duy Linh",
                "birthday": "1993-05-15",
                "gender": false,
                "phone": "0702739233",
                "address": "35 Nguyễn Văn Linh",
                "delFlag": true,
                "id_ward": 17,
                "id_position": 2
    }
}
