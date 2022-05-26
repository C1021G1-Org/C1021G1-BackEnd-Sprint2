package com.example.carparkingmanagementbe.controller;


import com.example.carparkingmanagementbe.dto.LocationDetailDto;
import com.example.carparkingmanagementbe.model.Location;

import com.example.carparkingmanagementbe.service.ILocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/location")

public class LocationController {
    @Autowired
    private ILocationService iLocationService;

    @GetMapping("/detail/{id}")
    public ResponseEntity<LocationDetailDto> getId(@PathVariable Long id) {
        LocationDetailDto location = iLocationService.findById(id);

        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(location, HttpStatus.OK);
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<Location> getALlId(@PathVariable Long id) {
        Location location = iLocationService.findLocationById(id);

        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(location, HttpStatus.OK);
        }

    }


    @DeleteMapping("/delete-location/{id}")
    public ResponseEntity<Location> deleteNews(@PathVariable Long id) {
        Location news = iLocationService.findLocationById(id);
        if (news == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iLocationService.deleteLocationById(id);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

}
