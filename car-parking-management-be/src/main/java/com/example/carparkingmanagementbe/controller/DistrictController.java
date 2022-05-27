package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.model.District;
import com.example.carparkingmanagementbe.model.Province;
import com.example.carparkingmanagementbe.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
public class DistrictController {
    @Autowired
    private IDistrictService districtService;
    @GetMapping("/district-list/{id}")
    public ResponseEntity<List<District>> getAllDistrict(@PathVariable Long id) {
        List<District> districtList = districtService.getAllDistrict(id);
        if (districtList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(districtList,HttpStatus.OK);
    }
}
