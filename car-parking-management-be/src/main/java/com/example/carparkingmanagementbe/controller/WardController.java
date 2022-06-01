package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.model.District;
import com.example.carparkingmanagementbe.model.Ward;
import com.example.carparkingmanagementbe.service.IDistrictService;
import com.example.carparkingmanagementbe.service.IWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
public class WardController {
    @Autowired
    private IWardService wardService;
    @GetMapping("/ward-list/{id}")
    public ResponseEntity<List<Ward>> getAllWard(@PathVariable Long id) {
        List<Ward> wardList = wardService.getAllWard(id);
        if (wardList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(wardList,HttpStatus.OK);
    }

    @GetMapping("/ward/{id}")
    public ResponseEntity<Optional<Ward>> findWardById(@PathVariable Long id) {
        Optional<Ward> ward = wardService.findWardById(id);
        if (!ward.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ward,HttpStatus.OK);
    }
}
