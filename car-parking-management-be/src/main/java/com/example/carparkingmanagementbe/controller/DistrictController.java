package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.model.Car;
import com.example.carparkingmanagementbe.model.District;
import com.example.carparkingmanagementbe.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")   
@RequestMapping("/api/district")
public class DistrictController {
    @Autowired
    private IDistrictService districtService;
    @GetMapping("/district-list")
    public ResponseEntity<List<District>> getAllDistrict() {
        List<District> districtList = districtService.getAllDistrict();
        if (districtList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(districtList,HttpStatus.OK);
    }

    //TrongHD lấy thông tin
    @GetMapping("/{id}")
    public ResponseEntity<List<District>> findByIdDistrict(@PathVariable Long id) {
        List<District> district = districtService.getDistrictById(id);
        if (district == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(district, HttpStatus.OK);
    }
}
