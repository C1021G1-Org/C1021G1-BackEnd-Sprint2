package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.EmployeeDto;
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
public class EmployeeControllerUpdate {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void updateEmployee19_1() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail(null);
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee19_2() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword(null);
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee19_3() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName(null);
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee19_4() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday(null);
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee19_5() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(null);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee19_6() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone(null);
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee19_7() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress(null);
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee19_8() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(null);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee19_9() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee20_1() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee20_2() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee20_3() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee20_4() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee20_5() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee20_6() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee21_1() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinhgmailcom");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee21_2() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duylinhh");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee21_3() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh@");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee21_4() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("05-15-1993");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee21_5() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("07027392");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee21_6() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh !");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee21_7() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail(null);
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee22_1() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("d@a.m");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee22_2() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("dLin1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee22_3() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee22_4() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("070273923");
        employeeDto.setAddress("33 NVL ");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee23_1() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.commmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee23_2() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee23_3() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("07027392332");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee23_4() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateEmployee24() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduyl1inh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739123");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/employee/1")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
