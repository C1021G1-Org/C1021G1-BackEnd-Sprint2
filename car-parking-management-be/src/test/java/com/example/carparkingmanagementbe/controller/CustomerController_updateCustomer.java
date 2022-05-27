package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.CustomerDtoCheck;
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
public class CustomerController_updateCustomer {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateCustomer_name_19() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName(null);
        customerDtoCheck.setBirthday("2022-02-03");
        customerDtoCheck.setIdCard("2034698745");
        customerDtoCheck.setEmail("ngobao@gmail.com");
        customerDtoCheck.setPhone("0359874619");
        customerDtoCheck.setAddress("64 Hà Huy Tập");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                .patch("/api/customer/update/1")
                .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
             .andDo(print())
             .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_name_20() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("");
        customerDtoCheck.setBirthday("2022-02-03");
        customerDtoCheck.setIdCard("2034698745");
        customerDtoCheck.setEmail("ngobao@gmail.com");
        customerDtoCheck.setPhone("0359874619");
        customerDtoCheck.setAddress("64 Hà Huy Tập");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_name_21() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("trong932");
        customerDtoCheck.setBirthday("2022-02-03");
        customerDtoCheck.setIdCard("2034698745");
        customerDtoCheck.setEmail("ngobao@gmail.com");
        customerDtoCheck.setPhone("0359874619");
        customerDtoCheck.setAddress("64 Hà Huy Tập");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_name_22() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("tron");
        customerDtoCheck.setBirthday("2022-02-03");
        customerDtoCheck.setIdCard("2034698745");
        customerDtoCheck.setEmail("ngobao@gmail.com");
        customerDtoCheck.setPhone("0359874619");
        customerDtoCheck.setAddress("64 Hà Huy Tập");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_name_23() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("tronggggggggggggggggggggggggggggggggggggggggggggggggggggg");
        customerDtoCheck.setBirthday("2022-02-03");
        customerDtoCheck.setIdCard("2034698745");
        customerDtoCheck.setEmail("ngobao@gmail.com");
        customerDtoCheck.setPhone("0359874619");
        customerDtoCheck.setAddress("64 Hà Huy Tập");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_birthday_19() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("Ngô Duy Bảo");
        customerDtoCheck.setBirthday(null);
        customerDtoCheck.setIdCard("2034698745");
        customerDtoCheck.setEmail("ngobao@gmail.com");
        customerDtoCheck.setPhone("0359874619");
        customerDtoCheck.setAddress("64 Hà Huy Tập");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_birthday_21() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("Ngô Duy Bảo");
        customerDtoCheck.setBirthday("2022-03-02");
        customerDtoCheck.setIdCard("2034698745");
        customerDtoCheck.setEmail("ngobao@gmail.com");
        customerDtoCheck.setPhone("0359874619");
        customerDtoCheck.setAddress("64 Hà Huy Tập");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_idCard_19() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("Ngô Duy Bảo");
        customerDtoCheck.setBirthday("1995-09-08");
        customerDtoCheck.setIdCard(null);
        customerDtoCheck.setEmail("ngobao@gmail.com");
        customerDtoCheck.setPhone("0359874619");
        customerDtoCheck.setAddress("64 Hà Huy Tập");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_idCard_20() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("Ngô Duy Bảo");
        customerDtoCheck.setBirthday("1995-09-08");
        customerDtoCheck.setIdCard("");
        customerDtoCheck.setEmail("ngobao@gmail.com");
        customerDtoCheck.setPhone("0359874619");
        customerDtoCheck.setAddress("64 Hà Huy Tập");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_idCard_21() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("Ngô Duy Bảo");
        customerDtoCheck.setBirthday("1995-09-08");
        customerDtoCheck.setIdCard("21039");
        customerDtoCheck.setEmail("ngobao@gmail.com");
        customerDtoCheck.setPhone("0359874619");
        customerDtoCheck.setAddress("64 Hà Huy Tập");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_email_19() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("Ngô Duy Bảo");
        customerDtoCheck.setBirthday("1995-09-08");
        customerDtoCheck.setIdCard("203469874120");
        customerDtoCheck.setEmail(null);
        customerDtoCheck.setPhone("0359874619");
        customerDtoCheck.setAddress("64 Hà Huy Tập");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_email_20() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("Ngô Duy Bảo");
        customerDtoCheck.setBirthday("1995-09-08");
        customerDtoCheck.setIdCard("203469874120");
        customerDtoCheck.setEmail("");
        customerDtoCheck.setPhone("0359874619");
        customerDtoCheck.setAddress("64 Hà Huy Tập");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_email_21() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("Ngô Duy Bảo");
        customerDtoCheck.setBirthday("1995-09-08");
        customerDtoCheck.setIdCard("203469874120");
        customerDtoCheck.setEmail("12gmail.com");
        customerDtoCheck.setPhone("0359874619");
        customerDtoCheck.setAddress("64 Hà Huy Tập");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_email_23() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("Ngô Duy Bảo");
        customerDtoCheck.setBirthday("1995-09-08");
        customerDtoCheck.setIdCard("203469874120");
        customerDtoCheck.setEmail("adsfjhfgdjnsbfkjhdsbfmsjfhbsdmfjbdsmfjmsbjskajsdakjshkfjahfhfakjsfhskfhas@gmail.com");
        customerDtoCheck.setPhone("0359874619");
        customerDtoCheck.setAddress("64 Hà Huy Tập");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_phone_19() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("Ngô Duy Bảo");
        customerDtoCheck.setBirthday("1995-09-08");
        customerDtoCheck.setIdCard("203469874120");
        customerDtoCheck.setEmail("ngobao@gmail.com");
        customerDtoCheck.setPhone(null);
        customerDtoCheck.setAddress("64 Hà Huy Tập");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_phone_20() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("Ngô Duy Bảo");
        customerDtoCheck.setBirthday("1995-09-08");
        customerDtoCheck.setIdCard("203469874120");
        customerDtoCheck.setEmail("ngobao@gmail.com");
        customerDtoCheck.setPhone("");
        customerDtoCheck.setAddress("64 Hà Huy Tập");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_phone_21() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("Ngô Duy Bảo");
        customerDtoCheck.setBirthday("1995-09-08");
        customerDtoCheck.setIdCard("203469874120");
        customerDtoCheck.setEmail("ngobao@gmail.com");
        customerDtoCheck.setPhone("098263");
        customerDtoCheck.setAddress("64 Hà Huy Tập");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_address_19() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("Ngô Duy Bảo");
        customerDtoCheck.setBirthday("1995-09-08");
        customerDtoCheck.setIdCard("203469874120");
        customerDtoCheck.setEmail("ngobao@gmail.com");
        customerDtoCheck.setPhone("0359874611");
        customerDtoCheck.setAddress(null);
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_address_20() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("Ngô Duy Bảo");
        customerDtoCheck.setBirthday("1995-09-08");
        customerDtoCheck.setIdCard("203469874120");
        customerDtoCheck.setEmail("ngobao@gmail.com");
        customerDtoCheck.setPhone("0359874611");
        customerDtoCheck.setAddress("");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_address_22() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("Ngô Duy Bảo");
        customerDtoCheck.setBirthday("1995-09-08");
        customerDtoCheck.setIdCard("203469874120");
        customerDtoCheck.setEmail("ngobao@gmail.com");
        customerDtoCheck.setPhone("0359874611");
        customerDtoCheck.setAddress("aaaa");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_address_23() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("Ngô Duy Bảo");
        customerDtoCheck.setBirthday("1995-09-08");
        customerDtoCheck.setIdCard("203469874120");
        customerDtoCheck.setEmail("ngobao@gmail.com");
        customerDtoCheck.setPhone("0359874611");
        customerDtoCheck.setAddress("đông tây nam đông đông đông đông đông đông đông đông đông đông đông");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_gender_19() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("Ngô Duy Bảo");
        customerDtoCheck.setBirthday("1995-09-08");
        customerDtoCheck.setIdCard("203469874120");
        customerDtoCheck.setEmail("ngobao@gmail.com");
        customerDtoCheck.setPhone("0359874611");
        customerDtoCheck.setAddress("64 Hà Huy Tập");
        customerDtoCheck.setGender(null);
        customerDtoCheck.setWard(966L);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateCustomer_ward_19() throws Exception {
        CustomerDtoCheck customerDtoCheck = new CustomerDtoCheck();
        customerDtoCheck.setId(1L);
        customerDtoCheck.setCode("KH-001");
        customerDtoCheck.setName("Ngô Duy Bảo");
        customerDtoCheck.setBirthday("1995-09-08");
        customerDtoCheck.setIdCard("203469874120");
        customerDtoCheck.setEmail("ngobao@gmail.com");
        customerDtoCheck.setPhone("0359874611");
        customerDtoCheck.setAddress("64 Hà Huy Tập");
        customerDtoCheck.setGender(true);
        customerDtoCheck.setWard(null);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .patch("/api/customer/update/1")
                        .content(this.objectMapper.writeValueAsString(customerDtoCheck))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
