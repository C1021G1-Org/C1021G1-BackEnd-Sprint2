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
public class EmployeeControllerCreate {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void createEmployee13_1() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail(null);
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setCode("NV-0001");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee13_2() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword(null);
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee13_3() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName(null);
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee13_4() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday(null);
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee13_5() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(null);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createEmployee13_6() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone(null);
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee13_7() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress(null);
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee13_8() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(null);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee13_9() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee13_10() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail(null);
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setCode(null);
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee14_1() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee14_2() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee14_3() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee14_4() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee14_5() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee14_6() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee14_7() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail(null);
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setCode("");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee15_1() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinhgmailcom");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee15_2() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duylinhh");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee15_3() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh@");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee15_4() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV0001");
        employeeDto.setBirthday("05-15-1993");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee15_5() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("07027392");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee15_6() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh !");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee15_7() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail(null);
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setCode("NV-001");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee16_1() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("d@a.m");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee16_2() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("dLin1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee16_3() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee16_4() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("070273923");
        employeeDto.setAddress("33 NVL ");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee17_1() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.commmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee17_2() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee17_3() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("07027392332");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee17_4() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createEmployee18() throws Exception{
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("dangduylinh@gmail.com");
        employeeDto.setPassword("duiLinh1");
        employeeDto.setName("Đặng Duy Linh");
        employeeDto.setCode("NV-0001");
        employeeDto.setBirthday("1993-05-15");
        employeeDto.setGender(false);
        employeeDto.setPhone("0702739233");
        employeeDto.setAddress("35 Nguyễn Văn Linh");
        employeeDto.setId_ward(17L);
        employeeDto.setId_position(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
