package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.model.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class MapParkingController {

    @Autowired
    private LocationController locationController;

    @Test
    public void findAllLocation_1() {
        ResponseEntity<Page<Location>> pageResponseEntity = this.locationController.listAllLocation(PageRequest.of(0, 86));
        Assertions.assertEquals(404, pageResponseEntity.getStatusCodeValue());
    }

    @Test
    public void findAllLocation_2() {
        ResponseEntity<Page<Location>> responseEntity = this.locationController.listAllLocation(PageRequest.of(0, 86));
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(1, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(19, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("A-1",
                responseEntity.getBody().getContent().get(6).getCode());
        Assertions.assertEquals("xe 12 cho",
                responseEntity.getBody().getContent().get(6).getDescription());
    }

}
