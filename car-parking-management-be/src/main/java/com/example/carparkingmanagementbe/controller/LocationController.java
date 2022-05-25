package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.dto.LocationDto;
import com.example.carparkingmanagementbe.model.Location;
import com.example.carparkingmanagementbe.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping( "/api")
public class LocationController {

    @Autowired
    private ILocationService service;

    /*TuanPDCoding*/
    @GetMapping("/location/{id}")
    public ResponseEntity<?> findLocationByIdDto(@PathVariable Long id) {
        Location location = service.findLocationById(id);
        if (location == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @PatchMapping(value = "/editLocation/{id}")
    public ResponseEntity<?> updateLocation(@Valid @RequestBody LocationDto locationDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors().get(0).getDefaultMessage(), HttpStatus.NOT_FOUND);
        }
        service.editLocation(locationDto);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    /*TuanPDCoding*/

}
