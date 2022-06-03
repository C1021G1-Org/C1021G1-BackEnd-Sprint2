package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerGetAllCustomer {

    @Autowired
    private CustomerController customerController;

    @Autowired
    private MockMvc mockMvc;

    //ThangDBX kiểm tra cho list danh sách

    @Test
    public void getListCustomer_5(){
        ResponseEntity<Page<Customer>> responseEntity = customerController.getAllCustomer(21);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    @Test
    public void getListCustomer_6(){
        ResponseEntity<Page<Customer>> responseEntity = customerController.getAllCustomer(1);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(4,responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(19,responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Nguyễn Văn H" ,responseEntity.getBody().getContent().get(1).getName());
    }


    // em không kiểm tra cho trường hợp tham số rỗng ""
    //ThangDBX test cho trường hợp tham số null


    @Test
    public void searchCustomerByStartDate_1(){
        ResponseEntity<Page<Customer>> responseEntity =
                customerController.searchFull(null,"","","","",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    @Test
    public void searchCustomerByEndDate_1(){
        ResponseEntity<Page<Customer>> responseEntity =
                customerController.searchFull("",null,"","","",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    @Test
    public void searchCustomerByCode_1(){
        ResponseEntity<Page<Customer>> responseEntity =
                customerController.searchFull("","",null,"","",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    @Test
    public void searchCustomerByPhone_1(){
        ResponseEntity<Page<Customer>> responseEntity =
                customerController.searchFull("","","",null,"",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    @Test
    public void searchCustomerByIdCard_1(){
        ResponseEntity<Page<Customer>> responseEntity =
                customerController.searchFull("","","","",null,0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    //ThangDBX test cho trường hợp tham số không có trong database

    @Test
    public void searchCustomerByStartDate_3(){
        ResponseEntity<Page<Customer>> responseEntity =
                customerController.searchFull("2003-01-22","","","","",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    @Test
    public void searchCustomerByEndDate_3(){
        ResponseEntity<Page<Customer>> responseEntity =
                customerController.searchFull("","1970-11-19","","","",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    @Test
    public void searchCustomerByCode_3(){
        ResponseEntity<Page<Customer>> responseEntity =
                customerController.searchFull("","","KH-9999","","",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    @Test
    public void searchCustomerByPhone_3(){
        ResponseEntity<Page<Customer>> responseEntity =
                customerController.searchFull("","","","99999999","",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    @Test
    public void searchCustomerByIdCard_3(){
        ResponseEntity<Page<Customer>> responseEntity =
                customerController.searchFull("","","","","9999999",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    //ThangDBX test cho trường hợp tham số có trong database

    @Test
    public void searchCustomerByStartDate_4(){
        ResponseEntity<Page<Customer>> responseEntity =
                customerController.searchFull("1990-01-05","","","","",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(10,responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(20,responseEntity.getBody().getTotalElements());
    }

    @Test
    public void searchCustomerByEndDate_4(){
        ResponseEntity<Page<Customer>> responseEntity =
                customerController.searchFull("","1995-01-02","","","",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(10,responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(20,responseEntity.getBody().getTotalElements());
    }

    @Test
    public void searchCustomerByCode_4(){
        ResponseEntity<Page<Customer>> responseEntity =
                customerController.searchFull("","","KH","","",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(10,responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(20,responseEntity.getBody().getTotalElements());
    }

    @Test
    public void searchCustomerByPhone_4(){
        ResponseEntity<Page<Customer>> responseEntity =
                customerController.searchFull("","","","0308","",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(10,responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(20,responseEntity.getBody().getTotalElements());
    }

    @Test
    public void searchCustomerByIdCard_4(){
        ResponseEntity<Page<Customer>> responseEntity =
                customerController.searchFull("","","","","121",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(10,responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(20,responseEntity.getBody().getTotalElements());
    }

    //ThangDBX kiểm tra cho phương thức delete Customer
    @Test
    public void deleteCustomer_26() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/customer/delete/{id}","")
        ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteCustomer_27() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/customer/delete/{id}",99)
        ).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteCustomer_28() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/customer/delete/{id}",2)
        ).andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
