package com.example.carparkingmanagementbe;

import com.example.carparkingmanagementbe.dto.CustomerDto;
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
public class CustomerController_create {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createCustomer_name_13() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(null);
        customerDto.setPhone("0369852147");
        customerDto.setGender(true);
        customerDto.setEmail("tinh@gmail.com");
        customerDto.setIdCard("789456123");
        customerDto.setBirthday("1999-12-12");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_name_14() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("");
        customerDto.setPhone("0369852147");
        customerDto.setGender(true);
        customerDto.setEmail("tinh@gmail.com");
        customerDto.setIdCard("789456123");
        customerDto.setBirthday("1999-12-12");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_name_15() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("@# Bảo");
        customerDto.setPhone("0369852147");
        customerDto.setGender(true);
        customerDto.setEmail("tinh@gmail.com");
        customerDto.setIdCard("789456123");
        customerDto.setBirthday("1999-12-12");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_name_16() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Ba");
        customerDto.setPhone("0369852147");
        customerDto.setGender(true);
        customerDto.setEmail("tinh@gmail.com");
        customerDto.setIdCard("789456123");
        customerDto.setBirthday("1999-12-12");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_name_17() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ababababababababababababababababababababababababababababababababababababababababababababab");
        customerDto.setPhone("0369852147");
        customerDto.setGender(true);
        customerDto.setEmail("tinh@gmail.com");
        customerDto.setIdCard("789456123");
        customerDto.setBirthday("1999-12-12");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCustomer_phone_13() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Ngô Duy Bảo");
        customerDto.setPhone(null);
        customerDto.setGender(true);
        customerDto.setEmail("tinh@gmail.com");
        customerDto.setIdCard("789456123");
        customerDto.setBirthday("1999-12-12");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_phone_14() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Ngô Duy Bảo");
        customerDto.setPhone("");
        customerDto.setGender(true);
        customerDto.setEmail("tinh@gmail.com");
        customerDto.setIdCard("789456123");
        customerDto.setBirthday("1999-12-12");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_phone_15() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Ngô Duy Bảo");
        customerDto.setPhone("0987hahsb");
        customerDto.setGender(true);
        customerDto.setEmail("tinh@gmail.com");
        customerDto.setIdCard("789456123");
        customerDto.setBirthday("1999-12-12");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_phone_16() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Ngô Duy Bảo");
        customerDto.setPhone("9");
        customerDto.setGender(true);
        customerDto.setEmail("tinh@gmail.com");
        customerDto.setIdCard("789456123");
        customerDto.setBirthday("1999-12-12");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_phone_17() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Ngô Duy Bảo");
        customerDto.setPhone("098910101010");
        customerDto.setGender(true);
        customerDto.setEmail("tinh@gmail.com");
        customerDto.setIdCard("789456123");
        customerDto.setBirthday("1999-12-12");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCustomer_email_13() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ngô duy bảo");
        customerDto.setPhone("0979642710");
        customerDto.setGender(true);
        customerDto.setEmail(null);
        customerDto.setIdCard("789456123");
        customerDto.setBirthday("1999-12-12");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_email_14() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ngô duy bảo");
        customerDto.setPhone("0979642710");
        customerDto.setGender(true);
        customerDto.setEmail("");
        customerDto.setIdCard("789456123");
        customerDto.setBirthday("1999-12-12");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_email_15() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ngô duy bảo");
        customerDto.setPhone("0979642710");
        customerDto.setGender(true);
        customerDto.setEmail("11111");
        customerDto.setIdCard("789456123");
        customerDto.setBirthday("1999-12-12");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_email_17() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ngô duy bảo");
        customerDto.setPhone("0979642710");
        customerDto.setGender(true);
        customerDto.setEmail("ababababâbababadâdâdâdâdbabababababababababâbab@gmail.com");
        customerDto.setIdCard("789456123");
        customerDto.setBirthday("1999-12-12");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCustomer_idCard_13() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ngô duy bảo");
        customerDto.setPhone("0979642710");
        customerDto.setGender(true);
        customerDto.setEmail("abc@gmail.com");
        customerDto.setIdCard(null);
        customerDto.setBirthday("1999-12-12");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_idCard_14() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ngô duy bảo");
        customerDto.setPhone("0979642710");
        customerDto.setGender(true);
        customerDto.setEmail("abc@gmail.com");
        customerDto.setIdCard("");
        customerDto.setBirthday("1999-12-12");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_idCard_15() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ngô duy bảo");
        customerDto.setPhone("0979642710");
        customerDto.setGender(true);
        customerDto.setEmail("abc@gmail.com");
        customerDto.setIdCard("012345678");
        customerDto.setBirthday("1999-12-12");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_idCard_16() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ngô duy bảo");
        customerDto.setPhone("0979642710");
        customerDto.setGender(true);
        customerDto.setEmail("abc@gmail.com");
        customerDto.setIdCard("12345678");
        customerDto.setBirthday("1999-12-12");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_idCard_17() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ngô duy bảo");
        customerDto.setPhone("0979642710");
        customerDto.setGender(true);
        customerDto.setEmail("abc@gmail.com");
        customerDto.setIdCard("1234567891111");
        customerDto.setBirthday("1999-12-12");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCustomer_birthday_13() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ngô duy bảo");
        customerDto.setPhone("0979642710");
        customerDto.setGender(true);
        customerDto.setEmail("abc@gmail.com");
        customerDto.setIdCard("201705898");
        customerDto.setBirthday(null);
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_birthday_14() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ngô duy bảo");
        customerDto.setPhone("0979642710");
        customerDto.setGender(true);
        customerDto.setEmail("abc@gmail.com");
        customerDto.setIdCard("201705898");
        customerDto.setBirthday("");
        customerDto.setAddress("Đà Nẵng");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCustomer_address_13() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ngô duy bảo");
        customerDto.setPhone("0979642710");
        customerDto.setGender(true);
        customerDto.setEmail("abc@gmail.com");
        customerDto.setIdCard("201705898");
        customerDto.setBirthday("1995-10-10");
        customerDto.setAddress(null);
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_address_14() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ngô duy bảo");
        customerDto.setPhone("0979642710");
        customerDto.setGender(true);
        customerDto.setEmail("abc@gmail.com");
        customerDto.setIdCard("201705898");
        customerDto.setBirthday("1995-10-10");
        customerDto.setAddress("");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_address_17() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ngô duy bảo");
        customerDto.setPhone("0979642710");
        customerDto.setGender(true);
        customerDto.setEmail("abc@gmail.com");
        customerDto.setIdCard("201705898");
        customerDto.setBirthday("1995-10-10");
        customerDto.setAddress("64 Hà Huy Tập,alaoalaoalaoalaoalaoalaoalaoalaolâoalalalallalala");
        customerDto.setCode("KH-001");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCustomer_code_13() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ngô duy bảo");
        customerDto.setPhone("0979642710");
        customerDto.setGender(true);
        customerDto.setEmail("abc@gmail.com");
        customerDto.setIdCard("201705898");
        customerDto.setBirthday("1995-10-10");
        customerDto.setAddress("64 Hà Huy Tập");
        customerDto.setCode(null);
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_code_14() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ngô duy bảo");
        customerDto.setPhone("0979642710");
        customerDto.setGender(true);
        customerDto.setEmail("abc@gmail.com");
        customerDto.setIdCard("201705898");
        customerDto.setBirthday("1995-10-10");
        customerDto.setAddress("64 Hà Huy Tập");
        customerDto.setCode("");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_code_15() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ngô duy bảo");
        customerDto.setPhone("0979642710");
        customerDto.setGender(true);
        customerDto.setEmail("abc@gmail.com");
        customerDto.setIdCard("201705898");
        customerDto.setBirthday("1995-10-10");
        customerDto.setAddress("64 Hà Huy Tập");
        customerDto.setCode("NV-012");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createCustomer_18() throws Exception {

        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("ngô duy bảo");
        customerDto.setPhone("0979642710");
        customerDto.setGender(true);
        customerDto.setEmail("abc@gmail.com");
        customerDto.setIdCard("201705898");
        customerDto.setBirthday("1995-10-10");
        customerDto.setAddress("64 Hà Huy Tập");
        customerDto.setCode("KH-012");
        customerDto.setWard(996L);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
