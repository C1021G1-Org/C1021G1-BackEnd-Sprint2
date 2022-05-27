package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.LocationList;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/api/location")
public class LocationController {
    //anh tinh code
    @Autowired
    private ILocationService iLocationService;

    @GetMapping("/list")
    public ResponseEntity<Page<LocationList>> getAllLocation(@RequestParam(defaultValue = "") String code,
                                                             @RequestParam(defaultValue = "") String id,
                                                             @RequestParam(defaultValue = "0") int page) {
        Page<LocationList> locationPage = iLocationService.findAll(code, id, page);
        if (locationPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(locationPage, HttpStatus.OK);
    }

    // dat code
    @GetMapping("/map-parking")
    public ResponseEntity<Page<Location>> getAllLocation(@RequestParam(defaultValue = "0") int page) {
        Page<Location> getAllLocation = iLocationService.getAllLocation(PageRequest.of(page, 86));
        if (getAllLocation.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getAllLocation, HttpStatus.OK);
    }

    @GetMapping("/map-parking/{id}")
    public ResponseEntity<Location> findLocationById(@PathVariable Long id) {
        Location location = iLocationService.findLocationById(id);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @GetMapping("/listMapParking")
    public ResponseEntity<Page<Location>> listAllLocation(Pageable pageable) {
        Page<Location> location = iLocationService.findAllLocation(pageable);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @DeleteMapping("/update-map-parking/{id}")
    public ResponseEntity<Location> updateColorLocation(@PathVariable Long id) {
        Location location = iLocationService.findLocationById(id);
        System.out.println(location.getIsEmpty());
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iLocationService.updateColorLocation(id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }


}
