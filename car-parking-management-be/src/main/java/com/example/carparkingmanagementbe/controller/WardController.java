package com.example.carparkingmanagementbe.controller;

import com.example.carparkingmanagementbe.model.Ward;
import com.example.carparkingmanagementbe.service.IWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/ward")
public class WardController {
    @Autowired
    private IWardService wardService;
    @GetMapping("/ward-list")
    public ResponseEntity<List<Ward>> getAllWard() {
        List<Ward> wardList = wardService.getAllWard();
        if (wardList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(wardList,HttpStatus.OK);
    }

    //TrongHD lấy thông tin khách hàng
    @GetMapping("/{id}")
    public ResponseEntity<List<Ward>> findByIdWard(@PathVariable Long id) {
        List<Ward> ward = wardService.getWardById(id);
        if (ward == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ward, HttpStatus.OK);
    }
}
