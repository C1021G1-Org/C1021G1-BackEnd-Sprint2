package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.LocationList;
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
public class LocationListAndSearch {
    @Autowired
    private LocationController locationController;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getListLocation_1_id() {
        ResponseEntity<Page<LocationList>> responseEntity = this.locationController.getAllLocation("",null,0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }
    @Test
    public void getListLocation_2_id() {
        ResponseEntity<Page<LocationList>> responseEntity = this.locationController.getAllLocation(""," ",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    @Test
    public void getListLocation_3_id() {
        ResponseEntity<Page<LocationList>> responseEntity = this.locationController.getAllLocation("","11",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }
    @Test
    public void getListLocation_4_id() {
        ResponseEntity<Page<LocationList>> responseEntity = this.locationController.getAllLocation("A","1",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
    }
    @Test
    public void getListLocation_1_code() {
        ResponseEntity<Page<LocationList>> responseEntity = this.locationController.getAllLocation(null,"",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }
    @Test
    public void getListLocation_2_code() {
        ResponseEntity<Page<LocationList>> responseEntity = this.locationController.getAllLocation(" "," ",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }

    @Test
    public void getListLocation_3_code() {
        ResponseEntity<Page<LocationList>> responseEntity = this.locationController.getAllLocation("sdadad","11",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }
    @Test
    public void getListLocation_4_code() {
        ResponseEntity<Page<LocationList>> responseEntity = this.locationController.getAllLocation("A","",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
    }
    @Test
    public void getListLocation_4_code_id() {
        ResponseEntity<Page<LocationList>> responseEntity = this.locationController.getAllLocation("A","1",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
    }

    @Test
    public void getListLocation_5() {
        ResponseEntity<Page<LocationList>> responseEntity = this.locationController.getAllLocation("","",4);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }
    @Test
    public void getListLocation_6() {
        ResponseEntity<Page<LocationList>> responseEntity = this.locationController.getAllLocation("","",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(4, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(20, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("A-1",
                responseEntity.getBody().getContent().get(0).getCode());
    }

    @Test
    public void getListLocation_6_code() {
        ResponseEntity<Page<LocationList>> responseEntity = this.locationController.getAllLocation("A","",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(4, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(20, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("A-1",
                responseEntity.getBody().getContent().get(0).getCode());
    }


    @Test
    public void getListLocation_6_id_1() {
        ResponseEntity<Page<LocationList>> responseEntity = this.locationController.getAllLocation("","1",0);
        Assertions.assertEquals(200,responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(4, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("A-1",
                responseEntity.getBody().getContent().get(0).getCode());
    }
    @Test
    public void getListLocation_7() {
        ResponseEntity<Page<LocationList>> responseEntity = this.locationController.getAllLocation("",null,0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }
    @Test
    public void getListLocation_8() {
        ResponseEntity<Page<LocationList>> responseEntity = this.locationController.getAllLocation(""," ",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }
    @Test
    public void getListLocation_9() {
        ResponseEntity<Page<LocationList>> responseEntity = this.locationController.getAllLocation("","11",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }
    @Test
    public void getListLocation_10() {
        ResponseEntity<Page<LocationList>> responseEntity = this.locationController.getAllLocation("","5",0);
        Assertions.assertEquals(404,responseEntity.getStatusCodeValue());
    }
}
