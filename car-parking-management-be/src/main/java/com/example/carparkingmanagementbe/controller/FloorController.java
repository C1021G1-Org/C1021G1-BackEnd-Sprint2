package com.example.carparkingmanagementbe.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carparkingmanagementbe.dto.LocationList;
import com.example.carparkingmanagementbe.model.Floor;
import com.example.carparkingmanagementbe.service.IFloorsService;
import com.example.carparkingmanagementbe.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/floor")
public class FloorController {

    @Autowired
    private IFloorsService iFloorsService;


    /*TinhHDCoding*/
    @GetMapping("/list")
    public ResponseEntity<List<?>> getAllLocation() {
        List<Floor> floorList = iFloorsService.findAll();

        if (floorList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(floorList, HttpStatus.OK);
    }


}
