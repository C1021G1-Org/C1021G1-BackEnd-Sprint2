package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.LocationDto;
import com.example.carparkingmanagementbe.model.AllowedCarParking;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import com.example.carparkingmanagementbe.dto.LocationList;
import org.springframework.data.domain.Page;

import java.util.Set;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    private ILocationService service;

    /*TuanPDCoding*/
    @GetMapping("/{id}")
    public ResponseEntity<?> findLocationByIdDto(@PathVariable Long id) {
        Location location = service.findLocationById(id);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> createLocation(@Valid @RequestBody LocationDto locationDto, Set<AllowedCarParking> allowedCarParking, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors().get(0).getDefaultMessage(), HttpStatus.NOT_FOUND);
        }
        service.createLocation(locationDto);
        service.createAllowParking(locationDto, allowedCarParking);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<?> updateLocation(@Valid @RequestBody LocationDto locationDto, Location location, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors().get(0).getDefaultMessage(), HttpStatus.NOT_FOUND);
        }
        service.editLocation(locationDto);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    /*TuanPDCoding*/

    /*TinhHDCoding*/
    @GetMapping("/list")
    public ResponseEntity<Page<LocationList>> getAllLocation(@RequestParam(defaultValue = "") String code,
                                                             @RequestParam(defaultValue = "") String id,
                                                             @RequestParam(defaultValue = "0") int page) {
        Page<LocationList> locationPage = service.findAll(code, id, page);
        if (locationPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(locationPage, HttpStatus.OK);
    }
    /*TinhHDCoding*/

}
