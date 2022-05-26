package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.LocationList;

import com.example.carparkingmanagementbe.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/api/location")
public class LocationController {
    @Autowired
    private ILocationService iLocationService;

    @GetMapping("/list")
    public ResponseEntity<Page<LocationList>> getAllLocation(@RequestParam(defaultValue = "") String code,
                                                             @RequestParam(defaultValue = "") String id,
                                                             @RequestParam(defaultValue = "0") int page) {
        Page<LocationList> locationPage = iLocationService.findAll(code,id,page);
        if (locationPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(locationPage, HttpStatus.OK);
    }
}
