package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.model.SignForm;
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

@AutoConfigureMockMvc
@SpringBootTest
public class AccountController_signUp {

    @Autowired
    private AccountController accountController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    SignForm signForm = new SignForm("Dang Duy Linh","DN", true,
            "2011-12-12","0980001111","dangduylinh238@gmail.com","Linh1234",
            "123456789987", 2L);

    @Test
    public void signUp_email_13() throws Exception {
        signForm.setEmail(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void signUp_email_14() throws Exception {
        signForm.setEmail("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_email_15() throws Exception {
        signForm.setEmail("new.gmail.com");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_18() throws Exception {
        signForm.setName("Dang Duy Linh");
        signForm.setAddress("DN");
        signForm.setGender(true);
        signForm.setDateOfBirth("2011-12-12");
        signForm.setPhone("0980001111");
        signForm.setEmail("dangduylinh238@gmail.com");
        signForm.setPassword("Linh1234");
        signForm.setIdCard("123456789987");
        signForm.setIdWard(2L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void signUp_password_13() throws Exception {
        signForm.setPassword(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_password_14() throws Exception {
        signForm.setPassword("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_password_15() throws Exception {
        signForm.setPassword("abcd");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_name_13() throws Exception {
        signForm.setName(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_name_14() throws Exception {
        signForm.setName("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_name_15() throws Exception {
        signForm.setName("abcd*asd");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_address_13() throws Exception {
        signForm.setAddress(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_address_14() throws Exception {
        signForm.setAddress("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_address_15() throws Exception {
        signForm.setAddress("zxcvbnmasdfghjklqwertyuiopqwertyuiopasddfgjhkdfgk");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_gender_13() throws Exception {
        signForm.setGender(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_dateOfBirth_13() throws Exception {
        signForm.setDateOfBirth(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_phone_13() throws Exception {
        signForm.setPhone(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_phone_14() throws Exception {
        signForm.setPhone("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_phone_15() throws Exception {
        signForm.setPhone("0905111222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_idCard_13() throws Exception {
        signForm.setIdCard(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_idCard_14() throws Exception {
        signForm.setIdCard("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void signUp_idCard_15() throws Exception {
        signForm.setIdCard("0905111222333");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/signUp")
                        .content(this.objectMapper.writeValueAsString(signForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


}
